/*
========================= Brute-force ==================================
Time: O(N^2)
Space: O(1)
Approach:
=======
1. For every element iterate till warmer temperature is found in the array
2. If so, update result value at index to difference of indices of two elements
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[]{}; 
        
        int[] result = new int[T.length]; 
        for(int i = 0; i < result.length - 1; i++) {
            for(int j = i+1; j < result.length; j++) {
                if(T[i] < T[j]) {
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}
/*
============================ Using stack =================================
Time: O(N)
Space:O(N) in worst case where temperatures are in descending order
Approach:
========
1. As we know warmer temperatures have to be checked in later indices, pop from stack till not empty or larger element is found
2. If stack is empty after this step, no warmer temperature found, so it is 0
3. Else update difference between indices at the index of result array
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[]{}; 
        
        int[] result = new int[T.length]; 
        
        Stack<Integer> stack = new Stack<>(); 
        int len = T.length; 
        
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty()? 0: stack.peek() - i; 
            stack.push(i); 
        }
        return result;
    }
}