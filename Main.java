public class Main {
    static Board board;
    public static void main(String[] args) {
        board = new Board();


        Player black = new Player(false);
        Player white  = new Player(true);

        System.out.println(board.printBoard());

        while(true){                        //while(not szach)!

            //White player
            System.out.println("Ruch białych");
            white.movePrompt();
            if(!Board.locateFigure(King.BlackKing[0])){
                System.out.println("Wygrana białych!");
                break;
            }
            System.out.println(board.printBoard());

            //Black player
            System.out.println("Ruch czarnych");
            black.movePrompt();
            if(!Board.locateFigure(King.WhiteKing[0])){
                System.out.println("Wygrana czarnych!");
                break;
            }

            System.out.println(board.printBoard());
        }

        System.out.println("Koniec!");


















    }
}
