class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++)
        {
            int idx = i%n;
            while(!st.isEmpty() && nums[idx] > nums[st.peek()])
            {
                int popIdx = st.pop();
                res[popIdx] = nums[idx];
            }
            if(i<n)
            {
                st.push(i);
            }
        }
        return res;
    }
}

//tc:O(n)
//sc:O(n)