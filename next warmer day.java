//Timecomplexity:- O(n).
//spacecomplexity:- O(n).
//did it run on leetcode:- Yes.
//your approach with code:- Using monotonic stack property in which when peek element is less than current element, adding to present index of output array.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> cache=new Stack<>();
        int[]output=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!cache.isEmpty() && temperatures[cache.peek()]<temperatures[i]){
                int idx=cache.pop();
                output[idx]=i-idx;
            }
            cache.push(i);
            
        }
        return output;
    }
}