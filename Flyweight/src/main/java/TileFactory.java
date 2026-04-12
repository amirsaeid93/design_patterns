public class TileFactory {


    public Tile createTile(int x, int y, double rnd) {

        TileType type;
        if (rnd < 0.05) type = TileType.MOUNTAIN;
        else if (rnd < 0.20) type = TileType.WATER;
        else if (rnd < 0.35) type = TileType.SAND;
        else if (rnd < 0.60) type = TileType.FOREST;
        else type = TileType.GRASS;

        return new Tile(type, x, y);
    }
}