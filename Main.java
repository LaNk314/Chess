public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        System.out.println(board.printBoard());

        Pawn ptest = new Pawn();
        Pawn Btmp = ptest.BlackPawns[4];
        Pawn Wtmp = ptest.WhitePawns[7];

        Rook rtest = new Rook();
        Rook TmpRook = rtest.BlackRook[1];

        Knight kntest = new Knight();
        Knight TmpKnight = kntest.WhiteKnight[0];

        Bishop btest = new Bishop();
        Bishop TmpBishop = btest.BlackBishop[1];

        King ktest = new King();
        King TmpKing = ktest.BlackKing[0];

        Queen qtest = new Queen();
        Queen TmpQueen = qtest.BlackQueen[0];



        System.out.println(Board.locateFigure(Btmp));


       /*
        Board.putFigure(tmp,4,2);
        System.out.println(Board.identifyFigure(4,2));
        System.out.println(Board.locateFigure(tmp));
        */
        /*
        Board.moveFigure(Btmp, 4,4);
        Board.moveFigure(Wtmp,3, 7);
        */

        System.out.println(Board.locateFigure(TmpRook ));
        Board.moveFigure(TmpRook, 3,7);
        Board.moveFigure(TmpRook, 3,2);
        /*
        System.out.println(Board.locateFigure(TmpKnight));
        Board.moveFigure(TmpKnight, 2,2);
        Board.moveFigure(TmpKnight, 4,3);

        System.out.println(Board.locateFigure(TmpBishop));
        Board.moveFigure(TmpBishop, 2,0);
        Board.moveFigure(TmpBishop, 1,1);
        */
        System.out.println(Board.locateFigure(TmpKing));
        Board.moveFigure(TmpKing, 6,4);
        Board.moveFigure(TmpKing, 5,4);

        System.out.println(Board.locateFigure(TmpQueen));
        Board.moveFigure(TmpQueen, 3,4);
        Board.moveFigure(TmpQueen, 3,-1);



        System.out.println("\n"+board.printBoard());



    }
}
