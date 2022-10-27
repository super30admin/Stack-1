class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> s= new Stack<>();
        
        for(int i=0; i<2* nums.length; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i%nums.length] ){
                int popped= s.pop();
                result[popped]= nums[i%nums.length];
            }
            if(i<nums.length){
                s.push(i);
            }
        }
        return result;
    }
}