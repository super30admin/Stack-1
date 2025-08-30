class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
        {
            return new int[]{};
        }
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer>bucket = new Stack<>();
        for(int i = 0 ; i < n ; i++)
        {
            while(!(bucket.isEmpty()) && temperatures[i] > temperatures[bucket.peek()])
            {
                int popped = bucket.pop();
                result[popped] = i - popped;
            }
            bucket.add(i);
        }
    return result;
    }
}
