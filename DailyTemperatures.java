//Problem 130:  Daily Temperatures
//TC:O(2N)=>O(N)
//SC:O(N)

/*Steps
   Bruteforce: TC:O(n^2)|SC:O(1): Iterate over array for each element and the look for next warmer day, if you got it then break the inner for loop and check for next element

   Optimized: Use Stack and First try to resolve the peek one element, if resolved pop it, otherwise just push the new coming element in to the stack

*/

import java.util.*;
class Solution130 {
    public int[] dailyTemperatures(int[] T) {
        
        if(T==null || T.length==0) return new int[0];
        //TC:O(2N)=>O(N) | SC:O(N)
        int res[] = new int[T.length];
        //First try to resolve the peek one, if resolved pop it otherwise just push the new coming in to the stack
         Stack<Integer> stack = new Stack<>();
         for(int i=0;i<T.length;i++){
             
             while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                 int idx = stack.pop();
                 res[idx] = i-idx;
             }
             stack.push(i);//insering index
         }
        
        //Bruteforce
        //TC:O(n^2)|SC:O(1)
        /*for(int i=0;i<T.length-1;i++){
            for(int j=i+1;j<T.length;j++){
               if(T[j]>T[i]){
                 res[i] = j-i;
                 break;  
               }   
            }
            
        }*/
        
        return res;
    }
}