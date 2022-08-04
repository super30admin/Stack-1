# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        result = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            while len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]:
                pop = stack.pop()
                result[pop] = i - pop
            stack.append(i)
        return result


print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))


# T.C: O(n^2); S.C: O(1)
# class Solution:
#     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
#         result = [0]*len(temperatures)
#         for i in range(len(temperatures)):
#             for j in range(i+1, len(temperatures)):
#                 if temperatures[j] > temperatures[i]:
#                     result[i] = j-i
#                     break
#         return result

