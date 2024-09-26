import java.util.Arrays;
import java.util.Stack;

public class next_greater_element {
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

