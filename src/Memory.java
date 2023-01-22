import java.util.Random;
public class Memory {
    private static final char[][] arr = new char[4][4];

    private static boolean notFull() {
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++)
                if((int)(arr[i][j])==0)
                    return true;

        return false;
    }

    public static void fillArray() {
        int firstIndex, secondIndex, thirdIndex, fourthIndex;
        char randomChar = 65; //ASCII index of 'A'
        Random generator = new Random();

        while(notFull()) {

            //continue creating random indexes if the target index is full or if the 2 target indexes are same
            do {
                firstIndex = generator.nextInt(4);
                secondIndex = generator.nextInt(4);
                thirdIndex = generator.nextInt(4);
                fourthIndex = generator.nextInt(4);
            } while((arr[firstIndex][secondIndex]!=0) || (arr[thirdIndex][fourthIndex]!=0) || (firstIndex == thirdIndex) && (secondIndex == fourthIndex));

            arr[firstIndex][secondIndex]=randomChar;
            arr[thirdIndex][fourthIndex]=randomChar;
            randomChar += 1;
        }
    }

    public static void printBoard() {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==' ')
                    System.out.print("   ");
                else
                    System.out.print("#  ");
            }
            System.out.println();
        }
    }

    public static boolean flipFirstCard(int index1, int index2) {
        if((index1<0) || (index1>3) || (index2<0) || (index2>3) || (arr[index1][index2]==' '))
            return false;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==' ')
                    System.out.print("   ");
                else if(index1==i && index2==j)
                    System.out.print(arr[i][j]+"  ");
                else
                    System.out.print("#  ");
            }
            System.out.println();
        }
        return true;
    }

    public static boolean flipSecondCard(int index1, int index2, int index3, int index4) {
        if((index3<0) || (index3>3) || (index4<0) || (index4>3) || (arr[index3][index4]==' ') || (index1==index3 && index2==index4))
            return false;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==' ')
                    System.out.print("   ");
                else if((index1==i && index2==j) || (index3==i && index4==j))
                    System.out.print(arr[i][j]+"  ");
                else
                    System.out.print("#  ");
            }
            System.out.println();
        }
        return true;
    }

    public static void matchCards(int a, int b, int c, int d) {
        if(arr[a][b] == arr[c][d]) {
            arr[a][b]=' ';
            arr[c][d]=' ';
            System.out.println("\nCongratulates!!");
        }
    }

    public static boolean winCondition() {
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++)
                if((int)(arr[i][j])!=' ')
                    return false;

        return true;
    }
}
