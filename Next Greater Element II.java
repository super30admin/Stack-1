//brute force for each ele go over all the ele 2 times tc- O(n^2) sc- O(1)

//optimized tc- O(2n) going 2 times over array + O(n) resolving each ele + O(n) filling array with -1
//sc-O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }else{
                if(st.peek() == i%n) break;
            }
        }

        return result;
     }
}