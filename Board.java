import java.sql.SQLOutput;

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
                if(board[i][j] == null){
                    result += "|  Empty   |";
                    continue;
                }
                result += "|" + board[i][j] + "|";
            }
            result += "\n";
        }
        return result;
    }
    public static Figure identifyFigure(int row, int column){
            return  board[row][column];
        }
    public static void moveFigure(Figure a, int row, int column) {

        Coordinates primaryState = locateFigure(a);
        if(a.ifPossible(primaryState, new Coordinates(row, column))) {
            if(row >= 0 && row < 8 && column >= 0 && column < 8) {
                board[row][column] = a;
                board[primaryState.getRow()][primaryState.getColumn()] = null;
                System.out.println("Success!");
            }
            else System.out.println("Out of chessboard");
        }
        else System.out.print("Invalid move for that figure");
    }
    public static void spawnFigure(Figure a, int row, int column){
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




