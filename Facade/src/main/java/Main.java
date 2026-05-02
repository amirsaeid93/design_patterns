public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        try {
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris joke: " + joke);
        } catch (Exception e) {
            System.err.println("Failed to fetch Chuck Norris joke: " + e.getMessage());
        }

        try {
            String base = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "base");
            System.out.println("FX rates 'base': " + base);
        } catch (Exception e) {
            System.err.println("Failed to fetch FX rates (base): " + e.getMessage());
        }

        try {
            String rates = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates");
            System.out.println("FX rates 'rates' (first occurrence): " + rates);
        } catch (Exception e) {
            System.err.println("Failed to fetch FX rates (rates): " + e.getMessage());
        }
    }
}
