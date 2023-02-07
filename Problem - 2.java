// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
The question states that the array is circular, which means that when we start from one index, we would loop through it till end and from the offset till start

To tackle that , we can either create an array twice the size, or we can search twice in the array and take help from modulo operator to prevent offset

We keep putting elements in the stack, when the next element is greater than the element on the top of the stack, then we would record that and keep putting elements in the stack

if our new index is offset or becomes greater than length, then we will not add that to the stack, as we had already gone through it in the first iteration

we will end the loop when our current idx and element on the top of the stack index matches, this means we have came to the same place where we started and already completed the circle

in the end, if there are still elements left in the stack, we would mark -1 at those indices, as no greater element could be found from those

T: O(n)
S: O(n) // Stack coan hold all the elements
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i < 2 * nums.length ; i++){ // we are taking twice as much length, because the array is circular, 
            int idx = i % nums.length ;// for the last index, we would go over one more time, so taking modulo would prevent the overflow
            int element = nums[idx];
            //If the top of the stack contains element smaller than current, then update the result index
            while(!stack.isEmpty() && nums[stack.peek()] < element){
                int oldIdx = stack.pop();
                result[oldIdx] = element;
            }
            if(!stack.isEmpty() && stack.peek() == idx) {
                break; // we have came to the same element and no element found bigger
            }
            if(i < nums.length) // When i goes bigger than length, that means that we were at the last index and now we are checking 
            stack.push(idx);
        }
        // If there are elements still in stack, then those would not have greater element, so we will mark them as -1
        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = -1;
        }
        

        return result;

    }
}