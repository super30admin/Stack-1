class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //int[0] = temp value, int[1] = index value
        //Time Complexity:O(n)
        //Space Complexity:O(n)
       Stack<int[]> stack = new Stack<>();
       int res[] = new int[temperatures.length];
       for (int i =0; i < temperatures.length;i++){
        int curTemp = temperatures[i];
        while  (!stack.isEmpty() && stack.peek()[0] < curTemp){
            int[] poppedArr = stack.pop();
            res[poppedArr[1]] = i - poppedArr[1];
        }
        stack.push (new int[]{temperatures[i],i});
       } 
       return res;
    }
}
