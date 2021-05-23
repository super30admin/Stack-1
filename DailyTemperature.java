
/*
 *  Time Complexity: O(N) Where N is the number of elements in the array
 *  Space Complexity: O(N) Used by the Stack space. N is the number of elements in the array
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  We first create a stack and a result array of length N. In the stack we only store the index of the element since we can always get the value by accessing the input array. Now, we iterate over the input array and for each element we check if its greater than peek index element of the stack, if yes we pop the index in the stack and then update the result array value at that index with the different between this index and the current loop index (i). In every iteration we push the current index to the stack. In the last we return the result array.
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length==0) return new int[]{};
        Stack<Integer> temp = new Stack<>();
        int res[] = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!temp.isEmpty() && temperatures[i]>temperatures[temp.peek()]){
                int idx = temp.pop();
                res[idx]= i-idx;
            }
            temp.push(i);
        }       
        return res;
    }
}
