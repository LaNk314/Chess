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
        WhiteKnight[0] = new Knight(true); Board.putFigure(WhiteKnight[0], 0, 1);
        WhiteKnight[1] = new Knight(true); Board.putFigure(WhiteKnight[1], 0, 6);

        BlackKnight[0] = new Knight(false); Board.putFigure(BlackKnight[0], 7, 1);
        BlackKnight[1] = new Knight(false); Board.putFigure(BlackKnight[1], 7, 6 );
    }

    public String toString() {
        if(this.color)  return "W_Knight";
        else return "B_Knight";
    }
}
