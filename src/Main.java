import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index1, index2, index3, index4;
        boolean check;
        Memory.fillArray(); //shuffle all cards and create new game board

        while(Memory.winCondition()==false) {

            Memory.printBoard();

            System.out.println("Please enter the 2 index you want to flip:");
            index1=scan.nextInt();
            index2=scan.nextInt();
            check=Memory.flipFirstCard(index1, index2); // return false if we made illegal move
            if(check==false) {
                System.out.println("Illegal move...\n\n\n");
                continue;
            }

            System.out.println("Please enter the 2 index you want to flip:");
            index3=scan.nextInt();
            index4=scan.nextInt();
            check=Memory.flipSecondCard(index1, index2, index3, index4);
            if(check==false){
                System.out.println("Illegal move...\n\n\n");
                continue;
            }

            Memory.matchCards(index1, index2, index3, index4);
            System.out.println("\n\n\n");
        }

        System.out.println("\n\nCongratulations!!! You win the game.");
    }
}
