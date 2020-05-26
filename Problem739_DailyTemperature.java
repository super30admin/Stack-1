/**
 * Time Complexity - O(n)
 * Space Complexity - O(w) w = width
 */

class Solution {
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        int i = T.length-1;
        while(i >=0){

            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }

            res[i] = ((stack.isEmpty() ? i : stack.peek()) - i);
            stack.push(i);
            i--;
        }
        return res;
    }
}