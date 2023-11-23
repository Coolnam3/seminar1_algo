import java.util.Scanner;
import java.util.stream.LongStream;

public class GlobalFunctions {
    public void getAverageTime(int [] numbers,quicksortInterface function){
        int size= numbers.length;
        long[] times=new long[10];
        for(int i=0;i<size;i++){
            long startTime=System.nanoTime();
            function.apply(numbers,0,size-1);
            long endTime=System.nanoTime();
            times[i]=endTime-startTime;
        }


        double average=(LongStream.of(times).sum())/ times.length;

        System.out.printf("The average time is: %.8f \n",average/1000000);
    }

    public void getAverageTimeIterativeInsertion(int [] numbers) {
            int size = numbers.length;
            long[] times = new long[10];
            for (int i = 0; i < size; i++) {
                long startTime = System.nanoTime();
                InsertionSort.iterativeInsertionSort(numbers);
                long endTime = System.nanoTime();
                times[i] = endTime - startTime;
            }
            double average = (LongStream.of(times).sum()) / times.length;
            System.out.printf("The average time is: %.8f \n", average / 1000000);

    }

    public void getAverageTimeRecursiveInsertion(int[] numbers){
        int size = numbers.length;
        long[] times = new long[10];
        for (int i = 0; i < size; i++) {
            long startTime = System.nanoTime();
            InsertionSort.recursiveInsertionSort(numbers,size-1);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;
        }
        double average = (LongStream.of(times).sum()) / times.length;
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

    public void printMenu(String headline, String[] options) {
            System.out.println(headline);
            for (int i = 1; i <= options.length; i++) {
                System.out.println(i + ". " + options[i - 1]);
            }
        }

}