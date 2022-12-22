package tanvir;

import java.util.Arrays;

public class RandomNumber {
    public void linearCongruentialMethod(int x, int m, int a, int c, int[] randomNums, int noOfRandomNums) {
        randomNums[0] = x;
        for (int i = 1; i < noOfRandomNums; i++) {
            randomNums[i] = ((randomNums[i - 1] * a) + c) % m;
        }
    }

    public static void main(String[] args) {
        RandomNumber ob = new RandomNumber();

        int x = 5;
        int m = 7;
        int a = 3;
        int c = 3;
        int noOfRandomNums = 3;
        int[] randomNums = new int[noOfRandomNums];

        ob.linearCongruentialMethod(x, m, a, c, randomNums, noOfRandomNums);
        System.out.println(Arrays.toString(randomNums));
    }
}

