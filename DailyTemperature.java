//Time complexity is O(N)
//Space complexity is O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<int[]>();
        int[] result =new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && st.peek()[0]<temperatures[i]){
                int[] temp = st.pop();
                result[temp[1]]=Math.abs(temp[1]-i);
            }
            st.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}