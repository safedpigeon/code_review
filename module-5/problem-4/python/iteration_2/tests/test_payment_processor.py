import pytest
from src.services.tax_calculator import TaxCalculator
from src.services.discount_calculator import DiscountCalculator
from src.gateways.payment_gateway_impl import PaymentGatewayImpl
from src.payment_processor import PaymentProcessor

class MockPaymentGateway:
    def __init__(self):
        self.called = False
    def process(self, amount, currency):
        self.called = True

@pytest.fixture
def calculators():
    return TaxCalculator(), DiscountCalculator()

# --- Unit Tests ---

def test_tax_calculation(calculators):
    tax_calc, _ = calculators
    assert tax_calc.calculate_tax(100.0, "US") == 10.0
    assert tax_calc.calculate_tax(100.0, "EU") == 20.0
    assert tax_calc.calculate_tax(100.0, "Asia") == 5.0
    assert tax_calc.calculate_tax(100.0, None) == 5.0

def test_discount_calculation(calculators):
    _, disc_calc = calculators
    assert disc_calc.calculate_discount(100.0, "PREMIUM") == 10.0
    assert disc_calc.calculate_discount(100.0, "GOLD") == 20.0
    assert disc_calc.calculate_discount(100.0, "REGULAR") == 0.0
    assert disc_calc.calculate_discount(100.0, None) == 0.0

# --- Integration Tests ---

def test_payment_processor_with_mock_gateway(calculators):
    tax_calc, disc_calc = calculators
    mock_gateway = MockPaymentGateway()
    processor = PaymentProcessor(tax_calc, disc_calc, mock_gateway)
    
    result = processor.process_payment(100.0, "USD", "US", "GOLD")
    
    # 100 + 10 (US) - 20 (GOLD) = 90
    assert result == 90.0
    assert mock_gateway.called is True

def test_payment_processor_invalid_amount(calculators):
    tax_calc, disc_calc = calculators
    mock_gateway = MockPaymentGateway()
    processor = PaymentProcessor(tax_calc, disc_calc, mock_gateway)
    
    with pytest.raises(ValueError):
        processor.process_payment(-10.0, "USD", "US", "GOLD")

# --- E2E Test ---

def test_full_payment_flow():
    processor = PaymentProcessor(
        TaxCalculator(),
        DiscountCalculator(),
        PaymentGatewayImpl()
    )
    
    result = processor.process_payment(100.0, "USD", "EU", "PREMIUM")
    # 100 + 20 (EU) - 10 (PREMIUM) = 110
    assert result == 110.0
