// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
       if(T == null || T.length==0) return new int[0];
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0,T[0]));
        int[] result = new int[T.length];
        for(int i = 1;i<T.length;i++){
            int val =0;
            int index =0;
                while(!stack.isEmpty() && stack.peek().val<T[i]){
                    Pair p = stack.pop();
                    val = i-p.index;
                    index = p.index;
                    result[index] = val;
                }
            stack.push(new Pair(i,T[i]));
            
            
            
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            result[p.index] = 0;
        }
        
       return result; 
    }
    
}
class Pair{
    int index;
    int val;
    Pair(int index,int val){
        this.index = index;
        this.val = val;
    }
}