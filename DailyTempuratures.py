class Solution:
    # Time Complexity - O(N^2)
    # Space Complexity - O(1)    
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        result = []
        for i in range(len(T)):
            wDays = 0
            highest = T[i]
            for j in range(i+1, len(T)):
                if highest < T[j]:
                    wDays = j-i
                    result.append(wDays)
                    break
            else:
                result.append(wDays)
        return result

    # Solution 2 - Using Stack (store the index in indereasing order of the T[index] values)
    # Time Complexity - O(N)
    # Space Complexity - O(N)   
    from collections import deque
    def dailyTemperatures2(self, T: List[int]) -> List[int]:
        # Return empty of T is not given
        if not T:
            return []
        l = len(T)
        # Intialize the output with 0's 
        output = [0] * l
        stack = deque()
        for i in range(l):
            #  stack is not empty and stack top is less than the current day tempurature
            #  then pop the index and modify the popped index value with (i-popped index)
            #  as we found the warmer day for popped index 
            while stack and T[stack[-1]] < T[i]:
                # we will start to pop
                topIndex = stack.pop()
                output[topIndex] = i - topIndex
            # Add the current index to the stack
            stack.append(i)
        return output