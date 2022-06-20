import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Player implements IPlayer {
    Scanner playerInput = new Scanner(System.in);

    List aliveFigures = new ArrayList();

    private boolean color;
    Map<String, Integer> tiles = new HashMap<>();
    Map<String, Integer> figures = new HashMap<>();

    Player(boolean color) {
        this.color = color;

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                tiles.put(Character.toString(65 + i) + (j + 1), j * 10 + i);
            }
        }
        figures.put("Q",1);
        figures.put("R",2);
        figures.put("K",3);
        figures.put("B",4);
    }


    public void movePrompt() {
        int sourceInt;
        int destinationInt;

        while (true) {
            System.out.println("Wybierz figurę do ruszenia (Duża litera + liczba): ");
            try {
                sourceInt = tiles.get(playerInput.next());
            } catch (NullPointerException a) {
                System.out.println("Wybierz poprawne pole!");
                continue;
            }
            Coordinates source = new Coordinates(sourceInt / 10 % 10, sourceInt % 10);
            if(Board.identifyFigure(source) == null){
                System.out.println("Nie możesz ruszyć pustym polem!");
                continue;
            }
            if(Board.identifyFigure(source).color != this.color){
                System.out.println("To nie jest twoja figura!");
                continue;
            }

            System.out.println("Dokąd chcesz się ruszyć? (Duża litera + liczba): ");
            try {
                destinationInt = tiles.get(playerInput.next());
            } catch (NullPointerException a) {
                System.out.println("Wybierz poprawne pole!");
                continue;
            }
            Coordinates destination = new Coordinates(destinationInt / 10 % 10, destinationInt % 10);

            if(Board.moveFigure(source, destination)) {
                if(Board.identifyFigure(destination) instanceof Pawn) {
                    if ((destination.getRow() == 0 && !color) || destination.getRow() == 7 && color) {
                        while (true) {
                            Board.spawnFigure(null, destination);
                            System.out.println("Doszedłeś do końca planszy pionkiem, wybierz figurę do podstawienia zamiast niego!: ");
                            System.out.println("Wieża: R; Skoczek: K; Goniec: B; Królowa: Q");
                            String upgradedPawn = playerInput.next();
                            try {
                                int idk = figures.get(upgradedPawn);
                            } catch (NullPointerException a) {
                                System.out.println("Wybierz jedną z opcji: R, K, B, Q");
                                continue;
                            }
                            switch (upgradedPawn) {
                                case "R":
                                    if (color) Board.spawnFigure(new Rook().WhiteRook[0], destination);
                                    else Board.spawnFigure(new Rook().BlackRook[0], destination);
                                    break;

                                case "K":
                                    if (color) Board.spawnFigure(new Knight().WhiteKnight[0], destination);
                                    else Board.spawnFigure(new Knight().BlackKnight[0], destination);
                                    break;

                                case "B":
                                    if (color) Board.spawnFigure(new Bishop().WhiteBishop[0], destination);
                                    else Board.spawnFigure(new Bishop().BlackBishop[0], destination);
                                    break;

                                case "Q":
                                    if (color) Board.spawnFigure(new Queen().WhiteQueen[0], destination);
                                    else Board.spawnFigure(new Queen().BlackQueen[0], destination);
                                    break;
                            }
                            break;
                        }
                    }
                }
                break;
            }
            System.out.println("Niepoprawny ruch, spróbuj ponownie");
        }
    }
}



