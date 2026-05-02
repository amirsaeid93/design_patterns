public class PixelArtModel {
    private final int[][] grid = new int[8][8];
    private int cursorRow = 0, cursorCol = 0;

    public int[][] getGrid() { return grid; }
    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }

    public void moveCursor(int dRow, int dCol) {
        int oldRow = cursorRow;
        int oldCol = cursorCol;
        cursorRow = Math.max(0, Math.min(7, cursorRow + dRow));
        cursorCol = Math.max(0, Math.min(7, cursorCol + dCol));
        System.out.println("DEBUG: Cursor moved from (" + oldRow + "," + oldCol + ") to (" + cursorRow + "," + cursorCol + ")");
    }

    public void togglePixel() {
        System.out.println("DEBUG: togglePixel() called at (" + cursorRow + ", " + cursorCol + ")");
        grid[cursorRow][cursorCol] = grid[cursorRow][cursorCol] == 0 ? 1 : 0;
        System.out.println("DEBUG: Pixel at (" + cursorRow + ", " + cursorCol + ") is now: " + grid[cursorRow][cursorCol]);
    }

    public void printCodeToConsole() {
        System.out.println("DEBUG: printCodeToConsole() called.");
        System.out.println("int[][] pixelArt = {");
        for (int r = 0; r < 8; r++) {
            System.out.print("    {");
            for (int c = 0; c < 8; c++) {
                System.out.print(grid[r][c]);
                if (c < 7) System.out.print(", ");
            }
            System.out.println(r < 7 ? "}," : "}");
        }
        System.out.println("};");
    }
}
