//****130.739. Daily Tempratures- BRUTEFORCE WAY****
// Time Complexity :O(N square);
// Space Complexity :o(1);
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int [] answer=new int[n];
        
        for(int i=0;i<temperatures.length;i++)
        {
            for(int j=i+1;j<temperatures.length;j++)
            {
                if(temperatures[i]<temperatures[j])
                {
                    answer[i]=j-i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
