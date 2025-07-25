//Brute force: Nested loops, check for each temp
//time = O(n^2)
//space = O(1)

//monotonic stack
//time = O(2n)
//space = O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++ ){
            // System.out.print("up");
            // System.out.println(i);
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int poppedIdx = st.pop();
                // System.out.print("down");
                // System.out.println(poppedIdx);
                result[poppedIdx] = i-poppedIdx;
            }
            st.push(i);
        }
        return result;
    }
}