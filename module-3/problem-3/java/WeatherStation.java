public class WeatherStation {
    private float temperature;
    private PhoneDisplay phoneDisplay;
    private WindowDisplay windowDisplay;

    public WeatherStation(PhoneDisplay phoneDisplay, WindowDisplay windowDisplay) {
        this.phoneDisplay = phoneDisplay;
        this.windowDisplay = windowDisplay;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyDisplays();
    }

    private void notifyDisplays() {
        // Tight coupling: WeatherStation knows about specific display types
        phoneDisplay.update(temperature);
        windowDisplay.showTemperature(temperature);
    }

    public float getTemperature() {
        return temperature;
    }
}
