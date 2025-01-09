package org.WilfullMurder.CGOL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    Cell cell, neighbour1, neighbour2, neighbour3, neighbour4;

    @BeforeEach
    void setUp() {
        cell = new Cell();
        neighbour1 = new Cell();
        neighbour1.setAlive(true);
        neighbour2 = new Cell();
        neighbour2.setAlive(true);
        neighbour3 = new Cell();
        neighbour3.setAlive(true);
        neighbour4 = new Cell();
        neighbour4.setAlive(true);
    }


    @Test
    void testCell() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    void testAlive() {
        Cell cell = new Cell();
        cell.setAlive(true);
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.update();
        assertTrue(cell.isAlive());
    }

    @Test
    void testDead() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    @Test
    void testHasNoNeighbours() {
        Cell cell = new Cell();
        assertEquals(0, cell.getNeighbourCount());
    }

    @Test
    void testHasNeighbours() {
        Cell cell = new Cell();
        cell.addNeighbour(0,0, neighbour1);
        assertEquals(1, cell.getNeighbourCount());
    }

    @Test
    void testHasMultipleNeighbours() {
        Cell cell = new Cell();
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.addNeighbour(0,2, neighbour3);
        assertEquals(3, cell.getNeighbourCount());
    }

    @Test
    void testDiesWithLessThanTwoLivingNeighbours(){
        Cell cell = new Cell();
        cell.setAlive(true);
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.update();
        assertTrue(cell.isAlive());

        cell.removeNeighbour(0,0);
        cell.update();
        assertFalse(cell.isAlive());
    }

    @Test
    void testDiesWithMoreThanThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.addNeighbour(0,2, neighbour3);
        cell.addNeighbour(1,0, neighbour4);
        cell.update();
        assertFalse(cell.isAlive());
    }

    @Test
    void testBreedsWithTwoLivingNeighbours(){
        Cell cell = new Cell();
        cell.setAlive(true);
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.update();
        assertTrue(cell.isAlive());
        assertEquals(2, cell.getGeneration());
    }

    @Test
    void testBreedsWithThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.addNeighbour(0,2, neighbour3);
        cell.update();
        assertTrue(cell.isAlive());
        assertEquals(1, cell.getGeneration());
    }

    @Test
    void testCellIsBornFromThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.addNeighbour(0,2, neighbour3);
        cell.setAlive(false);
        cell.update();
        assertTrue(cell.isAlive());
    }

    @Test
    void testGenerationIsTrackedCorrectly(){
        Cell cell = new Cell();
        assertEquals(0, cell.getGeneration());
        cell.addNeighbour(0,0, neighbour1);
        cell.addNeighbour(0,1, neighbour2);
        cell.addNeighbour(0,2, neighbour3);
        cell.update();
        assertEquals(1, cell.getGeneration());
        cell.update();
        assertEquals(2, cell.getGeneration());
        cell.removeNeighbour(0,0);
        cell.removeNeighbour(0,1);
        cell.update();
        assertEquals(0, cell.getGeneration());
    }

}