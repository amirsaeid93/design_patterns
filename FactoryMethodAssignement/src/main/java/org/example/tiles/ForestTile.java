package org.example.tiles;

public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }
}