/* A cafeteria table consists of a row of 
𝑁
N seats, numbered from 
1
1 to 
𝑁
N from left to right. Social distancing guidelines require that every diner be seated such that 
𝐾
K seats to their left and 
𝐾
K seats to their right (or all the remaining seats to that side if there are fewer than 
𝐾
K) remain empty.
There are currently 
𝑀
M diners seated at the table, the 
𝑖
ith of whom is in seat 
𝑆
𝑖
S 
i
​
 . No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
Please take care to write a solution which runs within the time limit.
Constraints
1
≤
𝑁
≤
1
0
15
1≤N≤10 
15
 
1
≤
𝐾
≤
𝑁
1≤K≤N
1
≤
𝑀
≤
500
,
000
1≤M≤500,000
𝑀
≤
𝑁
M≤N
1
≤
𝑆
𝑖
≤
𝑁
1≤S 
i
​
 ≤N
Sample test case #1
N = 10
K = 1
M = 2
S = [2, 6]
Expected Return Value = 3
Sample test case #2
N = 15
K = 2
M = 3
S = [11, 6, 14]
Expected Return Value = 1
Sample Explanation
In the first case, the cafeteria table has 
𝑁
=
10
N=10 seats, with two diners currently at seats 
2
2 and 
6
6 respectively. The table initially looks as follows, with brackets covering the 
𝐾
=
1
K=1 seat to the left and right of each existing diner that may not be taken.
  1 2 3 4 5 6 7 8 9 10
  [   ]   [   ]
Three additional diners may sit at seats 
4
4, 
8
8, and 
10
10 without violating the social distancing guidelines.
In the second case, only 
1
1 additional diner is able to join the table, by sitting in any of the first 
3
3 seats.

*/


import java.util.HashSet;

public class Cafeteria {
    public static void main(String[] args) {
        /*
        long N = 10;
        long K = 1;
        int M = 2;
        long[] S = {2,6};

         */

        long N = 15;
        long K = 2;
        int M = 3;
        long[] S = {11,6,14};

        //System.out.println(getMaxAdditionalDinersCount(N,K,M,S));
    }

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        HashSet<Long> occupied = new HashSet<>();
        boolean occ = false;
        long addnew = 0;

        for (int i=0; i<S.length; i++) {
            occupied.add(S[i]);
        }

        for (long i=1; i<=N; i++) {
            occ = false;

            //System.out.println("i=" + i);

            for (long j = i-K; j <= i+K; j++ ) {
                if (occupied.contains(j)) { /// check if the ith position already occupied.
                    occ = true;
                    i = i+K;
                    break;
                }
            }
            if (!occ) {
                occupied.add(i);
                addnew++;
            }
        }
        return addnew;
    }
}
