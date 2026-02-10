import java.util.Random;

public class DiceGame extends Game {
    private Player[] players;
    private int winningScore = 20;
    private Player winner;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        System.out.println("Dice Game initialized with " + numberOfPlayers + " players.");
        System.out.println("First to reach " + winningScore + " points wins!\n");
    }

    @Override
    public boolean endOfGame() {
        return winner != null;
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Player current = players[playerIndex];
        int roll = random.nextInt(6) + 1;
        current.addScore(roll);
        System.out.printf("%s rolled a %d. Total score: %d%n",
                current.getName(), roll, current.getScore());

        if (current.getScore() >= winningScore) {
            winner = current;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\nGame has ended and here are the results: " + winner.getName() + " wins with " + winner.getScore() + " points!");
    }
}