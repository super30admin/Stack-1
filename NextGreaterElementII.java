import java.util.Stack;
 //using a stack to identify the next greater element and use modulo operator 
 //to  compensate for previous elements.
 //Time Complexity: O(2*n)
 //Space Complexity: O(n)
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;

        int[] result = new int[n];

        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<2*n;i++)
        {
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()])
            {
                int popped = st.pop();
                result[popped] = nums[i%n];
            }

            if(i<n)
                st.push(i);
            else if(st.peek() == i%n)
                break;
        }
        return result;


    }
}
