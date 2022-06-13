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

        if(destinationColumn > initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow + i;
                int iteratedColumn = initialColumn + i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(destinationRow,destinationColumn);
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(iteratedRow, iteratedColumn) != null) break;
                } else break;
            }
        } else if(destinationColumn > initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow - i;
                int iteratedColumn = initialColumn + i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(destinationRow,destinationColumn);
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(iteratedRow, iteratedColumn) != null) break;
                } else break;
            }
        } else if(destinationColumn < initialColumn && destinationRow > initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow + i;
                int iteratedColumn = initialColumn - i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(destinationRow,destinationColumn);
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(iteratedRow, iteratedColumn) != null) break;
                } else break;
            }
        } else if(destinationColumn < initialColumn && destinationRow < initialRow){
            for(int i = 1; i <= 7; i++){
                int iteratedRow = initialRow - i;
                int iteratedColumn = initialColumn - i;
                if(destinationRow == iteratedRow && destinationColumn == iteratedColumn){
                    Figure figureAtDestination = Board.identifyFigure(destinationRow,destinationColumn);
                    if(figureAtDestination == null) return true;
                    else if(figureAtDestination.color != this.color) return true;
                    return false;
                }
                if(iteratedRow >= 0 && iteratedRow < 8 && iteratedColumn >= 0 && iteratedColumn < 8) {
                    if (Board.identifyFigure(iteratedRow, iteratedColumn) != null) break;
                } else break;
            }
        }

        return false;
    }

    public String toString(){
        if(this.color) return " W Bishop ";
        else return " B Bishop ";

    }
}
