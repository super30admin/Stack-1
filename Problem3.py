#time complexity o(n)
#space complexity o(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        result = [1] * n

        #left pass
        for i in range(n):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1
        total = result[n-1]
        #right pass
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i],result[i+1] + 1)
            total += result[i]
        
        return total