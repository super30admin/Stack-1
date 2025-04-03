#  https://leetcode.com/problems/daily-temperatures/

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * (len(temperatures))

        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                index = stack.pop()
                result[index] = i - index

            stack.append(i)     

        return result   

# monotonic stack
# tc: O(n)
# SC: : O(n) the stack can go upto all entries of temp in worst case