import java.util.Random;


public class MapGenerator {
    private final int columns;
    private final int rows;
    private final TileFactory tileFactory;
    private final Random rnd;

    public MapGenerator(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.tileFactory = new TileFactory();
        this.rnd = new Random();
    }

    public Tile[][] generateMap() {
        Tile[][] map = new Tile[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                double v = rnd.nextDouble();
                map[r][c] = tileFactory.createTile(c, r, v);
            }
        }
        return map;
    }
}
