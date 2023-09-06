// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Daily Tempreture
Time : o(2n) -> o(n) as we are making 2 passes one over array and one over stack in worst ClassCastException
Space -> o(n) -> Space of stack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int popped = st.pop();
               result[popped] = i - popped;

            }
            st.push(i);
        }

        return result;
        
    }
}

//Next greater element
//Time ->o(2n)->o(n) as we are making 2 pass
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            if(i>n){
                 if(i%n==st.peek()){
                break;
            }
            }
            
             while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                 int popped = st.pop();
                 result[popped] = nums[i%n];

             }
             if(i<n){
                 st.push(i);
             }
        }

        return result;
        
    }
}


