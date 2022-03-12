//Time Complexity:O(2n)
//Space Complexity:O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[temperatures.length];
        if(temperatures==null || temperatures.length==0)
            return result;
        // stack.push(temperatures[0]);
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                result[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
