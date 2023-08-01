class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        Time Complexity - O(2n) ==> O(n)
        Space complexity - O(n)

        :type temperatures: List[int]
        :rtype: List[int]
        """
        # Initialize an array to store the result with 0s.
        result = [0] * len(temperatures)

        # Check if the temperatures list is empty or None.
        if temperatures is None or len(temperatures) == 0:
            return result

        # Initialize a stack to keep track of indices of temperatures.
        st = []

        # Iterate through the temperatures list to find the warmer days.
        for i in range(0, len(temperatures)):
            while st and temperatures[i] > temperatures[st[-1]]:
                popped = st.pop()  # Pop the index from the stack.
                # Calculate the number of days waited for a warmer temperature.
                result[popped] = i - popped
            # Push the current index onto the stack to check for a warmer temperature in the future.
            st.append(i)

        return result
