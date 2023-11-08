import java.util.Arrays;
import java.util.Stack;

//TC will be O(n)
//SC will be O(n)
//using monotonic increasing of stack
class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[] {};
        }
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(result, -1);


        for(int i=0; i< 2*n ; i++){ //2*n as array is circular
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int index = s.pop();
                result[index] = nums[i%n];
            }
            if(i < n){
                s.push(i);
            }
        }
        return result;
    }


    public static void main(String[] args){
        NextGreaterElement obj = new NextGreaterElement();
        int[] nums = {1,2,1};
        int[] result=obj.nextGreaterElements(nums);
        for (int i=0; i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}