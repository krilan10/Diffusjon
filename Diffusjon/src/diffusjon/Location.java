package diffusjon;

/**
 * Represent a location in a rectangular grid.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Location {

    // Row and column positions.
    private int row;
    private int col;

    /**
     * Represent a row and column.
     *
     * @param row The row.
     * @param col The column.
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    Location() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implement content equality.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        } else {
            return false;
        }
    }

    /**
     * Return a string of the form row,column
     *
     * @return A string representation of the location.
     */
    public String toString() {
        return row + "," + col;
    }

    /**
     * Use the top 16 bits for the row value and the bottom for the column.
     * Except for very big grids, this should give a unique hash code for each
     * (row, col) pair.
     *
     * @return A hashcode for the location.
     */
    public int hashCode() {
        return (row << 16) + col;
    }

    /**
     * @return The row.
     */
    public int getRow() {
        return row;
    }

    /**
     * @return The column.
     */
    public int getCol() {
        return col;
    }

    public void moveX(boolean moveRight) {

        if (moveRight&&getCol()<119) {
            col++;
          
        } else if (col > 1&& getCol()>0) {
            col--;
         
        }

    }
       public void moveY(boolean moveUp) {
           
        if (moveUp &&getRow()<119){
            row++;
           
        } else if (col > 1&&getRow()>0) {
            row--;
           
        }

    }
}
