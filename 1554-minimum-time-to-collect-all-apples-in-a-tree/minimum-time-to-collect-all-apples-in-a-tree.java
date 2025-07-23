class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Step 1: Build the adjacency list (undirected graph)
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        // Step 2: Start DFS from node 0 (root), parent is -1
        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int time = 0;

        // Explore all children of current node
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue; // Avoid going back up

            int childTime = dfs(child, node, graph, hasApple);

            // If child subtree has apple or child itself has apple, add time
            if (childTime > 0 || hasApple.get(child)) {
                time += childTime + 2; // 1 to go down, 1 to return
            }
        }

        return time;
    }
}
