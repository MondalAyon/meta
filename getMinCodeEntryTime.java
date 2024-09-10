/*
https://www.metacareers.com/profile/coding_puzzles?puzzle=990060915068194

 */
public class getMinCodeEntryTime {
    public static void main(String[] args) {
        // Test data set 1
        /*
        int N = 10;
        int M = 4;
        int[] C = {9,4,4,8};
        */
        // Test data set 2

        int N = 3;
        int M = 3;
        int[] C = {1,2,3};


        //System.out.println(getMinCodeEntryTime(N,M,C));
        System.out.println(getMinCodeEntryTimeV2(N,M,C));
    }

    /* This version runs within the time limit. It's O(N) where N= Size of C */
    /* the logic is option-1 = Abs[Code - pointer] and Option-2 is N - option-1 steps. Since option-1 + option-2 = N */
    public static long getMinCodeEntryTimeV2(int N, int M, int[] C) {

        long totalSteps = 0L;
        int p = 1;

        for (int k=0; k<M; k++) { // Read the code C[k] array.

            totalSteps += Math.min(Math.abs(p-C[k]), N - Math.abs(p-C[k]));
            p = C[k];

        }

        return totalSteps;
    }

    /* This version works but exceed time limit. Due to two loops */
    public static long getMinCodeEntryTime(int N, int M, int[] C) {

        int[] A = new int[N];
        for (int i=0; i<N; i++) A[i] = i+1;

        int p = 1;
        long totalSteps = 0L;

        for (int k=0; k<M; k++) {

            int i = p-1;
            int fStep=0;

            while (true) {
                if (A[i] == C[k]) {
                    break;
                }
                fStep++;
                i++;

                if (i==N) i=0;
            }

            int j=p-1;
            int rStep=0;
            while (true) {

                if (A[j] == C[k]) {
                    break;
                }
                rStep++;
                j--;

                if (j == -1) j=N-1;
            }

            //System.out.println("Code=" + C[k] + " Pointer=" + p + " fStep=" + fStep + " rStep=" + rStep);

            p = C[k];

            totalSteps += fStep < rStep ? fStep : rStep;
        }
        return totalSteps;
    }
}
