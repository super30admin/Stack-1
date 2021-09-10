// Time complexity - O(n), O(n+n) read each temperature and push to stack and to resolve each from stack
//Space Complexity - O(n)

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
	    int[] result = new int[temperatures.length];
	    if(temperatures == null || temperatures.length == 0) return result;

	    Stack<Integer> st = new Stack<>();

	    for(int i=0; i<temperatures.length; i++){
	        while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
	            int index = st.pop();
	            result[index] = i - index;
	        }
	        st.push(i);
	    }
	    return result;
	}
}