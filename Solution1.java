//Next greater element
//TC:O(2n)
//SC:O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        

        //same like daily temps
        //condition to focus->circular array
        int n=nums.length;
        int[] result=new int[n];
        Stack<Integer> stk=new Stack<Integer>();
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++)//2 pass algo
        {

            //optimization
            if(i>n)
            {
                //in second pass we explore same element index
                //stop there
                if(stk.peek()==i%n)
                {
                    break;
                }
            }

            //i%n----> for second pass, i=11, we need exact position to understand the circular elements position
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i%n])
            {
                int popped=stk.pop();
                result[popped]=nums[i%n];//put next greater element for given element
                
            }
            if(i<n)
            {
                stk.push(i);//push elements during first pass only
            }

        }
        return result;
    }
}