
//TC: O(n)
//SC: O(n)
class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
      int n=temperatures.length;
      int[] res=new int[n];
      Stack<Integer> st=new Stack<>();
      for(int i=0;i<n;i++){
          int currt=temperatures[i];
          while(!st.isEmpty() && currt>temperatures[st.peek()]){
              int idx=st.pop();
              res[idx]=i-idx;
          }
          st.push(i);
      }
      return res;
  }
}