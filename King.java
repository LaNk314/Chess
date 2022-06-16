public class King extends Figure{

    static King[] WhiteKing = new King[1];
    static King[] BlackKing = new King[1];

    King(){
        fillBoard();
    }

    King(boolean color){
        this.color = color;
    }

    public static void checkSafety() {
        //Pawn

        //Rook

        //Knight

        //Bishop

        //King

        //Queen
    }


    void fillBoard(){
        WhiteKing[0] = new King(true); Board.spawnFigure(WhiteKing[0], 0, 4);
        BlackKing[0] = new King(false); Board.spawnFigure(BlackKing[0], 7, 3);
    }

    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();

        if(destinationRow == initialRow + 1 && destinationColumn == initialColumn + 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow + 1 && destinationColumn == initialColumn){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow + 1 && destinationColumn == initialColumn - 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow && destinationColumn == initialColumn - 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow - 1 && destinationColumn == initialColumn - 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow - 1 && destinationColumn == initialColumn){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow - 1 && destinationColumn == initialColumn + 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
        if(destinationRow == initialRow && destinationColumn == initialColumn + 1){
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) return true;
            else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color != this.color) return true;
        }
    return false;
    }

    public String toString(){
        if(this.color) return "KING";
        else return "king";
    }
}
