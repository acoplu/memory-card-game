import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index1, index2, index3, index4;
        boolean check;
        Memory.fillArray(); //shuffle all cards and create new game board

        while(Memory.winCondition()==false) {

            Memory.printBoard();

            System.out.println("Please enter the first indexes of first card you want to flip: ");
            System.out.print("[ROW-1] --> ");
            index1=scan.nextInt();
            System.out.print("[COLUMN-1] --> ");
            index2=scan.nextInt();
            check=Memory.flipFirstCard(index1-1, index2-1); // return false if we made illegal move
            if(check==false) {
                System.out.println("Illegal move...\n\n\n");
                continue;
            }

            System.out.println("Please enter the indexes of second card you want to flip: ");
            System.out.print("[ROW-2] --> ");
            index3=scan.nextInt();
            System.out.print("[COLUMN-2] --> ");
            index4=scan.nextInt();
            check=Memory.flipSecondCard(index1-1, index2-1, index3-1, index4-1);
            if(check==false){
                System.out.println("Illegal move...\n\n\n");
                continue;
            }

            Memory.matchCards(index1-1, index2-1, index3-1, index4-1);
            System.out.println("\n\n\n");
        }

        System.out.println("\n\nCongratulations!!! You win the game.");
    }
}
