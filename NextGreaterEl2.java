class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public int[] nextGreaterElements(int[] nums) {

       int[] res = new int [nums.length] ;
       Arrays.fill (res, -1);
        int n = nums.length;
        //will be used to store index of prev spaces
       Stack<Integer> s = new Stack <>();

       for (int i = 0;i < nums.length * 2;i++){

        while (!s.isEmpty() && nums[i%n] > nums[s.peek()]){
            int popped = s.pop();
            res[popped] = nums[i%n];
        }
        s.push (i%n );
       }
        return res;

    }
}
