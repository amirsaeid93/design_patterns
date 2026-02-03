import display.WeatherObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WeatherStation extends Thread {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private boolean running = true;

    public WeatherStation() {
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public synchronized void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        int newTemp = temperature + change;
        if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP) {
            temperature = newTemp;
        }
    }

    @Override
    public void run() {
        while (running) {
            updateTemperature();
            notifyObservers();
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopStation() {
        running = false;
    }
}