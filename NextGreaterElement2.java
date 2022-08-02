//Time O(n)
//Space O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0)
            return nums;
        int n = nums.length;
        int [] vals = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(vals,-1);
        for(int i=0;i<(2*n);i++)
        {  
            while(!s.isEmpty() &&  nums[s.peek()]<nums[i%n])
                vals[s.pop()]=nums[i%n];
            if(i<n)
            s.add(i);
            
            
        }
        return vals;
        
    }
}