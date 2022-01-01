//Time: O(N)
//Space: O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i=0;i<2*nums.length;i++){
            if(stack.isEmpty())
                stack.push(i);
            else if(nums[stack.peek()%nums.length]<nums[i%nums.length]){
                result[stack.pop()%nums.length] = nums[i%nums.length];
                i--;
            }
            else{
                stack.push(i);
            }
        }
        int temp;
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp<nums.length)
                result[temp] = -1;
        }

        return result;
    }
}