package binarySearch;

import java.util.Scanner;

public class BinarySearchMain {


    public static int log2(int n) {
        //  log2^x = log x / log 2
        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }

    public static int findNecessaryNumberOfSteps(Scanner scanner) {
        System.out.println("Enter the number of elements");
        int n = scanner.nextInt();
        return log2(n);
    }

    public static void findNumbersUsingBinarySearch(int from, int to, Scanner scanner) {
        int[] numbers = new int[to-from+1];
        for(int i = 0; i<=to-from; i++) {
            numbers[i] = i+from;
        }
        int low = 0;
        int max = to-from;
        int mid= (max+low)/2;

        int isGuessCorrect = 0;
        int numberOfGuesses = 0;

        while (!(isGuessCorrect==1)) {
            numberOfGuesses++;
            System.out.println(numberOfGuesses + ". guess. Is your number " + numbers[mid] + "?(1=yes, 2=lower, 3=higher");
            isGuessCorrect = scanner.nextInt();
            if (isGuessCorrect==1){
                break;
            }
            else if (isGuessCorrect==2) {
                max = mid;
            }
            else if (isGuessCorrect ==3) {
                low = mid;
            }
            mid = (low+max)/2;
        }
        System.out.println("It took " + numberOfGuesses + " to guess " + numbers[mid]);
    }

    public static void findNumberFrom0To128(Scanner scanner) {
        findNumbersUsingBinarySearch(0, 128, scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select one of the following operations:");
        System.out.println("1 - Necessary steps for finding the number \n" +
                "2 - Find the number from 1 to 128 (in max 7 steps)\n"+
                "3 - Choose your own min and max numbers (from x to y)");
        int x = scanner.nextInt();

        switch (x) {
            case 1:
                System.out.println(findNecessaryNumberOfSteps(scanner));
                break;
            case 2:
                findNumberFrom0To128(scanner);
                break;
            case 3:
                System.out.print("Enter your min number:");
                int min = scanner.nextInt();
                System.out.print("\nEnter your max number:");
                int max = scanner.nextInt();
                findNumbersUsingBinarySearch(min-1, max+1, scanner);
                break;
            default:
                System.out.println("Not accepted");
                break;
        }


    }
}
