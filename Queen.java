public class Queen extends Figure{

    Queen[] WhiteQueen = new Queen[1];
    Queen[] BlackQueen = new Queen[1];

    Queen(){
        fillBoard();
    }

    Queen(boolean color){
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        WhiteQueen[0] = new Queen(true); Board.spawnFigure(WhiteQueen[0], 0, 3);
        BlackQueen[0] = new Queen(false); Board.spawnFigure(BlackQueen[0], 7, 4);
    }

    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        for(int i = -7; i < 8; i++){
            if(to.getRow() == from.getRow() + i && to.getColumn() == from.getColumn() + i) return true; //mechanika poruszania sie bishopa
            if(to.getRow() == from.getRow() + i && to.getColumn() == from.getColumn() - i) return true;
            if(to.getRow() == from.getRow() - i && to.getColumn() == from.getColumn() + i) return true;
            if(to.getRow() == from.getRow() - i && to.getColumn() == from.getColumn() - i) return true;

            if(to.getRow() == from.getRow() + i && to.getColumn() == from.getColumn()) return true;     //mechanika poruszania sie rooka
            if(to.getColumn() == from.getColumn() + i && to.getRow() == from.getRow()) return true;
        }
        return false;
    }

    public String toString(){
        if(this.color) return "W_Queen";
        else return "B_Queen";
    }
}
