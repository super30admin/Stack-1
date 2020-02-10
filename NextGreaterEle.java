class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //base case
        if(nums==null || nums.length==0) return nums;
        
        //logic
        Stack<Integer> s=new Stack<>();
        int[] res=new int[nums.length];
        boolean[] found=new boolean[nums.length];
        Arrays.fill(res, -1);
        for(int i=nums.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek()<=nums[i]){
                s.pop();
            }
            res[i]=(s.isEmpty())?-1:s.peek();
            found[i]=(s.isEmpty())?false:true;
            s.push(nums[i]);
        }
        // for(int i: res){System.out.println(i);}
        for(int i=nums.length-1; i>=0; i--){
            if(found[i]==true) continue; //To prevent double calculation which is wrong!!
            while(!s.isEmpty() && s.peek()<=nums[i]){
                System.out.println("popped "+ s.pop());
            }
            // System.out.println(nums[i] + " " + s.peek());
            res[i]=(s.isEmpty())?-1:s.peek();
        }
        return res;
    }
}
