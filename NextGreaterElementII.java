import java.util.Arrays;
import java.util.Stack;
//tc o(n)
//sc o(1)
//idea is to store index of element in stack n check next element in array is greater than stack top.
// if yes then store array element in array at stack top element as index. n pop the element.
// at end return array
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result,-1);
        for(int i=0;i<2*length;i++){
            int k =i%length;
            while(!stack.isEmpty() && (nums[k]>nums[stack.peek()])){
                int index =stack.pop();
                result[index] = nums[k];
            }
            if(i<length){
            stack.push(i);
            }
        }
               return result;
    }

}
