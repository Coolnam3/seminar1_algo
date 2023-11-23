import java.io.FileNotFoundException;



public class Main {
    static GlobalFunctions gb=new GlobalFunctions();

    public static void recursiveOptions() {
        int[] numbers;
        gb.printMenu("Chooose amount of numbers to be sorted",new String[]{"10","1 000","10 000"
                ,"100 000","1 000 000"});
        int amount=gb.getIntInputFromUser();
        numbers=getNumbers(amount);
        gb.printMenu("Recursive",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch (choice)
        {
            case 1:
                gb.getAverageTime(numbers,Quicksort::recursiveQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(numbers,Quicksort::recursiveQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(numbers,Quicksort::recursiveQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeRecursiveInsertion(numbers);
                break;
        }
    }

    public static void iterativeOptions(){
        int[] numbers;
        gb.printMenu("Chooose amount of numbers to be sorted",new String[]{"10","1 000","10 000"
            ,"100 000","1 000 000"});
        int amount=gb.getIntInputFromUser();
        numbers=getNumbers(amount);
        gb.printMenu("Iterative",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch ( choice)
        {
            case 1:
                gb.getAverageTime(numbers,Quicksort::iterativeQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(numbers,Quicksort::iterativeQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(numbers,Quicksort::iterativeQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeIterativeInsertion(numbers);
                break;

        }
    }

    public static int[] getNumbers(int amount){
        int[] numbers;
        try {
            numbers = ReadFile.readFile(amount);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }

    public static void main(String[] args)
    {
        boolean cont=true;
        while (cont) {

            gb.printMenu("Menu", new String[]{"Recursive", "Iterative","Exit"});
            int choice = gb.getIntInputFromUser();
            switch (choice) {
                case 1:
                    recursiveOptions();
                    break;
                case 2:
                    iterativeOptions();
                    break;
                case 3:
                    cont=false;
                    break;
            }
        }


    }

}