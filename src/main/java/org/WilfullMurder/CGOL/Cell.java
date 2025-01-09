package org.WilfullMurder.CGOL;

/**
 * Represents a cell in the Game of Life.
 */
public class Cell {
    private boolean alive;
    private final Cell[][] neighbours;
    private int generation;

    /**
     * Constructs a new Cell that is initially alive with no neighbours.
     */
    public Cell() {
        neighbours = new Cell[3][3];
        neighbours[1][1] = this;
    }

    public void setAlive(boolean alive) {
        if(!this.alive && alive){
            generation = 1;
        }
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    /**
    * Gets the count of alive neighbours.
    *
    * @return the number of alive neighbours
    */
    public int getNeighbourCount() {
        int count = 0;
        for (Cell[] neighbour : neighbours) {
            for (Cell c : neighbour) {
                if(c == null){
                    c = new Cell();
                    neighbours[1][1] = c;
                    continue;
                }
                if(c.equals(this)){
                    continue;
                }
                if (c.isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Adds a neighbour at the specified coordinates.
     *
     * @param x the x-coordinate of the neighbour
     * @param y the y-coordinate of the neighbour
     */
    public void addNeighbour(int x, int y, Cell neighbour) {
        if(x < 0 || x > 2 || y < 0 || y > 2) {
            return;
        }
        if(x == 1 && y == 1){
            return;
        }
        neighbours[x][y] = neighbour;
    }

    /**
     * Removes a neighbour at the specified coordinates.
     *
     * @param x the x-coordinate of the neighbour
     * @param y the y-coordinate of the neighbour
     */
    public void removeNeighbour(int x, int y) {
        if(x < 0 || x > 2 || y < 0 || y > 2) {
            return;
        }
        if(x == 1 && y == 1){
            return;
        }
        if(neighbours[x][y].isAlive()) {
            neighbours[x][y].setAlive(false);;
        }
    }

    /**
     * Updates the alive status of the cell based on the number of alive neighbours.
     */
    public void update(){
        int aliveNeighbours = getNeighbourCount();

        if(aliveNeighbours < 2 || aliveNeighbours > 3){
            // Dies from loneliness or overpopulation
            alive = false;
            generation = 0;
            return;
        }

        if(!alive && aliveNeighbours == 3){
            // Cell is born
            setAlive(true);
            return;
        }

        if(alive){
            // Cell lives on
            generation++;
        }

    }

    public int getGeneration() {
        return generation;
    }
}