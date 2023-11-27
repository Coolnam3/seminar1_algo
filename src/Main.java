

public class Main {
    static GlobalFunctions gb=new GlobalFunctions();

    public static void recursiveOptions() {
        Quicksort qs=new Quicksort();
        int amount=gb.getAmountIntInputFromUser();

        gb.printMenu("Recursive",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch (choice)
        {
            case 1:
                gb.getAverageTime(amount,qs::recursiveQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(amount,qs::recursiveQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(amount,qs::recursiveQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeRecursiveInsertion(amount);
                break;
        }
    }

    public static void iterativeOptions(){
        Quicksort qs=new Quicksort();
        int amount=gb.getAmountIntInputFromUser();
        gb.printMenu("Iterative",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch ( choice)
        {
            case 1:
                gb.getAverageTime(amount,qs::iterativeQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(amount,qs::iterativeQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(amount,qs::iterativeQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeIterativeInsertion(amount);
                break;

        }
    }


    public static void search(){
        int amount=gb.getAmountIntInputFromUser();
        System.out.println("Search for number");
        int number=gb.getIntInputFromUser();
        Quicksort qs=new Quicksort();
        int[] array=gb.getNumbers(amount);
        qs.recursiveQuicksortMedian(array,0,amount-1);
        long startTime=System.nanoTime();
        if (binarySearch(array,0,amount-1,number)){
            long endTime=System.nanoTime();
            System.out.println("Time taken : "+ (endTime-startTime)/1000000);
            System.out.println("It exists");
        }
        else{
            long endTime=System.nanoTime();
            System.out.println("Time taken : "+ (endTime-startTime)/1000000);
            System.out.println("It does not exist");
        }

    }
    public static boolean binarySearch(int arr[], int low, int high, int key) {
        if (high >= low) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == key)
                return true;
            if (arr[middle] > key)
                return binarySearch(arr, low, middle - 1, key);
            return binarySearch(arr, middle + 1, high, key);
        }
        return false;
    }


    public static void main(String[] args) {

        boolean cont=true;
        while (cont) {

            gb.printMenu("Menu", new String[]{"Recursive", "Iterative","Binary Search","Exit"});
            int choice = gb.getIntInputFromUser();
            switch (choice) {
                case 1:
                    recursiveOptions();
                    break;
                case 2:
                    iterativeOptions();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    cont=false;
                    break;
            }
        }

    }

}