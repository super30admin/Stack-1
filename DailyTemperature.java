class Solution {
    public int[] dailyTemperatures(int[] T) {
        //sanity check
        if(T == null || T.length == 0){
            return T;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int[] res = new int[T.length];
        //looping through the entire array
        //if the top element is less than current then diff is number of days for warmer day
        //finally push current element on to stack
        for(int i = 0; i < T.length; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();
                res[index] = i - index; 
            }
            stack.push(i);
        }
        
        //all the left over elements doesnot have warmer days
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        
        return res;
    }
}
// Time Complexity:O(n)
// Space Complexity: O(n)