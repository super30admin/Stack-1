// Bruteforce Solution
// TC: O(n2)
// SC: O(1)
class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] answer = new int[nums.length];
        Arrays.fill(answer, -1); 
        for(int i = 0;i<n;i++) {
            for(int j = i+1; j<2*n; j++) {
                if(nums[j%n] > nums[i]) {
                    answer[i] = nums[j%n];
                    break;
            }
        }
       } 
       return answer;
    }
}


// Push the elements to stack and resolve then whenever you get a greater element
// TC: O(n)
// SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] answer = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(answer, -1); 
        st.push(0);
        for(int i=1;i<2*n;i++) {
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                int popped = st.pop();
                answer[popped] = nums[i%n];
            }
            if(i<n)
                st.push(i);
        }
        return answer;
    }
}