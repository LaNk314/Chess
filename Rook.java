public class Rook extends Figure{

    Rook[] WhiteRook = new Rook[2];
    Rook[] BlackRook = new Rook[2];

    Rook(){
        fillBoard();
    }

    Rook(boolean color){
        this.color = color;
    }

    void fillBoard(){
        WhiteRook[0]  = new Rook(true); Board.spawnFigure(WhiteRook[0],new Coordinates(0, 0));
        WhiteRook[1]  = new Rook(true); Board.spawnFigure(WhiteRook[1],new Coordinates( 0, 7));

        BlackRook[0] = new Rook(false); Board.spawnFigure(BlackRook[0],new Coordinates( 7, 0));
        BlackRook[1] = new Rook(false); Board.spawnFigure(BlackRook[1],new Coordinates( 7, 7));
        }
    @Override
    public boolean ifPossible(Coordinates from, Coordinates to){
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();

        if(destinationColumn == initialColumn) {
            for (int i = initialRow + 1; i < 8; i++) {
                if (destinationRow == i) {
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(i >= 0 && i < 8) {
                    if (Board.identifyFigure(new Coordinates(i, initialColumn)) != null) break;
                } else break;
            }                                                                               //Ruch wzdłuż kolumn
            for (int i = initialRow - 1; i >= 0; i--) {
                if (destinationRow == i) {
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(i >= 0 && i < 8) {
                    if (Board.identifyFigure(new Coordinates(i, initialColumn)) != null) break;
                } else break;
            }
        } else if(destinationRow == initialRow) {
            for (int i = initialColumn + 1; i < 8; i++) {
                if (destinationColumn == i) {
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(i >= 0 && i < 8) {
                    if (Board.identifyFigure(new Coordinates(initialRow, i)) != null) break;
                } else break;
            }                                                                               //Ruch wzdłuż wierszy
            for (int i = initialColumn - 1; i >= 0; i--) {
                if (destinationColumn == i) {
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(i >= 0 && i < 8) {
                    if (Board.identifyFigure(new Coordinates(initialRow, i)) != null) break;
                } else break;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        if(this.color) return "wRook";
        else return "bRook";
    }
}
