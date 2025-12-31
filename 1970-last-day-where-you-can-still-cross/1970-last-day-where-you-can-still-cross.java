import java.util.*;

class Solution {
    int r, c;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        r = row;
        c = col;

        int lo = 1, hi = cells.length, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (canCross(mid, cells)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    boolean canCross(int day, int[][] cells) {
        boolean[][] water = new boolean[r][c];
        for (int i = 0; i < day; i++) {
            water[cells[i][0]-1][cells[i][1]-1] = true;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[r][c];

        for (int j = 0; j < c; j++) {
            if (!water[0][j]) {
                q.add(new int[]{0, j});
                vis[0][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == r - 1) return true;

            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nc >= 0 && nr < r && nc < c &&
                    !water[nr][nc] && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
