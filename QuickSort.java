public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        int privot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(i < j && arr[j] >= privot){
                j--;
            }
            arr[i] = arr[j];
            while(i < j && arr[i] <= privot){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = privot;
        return i;
    }
}
