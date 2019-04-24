# Partation


/*
Input: Given an arrangment S nonnegative number {s1,..,sn} and an integer k
Output: Partation S in k ranges so as to minimize the maxximum sum over all the ranges

//////-> kth partation starts after we have placed the (k-1) divider
//////-> (k-1) divider can be placed between ith and (i+1)st element for i where 1<=i<=n



Table M for S=[1,2,3,4,5,6] for k = 3
|k| 1  |  2   |   3  |
|n|____|______|______|
|1| 1  |  1   |   1  |
|2| 3  |  2   |   2  |
|3| 6  |  3   |   3  |
|4| 10 |  6   |   4  |
|5| 15 |  9   |   6  |
|6|_21_|__11__|___9_ |

Table D for S = =[1,2,3,4,5,6] for k = 3
|k| 1  |  2   |   3  |
|n|____|______|______|
|1| -  |  -   |   -  |
|2| -  |  1   |   1  |
|3| -  |  2   |   2  |
|4| -  |  2   |   3  |
|5| -  |  3   |   4  |
|6|_- _|__4 __|___5_ |




 
