#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        res = [1 for _ in range(n)]
        if ratings == None or n == 0:
            return 0
        if n == 1:
            return 1
        for i in range(1, n):
            if ratings[i-1] < ratings[i]:
                res[i] = 1 + res[i-1]
        sumR = res[n-1]
        for i in range(n-2, -1, -1):
            if ratings[i+1] < ratings[i]:
                res[i] = max(res[i], 1+res[i+1])
            sumR += res[i]
        return sumR
        
