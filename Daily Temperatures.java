//  Time Complexity: O(2n)
//  Space Complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int ans[] = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i< temperatures.length; i++ ){
            while(!stk.empty() && temperatures[stk.peek()] < temperatures[i]){
                int ind = stk.pop();
                ans[ind] = i - ind;
            }
            stk.push(i);
        }
        return ans;
        
    }
}