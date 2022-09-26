//TC: O(2N)
//SC: O(N)

//Approach: since it is cyclic there can be warmer elements before them,
//so, iterate through the aray twice to find out the warmer days for the current element
//will compare the stack peek with the current element, if the index value of stack.peek is < current element
//should assign the current element as warmer element for the that peek index and pop the element
// if not that case and i< n then push it to stack
public class next_greater_element {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Stack<Integer> st = new Stack<>();
            int [] arr = new int [n];
            Arrays.fill(arr,-1);
            for(int i =0;i< 2*n;i++){
                while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                    arr[st.peek()] = nums[i%n];
                    st.pop();
                }
                if(i<n)
                    st.push(i); 
            }
            return arr;
        }
    }
}
