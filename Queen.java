public class Queen extends Figure{

    Queen[] WhiteQueen = new Queen[1];
    Queen[] BlackQueen = new Queen[1];

    Queen(){
        fillBoard();
    }

    Queen(boolean color){
        this.color = color;
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

        if(destinationColumn > initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow + i;
                int iteratedColumn = initialColumn + i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(new Coordinates(iteratedRow, iteratedColumn)) != null) break;
                } else break;
            }
        } else if(destinationColumn > initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow - i;
                int iteratedColumn = initialColumn + i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(new Coordinates(iteratedRow, iteratedColumn)) != null) break;
                } else break;
            }
        } else if(destinationColumn < initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow + i;
                int iteratedColumn = initialColumn - i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(new Coordinates(iteratedRow, iteratedColumn)) != null) break;
                } else break;
            }
        } else if(destinationColumn < initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow - i;
                int iteratedColumn = initialColumn - i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(new Coordinates(destinationRow,destinationColumn));
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(new Coordinates(iteratedRow, iteratedColumn)) != null) break;
                } else break;
            }
        }

        return false;
    }

    public String toString(){
        if(this.color) return "QUEN";
        else return "quen";
    }
}
