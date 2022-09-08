//Optimal : Using Stack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        
        if(temperatures == null || temperatures.length == 0)
            return res;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int diff = i - st.peek();
                res[st.peek()] = diff;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(n)