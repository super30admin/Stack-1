class Solution {
    //Time O(N)
    //Space O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
        {
            return temperatures;
        }
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n ; i++)
        {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int temp = stack.pop();
                ans[temp] = i-temp;
            }
            stack.push(i);
        }
        return ans;
    }
}