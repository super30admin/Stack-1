# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        for(int index = 0; index < T.length; index++){
        while(!stack.isEmpty() && T[index] > T[stack.peek()]){
            int priorIndex = stack.pop();
            result[priorIndex] = index - priorIndex;


        }
            stack.push(index);


        }



        return result;
    }
}