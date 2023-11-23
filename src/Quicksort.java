
import java.util.Random;
import java.util.Stack;

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
    public static int getMedian(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low])) {
            return mid;
        } else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid])) {
            return low;
        } else {
            return high;
        }
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
            int pivot=getMedian(arr, low, high);
            int middle = partition(arr, low, high,pivot);
            recursiveQuicksortMedian(arr, low, middle - 1);
            recursiveQuicksortMedian(arr, middle + 1, high);
        }
    }

    public static void iterativeQuicksortFirst(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int middle = partition(arr, low, high, low);
                stack.push(low);
                stack.push(middle - 1);
                stack.push(middle + 1);
                stack.push(high);
            }
        }
    }
    public static void iterativeQuicksortRandom(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);


        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = getRandomNumberUsingNextInt(low, high);
                int middle = partition(arr, low, high, pivotIndex);
                stack.push(low);
                stack.push(middle - 1);
                stack.push(middle + 1);
                stack.push(high);
            }
        }
    }
    public static void iterativeQuicksortMedian(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = getMedian(arr, low, high);
                int middle = partition(arr, low, high, pivotIndex);
                stack.push(low);
                stack.push(middle - 1);
                stack.push(middle + 1);
                stack.push(high);
            }
        }
    }



    }


