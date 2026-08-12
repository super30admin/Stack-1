//problem1
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int ind=st.pop();
                int res=i-ind;
                ans[ind]=res;
            }
            st.push(i);
        }
        return ans;
    }
}
//problem2
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()%n]){
                int popp=st.pop();
                res[popp]=nums[i%n];
            }
            //if((i%n)==st.peek()) break;
            if(i<n) st.push(i);
        }
        return res;
    }
}
