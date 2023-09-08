//Daily Temperatures 

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

//TC: O(n)
//SC:O(n)
        //next warmer day/greater/smaller day
        //Use Stack

        int[] T=new int[temperatures.length];

        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<temperatures.length;i++)
        {
            //compare actual values
         while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i])
         {
             //work with indexes
             //store indexes on stack
             int popped=stk.pop();
             int diff=i-popped;
             T[popped]=diff;

         }
         stk.push(i);//push index on stack
         //for first element and every other element
        }
        return T;
    }  

    }
