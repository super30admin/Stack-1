// Time Complexity : O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use the concept of monotonic decreasing stacks
*/
public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length==0) return new int[]{};
        int[] result= new int[temperatures.length];
        //Monotic decreasing stack;
        Stack<Pair<Integer,Integer>> stack= new Stack<>();

        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek().getKey()){
                Pair<Integer,Integer> curr= stack.pop();
                int idx= curr.getValue();
                result[idx]= i-idx;
            }
            stack.push(new Pair<>(temperatures[i],i));
        }

        return result;
    }
}
