class Solution {
    //TC: O(2n)  SC: O(n)
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }

    //TC:O(4n)   SC: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        Arrays.fill(results, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<2*n;i++){
            if(i>n){
                if(st.peek() == i%n)
                    break;
            }
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int popped = st.pop();
                results[popped] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return results;
    }
}