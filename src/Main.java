

public class Main {
    static GlobalFunctions gb=new GlobalFunctions();

    public static void recursiveOptions() {
        int amount=gb.getAmountIntInputFromUser();

        gb.printMenu("Recursive",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch (choice)
        {
            case 1:
                gb.getAverageTime(amount,Quicksort::recursiveQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(amount,Quicksort::recursiveQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(amount,Quicksort::recursiveQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeRecursiveInsertion(amount);
                break;
        }
    }

    public static void iterativeOptions(){
        int amount=gb.getAmountIntInputFromUser();
        gb.printMenu("Iterative",
                new String[]{"First pivot", "Random pivot", "Median of three pivot","Insertion sort"});
        int choice=gb.getIntInputFromUser();
        switch ( choice)
        {
            case 1:
                gb.getAverageTime(amount,Quicksort::iterativeQuicksortFirst);
                break;
            case 2:
                gb.getAverageTime(amount,Quicksort::iterativeQuicksortRandom);
                break;
            case 3:
                gb.getAverageTime(amount,Quicksort::iterativeQuicksortMedian);
                break;
            case 4:
                gb.getAverageTimeIterativeInsertion(amount);
                break;

        }
    }



    public static void main(String[] args) {

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