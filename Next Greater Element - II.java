//Time Complexity= O(3N)
//Space Complexity = O(N)
// Assume it's a continuos array , maintain a monotonous decreasing stack and add elements to the stack only if i<n and for the largest element, we can put -1 when stack.peek is equal to same index when moved twice circularly.

// New thing learnt = Arrays.fill(result,-1)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();


        Arrays.fill(result,-1); // important


        for(int i =0; i < 2*nums.length ;i++){
            // System.out.println(i);
            while(!stk.isEmpty() && nums[i%n] > nums[stk.peek()]){
                result[stk.peek()] = nums[i%n];
                // System.out.println(stk);
                // System.out.println(i);


                stk.pop();
            }
            if(i<n){
                stk.add(i);
            }
            if(i>n && stk.peek() == i%n){
                result[stk.peek()] = -1;
                // stk.pop();
                break;
            }
        }

        return result;
    }
}