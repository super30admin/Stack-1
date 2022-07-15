TC- O(N)
SC - O(N)

/**
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function(nums) {
   
    const map = new Map()
    for (const [i, temp] of nums.entries()) {
        if (!map.has(temp)) map.set(temp, [])
        
        const queue = map.get(temp)
        queue.push(i)
    }
    
    
    const len = nums.length
    let result = new Array(len)
    const upperBound = 100
    for (const [i, temp] of nums.entries()) {
        let outcome = len
        
       
        for (let t = 1 + temp; t <= upperBound; t++) {
            const queue = map.get(t)
            if (!queue) continue
            
          
            let low = 0, high = -1 + queue.length
            
           
            if (queue[high] <= i)    continue
            
            while (low < high) {
                const mid = Math.floor((low + high) / 2)
                if (queue[mid] > i)  high = mid
                else low = 1 + mid
            }
            
            const bestIndex = queue[high]
            outcome = Math.min(outcome, bestIndex)
        }
        
        
        if (outcome === len) {
            outcome = i
        }
        
        outcome -= i
        result[i] = outcome
    }
    
    
    return result
};