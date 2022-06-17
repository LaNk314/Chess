public class Board {

    static private Figure[][] board = new Figure[8][8];

    Pawn pawn;
    Rook rook;
    Knight knight;
    Bishop bishop;
    Queen queen;
    King king;

    Board() {
        pawn = new Pawn();
        rook = new Rook();
        knight = new Knight();
        bishop = new Bishop();
        queen = new Queen();
        king = new King();
    }

    public String printBoard() {

        String result = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j] == null){
                    result += "|  #  |";
                    continue;
                }
                result += "|" + board[i][j] + "|";
            }
            result += "  " + (i + 1) + "\n";
        }
        for(int i = 0; i < 8; i++){
            result += "   " + Character.toString(65 + i) + "   ";
        }
        return result;
    }

    public static Figure identifyFigure(Coordinates a){
        if(a.getRow() >= 0 && a.getRow() < 8 && a.getColumn() >= 0 && a.getColumn() < 8) {
            return board[a.getRow()][a.getColumn()];
        }
        else {
            System.out.println("Out of board");
            return null;
        }
        }

    public static boolean moveFigure(Coordinates from, Coordinates to) {
        Figure a = identifyFigure(from);
        if(a.ifPossible(from, to)) {
            if(to.getRow() >= 0 && to.getRow() < 8 && to.getColumn() >= 0 && to.getColumn() < 8) {
                board[to.getRow()][to.getColumn()] = a;
                board[from.getRow()][from.getColumn()] = null;
                //System.out.println("Success!");
                return true;
            }
            //else System.out.println("Out of chessboard");
            return false;
        }
        //else System.out.print("Invalid move for that figure");
        return false;
    }

    public static void spawnFigure(Figure a, Coordinates where){
        board[where.getRow()][where.getColumn()] = a;
    }
    public static boolean checkCheck(){
        King.checkSafety();                                                                     //Do dokończenia
        return false;
    }
    public static boolean locateFigure(Figure a){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(a == board[i][j]) return true;
            }
        }
        return false;
    }

}




