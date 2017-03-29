/**
 * Created by Kristian on 27.03.2017.
 */
public class Field {
    private int col;
    private int row;
    private int numberOf;

    public Field(int col, int row){
        this.col = col;
        this.row = row;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {

        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }
}
