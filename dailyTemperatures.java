//APPROACH: For this problem we will use a stack and while pushing the unresolvable element into the stack we will iterate over the array to find the element that can resolve the element on the top of the stack. Once it is resolved we will pop the top element out and then put a corresponding entry in the result array. Keep doing it while the stack is not empty and you are able to find a resolving element.

//time complexity O(n)
//space complexity O(n) which is the stack space

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}
