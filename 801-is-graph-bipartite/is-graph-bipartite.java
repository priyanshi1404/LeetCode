class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int [] colors=new int[n];

        for(int i=0;i<n; i++){
            if(colors[i]==0){
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    int node=queue.poll();
                    for(int neighbour: graph[node]){
                        if(colors[neighbour] == 0){
                            colors[neighbour] = -colors[node];
                            queue.add(neighbour);
                        }
                        else if(colors[neighbour]== colors[node]){
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }
}