
//https://leetcode.com/problems/subsets/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
    let result = [];
    result.push([]);

    for (let i = 0; i < nums.length; i++) {
        let curNum = nums[i];
        let len = result.length;
        for (let j = 0; j < len;j++) {
            let copy = result[j].slice(0);
            copy.push(curNum);
            result.push(copy)
        }
    }
    return result;
};
//console.log(subsets([1, 3]));


var subsets1 = function (nums) {
    // Started with an empty set
    let result = [];
    result.push([]);

    for (let element of nums) { 
        let length = result.length; 
        // Can't use result.length inside the loop since 
        // results length is increased in loop
        for (let i = 0; i < length; i++) {
            let copy = result[i].slice(); // Make a copy of the element at index i  
            copy.push(element); // Add current element to copy
            result.push(copy); // Add copy back to results array
        }
    }

    return result;
};

console.log(subsets1([1, 3]));
