"""
// Time Complexity : O(len(T))
// Space Complexity : O(len(T))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Iterate over the array of temperatures
- while stack is not empty and current temperature > stack's top,
    ele - pop the last element from stack
    - get the last index 
    - update result array of index to be current index - last index
- add (ele,index) to stack
- while stack is not empty
    - add 0 to result till end of stack // dealing with temperatures not having next
    higher temperature
"""
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        """
        arr - [73, 74, 75, 71, 69, 72, 76, 73]
        curr = 75
        result[0] = 1
        result[1] = 2
        result[5,4,3,2] (updates)
        stk = [(75,2),(71,3),(69,4),(72,5)]
        """
        
        
        stk = []
        N = len(T)
        result = [0]*N

        for i,num in enumerate(T):
            while stk and stk[-1][0] < num:
                ele = stk.pop()
                #result.append(i - ele[1])
                result[ele[1]]=i - ele[1]

            stk.append([num,i])

        while stk:
            ele = stk.pop()
            #result.append(0)
            result[ele[1]]=0

        return result