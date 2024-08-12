public class uniformInteger {

    public static void main(String[] args) {
        long A = 999999999999L;
        long B = 999999999999L;

        System.out.println(getUniformIntegerCountInInterval(A,B));
    }

    public static int getUniformIntegerCountInInterval(long A, long B) {

        int result = 0;
        long num = 1L;

        long seed = 1L;
        long sc = 10L;

        while (true) {

            for (long i = 1L; i <= 9L; i++) {
                num = seed * i;
                if (num > B) break;
                System.out.println(num);
                if (num >= A && num <= B) result ++;
            }
            seed = seed * sc + 1L;
            System.out.println("New seed = " + seed);

            if (num > B) break;
        }


        return result;
    }

}
