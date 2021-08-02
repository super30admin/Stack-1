class Solution {

    //Tried using 2 stacks but could not figure out code implementation
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int[] result = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            stack1.add(temperatures[i]);
        }

        for (int i=0; i<temperatures.length; i++) {

            int curr = temperatures[i];

            int count = findNextDay(stack1, stack2, curr);

            result[i] = count;

        }

        return result;

    }

    private int findNextDay(Stack<Integer> stack1, Stack<Integer> stack2, int curr) {

        int count = 0;
        while (!stack1.isEmpty() && stack1.peek() <= curr) {

            stack2.add(stack1.pop());
            count++;
        }

        return count;

    }
}