// Time Complexity : O(2n) = O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        //base cases
        if(nums == null || nums.length == 0) return new int[]{};
        if(nums.length == 1) return new int[]{-1};

        int n = nums.length;
        int[] result = new int[n];
        //by default, fill the array as -1 if the next greater element is not found in the end
        Arrays.fill(result, -1);

        Stack<Integer> s = new Stack<>();
        //since it's circular array, use two pass to check if next greater element is found for all elements
        for(int i = 0; i < n * 2; i++) {
            //if the current element is greater than the stack top element,
            //pop the element and update the result of that index with the curr(greater) element.
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int index = s.pop();
                result[index] = nums[i % n];
            }
            //all the elements in the stack will be pushed in the first pass itself
            //this check is to prevent elements from being pushed during second pass
            if(i < n) {
                s.push(i);
            }
            //if during second pass, if we cross the element more than once, break from the loop
            if(i > n && i % n > s.peek()) break;
        }
        return result;
    }
}