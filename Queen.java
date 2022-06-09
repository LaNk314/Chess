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
        WhiteQueen[0] = new Queen(true); Board.putFigure(WhiteQueen[0], 0, 3);
        BlackQueen[0] = new Queen(false); Board.putFigure(BlackQueen[0], 7, 4);
    }

    public String toString(){
        if(this.color) return "W_Queen";
        else return "B_Queen";
    }
}
