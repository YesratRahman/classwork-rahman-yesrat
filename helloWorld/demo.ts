let boolVariable : boolean = false; 
let numVariable : number = 50; 
let strVariable : string = "bob"; 
let oldArray : string[] = ["Alice", "Bob", "Christina", "Dave"];
let tupleVariable : [number, string, boolean];
tupleVariable = [5, "Robert", false]; 
enum StreetLights {
    Red, 
    Yellow,
    Green
}
let streetLight : StreetLights.Yellow; 

//"any" basically puts us back to the old js time
let anyVar : any = 5; 
anyVar = "Bob"; 
numVariable = anyVar; 

let objVariable : object = {}
//objVariable.newProp = 5;  won't work 

interface TicTacToePlayer{
    name : string;
    turn : boolean; 

}

function printPlayerName (player : TicTacToePlayer) : string{
    console.log(player.name);
    return player.name; 
}

interface Student {
    studentId? : number; //this field is optional, because when we add the student we don't have the id until api gives it to us
    name : string; 
}
let s: Student = {name: "Bob"}; 

let optinalvar : Partial<Student> = {}; 
optinalvar.name = "David"; 
optinalvar.studentId = 5; 

//not allowed, because student does not have this
// optinalvar.newprop = 5; 
//not allowed, because student does not have this
// let studentWithExtra : Student = {name: "Bob", newProp  = 5 }; 

interface GoodStudent{
    readonly studentId? : number; 
    readonly name : string; 
}

let readonlyVar : GoodStudent = {studentId : 5, name: "Bob"};
//not allowed, since we already set it before
//Even though, we don't have to 
//readonlyVar.studentId = 5; 

class TalentPathStudent implements Student{
    studentId : number; 
    name : string; 
    constructor(id: number, name: string){
        this.studentId = id; 
        this.name = name; 
    }
    // printName : void {
    //     console.log(this.studentId); 
    // }
}
//let tpStudent : TalentPathStudent = {studentId: 5 , name: "Bob"}; 
let tpStudent : TalentPathStudent = new TalentPathStudent(5, "Bob"); 

tpStudent = {studentId: 5 , name: "Bob"}; 
//console.log(tpStudent); 

interface Runnable {
    run(printMessage : string) : void; 
}

let testRunnable : Runnable =  {
    run : function (printMessage : string) : number{
        console.log(printMessage); 
        return 0; 
    }
}

let allEqual : (a: number, b : number, c : number ) => boolean; 

allEqual = function (a: number, b : number, c : number ) : boolean  {
    return true; 
}
allEqual = function (a: number, b : number, c? : number ) : boolean  {
    return true; 
}
allEqual = function (a: number, b: number){
    return true; 
}


//Literal Type 
type OneDigitNumber = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ; 
let num : OneDigitNumber = 5; 

num += 1; 

//Not allowed 
//num  = 10; 
for(let i = 0; i < 100; i++ )
{
    num++; 
    console.log(num); 
}

let addTwoNumbers = function(a: number, b : number) : number {
    return a + b; 

}
addTwoNumbers(5, num); 

//Does not work 
//num = addTwoNumbers(5, num); 

let addTwoNumbers1 = function(a: OneDigitNumber, b : OneDigitNumber) : OneDigitNumber {
    return (a + b)  as OneDigitNumber; 

}
console.log(addTwoNumbers1(5,6)); 

type lightStatus = "Red" | "Yellow" | "Green"; 
let currentLight : lightStatus = "Red"; 
currentLight += " arrow"; 
console.log(currentLight); 

let mixedTypeVariable : string | Student | null; 
mixedTypeVariable = "Raha"; 
mixedTypeVariable = tpStudent; 