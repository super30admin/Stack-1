
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
This problem is done using monotonic stack.we first insert the zeroth index in the stack and then starting from first index we  compare the element at current index with that of the one present at the top of stack .If it is greater then we pop the top element of the stack and then calculate the distance between current index and the element at the top of the stack and insert the distance at the index that we popped from the stack else we push the element into the stack.In this manner we do this for all the elements.


# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        stack=[]
        result=[0 for i in range(len(T))]
        stack.append(0)
        for i in range(1,len(T)):
            while len(stack)!=0 and T[i]>T[stack[-1]]:
                index=stack.pop()
                result[index]=i-index
            stack.append(i)
        return result
                
                
        