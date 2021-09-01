// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //bruthforce approach
    /*
    public int[] dailyTemperatures(int[] temperatures) {
        
        int i=0;
        int j=i+1;
        
        int[] result=new int[temperatures.length];
        
        for(i=0;i<temperatures.length;)
        {
            if(j< temperatures.length && temperatures[i]<temperatures[j])
            {
                result[i]=j-i;
                i=i+1;
                j=i+1;
            }
            else
            {
            	if(j>=temperatures.length)
                {
                   i=i+1;
                    j=i+1;
                }
            		
            	else
                    j=j+1;
            }
        }
        return result;
    }
    */
     public int[] dailyTemperatures(int[] temperatures)
     {
         if(temperatures==null||temperatures.length==0)
             return new int[]{};
         
         Stack<Integer> stack=new Stack<>();
         
         int[] result=new int[temperatures.length];
         
         for(int i=0;i<temperatures.length;i++)
         {
             while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
             {
                 int item=stack.pop();
                 result[item]=i-item;
             }
             stack.push(i);
         }
         return result;
     }
}
