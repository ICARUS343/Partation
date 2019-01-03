package Dynamic;
import java.util.*;


/*
Input: Given an arrangment S of nonnegative number {s1,..,sn} and an integer k
Output: Partation S in k ranges so as to minimize the maxximum sum over all the ranges

//////-> kth partation starts after we have placed the (k-1) divider
//////-> (k-1) divider can be placed between ith and (i+1)st element for i where 1<=i<=n
*/
/*


///
Table M for S=[1,2,3,4,5,6] for k = 3
|k| 1  |  2   |   3  |
|n|____|______|______|
|1| 1  |  1   |   1  |
|2| 3  |  2   |   2  |
|3| 6  |  3   |   3  |
|4| 10 |  6   |   4  |
|5| 15 |  9   |   6  |
\6|_21_|__11__|___9_ |

Table D for S = =[1,2,3,4,5,6] for k = 3
|k| 1  |  2   |   3  |
|n|____|______|______|
|1| -  |  -   |   -  |
|2| -  |  1   |   1  |
|3| -  |  2   |   2  |
|4| -  |  2   |   3  |
|5| -  |  3   |   4  |
\6|_- _|__4 __|___5_ |



 */

public class PartationProblem {


    public static void Partation(int[] array, int k)
    {
        int n = array.length;
        int[][] M = new int[n][k];
        int[][] D = new int[n][k];
        int[] p = new int[n];
        p[0] = array[0];
        /*
        prefix sum
        */

        for(int i = 1; i<n; i++){ p[i] = p[i-1] + array[i]; }

        /*
        Base case
        M[1,k] = s1
        M[n,1] = sum(i=1 <-> n) <-> si
         */
        for(int i = 0; i < n ; i++ ){ M[i][0]= p[i]; }

        for(int i = 0; i < k ; i++ ){ M[0][i]= array[0]; }

        /*
        main recurrance
        M[n,k] = min(i = 1 <-> n) max --> ( M[i,k-1], sum (j = i+1 <-> n --> sj) )
        */


        for( int i = 1; i < n; i++)
        {
            for(int j = 1; j < k; j++ )
            {
                M[i][j] = Integer.MAX_VALUE;
                for(int x = 0; x < (i); x++)
                {

                    int a = M[x][j-1];
                    int b = p[i] - p[x];

                    int s = Math.max(a, b);

                    if(M[i][j] >= s)
                    {
                        M[i][j] = s;
                        D[i][j] = x+1;
                    }

                }
            }
        }
        System.out.print("Calculating maximum sum in each partation Matrix M: ");
        System.out.println(Arrays.deepToString(M));
        System.out.println("Keeping track of the partation Matrix D: ");
        System.out.println(Arrays.deepToString(D));

        ReconstructPartation(array, D, n, k);
    }
    public static void ReconstructPartation(int[]S, int[][]D, int n, int k )
    {

        if(k == 1)
        {
            System.out.print("Partation 1: ");

            for(int a = (D[n-1][k-1]);a< n; a++)
            {

                System.out.print(S[a]);
                System.out.print(", ");

            }
            System.out.println();

        }
        else

            {
                ReconstructPartation(S, D, D[n-1][k-1],k-1);
                int m = n;
                System.out.print( "partation " + k+" : ");
                for(int a = (D[n-1][k-1]);a< n; a++)
                {

                    System.out.print(S[a]);
                    System.out.print(", ");

                }
                m = (D[n-1][k-1])+1;
                System.out.println();
            }

    }

    public static void main(String[] args) {
        int[] array = new int[]{40,20,1,1,1,1,1,20,21};
        Partation(array,5);
    }



}
