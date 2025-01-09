package org.WilfullMurder.CGOL;


public class Main {
    public static void main(String[] args) {
        Window window = new Window(1920, 1080);
        Grid grid = new Grid(96, 54);
        populateGridAtRandom(grid);

        while (true) {
            window.drawGrid(grid);
            grid.update();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void populateGridAtRandom(Grid grid) {
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                grid.setCellLifeStatus(i, j, Math.random() < 0.5);
            }
        }

        // Set the neighbours for each cell
        // This is done after the grid is populated to ensure all cells are created

        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                Cell currentCell = grid.getCell(i, j);
                // Cell neighbours must be located in the 3x3 (0,0) to (2,2) grid around the cell
                for (int x = 0; x <= 2; x++) {
                    for (int y = 0; y <= 2; y++) {
                        if(x == 1 && y == 1) continue; // Skip the cell itself

                        int neighbourX = i + x;
                        int neighbourY = j + y;
                        if (neighbourX >= 0 && neighbourX < grid.getWidth() && neighbourY >= 0 && neighbourY < grid.getHeight()) {
                            currentCell.addNeighbour(x + 1, y + 1, grid.getCell(neighbourX, neighbourY));
                        }
                    }
                }
            }
        }
        System.out.println("Grid populated");
    }
}