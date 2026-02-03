package display;

public class TVDisplay implements WeatherObserver {
    private final String name;

    public TVDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " (TV): Breaking news! Temperature is now " + temperature + "°C");
    }
}