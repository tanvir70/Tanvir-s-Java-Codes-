package HundredDaysOfJava;


public class SearchRotatedArray {
    public static int search ( int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right){
            mid = left + (right - left) / 2;
            if ( nums[mid] == k ){
                return mid;
            }
            if ( nums[mid] >= nums[left]){
                if ( k >= nums[left] && k < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if ( k > nums[mid] && k <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}