import java.util.Arrays;
import java.util.Stack;
// Time O(3N) -> O(N)
// Space O(N)
public class NextGreaterElement2 {
	
public int[] nextGreaterElements(int[] nums) {
        
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        int[] arr = new int[2 * len];
        Stack<Integer> stack = new Stack<>();
        // populate arr with nums from 0->n-1 and again from 0->n-1 to handle circular scenario
        for(int i=0;i<2*len;i++){
           arr[i] = nums[i%len];
        }

        for(int i=0;i<2*len;i++){
            while(!stack.isEmpty() && arr[i] > nums[stack.peek() % len]){
                int popIndex = stack.pop();
                res[popIndex%len] = arr[i];
            }
            stack.push(i);
        }

    return res;

    }
}
