public class Rook extends Figure{

    Rook[] WhiteRook = new Rook[2];
    Rook[] BlackRook = new Rook[2];

    Rook(){
        fillBoard();
    }

    Rook(boolean color){
        this.color = color;
    }

    void move(){

    }

    void fillBoard(){
        WhiteRook[0]  = new Rook(true); Board.putFigure(WhiteRook[0],0, 0);
        WhiteRook[1]  = new Rook(true); Board.putFigure(WhiteRook[1], 0, 7);

        BlackRook[0] = new Rook(false); Board.putFigure(BlackRook[0], 7, 0);
        BlackRook[1] = new Rook(false); Board.putFigure(BlackRook[1], 7, 7);
        }

    @Override
    public String toString() {
        if(this.color) return "W_Rook";
        else return "B_Rook";
    }
}
