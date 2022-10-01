//Approach - 2: Monotonic Dec Stack
//Time Complexity : O(n)
//Space Complexity :  O(n)

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res,-1);
        
        Stack<Integer> st = new Stack<>();
 
        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popedIndex = st.pop();
                res[popedIndex] = nums[i%n];
            }
            if(i<n)
             st.push(i);
        }
        return res;
    }
}

//Approach - 1: Brute Force, 2 Arrays
//Time Complexity : O(n^2)
//Space Complexity :  O(n); extra space for 2n array

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int[] doublenums = new int[nums.length * 2];
        
        System.arraycopy(nums, 0 , doublenums, 0, nums.length);
        System.arraycopy(nums, 0 , doublenums, nums.length, nums.length);
        
        for(int i=0; i<nums.length; i++){
            res[i] = -1;
            for(int j=i+1; j<doublenums.length; j++){
                if(doublenums[j] > doublenums[i]){
                    res[i] = doublenums[j];
                    break;
                }
            }
        }
        return res;
    }
}
