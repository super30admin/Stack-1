//Time Complexity:O(N)
//Space Complexity:O(N)
//Approach- I'll keep adding the indices to the stack until I encounter an index when element at that index is less than the current index. In this case, I'll pop and update the values of all the indices before that until the stack is empty.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!s.isEmpty() && T[i]>T[s.peek()]){
                int temp=s.pop();
                res[temp]=i-temp;
            }
            s.push(i);
        }
        return res;
    }
}