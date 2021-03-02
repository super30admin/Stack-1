//Time Complexity: O(n) where n is the length of T array
//Space Complexity: O(n)

//Successfully runs on leetcode: 14 ms

//Approach: When the stack is non-empty, we check if the incoming element is greater than the element at the top of the stack,
//if yes - then we store the difference of the indices which will give us the distance of the next greater element for the 
//current element. we store the current element to stack then and move forward.


class Solution {
    public int[] dailyTemperatures(int[] T) {
       if(T == null || T.length == 0) return null;
       Stack<Integer> stack = new Stack<>();
       int[] result = new int[T.length];
       for(int i = 0; i < T.length; i++)
       {
           while(!stack.isEmpty() && T[i] > T[stack.peek()])
           {
               int index = stack.pop();
               result[index] = i - index;
           }
           stack.push(i);
       }
        return result;
    }
}