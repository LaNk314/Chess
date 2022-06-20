public class Bishop extends Figure{

    Bishop[] WhiteBishop = new Bishop[2];
    Bishop[] BlackBishop = new Bishop[2];

    Bishop() {
        fillBoard();
    }

    Bishop(boolean color){
        this.color = color;
    }

    void fillBoard(){
        WhiteBishop[0] = new Bishop(true); Board.spawnFigure(WhiteBishop[0],new Coordinates(0, 2));
        WhiteBishop[1] = new Bishop(true); Board.spawnFigure(WhiteBishop[1],new Coordinates(0,5 ));
        Board.whiteFigures.add(WhiteBishop[0]);
        Board.whiteFigures.add(WhiteBishop[1]);

        BlackBishop[0] = new Bishop(false); Board.spawnFigure(BlackBishop[0],new Coordinates(7, 2));
        BlackBishop[1] = new Bishop(false); Board.spawnFigure(BlackBishop[1],new Coordinates(7, 5));
        Board.blackFigures.add(BlackBishop[1]);
        Board.blackFigures.add(BlackBishop[0]);

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
        if(this.color) return "wBish";
        else return "bBish";

    }
}
