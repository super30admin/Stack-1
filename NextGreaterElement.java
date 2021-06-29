//time:O(4n)-> O(n)
//space:o(n)
//did it run successfully on leetcode: yes
class NextGreaterElement {
    
    public int[] nextGreaterElements(int[] nums) {
        //array to store results
        int[] res = new int[nums.length];
        //initializing result array with -1
        Arrays.fill(res, -1);
        //stack to store index of unresolved elements
        Stack<Integer> st = new Stack<>();
        
        int n = nums.length;
        //looping the input array twice
        for(int i=0; i<2*n; i++){
            //if current value is greater than value of element with index at the top of stack 
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                //get the index at the top
                int ind = st.pop();
                //add current value to above index
                res[ind] = nums[i%n];
            }
            //add elemnts to stack only for the first loop
            if(i<n) st.push(i);
            
        }
        return res;
    }
}