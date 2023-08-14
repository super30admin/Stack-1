// TC=O(4n)
// SC=O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int result[]= new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                int curr= st.pop();
                result[curr]= nums[i%n];
            }
            if(i<n)
                st.push(i);
            if(i>=n && st.peek()==i%n)
                break;
        }
        
        return result;
    }
}
