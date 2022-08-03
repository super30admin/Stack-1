import java.util.Arrays;
import java.util.Stack;

//Time: O(n), 4n -> n
//Space: O(n)


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        //null case check
        if(n == 0 || nums == null) return new int[0];
        
        //creating a result array where we will return the next greatest element
        int [] result = new int [n];
        
        //Stack where we will keep storing numbers until we find the next greatest element
        Stack<Integer> st = new Stack<>();
        
        //we initially fill the result array with '-1's
        Arrays.fill(result, -1); //O(n)*****************************
        
        //As nums is a circular array, we loop 2n or two times
        for(int i = 0; i < 2*n; i++) { //O(2n)**********************
            //here we are checking if the element at i%n index is greater than the elem at top of the stack
            //we check i%n as it will give us the original indices on our second loop through the array
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]) {//O(n)*****************
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            //we check i < n because we want to push all the indices only once
            if(i < n) {
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}

