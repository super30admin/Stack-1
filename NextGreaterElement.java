/**
Utilize a stack to keep track of indices of elements.
Iterate through 2*n elements (to cover circular array), updating the result array with the next greater element for each element in the array.
If the current index exceeds n and the stack top points to the current index modulo n, exit the loop. Otherwise, push the current index onto the stack.
TC- O(2n), SC- O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
         Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int poped = st.pop();
                res[poped] = nums[i%n];
            }
            if(i>n && st.peek() == i%n) break;
            if(i<n) st.push(i);
            
        }
        return res;
    }
}
