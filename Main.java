public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        System.out.println(board.printBoard());

        Pawn test = new Pawn();
        Pawn tmp = test.BlackPawns[4];

        Board.putFigure(tmp,4,2);
        System.out.println(Board.identifyFigure(4,2));
        System.out.println(Board.locateFigure(tmp));



    }
}
