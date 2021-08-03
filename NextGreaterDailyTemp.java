class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //O(2n) exact time and O(n) space
        int[] result = new int[temperatures.length];

        if (temperatures == null || temperatures.length == 0) {
            return result;
        }

        //We can leave the index only in the stack because we can reference the number in the temp array
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }

            stack.push(i);

        }

        return result;

    }

}