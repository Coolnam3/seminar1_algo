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
        for(int i=0;i<times.length;i++){
            int[] numbers=getNumbers(amount);
            long startTime=System.nanoTime();
            function.apply(numbers,0,amount-1);
            long endTime=System.nanoTime();
            times[i]=endTime-startTime;
            System.out.println(i);
            System.out.println(Arrays.toString(numbers));
        }


        double average= (double) (LongStream.of(times).sum()) / times.length;

        System.out.printf("The average time is: %.8f \n",average/1000000);
    }

    public void getAverageTimeIterativeInsertion(int amount) {
            long[] times = new long[10];
            for (int i = 0; i < times.length; i++) {
                int[] numbers=getNumbers(amount);
                long startTime = System.nanoTime();
                InsertionSort.iterativeInsertionSort(numbers);
                long endTime = System.nanoTime();
                times[i] = endTime - startTime;
                System.out.println(i);
            }
            double average = (double) (LongStream.of(times).sum()) / times.length;
            System.out.printf("The average time is: %.8f \n", average / 1000000);

    }

    public void getAverageTimeRecursiveInsertion(int amount){
        long[] times = new long[10];
        for (int i = 0; i < times.length; i++) {
            int[] numbers=getNumbers(amount);
            long startTime = System.nanoTime();
            InsertionSort.recursiveInsertionSort(numbers,amount-1);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;
            System.out.println(i);
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
                new String[]{"10","1 000","10 000"
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
            case 1 -> 10;
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