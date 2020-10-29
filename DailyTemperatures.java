// Time Complexity : O(n)
// Space Complexity : O(n) for additional stack space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//while traversing through the loop, we check 
//if the stack's top ele is less than the current element, if it is then we do the differenece of index and add to output array
//if it is not, then just push the element t the stack
//retun the output array

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> temp=new Stack<>();
        int[] output=new int[T.length];
        
        for(int i=0;i<T.length;i++){
          while(!temp.isEmpty() && T[i]>T[temp.peek()]) {
                 
                  int top=temp.pop();
                  output[top]=i-top;
              }
          
            temp.push(i);
           
        }
        return output;
    }
}