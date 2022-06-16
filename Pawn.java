public class Pawn extends Figure{

    Pawn[] WhitePawns = new Pawn[8];
    Pawn[] BlackPawns = new Pawn[8];

    Pawn(){
        fillBoard();
    }
    Pawn(boolean color) {
        this.color = color;
    }

    void move(){}
    void fillBoard(){
        for(int i = 0; i < 8; i++){
            WhitePawns[i] = new Pawn(true); Board.spawnFigure(WhitePawns[i],1, i);
            BlackPawns[i] = new Pawn(false); Board.spawnFigure(BlackPawns[i],6, i);
        }
    }
    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();

        if (color){                                                                         //kolor biały
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) {            //scenariusz dla ruchu
                    if (destinationColumn == initialColumn) {
                        if (destinationRow == initialRow + 2 && initialRow == 1 && Board.identifyFigure(new Coordinates(initialRow +1, initialColumn)) == null) return true;
                        else if (destinationRow == initialRow + 1) return true;
                    }
                return false;
            } else if(!Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color){       //scenariusz dla ataku
                if(destinationColumn == initialColumn + 1 || destinationColumn == initialColumn - 1 && destinationRow == initialRow + 1) return true;
            }
        } else {                                                                            //kolor czarny
            if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)) == null) {            //scenariusz dla ruchu
                if (destinationColumn == initialColumn) {
                    if (destinationRow == initialRow - 2 && initialRow == 6 && Board.identifyFigure(new Coordinates(initialRow -1, initialColumn)) == null) return true;
                    else if (destinationRow == initialRow - 1) return true;
                }
                return false;
            } else if(Board.identifyFigure(new Coordinates(destinationRow,destinationColumn)).color){        //scenariusz dla ataku
                if(destinationColumn == initialColumn + 1 || destinationColumn == initialColumn - 1 && destinationRow == initialRow - 1) return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        if(this.color) return "PAWN";
        else return "pawn";
    }
}
