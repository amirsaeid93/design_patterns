import display.BillboardDisplay;
import display.PhoneDisplay;
import display.TVDisplay;
import display.WeatherObserver;


public class WeatherSimulator {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver phone = new PhoneDisplay("Observer1");
        WeatherObserver tv = new TVDisplay("Observer2");
        WeatherObserver billboard = new BillboardDisplay("Observer3");

        station.registerObserver(phone);
        station.registerObserver(tv);
        station.registerObserver(billboard);

        station.start();

        try {
            Thread.sleep(15000);
            System.out.println("\n--- Removing Observer2 (TVDisplay) ---\n");
            station.removeObserver(tv);

            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        station.stopStation();
        System.out.println("\nSimulation ended.");
    }
}