public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        System.out.println(board.printBoard());

        Pawn ptest = new Pawn();
        Pawn TmpPawn = ptest.WhitePawns[5];

        Rook rtest = new Rook();
        Rook TmpRook = rtest.BlackRook[1];

        Knight kntest = new Knight();
        Knight TmpKnight = kntest.WhiteKnight[1];

        Bishop btest = new Bishop();
        Bishop TmpBishop = btest.BlackBishop[1];

        King ktest = new King();
        King TmpKing = ktest.WhiteKing[0];

        Queen qtest = new Queen();
        Queen TmpQueen = qtest.BlackQueen[0];





       /*
        Board.putFigure(tmp,4,2);
        System.out.println(Board.identifyFigure(4,2));
        System.out.println(Board.locateFigure(tmp));
        */
        /*
        Board.moveFigure(Btmp, 4,4);
        Board.moveFigure(Wtmp,3, 7);
        */

/*
        System.out.println(Board.locateFigure(TmpRook ));
        Board.moveFigure(TmpRook, 6,7);
        Board.moveFigure(TmpRook, 5,0);

        System.out.println(Board.locateFigure(TmpKnight));
        Board.moveFigure(TmpKnight, 2,2);
        Board.moveFigure(TmpKnight, 4,3);

        Board.moveFigure(Btmp, 4,4);
        System.out.println(Board.locateFigure(TmpBishop));
        Board.moveFigure(TmpBishop, 6,4);
        Board.moveFigure(TmpBishop, 3,7);
        Board.moveFigure(TmpBishop, 1,5);

/*
        System.out.println(Board.locateFigure(TmpKing));
        Board.moveFigure(TmpKing, 6,4);
        Board.moveFigure(TmpKing, 5,4);
*/
        Board.moveFigure(TmpPawn,2,5);
        Board.moveFigure(TmpQueen, -1,5);



        System.out.println("\n"+board.printBoard());



    }
}
