class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            if(!s.isEmpty()){
                while(!s.isEmpty() && nums[i]>nums[s.peek()]){
                    int idx = s.pop();
                    arr[idx] = nums[i];

                }
                s.push(i);
            }
            else{
                s.push(i);
            }
        }
        if(!s.isEmpty()){
            for(int j=0;j<n;j++){
                while(!s.isEmpty() && nums[j]>nums[s.peek()]){
                    int idx = s.pop();
                    arr[idx] = nums[j];

                }
            }
        }
        while(!s.isEmpty()){
            int idx = s.pop();
            arr[idx] = -1;
        }

        return arr;
    }
}