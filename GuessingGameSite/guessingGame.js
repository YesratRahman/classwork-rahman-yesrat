
let random4Digit = function(){

    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  
    let answer = digits.splice( Math.trunc(Math.random() * (digits.length - 1) + 1 ), 1)[0];
  
    for( let i = 1; i < 4; i++ ){
  
      let randomIndex = Math.trunc(Math.random() * digits.length);
  
      let digit = digits.splice(randomIndex,1)[0];
      answer *= 10;
      answer += digit;
  
    }
  
    return answer;
  
  }

let newArray  = random4Digit(); 
let hiddenNumber = Array.from(String(newArray), Number); 

    
const checkGame = function(){

    let guess = document.getElementById("guessNum").value;
    let array = Array.from(String(guess),Number)

    updatedBox(guess); 

    for(let i = 0;i < 4; i++)
    {
        if(hiddenNumber[i] === array[i])
        {
            document.getElementById("box"+(i+1)).style.backgroundColor = "green";
        }
        else if(hiddenNumber.includes(array[i]) && (hiddenNumber[i]!== array[i])) 
        
        {
            document.getElementById("box"+(i+1)).style.backgroundColor  = "yellow";

        }
        else
        {
            document.getElementById("box"+(i+1)).style.backgroundColor = "red";

        }
    } 

    if(allValidDigit(array))
    {
        alert("Congratulation, you guessed the number right!");
    }
}

function allValidDigit(numberArray)
{
for(let i = 0;i<4;i++)
{
    if(numberArray[i]!==hiddenNumber[i])
    {
        return false;
    }
}

return true;
}

function updatedBox(guessBox)
{
document.getElementById("box1").innerText = Math.trunc(Math.floor(guessBox/1000));
document.getElementById("box2").innerText = Math.trunc(guessBox%1000/100);
document.getElementById("box3").innerText = Math.trunc(guessBox%100/10);
document.getElementById("box4").innerText = Math.trunc(guessBox%10);

}



  const resetElement = function()
  {
      for(let i = 1; i<5;i++)
      {
          document.getElementById("box"+i).style.backgroundColor  = "white";
          document.getElementById("box"+i).innerText = " ";
      }
      document.getElementById("guessNum").value = null; 

  }
  
  const reset = function()
  {
      resetElement();
      newArray = random4Digit();
      hiddenNumber = Array.from(String(newArray), Number); 

  }

  






  

// const random4Digit = function(){
//     return shuffle( "0123456789".split('') ).join('').substring(0,4);
//   }
  
//   function shuffle(o){
//       for(var j, x, i = o.length; i; j = Math.floor(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
//       return o;
//   }
  


 