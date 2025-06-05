class Solution {
    public int[][] merge(int[][] intervals) {
        //Step 01- Sort the array
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);   //lambda expression compare method argument
        //Step 02- Store the final result
        List<int[]> result=new ArrayList<>();  //all slots are free
        //step 03- traverse hr intervals one by one
        for(int [] interval:intervals){
            //this interval is not overlapping just to add it
            if(result.size()==0 || result.get(result.size()-1)[1]<interval[0]){
                result.add(interval);
            }
            else{
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],interval[1]);
                //if overlap so merge it
            }
        }
        return result.toArray(new int[result.size()][]); //convert list to array

    }
}