class Solution {
    public int[] nextGreaterElements(int[] t) {
        Stack<Integer> ind = new Stack<>();
        int[] res = new int[t.length];
        Arrays.fill(res, -1);
        ind.push(0);
        int i=1;
        while(i<t.length){
            while(!ind.isEmpty() && t[ind.peek()]<t[i]){
                res[ind.peek()] = t[i];
                ind.pop();
            }
            if(ind.contains(i))
                return res;
            ind.push(i);
            i++;
            i = i%t.length;
        }
        return res;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
