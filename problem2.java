class nextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[] {};
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack();
        
        for(int i = 0; i < 2 * n; i++){
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int top = s.pop();
                result[top] = nums[i % n];
            }
            if(i < n){
                s.push(i);
            }
        }
        return result;
    }
}

//time complexity O(n) where n is length of array
//space complexity O(n)