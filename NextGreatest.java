class Solution {
    //tc-o(4n) sc-o(n)
    public int[] nextGreaterElements(int[] nums) {
     int n = nums.length;
     Stack<Integer> st = new Stack<>();
     int[]result = new int[n];
     Arrays.fill(result,-1);

     for(int i=0;i< 2*n;i++)
     {
      while(!st.isEmpty() && nums[i%n] > nums[st.peek()])
      {
          int curr = st.pop();
          result[curr] = nums[i%n];
      }
       if(i < n) st.push(i);
       if(i >= n && st.peek() == i%n) break;

     }
     return result;   
    }
}