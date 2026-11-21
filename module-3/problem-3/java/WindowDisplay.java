public class WindowDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Window Display: Current temperature is " + temperature + "°C");
    }
}
