# https://leetcode.com/problems/daily-temperatures/

# Time Complexity- O(n) Space Complexity- O(n)

class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        n = len(temperatures)
        # create an auxiliary array
        result = [0] * n
        # initialiase a stack
        st = []
        
        # interate through the list of temperatures
        for i in range(n):
            # compare the current temperature with the last value in the stack till the stack is not becomes empty
            while st and temperatures[i] > temperatures[st[-1]]:
                # popped out of the stack if the next 
                popped = st.pop()
                # add it into the result array
                result[popped] = i - popped
            # append the stack
            st.append(i)

        return result

solution = Solution()
print(solution.dailyTemperatures([73,74,75,71,69,72,76,73]))
        