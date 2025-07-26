class Solution {
    private static final int BOUNDARY = 1000000;
    private static final int MAX_VISIT = 20000; // Safe upper bound escape radius

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockSet = new HashSet<>();
        for (int[] b : blocked) {
            blockSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockSet) && bfs(target, source, blockSet);
    }

    private boolean bfs(int[] start, int[] end, Set<String> blocked) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int count = 0;

        while (!queue.isEmpty() && count < MAX_VISIT) {
            int[] curr = queue.poll();
            count++;

            for (int[] dir : directions) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                String key = x + "," + y;

                if (x >= 0 && x < BOUNDARY && y >= 0 && y < BOUNDARY &&
                    !blocked.contains(key) && !visited.contains(key)) {
                    if (x == end[0] && y == end[1]) return true;

                    queue.offer(new int[]{x, y});
                    visited.add(key);
                }
            }
        }

        return count >= MAX_VISIT; // if we explore far enough, escape is possible
    }
}
