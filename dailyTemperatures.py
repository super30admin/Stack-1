class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        ans = [0]*len(T)
        for i in range(len(T)):
            while stack and T[stack[-1]]<T[i]:
                index = stack.pop()
                ans[index] = i-index
            stack.append(i)
        return ans
 time: O(n)
 Space:O(n)
