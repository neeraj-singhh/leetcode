class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length;

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canCross(int row, int col, int[][] cells, int days) {
        boolean[][] water = new boolean[row][col];

        for (int i = 0; i < days; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = true;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        for (int j = 0; j < col; j++) {
            if (!water[0][j]) {
                q.offer(new int[]{0, j});
                vis[0][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == row - 1) return true;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < row && ny < col &&
                        !water[nx][ny] && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
