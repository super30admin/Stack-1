//Next greater Element - 2
// Time Complexity :O(n)
// Space Complexity :O(n) - stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//use stack to store the index and pop out the index if the value in nums is greater
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,3};
        Problem2 p = new Problem2();
        int[] res = p.nextGreaterElements(nums);
        for(int i : res){
            System.out.print(i+" ");
        }

    }
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if(nums == null || nums.length ==0){
            return res;
        }
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res,-1);
        int n = nums.length;
        for(int i = 0;i< 2*n; i++){
            int temp = i%n;
            while(!st.isEmpty() && nums[st.peek()] < nums[temp]){
                int pos = st.pop();
                res[pos] = nums[temp];
            }
            if(i < n){
                st.push(i);
            }
        }
        return res;


    }
}
