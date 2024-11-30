
//brute force for each (1 for loop), find next warmer day in inner loop, once found go to next day from outer loop
 //tc- O(n^2) sc- O(1)


//optimized approach tc-O(2n) sc- O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;

    }
}