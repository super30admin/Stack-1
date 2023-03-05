// TC: O(3n) - 2 iterations of array(cicrular) , 1 for popping n-1 elements from stack ~ O(n)
// SC: O(n)

// We need to find the next greater element in the array, the greater element could also be before the element and 
// can be resolved in the second iteration, if we dont find a greater element put its value as -1
// Create result array and fill all values with -1, we'll replace them when we find the greater element
// For loop goes over 2n elements
// i%n because if we only had i, we wouldnt be able to go in circle, i%n gives same position as i, for the 2nd iteration
// we are only storing indexes in stack so we compare values by doing nums[st.peek()] or nums[i%n]
// Larger i%n resolves peek element, put it in result, else push ith element in stack
// If an element is not resolved in 1st iteration but can be resolved in 2nd loop(if its not the largest), 
// It will go in 2n loop and try get resolved, but in 2nd iteration, do not push smaller elements in stack.



class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        //fill result with -1 as per the condition in the question
        Arrays.fill(result,-1); 
        
        Stack<Integer>st=new Stack<>();
        
        // iterate over the array 2 times because circular
        for(int i=0;i<2*n;i++){
            
            // i%n because we need same index in the 2nd iteration
            // we are storing indices in stack so nums[index in stack]
            // while stack is not empty and i%n resolves peek value
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                
                int popped=st.pop();
                
                // popped value resolved by i%n so put its actual value
                result[popped] = nums[i%n]; 
            }
            
            // we are only pushing elements if smaller, in 1st iteration
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}