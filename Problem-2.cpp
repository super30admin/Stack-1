/*
This approach makes use of a stack. This stack stores the indices of the appropriate elements from numsnumsnums array. The top of the stack refers to the index of the Next Greater Element found so far. We store the indices instead of the elements since there could be duplicates in the numsnumsnums array. The description of the method will make the above statement clearer.

We start traversing the numsnumsnums array from right towards the left. For an element nums[i]nums[i]nums[i] encountered, we pop all the elements stack[top]stack[top]stack[top] from the stack such that nums\big[stack[top]\big] ≤ nums[i]. We continue the popping till we encounter a stack[top]stack[top]stack[top] satisfying nums[stack[top]]>nums[i]nums\big[stack[top]\big] > nums[i]nums[stack[top]]>nums[i]. Now, it is obvious that the current stack[top]stack[top]stack[top] only can act as the Next Greater Element for nums[i]nums[i]nums[i](right now, considering only the elements lying to the right of nums[i]nums[i]nums[i]).

If no element remains on the top of the stack, it means no larger element than nums[i]nums[i]nums[i] exists to its right. Along with this, we also push the index of the element just encountered(nums[i]nums[i]nums[i]), i.e. iii over the top of the stack, so that nums[i]nums[i]nums[i](or stack[topstack[topstack[top) now acts as the Next Greater Element for the elements lying to its left.*/

class Solution {
public:
      vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> next(n, -1);
        stack<int> s; // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!s.empty() && nums[s.top()] < num) {
                next[s.top()] = num;
                s.pop();
            }
            if (i < n) s.push(i);
        }   
        return next;
    }
};
    
