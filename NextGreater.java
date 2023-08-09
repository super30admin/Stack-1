import java.util.Stack;

public class NextGreater {
    //Time complexity: O(N)
    //Space complexity: O(N) extra stack with maxim N elements in the stack
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] elements = new int[nums.length];
        int count = 1;
        while(count <=2){
            for(int i = nums.length -1; i >= 0; i--){
                while(!stack.isEmpty()){
                    if(nums[i] < stack.peek()){
                        elements[i] = stack.peek();
                        break;
                    }
                    else stack.pop();
                }
                if(stack.isEmpty()) elements[i] = -1;

                stack.push(nums[i]);
            }
            count++;
        }

        return elements;

    }
}
