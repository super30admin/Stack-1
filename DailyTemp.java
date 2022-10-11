//Time Complexity: O(n)
//Sapce Complexity: O(n)

//maintaining monotonic decreasing stack!

class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length ==0) return new int[0];
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            while( !st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                result[st.peek()] = i-st.pop();
            }
            st.push(i);
        }
        return result;
    }
}