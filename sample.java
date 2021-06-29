
// Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


//Brute Force
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] answer=new int[n];
        if(temperatures.length<2) return answer;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    answer[i]=j-i;
                    break;
                }
            }
        }
        return answer;
    }
}





// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


//Optimal
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] answer=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
           while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
               int idx=st.pop();
               answer[idx]=i-idx;
           }
            st.push(i);
        }
        return answer;
    }
}


Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                int idx=st.pop();
                result[idx]=nums[i%n];
            }
            if(i<n) st.push(i);
        }
        return result;
    }
}




