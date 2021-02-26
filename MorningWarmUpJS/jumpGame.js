/**
 * @param {number[]} nums
 * @return {boolean}
 */


var canJump = function(nums) {

    
    let lastIndex = nums.length - 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        if (i + nums[i] >= lastIndex) {
            lastIndex = i;
        }  // else the final index remains the target index
    }
        
    return lastIndex === 0;
};

console.log(canJump([2,3,1,1,4]));

// [2,  3,  1,   1,    4]

// 0   1   2    3     4 

// 2+0  3+1 3+1  3+1   4
// >=1  >=2 >=3  >=4  

// [3,  2,   1,    0,   4] 
// 0   1    2      3     4 
//   2+1    2+1    3
//               not>=4  >=4  