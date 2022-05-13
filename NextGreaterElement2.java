//TC : O(2N + N) === O(3N) == O(N)
//SC : O(N) // Using Stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)    return new int[0];
        
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        Arrays.fill(res, -1);
        
        boolean flag = false;
        for(int i = 0; i< 2 * n; i++){
            if(flag)    break;
            while(!flag && !stack.isEmpty() && nums[i % n] > nums[stack.peek()]){
                res[stack.pop()] = nums[i % n];
                if(i > n - 1 && i % n == stack.peek() )
                    flag = true;
            //OPtimization --- For 2nd Loop, reacvhed at index same at stack.peek()
            }
            if(i < n)
                  stack.push(i);
            
        }
        
        return res;
    }
}