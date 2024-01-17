//  Time Complexity: O(2n)
//  Space Complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result[] = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        Arrays.fill(result, -1);

        for(int i=0; i< 2 * n; i++){
            int ind = i % n;
            while(!stk.isEmpty() && nums[stk.peek()] < nums[ind]){
                int popped = stk.pop();
                result[popped] = nums[ind];
                if(!stk.isEmpty() &&stk.peek() == ind){
                    // result[ind] = -1;
                    break;
                }
            }
            if(i<n)
                stk.push(ind);


        }
        return result;


    }
}