package org.WilfullMurder.CGOL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Represents the main window for the Game of Life application.
 */
public class Window {

    JFrame frame;

    public Window(int width, int height) {
        frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    /**
     * Draws the grid on the window.
     *
     * @param grid the grid to be drawn
     */
    public void drawGrid(Grid grid) {
        Graphics g = frame.getGraphics();

        int cellWidth = frame.getWidth() / grid.getWidth();
        int cellHeight = frame.getHeight() / grid.getHeight();

        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                drawCell(g, grid, i, j);
                g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);

                // Draw Generation Number in cell center
                g.setColor(Color.GRAY);
                g.drawString(Integer.toString(grid.getCell(i, j).getGeneration()), (i * cellWidth) + (cellWidth / 2)-3, (j * cellHeight) + (cellHeight / 2) + 3);

                // Draw Grid Lines
                g.setColor(Color.GRAY);
                g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    /**
     * Draws a single cell on the grid.
     *
     * @param g the Graphics object used for drawing
     * @param grid the grid containing the cell
     * @param i the x-coordinate of the cell
     * @param j the y-coordinate of the cell
     */
    private void drawCell(Graphics g, Grid grid, int i, int j) {
        if (grid.getCell(i, j).isAlive()) {
            g.setColor(Color.DARK_GRAY);
        } else {
            g.setColor(Color.BLACK);
        }
    }
}
