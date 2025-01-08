package org.WilfullMurder.CGOL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void testGrid() {
        Grid grid = new Grid(10, 10);
        assertNotNull(grid);
    }

    @Test
    void testGetCell() {
        Grid grid = new Grid(10, 10);
        Cell cell = grid.getCell(0, 0);
        assertNotNull(cell);
    }

    @Test
    void testUpdate() {
        Grid grid = new Grid(10, 10);
        grid.getCell(0, 0).addNeighbour(0, 0);
        grid.getCell(0, 0).addNeighbour(0, 1);
        grid.getCell(0, 0).addNeighbour(0, 2);
        grid.update();
        assertTrue(grid.getCell(0, 0).isAlive());
    }

}