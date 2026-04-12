import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int TILE_SIZE = 32;
    private static final int COLS = 30;
    private static final int ROWS = 20;

    private Tile[][] map;
    private final MapRenderer renderer = new MapRenderer(TILE_SIZE);
    private final MapGenerator generator = new MapGenerator(COLS, ROWS);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Map Renderer (Flyweight)");


        this.map = generator.generateMap();


        Canvas canvas = new Canvas(COLS * TILE_SIZE, ROWS * TILE_SIZE);
        renderer.render(map, canvas);


        Button regenBtn = new Button("Regenerate Map");
        regenBtn.setOnAction(e -> {
            map = generator.generateMap();
            renderer.render(map, canvas);
        });

        ToolBar toolbar = new ToolBar(regenBtn);
        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setCenter(canvas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
