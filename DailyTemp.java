class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i= 0; i< n; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
//SC:O(N)
//TC:O(N)
