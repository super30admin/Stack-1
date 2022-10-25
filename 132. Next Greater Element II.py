class Solution:
    def nextGreaterElements(self, nums):
        n = len(nums)
        result = [-1 for i in range(n)]
        st = []  # stack to store the indexes of the unresolved elements

        for i in range(2 * n):  # we loop through the array twice
            # we do i % n if not it will raise out of bounds error
            while len(st) > 0 and nums[st[-1]] < nums[i % n]:
                top = st.pop()
                # put the value of the greater element in the result for the element on the top
                result[top] = nums[i % n]
            # Append in the stack only if i less than len(nums) as we are not appending for the second loop
            if i < n:
                st.append(i)  # put the current index in  stack
        print(result)
        return result


# Monotonic stack
# Time Complexity: O(3n)
# Space Complexity: O(n)

if __name__ == "__main__":
    obj = Solution()
    obj.nextGreaterElements([9, 6, 7, 10, 21, -5, -3, 18])
