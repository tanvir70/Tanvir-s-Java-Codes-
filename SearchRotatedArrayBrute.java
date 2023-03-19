package HundredDaysOfJava;

public class SearchRotatedArrayBrute {
    public static int search ( int[] nums, int k){
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == k){
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        int k = 3;
        System.out.println(search(array,k));
    }
}
