//Use a monotonic decreasing stack. If the obtained element is greater than stack.peek, update ans at it's particular index. Else, add them to stack
//TC: O(2n)
//SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            while(!(stack.isEmpty()) && temperatures[stack.peek()]<temperatures[i]){
                int popped=stack.pop();
                ans[popped]=i-popped;
            }
            stack.push(i);
        }

        return ans;
        
    }
}
