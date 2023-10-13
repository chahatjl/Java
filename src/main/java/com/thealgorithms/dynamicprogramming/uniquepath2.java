package com.thealgorithms.dynamicprogramming
//memoization
public class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        if(obstacleGrid[m-1][n-1]==1) return 0;
        return dfs(obstacleGrid,0,0,m,n);
    }
    int dfs(int[][] obstacleGrid, int i, int j, int m, int n){
        if((!(i>=0 && i<m && j>=0 && j<n)) || obstacleGrid[i][j]==1)
            return 0;
        if(i==m-1 && j==n-1)
            return 1;
        if(memo[i][j]==0)
            memo[i][j] = dfs(obstacleGrid,i+1, j, m, n) + dfs(obstacleGrid,i,j+1, m, n); 
        return memo[i][j];
    }
}

//tabluation
package com.thealgorithms.dynamicprogramming
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        // Initialize the bottom-right cell based on the obstacleGrid value
        dp[n - 1][m - 1] = (obstacleGrid[n - 1][m - 1] == 0) ? 1 : 0;

        // Initialize the last row and last column
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = (obstacleGrid[i][m - 1] == 0) ? dp[i + 1][m - 1] : 0;
        }
        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = (obstacleGrid[n - 1][j] == 0) ? dp[n - 1][j + 1] : 0;
        }

        // Fill the dp table using bottom-up approach
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[0][0];
    }
}

//space optimized version
package com.thealgorithms.dynamicprogramming
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];

        // Initialize the last row
        dp[m - 1] = (obstacleGrid[n - 1][m - 1] == 0) ? 1 : 0;

        // Initialize the last column
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1] = (obstacleGrid[i][m - 1] == 0) ? dp[m - 1] : 0;
        }

        // Fill the dp array using bottom-up approach
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] = dp[j] + dp[j + 1];
                } else {
                    dp[j] = 0;
                }
            }
        }

        return dp[0];
    }
}

