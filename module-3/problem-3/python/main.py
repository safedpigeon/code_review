from weather_station import WeatherStation
from phone_display import PhoneDisplay
from window_display import WindowDisplay

def main():
    phone = PhoneDisplay()
    window = WindowDisplay()
    
    station = WeatherStation(phone, window)
    
    print("Updating temperature to 25.5...")
    station.set_temperature(25.5)
    
    print("Updating temperature to 30.0...")
    station.set_temperature(30.0)

if __name__ == "__main__":
    main()
