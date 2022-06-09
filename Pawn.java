public class Pawn extends Figure{

    Pawn[] WhitePawns = new Pawn[8];
    Pawn[] BlackPawns = new Pawn[8];

    Pawn(){
        fillBoard();
    }

    Pawn(boolean color) {
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        for(int i = 0; i < 8; i++){
            WhitePawns[i] = new Pawn(true); Board.putFigure(WhitePawns[i],1, i);
            BlackPawns[i] = new Pawn(false); Board.putFigure(BlackPawns[i],6, i);
        }
    }

    @Override
    public String toString() {
        if(this.color) return "W_Pawn";
        else return "B_Pawn";
    }
}
