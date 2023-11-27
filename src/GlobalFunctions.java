import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class GlobalFunctions {

    public static int[] getNumbers(int amount){
        int[] numbers;
        try {
            numbers = ReadFile.readFile(amount);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
    public void getAverageTime(int amount,quicksortInterface function){
        long[] times=new long[10];
        int[] numbers=getNumbers(amount);
        for(int i=0;i<times.length;i++){
            int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
            long startTime=System.nanoTime();
            function.apply(numbersCopy,0,amount-1);
            long endTime=System.nanoTime();
            times[i]=endTime-startTime;
        }


        double average= (double) (LongStream.of(times).sum()) / times.length;

        System.out.printf("The average time is: %.8f \n",average/1000000);
    }

    public void getAverageTimeIterativeInsertion(int amount) {
        InsertionSort is=new InsertionSort();
        long[] times = new long[10];
        int[] numbers=getNumbers(amount);
        for (int i = 0; i < times.length; i++) {
            int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
            long startTime = System.nanoTime();
            is.iterativeInsertionSort(numbersCopy);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;
            }
            double average = (double) (LongStream.of(times).sum()) / times.length;
            System.out.printf("The average time is: %.8f \n", average / 1000000);

    }

    public void getAverageTimeRecursiveInsertion(int amount){
        InsertionSort is=new InsertionSort();
        long[] times = new long[10];
        int[] numbers=getNumbers(amount);
        for (int i = 0; i < times.length; i++) {
            int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
            long startTime = System.nanoTime();
            is.recursiveInsertionSort(numbersCopy,amount-1);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;
        }
        double average = (double) (LongStream.of(times).sum()) / times.length;
        System.out.printf("The average time is: %.8f \n", average / 1000000);
    }

    public int getIntInputFromUser() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        try {
            System.out.print("Enter an integer: ");
            choice=input.nextInt();
        }
        catch (Exception e){
            System.out.println("Error: "+ e);
            getIntInputFromUser();
        }
        return choice;
    }
    public int getAmountIntInputFromUser() {
        printMenu("Choose amount of numbers to be sorted",
                new String[]{"100","1 000","10 000"
                ,"100 000","1 000 000"});
        Scanner input = new Scanner(System.in);
        int choice = 0;
        try {
            System.out.print("Enter an integer: ");
            choice=input.nextInt();
        }
        catch (Exception e){
            System.out.println("Error: "+ e);
            getIntInputFromUser();
        }
        return switch (choice) {
            case 1 -> 100;
            case 2 -> 1000;
            case 3 -> 10000;
            case 4 -> 100000;
            case 5 -> 1000000;
            default -> choice;
        };

    }

    public void printMenu(String headline, String[] options) {
            System.out.println(headline);
            for (int i = 1; i <= options.length; i++) {
                System.out.println(i + ". " + options[i - 1]);
            }
        }

}