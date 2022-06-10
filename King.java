public class King extends Figure{

    King[] WhiteKing = new King[1];
    King[] BlackKing = new King[1];

    King(){
        fillBoard();
    }

    King(boolean color){
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        WhiteKing[0] = new King(true); Board.spawnFigure(WhiteKing[0], 0, 4);
        BlackKing[0] = new King(false); Board.spawnFigure(BlackKing[0], 7, 3);
    }

    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        if(to.getRow() == from.getRow() + 1 && to.getColumn() == from.getColumn() + 1) return true;
        if(to.getRow() == from.getRow() + 1 && to.getColumn() == from.getColumn()) return true;
        if(to.getRow() == from.getRow() + 1 && to.getColumn() == from.getColumn() - 1) return true;
        if(to.getRow() == from.getRow() && to.getColumn() == from.getColumn() - 1) return true;
        if(to.getRow() == from.getRow() - 1 && to.getColumn() == from.getColumn() - 1) return true;
        if(to.getRow() == from.getRow() - 1 && to.getColumn() == from.getColumn()) return true;
        if(to.getRow() == from.getRow() - 1 && to.getColumn() == from.getColumn() + 1) return true;
        if(to.getRow() == from.getRow()  && to.getColumn() == from.getColumn() + 1) return true;
    return false;
    }

    public String toString(){
        if(this.color) return "B_King";
        else return "W_King";
    }
}
