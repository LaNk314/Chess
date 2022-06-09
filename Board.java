public class Board {

    static private Figure[][] board = new Figure[8][8];

    Board() {
        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Knight knight = new Knight();
        Bishop bishop = new Bishop();
        Queen queen = new Queen();
        King king = new King();
    }

    public String printBoard() {
        String result = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result += "| " + board[i][j] + " |";
            }
            result += "\n";
        }
        return result;
    }
    public static Figure identifyFigure(int row, int column){
        return  board[row][column];
    }
    public static void putFigure(Figure a, int row, int column) {
        board[row][column] = a;
    }
    public static Coordinates locateFigure(Figure a){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(a == board[i][j]) return new Coordinates(i,j);
            }
        }
        return new Coordinates(21,37);
    }

}




