public class Coordinates {
    private int row;
    private int column;

    Coordinates(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }

    @Override
    public String toString(){
        return "row: " + row + ", column:  " + column;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Coordinates){
            if(this.getRow() == ((Coordinates) o).getRow() && this.getColumn() == ((Coordinates) o).getColumn()) return true;
            else return false;
        }
        else return false;
    }

}
