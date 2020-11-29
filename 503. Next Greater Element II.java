class Solution {//Time and space of O(n)
    public int[] nextGreaterElements(int[] nums) {
        //Base case 
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        //Iterate throught the array
        for(int i = 0 ; i< 2 *nums.length ; i++){
            int index = i % nums.length ;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                //int index = stack.pop();
                int currIndex = stack.pop();
                result[currIndex] = nums[index];
            }
            stack.push(index);
        }
        // while(!stack.isEmpty()){
        //     result[stack.pop()] = 0;
        // }
        return result;
    }
}