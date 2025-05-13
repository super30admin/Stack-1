import java.util.Arrays;

//TC : O(n)
//Sc: O(n)
class NextGreaterElementII {
  public int[] nextGreaterElements(int[] nums) {
      Stack<Integer> stk=new Stack<>();
      int n=nums.length;
      int[] res=new int[n];
      Arrays.fill(res,-1);//n
      for(int i=0;i<2*n;i++){ //3n
          while(!stk.isEmpty() && nums[stk.peek()]<nums[i%n]){
              int idx=stk.pop();
              res[idx]=nums[i%n];
          }
          if(i<n){
              stk.push(i);
          }
      }
      return res;
  }
}