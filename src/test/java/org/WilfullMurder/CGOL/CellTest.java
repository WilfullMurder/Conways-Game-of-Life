package org.WilfullMurder.CGOL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testCell() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    void testAlive() {
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
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
        cell.addNeighbour(0,0);
        assertEquals(1, cell.getNeighbourCount());
    }

    @Test
    void testHasMultipleNeighbours() {
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.addNeighbour(0,2);
        assertEquals(3, cell.getNeighbourCount());
    }

    @Test
    void testDiesWithLessThanTwoLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.update();
        assertTrue(cell.isAlive());

        cell.removeNeighbour(0,0);
        cell.update();
        assertFalse(cell.isAlive());
    }

    @Test
    void testDiesWithMoreThanThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.addNeighbour(0,2);
        cell.update();
        assertTrue(cell.isAlive());
        cell.addNeighbour(1,0);
        cell.update();
        assertFalse(cell.isAlive());
    }

    @Test
    void testLivesWithTwoLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.update();
        assertTrue(cell.isAlive());
        assertEquals(1, cell.getGeneration());
    }

    @Test
    void testLivesWithThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.addNeighbour(0,2);
        cell.update();
        assertTrue(cell.isAlive());
        assertEquals(1, cell.getGeneration());
    }

    @Test
    void testDeadCellWithThreeLivingNeighbours(){
        Cell cell = new Cell();
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.addNeighbour(0,2);
        cell.setAlive(false);
        cell.update();
        assertTrue(cell.isAlive());
    }

    @Test
    void testGenerationIsTrackedCorrectly(){
        Cell cell = new Cell();
        assertEquals(0, cell.getGeneration());
        cell.addNeighbour(0,0);
        cell.addNeighbour(0,1);
        cell.addNeighbour(0,2);
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