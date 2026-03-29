import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerBuilder builder = null;

        System.out.println("Welcome to the Computer Customizer!");
        System.out.println("Select a base model:");
        System.out.println("1. Gaming Computer");
        System.out.println("2. Office Computer");

        int choice = 0;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }
        scanner.nextLine();

        if (choice == 1) {
            builder = new GamingComputerBuilder();
        } else {
            builder = new OfficeComputerBuilder();
            if (choice != 2) {
                System.out.println("Invalid choice, defaulting to Office Computer.");
            }
        }


        ComputerDirector director = new ComputerDirector(builder);
        Computer myComputer = director.constructComputer();


        System.out.println("Would you like to add extra accessories? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.println("Enter accessories separated by commas (e.g. Mouse Pad, Headset):");
            String input = scanner.nextLine();
            String[] extras = input.split(",");
            for (String extra : extras) {
                if (!extra.trim().isEmpty()) {
                    myComputer.addAccessory(extra.trim());
                }
            }
        }


        System.out.println("Would you like to upgrade RAM? (Enter size in GB, or 0 to keep default):");
        if (scanner.hasNextInt()) {
            int newRam = scanner.nextInt();
            if (newRam > 0) {
                myComputer.setRamSize(newRam);
            }
        }


        myComputer.showConfiguration();
        scanner.close();
    }
}
