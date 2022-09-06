// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        //base cases
        if(temperatures == null || temperatures.length == 0) return new int[]{};
        if(temperatures.length == 1) return new int[]{0};

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        //push the index of elements in the stack one by one to be processed
        for(int i = 0; i < n; i++) {

            //if the value is greater than the stack top element value (temp is greater),
            // pop the element and update the result for that index as the difference between the greater element and popped element
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
        }
        return result;
    }
}