

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Sort queries based on start index
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // Max-heap for available queries (by end index)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for running queries (by end index)
        PriorityQueue<Integer> running = new PriorityQueue<>();

        int queryIndex = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries starting at or before index i
            while (queryIndex < m && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Remove queries from running that have ended before index i
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }

            // Apply additional queries if needed
            while (nums[i] > running.size()) {
                if (available.isEmpty() || available.peek() < i) {
                    return -1; // Not enough coverage for index i
                }
                running.offer(available.poll());
            }
        }

        // Remaining queries in 'available' can be removed
        return available.size();
    }
}
