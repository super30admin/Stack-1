class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null)
            return new int[]{};
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                int index=s.pop();
                res[index]=nums[i%n];
            }  
                if(i<n)
                    s.push(i);
        }    
        return res;  
    }
}

