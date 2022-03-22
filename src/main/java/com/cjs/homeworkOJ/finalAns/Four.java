package com.cjs.homeworkOJ.finalAns;

public class Four {
    public static int[] findScope(int[] array, int target) {
        int[] result = {-1, -1};
        //先判断，若比最小的小，比最大的大，则（－１，－１）
        if (target < array[0] || target > array[array.length - 1]) return result;
        int left = 0;
        int right = array.length - 1;
        //二分法,先找最左边的target
        while (left + 1 < right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] >= target) right = midIndex;
            else left = midIndex;
        }
        //判断一下
        if (array[right] == target) result[0] = right;
        left = right;
        right = array.length - 1;
        //再找最右边的target
        while (left + 1 < right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] <= target) left = midIndex;
            else right = midIndex;
        }
        if (array[left] == target) result[1] = left;
        return result;
    }

    public static int[] findAdvance(int[] array, int target) {


        return null;
    }

    public static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    public static int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    public static void main(String[] args) {
        int left_bound = left_bound2(new int[]{1, 2, 2, 2, 2, 3}, 5);
        System.out.println(left_bound);
    }
}
