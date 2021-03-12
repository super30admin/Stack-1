# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We use the stack since we want to find the next largest 
# We put each index inside the stack 
# compare this index with peek from stack if we found greater int
# then we update the res array with the current index - stack.pop()
# we keep doing this for the rest of the elements in the stack 
# util the conditions  is True 

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T == None or len(T) == 0: return 
        stack = deque()
        res = [0]*len(T)
        
        for i in range(len(T)):
            while stack and T[i] > T[stack[-1]]:
                x = stack.pop()
                res[x] = i-x
            stack.append(i)
        
        return res