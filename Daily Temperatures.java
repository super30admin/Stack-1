class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int[] ans = new int[temp.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=temp.length-1 ; i>=0 ; i--){

           while(!stack.isEmpty() && temp[i]>=temp[stack.peek()])
           {
               stack.pop();
           }

           if(!stack.isEmpty() && temp[stack.peek()]>temp[i])
           {
               ans[i] = stack.peek()-i;
           }

            stack.push(i);

       }


        return ans;

    }
}
