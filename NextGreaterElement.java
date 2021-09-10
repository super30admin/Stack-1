// Time complexity - O(4*n)
//Space Complexity - O(n)

class Solution {
	public int[] nextGreaterElements(int[] nums) {
	    int[] res = new int[nums.length];
	    if(nums == null || nums.length == 0) return res;
	    Stack<Integer> st = new Stack<>();
	    Arrays.fill(res,-1);
	    int n = nums.length;
	    for(int i=0; i<2*n; i++){
	        while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
	            int index = st.pop();
	            res[index] = nums[i%n];
	        }
	        if(i<n) st.push(i);
	    }
	    return res;
	}
}
