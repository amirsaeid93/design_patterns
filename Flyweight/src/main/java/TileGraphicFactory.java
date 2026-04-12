import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.EnumMap;
import java.util.Map;


public class TileGraphicFactory {
    private final Map<TileType, Image> cache = new EnumMap<>(TileType.class);
    private final int tileSize;

    public TileGraphicFactory(int tileSize) {
        this.tileSize = tileSize;
    }


    public Image getGraphic(TileType type) {
        return cache.computeIfAbsent(type, this::createGraphicFor);
    }

    private Image createGraphicFor(TileType type) {

        Canvas canvas = new Canvas(tileSize, tileSize);
        var gc = canvas.getGraphicsContext2D();


        Color base;
        switch (type) {
            case WATER -> base = Color.web("#4DA6FF");
            case MOUNTAIN -> base = Color.web("#8B8B8B");
            case SAND -> base = Color.web("#F3E2A9");
            case FOREST -> base = Color.web("#2E8B57");
            case GRASS -> base = Color.web("#7CFC00");
            default -> base = Color.BLACK;
        }


        gc.setFill(base);
        gc.fillRect(0, 0, tileSize, tileSize);


        gc.setStroke(Color.rgb(0,0,0,0.15));
        gc.strokeRect(0, 0, tileSize, tileSize);

        switch (type) {
            case WATER -> {
                gc.setFill(Color.rgb(255,255,255,0.3));
                for (int i = 0; i < 3; i++) {
                    gc.fillOval(tileSize * (0.1 + 0.25 * i), tileSize * 0.6, tileSize * 0.25, tileSize * 0.12);
                }
            }
            case MOUNTAIN -> {
                gc.setFill(Color.DARKSLATEGRAY);
                gc.fillPolygon(new double[]{tileSize*0.1, tileSize*0.5, tileSize*0.9},
                        new double[]{tileSize*0.9, tileSize*0.2, tileSize*0.9}, 3);
            }
            case FOREST -> {
                gc.setFill(Color.DARKGREEN);
                for (int i = 0; i < 3; i++) {
                    gc.fillOval(tileSize*(0.15 + i*0.25), tileSize*0.2, tileSize*0.25, tileSize*0.25);
                }
            }
            case SAND -> {
                gc.setFill(Color.rgb(220, 200, 150, 0.6));
                for (int i = 0; i < 6; i++) {
                    gc.fillOval((i * tileSize) / 6.0, tileSize * 0.6, tileSize * 0.08, tileSize * 0.05);
                }
            }
            case GRASS -> {
                gc.setFill(Color.web("#5DAA00"));
                for (int i = 0; i < 4; i++) {
                    gc.fillRect(i * tileSize * 0.25, tileSize * 0.6, tileSize * 0.05, tileSize * 0.25);
                }
            }
        }


        WritableImage snapshot = new WritableImage(tileSize, tileSize);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        canvas.snapshot(params, snapshot);
        return snapshot;
    }
}
