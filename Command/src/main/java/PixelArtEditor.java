import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class PixelArtEditor extends Application {
    private static final int SIZE = 8;
    private static final int CELL_SIZE = 40;
    private final PixelArtModel model = new PixelArtModel();
    private final Rectangle[][] cells = new Rectangle[SIZE][SIZE];
    private Scene scene; // Declared as a field here

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStroke(Color.LIGHTGRAY);
                rect.setFill(Color.WHITE);
                cells[r][c] = rect;
                StackPane cell = new StackPane(rect);
                gridPane.add(cell, c, r);
            }
        }

        Button codeButton = new Button("Create Code");
        codeButton.setOnAction(e -> {
            new GenerateCodeCommand(model).execute();
            // Request focus back to the scene's root after button click
            // This ensures keyboard input continues to work
            scene.getRoot().requestFocus();
        });

        VBox root = new VBox(10, gridPane, codeButton);
        this.scene = new Scene(root); // Initialized here
        updateGrid();

        scene.setOnKeyPressed(e -> {
            Command cmd = null;
            if (e.getCode() == KeyCode.UP) cmd = new MoveCursorUpCommand(model);
            else if (e.getCode() == KeyCode.DOWN) cmd = new MoveCursorDownCommand(model);
            else if (e.getCode() == KeyCode.LEFT) cmd = new MoveCursorLeftCommand(model);
            else if (e.getCode() == KeyCode.RIGHT) cmd = new MoveCursorRightCommand(model);
            else if (e.getCode() == KeyCode.SPACE) cmd = new TogglePixelCommand(model);
            if (cmd != null) {
                cmd.execute();
                updateGrid();
            }
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        // Initial focus request
        scene.getRoot().requestFocus();
    }

    private void updateGrid() {
        int[][] grid = model.getGrid();
        int cursorRow = model.getCursorRow();
        int cursorCol = model.getCursorCol();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                Rectangle rect = cells[r][c];
                if (grid[r][c] == 1) rect.setFill(Color.BLACK);
                else rect.setFill(Color.WHITE);
                if (r == cursorRow && c == cursorCol) rect.setStroke(Color.RED);
                else rect.setStroke(Color.LIGHTGRAY);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
