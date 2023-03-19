package HundredDaysOfJava;

import java.util.Arrays;

public class FindFirstFindLast {
    public static int[] searchRange(int[] nums, int k) {

        int[] outputArray = {-1, -1};

        if (nums == null || nums.length == 0) {
            return outputArray;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != k) {
            return outputArray;
        } else {
            outputArray[0] = left;
        }

        right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left + 1) / 2);
            if (nums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        outputArray[1] = right;

        return outputArray;
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(searchRange(array, 8)));
    }
}