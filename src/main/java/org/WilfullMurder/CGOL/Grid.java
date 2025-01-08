package org.WilfullMurder.CGOL;

public class Grid {
    private final Cell[][] grid;

    public Grid(int width, int height) {
        grid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void update() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.update();
            }
        }
    }
}
