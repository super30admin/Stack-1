package problems.interfaces;

import java.util.Arrays;
import java.util.Stack;

//TC=O(4n)=O(n)
//SC=O(n)
public class Problem503 {

    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stk=new Stack<>();
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            while(!stk.isEmpty() && nums[i % n]>nums[stk.peek()]){
                int popped=stk.pop();
                result[popped]=nums[i % n];
            }
            if(i<n)
                stk.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem503 problem503=new Problem503();
        System.out.println(Arrays.toString(problem503.nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}
