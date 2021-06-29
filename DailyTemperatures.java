//time: O(2n)-> O(n)
//space: O(n)
//did it run successfully on leetcode: yes
class DailyTemperatures {
    
    public int[] dailyTemperatures(int[] temperatures) {
        //if input array is empty
        if(temperatures==null || temperatures.length==0) return temperatures;
        //array to stire final result
        int[] res = new int[temperatures.length];
        //stores unresolved indexes
        Stack<Integer> st = new Stack<>();
        //looping through all input elements
        for(int i=0; i<temperatures.length; i++){
            //if the top element in stack  is smaller then current element
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                //get the top elemnt
                int ind = st.pop();
                //set value of poped index
                res[ind] = i-ind;
            }
            //add current elemnt to stack
            st.push(i);
        }
        return res;
    }
}