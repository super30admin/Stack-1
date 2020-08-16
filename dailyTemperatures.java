//TIme Complexity : O(n) n is the numberof elements in T
//Space Complexity : O(n) since I'm using stack
// LeetCode : passed all tests.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int [] result = new int[T.length];
        if(T == null || T.length == 0) return result;
        if(T.length == 1) return new int[] {0};
        int slow = 0;
        int fast = 1;
        Stack<Integer> st = new Stack<>();
        while(fast< T.length){
            if(T[slow]<T[fast]){
                result[slow] = 1;
            }else{
                st.push(slow);
            }
            while(!st.isEmpty() && T[st.peek()]<T[fast]){
                result[st.peek()] = fast - st.peek();
                st.pop();
            }
            slow++;
            fast++;
        }
        
        result[T.length-1] = 0;
        
        return result;
    }
}