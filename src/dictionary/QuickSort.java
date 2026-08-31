package dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,2,7,8,1,3,9};
        List<Integer> answers = quickSort(arr);
        System.out.println(answers.toString());
    }
    public static List<Integer> quickSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length == 0) return list;
        if(arr.length == 1) {
            list.add(arr[0]);
            return list;
        }

        int pivot = arr[arr.length/2];

        // 왼쪽
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < pivot) {

            }
        }
        if(pivot-1 >= 0) {
            int[] left = Arrays.copyOfRange(arr,0,pivot);
            list.addAll(quickSort(left));
        }
        // 피봇
        list.add(pivot);
        // 오른쪽
        if(pivot+1 < arr.length) {
            int[] right = Arrays.copyOfRange(arr,pivot+1,arr.length);
            list.addAll(quickSort(right));
        }

        return list;
    }

}
