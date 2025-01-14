import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class problem1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int[] result= new int[n];
        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<n;i++)

        {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int popped= stack.pop();
                result[popped]= i -popped;
            }
            stack.push(i);
        }

        return result;

    }
}
