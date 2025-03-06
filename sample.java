// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i=1;i<temperatures.length;i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int popped = s.pop();
                result[popped] = i-popped;
            }
            s.push(i);
        }
        return result;
    }
}


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int i=0;
        while(i < 2*n) {
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int popped = s.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                s.push(i);
            }
            i++;
        }
        return result;
    }
}
