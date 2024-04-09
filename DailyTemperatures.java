
import java.util.Stack;
//TC - O(n)
//SC - O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int popped = stack.pop();
                result[popped] = i-popped;
            }
            stack.push(i);
        }
        return result;
    }
}
public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
