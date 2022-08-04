# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def candy(self, ratings: list[int]) -> int:
        result = [1]*len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                result[i] += result[i-1]
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1] and result[i] <= result[i+1]:
                result[i] = result[i+1]+1
        return sum(result)


print(Solution().candy([1, 2, 2]))
