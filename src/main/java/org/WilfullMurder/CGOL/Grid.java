package org.WilfullMurder.CGOL;

public class Grid {
    private final Cell[][] grid;
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return null;
        }
        return grid[x][y];
    }

    public void setCellLifeStatus(int x, int y, boolean alive) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        grid[x][y].setAlive(alive);
    }


    public void update() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.update();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
