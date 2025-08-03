class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>stack = new Stack<>();
        int[] output = new int[n];
        Arrays.fill(output , -1); //default -1
        for(int i = 0 ; i < 2*n ; i++){ // we are iterating upto twice of lgt bceause array is circular (means we can get back to starting index of array when your i is at last element)
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){ //i%n because i running upto 2n
                     output[stack.pop()] = nums[i % n];


            }
            if(i<n){
                stack.push(i);
            }
        }
        return output;


        
    }
}