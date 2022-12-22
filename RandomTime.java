package tanvir;
public class RandomTime {

    public static int randomNumberGenerator() {
        boolean[] array = new boolean[Integer.MAX_VALUE];



        int rand = 1 + (int) System.currentTimeMillis() % 7;
        return rand;
    }
    public static void main(String[] args) {
        System.out.println(randomNumberGenerator());
    }
}
