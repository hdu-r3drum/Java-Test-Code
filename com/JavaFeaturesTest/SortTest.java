
import java.util.ArrayList;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        ArrayList<Integer> resuList = basicSearch(arr, 5);
        for (int i = 0; i < resuList.size(); i++) {
            System.out.println("Element found at index: " + resuList.get(i));
        }
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    static ArrayList<Integer> basicSearch(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                list.add(i);
            }
        }
        return list;
    }
}
