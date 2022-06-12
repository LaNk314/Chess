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
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();
        int p = Math.min(initialColumn, initialRow);

        if(destinationColumn > initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= p; i++){
                if(Board.identifyFigure(initialRow + i, initialColumn + i) != null) break;
                if(destinationRow == initialRow + i && destinationColumn == initialColumn + i) return true;
            }
        } else if(destinationColumn > initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= p; i++){
                if(Board.identifyFigure(initialRow - i, initialColumn + i) != null) break;
                if(destinationRow == initialRow - i && destinationColumn == initialColumn + i) return true;
            }
        } else if(destinationColumn < initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= p; i++){
                if(Board.identifyFigure(initialRow + i, initialColumn - i) != null) break;
                if(destinationRow == initialRow + i && destinationColumn == initialColumn - i) return true;
            }
        } else if(destinationColumn < initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= p; i++){
                if(Board.identifyFigure(initialRow - i, initialColumn - i) != null) break;
                if(destinationRow == initialRow - i && destinationColumn == initialColumn - i) return true;
            }
        }

        return false;
    }

    public String toString(){
        if(this.color) return "W_Bishop";
        else return "B_Bishop";
    }
}
