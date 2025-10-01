
//time complexity O(n)
//space complexity O(n)

//We use a stack to keep track of the indices of the days with unresolved temperatures.
//As we iterate through the temperature array, we check if the current day's temperature is
//higher than the temperature at the index stored at the top of the stack.
//If it is, we pop the index from the stack and calculate the difference in days, storing it in the result array.


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int ans[]=new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty()&&temperatures[i]>temperatures[stk.peek()]){
                int temp=stk.pop();
                ans[temp]=i-temp;
            }
            stk.push(i);
        }
        return ans;
    }
}