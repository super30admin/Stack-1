//TC : O(N)
//SC : O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null||temperatures.length==0) return (new int[0]);

        int[] result = new int[temperatures.length];
        Stack <int[]> s = new Stack<>();
        //s.add(new int[]{temperatures[0],0});

        for(int i=0;i<temperatures.length-1;i++)
        {
            if(temperatures[i+1] > temperatures[i])
            {
                result[i] = 1;
                while(!s.isEmpty() && temperatures[i+1] > s.peek()[0])
                {
                    int[] temp = s.pop();
                    result[temp[1]] = i - temp[1] +1;
                }
            }
            else
                s.add(new int[]{temperatures[i],i});
        }

        return result;
    }
}