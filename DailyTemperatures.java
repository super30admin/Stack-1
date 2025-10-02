public class DailyTemperatures {
   //Using a stack to update all the temperatures with the nearest warmer temperature 
   //and update the result array
   //Time Complexity: O(n)
   //Space Complexity: O(n) 
    public int[] dailyTemp(int[] temperatures){
        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && temperatures[i]> temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}
