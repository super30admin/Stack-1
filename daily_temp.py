from collections import deque
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        result = [0 for i in range(len(T))]
        stack = deque()
        i = 0
        for i in range(len(T)):
            while stack and T[i]>T[stack[-1]]:
                temp = stack.pop()
                result[temp] = i-temp
            stack.append(i)
        return result

#time complexity - O(n), n = lenght of input list

#space complexity - O(n), stack space

#all test cases passed