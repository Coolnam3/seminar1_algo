
public class InsertionSort{


    public static void recursiveInsertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        recursiveInsertionSort(arr, n - 1);

        int pivot = arr[n - 1];
        int compare = n - 2;
        while (compare >= 0 && arr[compare] > pivot) {
            arr[compare + 1] = arr[compare];
            compare--;
        }

        arr[compare + 1] = pivot;
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
