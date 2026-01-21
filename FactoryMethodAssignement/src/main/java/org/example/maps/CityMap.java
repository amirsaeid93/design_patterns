package org.example.maps;

import org.example.tiles.BuildingTile;
import org.example.tiles.ForestTile;
import org.example.tiles.RoadTile;
import org.example.tiles.Tile;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int r = rand.nextInt(3);
        return switch (r) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}