import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String, Recommendation> recommendations = new HashMap<>();

        // Initial Recommendation
        Recommendation fictionLovers = new Recommendation("Fiction Lovers");
        fictionLovers.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));
        fictionLovers.addBook(new Book("J.R.R. Tolkien", "The Hobbit", "Fantasy", 1937));
        recommendations.put(fictionLovers.getTargetAudience(), fictionLovers);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View all recommendations");
            System.out.println("2. Clone a recommendation");
            System.out.println("3. Add a book to an existing recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next(); // clears invalid inputs
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Current Recommendation Lists ---");
                    if (recommendations.isEmpty()) {
                        System.out.println("No lists available.");
                    } else {
                        recommendations.forEach((key, value) -> System.out.println(value));
                    }
                    break;
                case 2:
                    System.out.print("Enter the target audience of the recommendation to clone: ");
                    String audienceToClone = scanner.nextLine();
                    if (recommendations.containsKey(audienceToClone)) {
                        Recommendation original = recommendations.get(audienceToClone);
                        Recommendation cloned = original.clone();

                        System.out.print("Enter the new target audience for the cloned list: ");
                        String newAudience = scanner.nextLine();
                        cloned.setTargetAudience(newAudience);

                        recommendations.put(newAudience, cloned);
                        System.out.println("Successfully cloned '" + audienceToClone + "' into '" + newAudience + "'!");
                    } else {
                        System.out.println("Recommendation list not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the target audience of the list you want to modify: ");
                    String targetAud = scanner.nextLine();
                    if (recommendations.containsKey(targetAud)) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        recommendations.get(targetAud).addBook(new Book(author, title, genre, year));
                        System.out.println("Book added to '" + targetAud + "' successfully!");
                    } else {
                        System.out.println("List not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
