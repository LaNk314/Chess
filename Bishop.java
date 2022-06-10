public class Bishop extends Figure{

    Bishop[] WhiteBishop = new Bishop[2];
    Bishop[] BlackBishop = new Bishop[2];

    Bishop() {
        fillBoard();
    }

    Bishop(boolean color){
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        WhiteBishop[0] = new Bishop(true); Board.spawnFigure(WhiteBishop[0], 0, 2);
        WhiteBishop[1] = new Bishop(true); Board.spawnFigure(WhiteBishop[1],0,5 );

        BlackBishop[0] = new Bishop(false); Board.spawnFigure(BlackBishop[0],7, 2);
        BlackBishop[1] = new Bishop(false); Board.spawnFigure(BlackBishop[1], 7, 5);
    }
    @Override
    public boolean ifPossible(Coordinates from, Coordinates to){
        for(int i = -7; i < 8; i++){
            if(to.getRow() == from.getRow() + i && to.getColumn() == from.getColumn() + i) return true;
            if(to.getRow() == from.getRow() + i && to.getColumn() == from.getColumn() - i) return true;
            if(to.getRow() == from.getRow() - i && to.getColumn() == from.getColumn() + i) return true;
            if(to.getRow() == from.getRow() - i && to.getColumn() == from.getColumn() - i) return true;
        }
        return false;
    }

    public String toString(){
        if(this.color) return "W_Bishop";
        else return "B_Bishop";
    }
}
