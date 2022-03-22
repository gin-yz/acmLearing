package com.cjs.homeworkOJ.finalAns;

public class Six {

    private static int mergeSoft(int[] arr, int left, int right) {
        if (left < right) { //当左边比右边小的时候
            int mid = (left + right) / 2;

            int leftCount = mergeSoft(arr, left, mid);
            int RightCount = mergeSoft(arr, mid + 1, right);

            int mergeCount = merge(arr, left, mid, right);
            return leftCount + RightCount + mergeCount;
        } else return 0;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;

        //左和右一个一个比，赋值到新数组中
        while (i <= mid && j <= right) {
            if (arr[i] > 3 * arr[j]) count += right - j + 1;
            if (arr[i] > 3 * arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        //将剩余为赋值的赋值
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        //将新数值中的值复制到原数组中
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
        return count;
    }
}
