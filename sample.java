class sample{
    /**************PROBLEM-1**************/
    //tc:0(n)
//sc:0(n)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if(temperatures==null || temperatures.length==0){
                return new int[]{};
            }
            int n=temperatures.length;
            int[] days=new int[n];
            Stack<Integer> s=new Stack<>();
            for(int i=0;i<n;i++){
                while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()]){
                    int popped=s.pop();
                    days[popped]=i-popped;
                }
                s.push(i);
            }
            return days;
        }
    }

/**********************PROBLEM-2***************/
//TC:0(N)
//SC:0(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> s=new Stack();
        for(int i=0;i<2*n;i++){
            while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                int popped=s.pop();
                result[popped]=nums[i%n];
            }
            if(i<n){
                s.push(i);
            }

        }

        return result;
    }
}

}