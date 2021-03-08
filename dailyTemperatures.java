/*
brute force: is to iterate the temperature  array 2 times to find the next greater number for curr
TC: O(n^2)
better approach is to use stack: 
push index of current number in stack if stack is empty.
For incoming element, check the one at index present in stack top. if its less than the top, record the differnce of index and add it to result.
TC: O(n) 
SC : O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        if(t.length == 0)return new int[0];
        
        int[]result = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        
        //iterate the temperature array
        for(int i = 0; i < t.length;i++){
            while(!stack.isEmpty() && t[stack.peek()] < t[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        
        return result;
    }
}
