// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func nextGreaterElements(_ nums: [Int]) -> [Int] {
        if nums.count == 0 || nums == nil {
            return nums
        }
        var stack = [Int]()
        var output = Array(repeating: -1, count: nums.count)
        stack.append(0)
        for i in 0..<nums.count * 2 {
            var index = i % nums.count
            while !stack.isEmpty && nums[stack.last!] < nums[index] {
                output[stack.removeLast()] = nums[index]
            }
            if output[index] == -1 {
            stack.append(index)
            }
        }
        return output
    }