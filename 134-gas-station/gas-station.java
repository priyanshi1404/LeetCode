class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingPoint=0;
        int deficit=0;
        int surplus=0;
        for(int i=0;i<gas.length;i++){
            int gain= gas[i] - cost[i];
            surplus+=gain;
            if(surplus<0){
                deficit+=surplus;
                surplus=0;
                startingPoint=i+1;
            }
        }
        if(surplus+deficit >=0){
            return startingPoint;
        }
        return -1;
    }
}