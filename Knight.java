public class Knight extends Figure{

    Knight[] WhiteKnight = new Knight[2];
    Knight[] BlackKnight = new Knight[2];

    Knight(){
        fillBoard();
    }

    Knight(boolean color){
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        WhiteKnight[0] = new Knight(true); Board.spawnFigure(WhiteKnight[0], 0, 1);
        WhiteKnight[1] = new Knight(true); Board.spawnFigure(WhiteKnight[1], 0, 6);

        BlackKnight[0] = new Knight(false); Board.spawnFigure(BlackKnight[0], 7, 1);
        BlackKnight[1] = new Knight(false); Board.spawnFigure(BlackKnight[1], 7, 6 );
    }

    @Override
    public boolean ifPossible(Coordinates from, Coordinates to){
        if(to.getRow() == from.getRow() + 2 && to.getColumn() == from.getColumn() + 1) return true;
        if(to.getRow() == from.getRow() + 2 && to.getColumn() == from.getColumn() + -1) return true;
        if(to.getRow() == from.getRow() + -2 && to.getColumn() == from.getColumn() + 1) return true;
        if(to.getRow() == from.getRow() + -2 && to.getColumn() == from.getColumn() - 1) return true;
        if(to.getColumn() == from.getColumn() + 2 && to.getRow() == from.getRow() + 1) return true;
        if(to.getColumn() == from.getColumn() + 2 && to.getRow() == from.getRow() - 1) return true;
        if(to.getColumn() == from.getColumn() - 2 && to.getRow() == from.getRow() + 1) return true;
        if(to.getColumn() == from.getColumn() - 2 && to.getRow() == from.getRow() - 1) return true;
        else return false;
    }

    public String toString() {
        if(this.color)  return "W_Knight";
        else return "B_Knight";
    }
}
