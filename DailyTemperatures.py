# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We go backwards and track the hottest temperature seen so far.
# If current day is cooler, we jump forward by already computed values to skip unnecessary checks.
# This helps us quickly find how many days until a warmer one shows up.

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * (n)

        i = n-1
        hottest = 0

        while i >= 0:
            if temperatures[i] >= hottest:
                hottest = temperatures[i]
                i -= 1
                continue

            days = 1
            while temperatures[i+days] <= temperatures[i]:
                days += res[i+days]

            res[i] = days
            i -= 1

        return res

        