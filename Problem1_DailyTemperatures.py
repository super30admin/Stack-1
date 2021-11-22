# Time Complexity: O(n), where n - length of the input array
# Space Complexity: O(n)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not temperatures or len(temperatures) == 0:
            return []

        n = len(temperatures)
        result = [0 for x in range(n)]
        stack = [0]

        for i in range(1, n):

            # If curr temp is greater than temp of idx from stack, update the result for that idx
            while stack and temperatures[i] > temperatures[stack[-1]]:
                idx = stack.pop()
                result[idx] = i - idx

                # Else, push the index into stack until a greater temp is found
            stack.append(i)

        return result