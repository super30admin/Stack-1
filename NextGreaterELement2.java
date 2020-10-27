// TC: O(2n+m) where n is the len of nums and m is the time taken to pop the stack elements
// SC: O(n)

public class NextGreaterELement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] output = new int[nums.length];
        // Filling array default value to -1 so we know when to push into the stack
        Arrays.fill(output, -1);
        // iterating twice just because array is circular
        for(int i=0; i<nums.length*2; i++){
            int x = i%nums.length;
            // compare current element with peek of stack
            while(!s.isEmpty() && nums[x] > nums[s.peek()]){
                int top = s.pop();
                System.out.println(top);
                output[top] = nums[x];
            }
            if(output[x] == -1)
                s.push(x);
        }
        return output;
    }
}