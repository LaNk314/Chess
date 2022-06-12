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
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();
        int p = Math.min(initialColumn, initialRow);

        if(destinationColumn == initialColumn) {
            for (int i = initialRow + 1; i < 8; i++) {
                if(Board.identifyFigure(i, initialColumn) != null) break;
                if (destinationRow == i) return true;
            }                                                                               //Ruch wzdłuż kolumn
            for (int i = initialRow - 1; i >= 0; i--) {
                if(Board.identifyFigure(i, initialColumn) != null) break;
                if (destinationRow == i) return true;
            }
        } else if (destinationRow == initialRow) {
            for (int i = initialColumn + 1; i < 8; i++) {
                if(Board.identifyFigure(initialRow, i) != null) break;
                if (destinationColumn == i) return true;
            }                                                                               //Ruch wzdłuż wierszy
            for (int i = initialColumn - 1; i >= 0; i--) {
                if(Board.identifyFigure(initialRow, i) != null) break;
                if (destinationColumn == i) return true;
            }
        }

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
        if(this.color) return "W_Queen";
        else return "B_Queen";
    }
}
