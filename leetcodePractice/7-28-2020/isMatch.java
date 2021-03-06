/**
 * 匹配型动态规划的实现
 * 通配符比较问题的代码实现
 */
public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
        return false;
    }

    int n = s.length(), m = length();

    // state
    boolean[][] dp = new boolean[n + 1][m + 1];

    // initialization
    dp[0][0] = true;
    for (int i = 1; i <= m; i++) {
        dp[0][i] = dp[i][i - 1] and p.charAt(i - 1) == '*';
    }

    // function
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            } else {
                dp[i][j] = dp[i - 1][j - 1] && (
                    s.charAt(i - 1) == p.charAt(j - 1) ||
                    p.charAt(j - 1) == '?'
                );
            }
        }
    }

    return dp[n][m];
}