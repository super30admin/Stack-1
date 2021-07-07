//time complexity: O(N) where N is 2*n as we iterate over the nums array twice
//Space complexity: O(N) N being space utilised by stack which is n
//fill the result array with -1 initially
//Iterate over the nums array from 0 to n twice as it is circular. 
//push i to stack if it is < n.
//take a temp variable that is the calculated index values for those > than n
//while the stack is not empty check if the value at temp index for nums array is > than the value at the top of the stack
//If so pop the value in the stack and store it as the index for result array and store the value at temp index in nums array to result at the popped index.
//Return result
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i=0; i<2*n; i++)
        {
            int temp = i%n;
            while(!stack.isEmpty() && nums[temp] > nums[stack.peek()])
            {
                int index = stack.pop();
                result[index] = nums[temp];
            }
          if(i<n)
              stack.push(i);
        }
        return result;
    }
    
}

//Dry Run:
// i =   0, 1, 2
//       3, 4, 5
//nums = [1, 2, 1]
//stack:[(0),1,(2)] (the popped values are in () brackets)
//ans = [2, -1, 2]