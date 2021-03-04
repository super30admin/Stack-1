'''
T = O(2n)
S = O(n)

Approach:
Iterate throught the array and store the index of the array elements in a stack,
At each iteration check if the top value of the stack can be poped perform this action untill all the possible values
Find the difference of the such possibilities using the indecies will give the result
'''


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return T
        stack = []
        result = [0] * len(T)
        for i in range(0,len(T)):
            while stack and T[stack[-1]] < T[i]:
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)
        print(stack)
        return result
                
                