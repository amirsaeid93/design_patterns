import character.GameCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        GameCharacter character = new GameCharacter(name);

        while (!(character.getState().getLevelName().equals("Master"))) {
            System.out.println("\n" + character.getStatus());
            System.out.println("Choose an action by inputting one of the following letters: train(t) | meditate(m) | fight(f) | quit(q)");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "t" -> character.train();
                case "m" -> character.meditate();
                case "f" -> character.fight();
                case "q" -> {
                    System.out.println("You ended the game.");
                    return;
                }
                default -> System.out.println("Invalid action!");
            }
        }

        System.out.println("\nCongratulations, you have passed the game! " + character.getStatus());
        System.out.println("The game has ended now.");
    }
}