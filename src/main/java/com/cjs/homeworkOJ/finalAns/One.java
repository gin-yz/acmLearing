package com.cjs.homeworkOJ.finalAns;

public class One {
    public static int findMinInRotate(int[] array) {
        //检查数组是否有效
        if (array == null || array.length == 0 || array.length == 1) {
            throw new IllegalArgumentException("input array error");
        }
        int left = 0;
        int right = array.length - 1;
        int indexMid = 0;
        //左必须大于右
        while (array[left] >= array[right]) {
            //若左右下标相差１，则右下标必为起点
            if (right - left == 1) {
                indexMid = right;
                break;
            }
            indexMid = (left + right) / 2;
            //如果left,right,indexMid下标相等，则只能顺序查找
            //即，若递增数组为[0,1,2,2,2,2]旋转后为[2,0,1,2,2,2]这样的形式
            if (array[left] == array[right] && array[indexMid] == array[left]) return minInOrder(array, left, right);
            //使用二分查找
            if (array[indexMid]>=array[left]) left = indexMid;
            else if(array[indexMid]<=array[right]) right = indexMid;
        }
        return array[indexMid];
    }
    //若递增数组为[0,1,2,2,2,2]旋转后为[2,0,1,2,2,2]这样的形式，只能使用O(n)的顺序查找
    private static int minInOrder(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left; i <= right; i++) {
            if (array[i]<result) result = array[i];
        }
        return result;
    }
}
