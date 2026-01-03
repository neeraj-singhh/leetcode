class Solution {
    public int numOfWays(int n) {
        long mod = 1_000_000_007;
        long same = 6, diff = 6;

        for (int i = 2; i <= n; i++) {
            long ns = (3 * same + 2 * diff) % mod;
            long nd = (2 * same + 2 * diff) % mod;
            same = ns;
            diff = nd;
        }
        return (int)((same + diff) % mod);
    }
}
