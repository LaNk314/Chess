public abstract class Figure {


    public boolean color;          //true = white; false = black

    Figure() {
        fillBoard();
    }
    private void fillBoard(){}
    public boolean ifPossible(Coordinates from, Coordinates to){
        return false;
    }

}
