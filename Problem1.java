// Time Complexity : O(N)
// Space Complexity : O(N) for the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Store elements in a stack. if the current element is greater than the top element
//pop the top element and store the difference in index corresponding to the popped element


class Problem1 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] tempDiff = new int[temperatures.length];
        Stack<Integer> stackdata = new Stack<Integer>();
        for(int i=0; i<temperatures.length; i++){

            while(!stackdata.isEmpty() && temperatures[i] > temperatures[stackdata.peek()]){
                int x  = stackdata.pop();
                int diff = i-x;
                tempDiff[x] = diff;
            }

            stackdata.push(i);

        }
        return tempDiff;
    }
}