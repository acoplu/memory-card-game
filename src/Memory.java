import java.util.Random;

public class Memory {
    private static char[][] arr = new char[4][4];

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

            do {
                firstIndex = generator.nextInt(4);
                secondIndex = generator.nextInt(4);
                thirdIndex = generator.nextInt(4);
                fourthIndex = generator.nextInt(4);

            } while((arr[firstIndex][secondIndex]!=0) && (arr[thirdIndex][fourthIndex]!=0) && (firstIndex != thirdIndex) && (secondIndex != fourthIndex));

            arr[firstIndex][secondIndex]=randomChar;
            arr[thirdIndex][fourthIndex]=randomChar;
            randomChar += 1;
        }
    }

    public static void main(String[] args) {
        fillArray();
    }

}
