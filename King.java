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
        WhiteKing[0] = new King(true); Board.putFigure(WhiteKing[0], 0, 4);
        BlackKing[0] = new King(false); Board.putFigure(BlackKing[0], 7, 3);
    }

    public String toString(){
        if(this.color) return "B_King";
        else return "W_King";
    }
}
