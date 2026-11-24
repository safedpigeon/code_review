class TaxCalculator:
    def calculate_tax(self, amount, region):
        if not region:
            return amount * 0.05
        region = region.upper()
        if region == "US":
            return amount * 0.10
        if region == "EU":
            return amount * 0.20
        return amount * 0.05
