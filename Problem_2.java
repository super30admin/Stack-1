// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force approach.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] varArr=new int[2*nums.length];
        for(int i=0;i<varArr.length;i++){
            varArr[i]=nums[i%nums.length];
        }
        //System.out.println(Arrays.toString(varArr));
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<i+nums.length;j++){
                //System.out.println(i+","+j);
                if(nums[i]<varArr[j]){
                    nums[i]=varArr[j];
                    flag=true;
                    break;
                }
            }
            if(!flag){
                nums[i]=-1;
            }
            flag=false;
        }
        return nums;
    }
}

//
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] varArr=new int[nums.length];
        Arrays.fill(varArr,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<2*nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%nums.length]){
                varArr[st.pop()]=nums[i%nums.length];
            }
            if(i<nums.length){
                st.push(i);
            }
        }
        return varArr;
    }
}