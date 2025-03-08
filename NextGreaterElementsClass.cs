// TC => O(n)
// SC => O(n)

public class Solution {
    public int[] NextGreaterElements(int[] nums) {
        if(nums == null || nums.Length == 0){
            return null;
        }
        int n = nums.Length;
        int[] result = new int[n];
        Array.Fill(result, -1);

        Stack<int> stack = new Stack<int>();
        stack.Push(0);
        for(int i = 0; i< 2 * n; i++){
            while(stack.Count > 0 && nums[stack.Peek()] < nums[i % n]){
                result[stack.Pop()] = nums[i % n];
            }
            if(i < n){
                stack.Push(i);
            }
        }
        return result;
    }
}