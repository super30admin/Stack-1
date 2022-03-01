class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        '''
        Algorithm
        Iterate over the temp array 
        While incoming temp is greater than top of the stack
        update the index val as 
        incoming temp index - stack top index 
        else:
        push the incoming element and index 

        Time complexity = O(2N)
        Space = O(N)
        '''
        n = len(temperatures)
        op = [0]*n
        stack = []
        for idx, val in enumerate(temperatures):
            while stack and val > stack[-1][0] :
                curr = stack.pop()
                op[curr[1]] = idx - curr[1] 
            stack.append( (val,idx) )
        return op
