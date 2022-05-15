 //TC:O(3n) = O(n) where n is the length of nums array
 //SC: O(n)

 //Code

 class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //null case
        if(nums == null || nums.length==0) return  new int[0];
        int n = nums.length;      //[1,11,4,8,6] here n = 5 ; i%n => 6%5 =1 , 7%5=2 ......and so on till 2n
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){   //iterating array 2 times because we have a cycle
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){   
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i<n)   //push ele into stack only in the first pass of the loop 
                st.push(i);
            
        }
        return result;
    }
}
