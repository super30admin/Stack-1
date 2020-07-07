//time o(2n) = o(n), as we are traversing the each element twice, (array and through stack)
//space o(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return new int[0];
        
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] =  i-idx;
            }
            stack.push(i);
        }
        return res;
    }
}