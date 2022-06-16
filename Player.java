import java.util.Scanner;

public class Player implements IPlayer {
    Scanner playerInput = new Scanner(System.in);

    private boolean color;

    Player(boolean color){
        this.color = color;
    }

    public void movePrompt(){
        int sourceInt;
        int destinationInt;

        while(true) {
            System.out.println("Podaj ruch: skąd / dokąd");
            System.out.println("współrzędne początkowe: ");
            sourceInt = playerInput.nextInt();
            if(sourceInt < 0 || sourceInt > 77){
                System.out.println("Niepoprawna liczba");
                continue;
            }
            Coordinates source = new Coordinates(sourceInt/10%10, sourceInt%10);

            if(Board.identifyFigure(source) == null){
                System.out.println("Nie możesz ruszyć pustym polem");
                continue;
            }
             if(Board.identifyFigure(source).color != this.color){
                 System.out.println("To nie jest twoja figura");
                 continue;
             }

            System.out.println("współrzędne końcowe: ");
            destinationInt = playerInput.nextInt();
            if(destinationInt < 0 || destinationInt > 77){
                System.out.println("Niepoprawna liczba");
                continue;
            }
            Coordinates destination = new Coordinates(destinationInt/10%10, destinationInt%10);

             if(Board.moveFigure(source,destination)) break;
             else {
                 System.out.println("Niepoprawny ruch");
                 continue;
             }
        }
    }

}
