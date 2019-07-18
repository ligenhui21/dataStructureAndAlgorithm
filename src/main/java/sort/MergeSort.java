package sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author ligh
 * @date 2019/7/18
 */
public class MergeSort {

    public static int[] mergeSort(int[] array){
        if(array == null || (array.length == 0)){
            return new int[0];
        }

        if(array.length == 1){
            return array;
        }

        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = merge(left, right);
        return result;
    }

    private static int[] merge(int[] left, int[] right){
        int length1 = left.length;
        int length2 = right.length;
        int[] result = new int[length1+length2];
        int i = 0, j = 0, k = 0;
        while(i < length1 && j < length2){
            if(left[i] <= right[j]){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }
        if(j < length2){
            for(; k < result.length; k++){
                result[k] = right[j++];
            }
        }else{
            for(; k < result.length; k++){
                result[k] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 2, 4, 1, 2};
        int[] result = mergeSort(array);
        System.out.println(Arrays.toString(result));
    }
}
