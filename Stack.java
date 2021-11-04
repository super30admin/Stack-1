import java.util.*;
public class Stack{
    // time complexity : N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts: no
    // https://leetcode.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int idx = st.pop();
                result[idx] = i-idx;
            }
            st.push(i);
          
           
        }
        return result;
    }

    // time complexity : N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts: no
 public int[] nextGreaterElements(int[] nums) {
    int n = nums.length, next[] = new int[n];
    Arrays.fill(next, -1);
    Stack<Integer> stack = new Stack<>(); 
    for (int i = 0; i < n * 2; i++) {
        int num = nums[i % n]; 
        while (!stack.isEmpty() && nums[stack.peek()] < num)
            next[stack.pop()] = num;
        if (i < n) stack.push(i);
    }   
    return next;
}
}