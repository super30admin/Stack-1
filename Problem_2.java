//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        Stack<Integer> s= new Stack<>();
        int[] res= new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            if(s.isEmpty())s.push(i);
            else if (nums[i%n]>nums[s.peek()]){
                while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                    int p=s.pop();
                    res[p]=nums[i%n];
                }
                s.push(i%n);
            }
            else{
                s.push(i%n);
            }
        }
        
        return res;
    }
}