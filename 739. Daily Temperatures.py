T(C) : O(n)

S(C) : O(n)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        ## need to store temperature and index as a pair in stack

        stack = []

        ## innitialize all valeus in resulting array to temp
        arr = [0] * len(temperatures)

        for i, j in enumerate(temperatures):
            ## maintaining decreasing monotonic structure of stack
            while stack and stack[-1][0] < j:

                tempVal, tempIdx = stack.pop()
                arr[tempIdx] = i - tempIdx
            stack.append([j , i])
            
        return arr









        
