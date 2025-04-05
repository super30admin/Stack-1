//Time Complexity:O(N)

//Space Complexity:O(N)

//Approach- First I'll fill up the result array with -1 since the given array is a circular array and I should return -1 to those elements for which I don't encounter any elements greater than that. 
//Otherwise I would be running a loop twice the size of the given array, take modulus of each index to the size of the array and check is that element is greater than the current element 
//at the top of the stack. In this case, I'll pop that index and add the current index value to this index.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);

        for(int i=0;i<2*nums.length;i++){
            int temp= i%nums.length;
            
            while(!s.isEmpty()&&nums[temp]>nums[s.peek()]){
                int idx=s.pop();
                res[idx]=nums[temp];
            }
            if(i<nums.length){
                s.push(i);
            }
        }
       return res;
    }
}