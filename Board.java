import java.util.ArrayList;
import java.util.List;

public class Board {

    static private Figure[][] board = new Figure[8][8];
    static List<Figure> whiteFigures = new ArrayList<Figure>();
    static List<Figure> blackFigures = new ArrayList<Figure>();

    static Pawn pawn;
    static Rook rook;
    static Knight knight;
    static Bishop bishop;
    static Queen queen;
    static King king;


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

//    public static boolean whiteCheckCheck(){
//        for(Figure figure : Board.whiteFigures){
//            if(figure.ifPossible(locateFigure(figure),locateFigure(king.BlackKing[0]))) return true;
//        }
//                                                                             //Do dokończenia
//        return false;
//    }
//
//    public static boolean blackCheckCheck(){
//        for(Figure figure : Board.blackFigures){
//            if(figure.ifPossible(locateFigure(figure), locateFigure(king.WhiteKing[0]))) return true;
//        }
//                                                                             //Do dokończenia
//        return false;
//    }
    public static Coordinates locateFigure(Figure a){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(a.equals(board[i][j])) return new Coordinates(i,j);
            }
        }
        return new Coordinates(21,37);
    }

}




