public class Knight extends Figure {

    Knight[] WhiteKnight = new Knight[2];
    Knight[] BlackKnight = new Knight[2];

    Knight() {
        fillBoard();
    }

    Knight(boolean color) {
        this.color = color;
    }

    void fillBoard() {
        WhiteKnight[0] = new Knight(true);
        Board.spawnFigure(WhiteKnight[0],new Coordinates(0, 1));
        WhiteKnight[1] = new Knight(true);
        Board.spawnFigure(WhiteKnight[1],new Coordinates(0, 6));

        BlackKnight[0] = new Knight(false);
        Board.spawnFigure(BlackKnight[0],new Coordinates(7, 1));
        BlackKnight[1] = new Knight(false);
        Board.spawnFigure(BlackKnight[1],new Coordinates(7, 6));
    }

    @Override
    public boolean ifPossible(Coordinates from, Coordinates to) {
        int initialRow = from.getRow();
        int initialColumn = from.getColumn();
        int destinationRow = to.getRow();
        int destinationColumn = to.getColumn();

        if (destinationRow == initialRow + 2 && destinationColumn == initialColumn + 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationRow == initialRow + 2 && destinationColumn == initialColumn + -1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationRow == initialRow + -2 && destinationColumn == initialColumn + 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationRow == initialRow + -2 && destinationColumn == initialColumn - 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationColumn == initialColumn + 2 && destinationRow == initialRow + 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationColumn == initialColumn + 2 && destinationRow == initialRow - 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationColumn == initialColumn - 2 && destinationRow == initialRow + 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        if (destinationColumn == initialColumn - 2 && destinationRow == initialRow - 1) {
            if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)) == null) return true;
            else if (Board.identifyFigure(new Coordinates(destinationRow, destinationColumn)).color != this.color)
                return true;
        }
        return false;
    }

    public String toString() {
        if (this.color) return "wHors";
        else return "bHors";
    }
}