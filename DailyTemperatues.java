class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> ind = new Stack<>();
        int[] res = new int[t.length];
        ind.push(0);
        int i=1;
        while(i<t.length){
            while(!ind.isEmpty() && t[ind.peek()]<t[i]){
                res[ind.peek()] = i-ind.peek();
                ind.pop();
            }
            ind.push(i);
            i++;
        }
        return res;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
