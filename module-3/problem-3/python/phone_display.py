from observer import Observer

class PhoneDisplay(Observer):
    def update(self, temperature):
        print(f"Phone Display: Temperature updated to {temperature}°C")
