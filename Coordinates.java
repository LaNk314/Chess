public class Coordinates {
    private int row;
    private int column;

    Coordinates(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString(){
        return "row: " + row + ", column:  " + column;
    }


}
