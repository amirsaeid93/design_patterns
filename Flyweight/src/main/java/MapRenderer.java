import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



public class MapRenderer {
    private final TileGraphicFactory graphicFactory;
    private final int tileSize;

    public MapRenderer(int tileSize) {
        this.tileSize = tileSize;
        this.graphicFactory = new TileGraphicFactory(tileSize);
    }


    public void render(Tile[][] map, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int rows = map.length;
        int cols = (rows > 0) ? map[0].length : 0;


        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Tile tile = map[r][c];
                Image tileImage = graphicFactory.getGraphic(tile.getType());
                gc.drawImage(tileImage, c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }


        gc.setLineWidth(0.5);
        gc.setStroke(javafx.scene.paint.Color.rgb(0,0,0,0.1));
        for (int r = 0; r <= rows; r++) {
            gc.strokeLine(0, r * tileSize, cols * tileSize, r * tileSize);
        }
        for (int c = 0; c <= cols; c++) {
            gc.strokeLine(c * tileSize, 0, c * tileSize, rows * tileSize);
        }
    }
}
