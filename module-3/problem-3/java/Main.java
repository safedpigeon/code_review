public class Main {
    public static void main(String[] args) {
        PhoneDisplay phone = new PhoneDisplay();
        WindowDisplay window = new WindowDisplay();
        
        WeatherStation station = new WeatherStation();
        station.registerObserver(phone);
        station.registerObserver(window);
        
        System.out.println("Updating temperature to 25.5...");
        station.setTemperature(25.5f);
        
        System.out.println("Updating temperature to 30.0...");
        station.setTemperature(30.0f);
    }
}
