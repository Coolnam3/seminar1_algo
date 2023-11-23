
public class InsertionSort{

    final String name="Insertion sort";

    public static void recursiveInsertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        recursiveInsertionSort(arr, n - 1);

        int pivot = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > pivot) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = pivot;
    }
    public static void iterativeInsertionSort(int[] arr){
        int size=arr.length;
        for(int index=1;index<size;index++){
            int pivot=arr[index];
            int compare= index-1;

            while (compare>=0 && arr[compare]>pivot){
                arr[compare+1]=arr[compare];
                compare--;
            }
            arr[compare+1]=pivot;
        }
    }
}
