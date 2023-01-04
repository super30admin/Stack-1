// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==0 || temperatures==null) return new int[] {};
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int cur=stack.pop();
                res[cur] = i - cur;
            }    
            stack.push(i);
        }
        return res;
    }
}