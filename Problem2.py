class Solution(object):
    def nextGreaterElements(self, nums):
        """
        Time complexity = O(2n) ==> O(n), n --> number of elements in nums
        Space complexity = O(n)

        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        result = [-1] * len(nums)  # Initialize the result array with -1s.
        st = []  # Initialize a stack to keep track of indices of elements.

        # Loop through the circular list (twice the size of nums).
        for i in range(0, 2 * n):

            # While the stack is not empty and the current element is greater than the element at the top of the stack,
            # update the result array for the top element with the current element.
            while st and nums[i % n] > nums[st[-1]]:
                popped = st.pop()  # Pop the index from the stack.
                result[popped] = nums[i % n]  # Update the result array.

            # If i is less than n, push the current index onto the stack.
            # We are only interested in the first n elements of the circular list in the first loop.
            if i < n:
                st.append(i)

            # Check if we are back to the starting position and break the loop.
            if i >= n and st[-1] == i % n:
                break

        return result
