//T. C = O(N)
//S.C= O (N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
    if(nums==null || nums.length==0)return new int []{};
        int n=nums.length;
        int []result=new int [n];
        // for(int i=0;i<n;i++){
        //     result[i]=-1;
        // }
        Arrays.fill(result,-1);
        
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                result[s.pop()]=nums[i%n];
            }
            if(i<n){
                s.push(i);
            }
        }
        return result;
    }
}
