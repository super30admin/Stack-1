//Time Complexity-O(n)
//Space Complexity-O(n)
//Ran succesfully on leetcode

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        /*vector<int>result(nums.size(),0);
        bool flag=false;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=i+1;j<nums.size();j++)
            {
                if(nums[j]>nums[i])
                {
                    result[i]=nums[j];
                    flag=true;
                    break;
                }
            }
            if(flag==false)
            {
                for(int j=0;j<i;j++)
                {
                    if(nums[j]>nums[i])
                    {
                        result[i]=nums[j];
                        flag=true;
                        break;
                    }
                }
            }
            if(flag==false)
                result[i]=-1;
            flag=false;
        }
        return result;*/
        stack<int>s;
        int n=nums.size();
        vector<int>result(n,0);
        if(nums.empty())
            return {};        
        for(int i=2*n-1;i>=0;i--)
        {
            while(!s.empty() && nums[s.top()]<=nums[i%n])
                s.pop();
            if(s.empty())
                result[i%n]=-1;
            else
                result[i%n]=nums[s.top()];
            s.push(i%n);
        }
        return result;
    }
};