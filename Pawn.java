public class Pawn extends Figure{

    Pawn[] WhitePawns = new Pawn[8];
    Pawn[] BlackPawns = new Pawn[8];

    Pawn(){
        fillBoard();
    }
    Pawn(boolean color) {
        this.color = color;
    }

    void move(){}
    void fillBoard(){
        for(int i = 0; i < 8; i++){
            WhitePawns[i] = new Pawn(true); Board.spawnFigure(WhitePawns[i],1, i);
            BlackPawns[i] = new Pawn(false); Board.spawnFigure(BlackPawns[i],6, i);
        }
    }
    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        if (color){
            if(to.getColumn() == from.getColumn()) {
                if (to.getRow() == from.getRow() + 2 && from.getRow() == 1) return true;
                else if (to.getRow() == from.getRow() + 1) return true;
            } return false;

        } else {
            if (to.getColumn() == from.getColumn()) {
                if (to.getRow() == from.getRow() - 2 && from.getRow() == 6) return true;
                else if (to.getRow() == from.getRow() - 1) return true;
            } return false;
        }
    }
    @Override
    public String toString() {
        if(this.color) return "W_Pawn";
        else return "B_Pawn";
    }
}
