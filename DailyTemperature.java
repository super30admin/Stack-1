/*
monotonically decreasing stack
Time Complexity: O(n)
Space Compleity: O(n)
*/
import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int[] a=new int[temperatures.length];
        if(temperatures==null){
          return null;
      }
      Stack<Integer> mds = new Stack<Integer>();
      mds.push(0);
    for(int i=1;i<temperatures.length;i++){
        while(!mds.isEmpty()&&temperatures[i]>temperatures[mds.peek()]){
            a[mds.peek()]=i-mds.pop();
        }
        mds.push(i);
    }
    // while(!mds.isEmpty()){
    //     a[mds.pop()]=0;
    // }
    // asempty spots are assigned to 0 by default need not do that again explicitly        
        return a;
    }
}