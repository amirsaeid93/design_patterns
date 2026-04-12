public enum TileType {
    GRASS("Grass"),
    WATER("Water"),
    MOUNTAIN("Mountain"),
    SAND("Sand"),
    FOREST("Forest");

    private final String displayName;

    TileType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}