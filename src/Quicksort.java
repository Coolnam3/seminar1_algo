
import java.util.Random;


interface quicksortInterface{
    public void apply(int[] arr, int max, int high);

    }
public class Quicksort{

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int low, int high,int pivot) {
        swap(arr, pivot, high);
        int pivotValue = arr[high];
        int leftp = low;
        int rightp = high-1;

        while (leftp<=rightp) {
            if (arr[leftp]> pivotValue & arr[rightp]<pivotValue){
                swap(arr,leftp,rightp);
                leftp++;
                rightp--;
            } else if (arr[leftp]<= pivotValue) {
                leftp++;
            } else if (arr[rightp]>= pivotValue) {
                rightp--;
            }
        }
        swap(arr,leftp,high);
        return leftp;

    }


    //Recursive

    public static void recursiveQuicksortFirst(int[] arr, int low, int high) {
        if (low < high) {
            int middle = partition(arr, low, high,low);
            recursiveQuicksortFirst(arr, low, middle - 1);
            recursiveQuicksortFirst(arr, middle + 1, high);
        }
    }


    public static void recursiveQuicksortRandom(int[] arr, int low, int high) {
        if (low < high) {
            int pivot=getRandomNumberUsingNextInt(low,high);
            int middle = partition(arr, low, high,pivot);
            recursiveQuicksortRandom(arr, low, middle - 1);
            recursiveQuicksortRandom(arr, middle + 1, high);
        }
    }


    public static void recursiveQuicksortMedian(int[] arr, int low, int high) {

        if (low < high) {
            int mid = low+(high - low) / 2;
            int pivot;

            if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low])) {
                pivot=mid;
            } else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid])) {
                pivot=low;
            } else {
                pivot=high;
            }
            int middle = partition(arr, low, high,pivot);
            recursiveQuicksortMedian(arr, low, middle - 1);
            recursiveQuicksortMedian(arr, middle + 1, high);
        }
    }

    // Iterative versions

    public static void iterativeQuicksortFirst(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;


        while (top >= 0) {

            high = stack[top--];
            low = stack[top--];

            int middle = partition(arr, low, high,low);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (middle - 1 > low) {
                stack[++top] = low;
                stack[++top] = middle - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (middle + 1 < high) {
                stack[++top] = middle + 1;
                stack[++top] = high;
            }
        }
    }

    public static void iterativeQuicksortRandom(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;


        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];
            int middle = partition(arr, low, high,getRandomNumberUsingNextInt(low,high));
            if (middle - 1 > low) {
                stack[++top] = low;
                stack[++top] = middle - 1;
            }
            if (middle + 1 < high) {
                stack[++top] = middle + 1;
                stack[++top] = high;
            }
        }
    }
    public static void iterativeQuicksortMedian(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];
            int mid = low+(high - low) / 2;
            int pivot;

            if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low])) {
                pivot=mid;
            } else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid])) {
                pivot=low;
            } else {
                pivot=high;
            }

            int middle = partition(arr, low, high,pivot);
            if (middle - 1 > low) {
                stack[++top] = low;
                stack[++top] = middle - 1;
            }
            if (middle + 1 < high) {
                stack[++top] = middle + 1;
                stack[++top] = high;
            }
        }


    }



    }


