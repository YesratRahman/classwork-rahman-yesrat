var sortByBits = function ( arr ) { 
    return arr.sort( ( a, b ) => {
       return countBit(a) - countBit(b) || a - b
   }) 
};  
let countBit = function ( num ) { 
 let count = 0 
 while (num != 0 ) {
    if (num% 2 === 1 ) {
       count++;       
     }       
    num = Math.trunc(num / 2 )     
    } 
return count;   
} 

console.log(sortByBits([0,1,2,3,4,5,6,7,8]))