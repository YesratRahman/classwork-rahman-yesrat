var boolVariable = false;
var numVariable = 50;
var strVariable = "bob";
var oldArray = ["Alice", "Bob", "Christina", "Dave"];
var tupleVariable;
tupleVariable = [5, "Robert", false];
var StreetLights;
(function (StreetLights) {
    StreetLights[StreetLights["Red"] = 0] = "Red";
    StreetLights[StreetLights["Yellow"] = 1] = "Yellow";
    StreetLights[StreetLights["Green"] = 2] = "Green";
})(StreetLights || (StreetLights = {}));
var streetLight;
//"any" basically puts us back to the old js time
var anyVar = 5;
anyVar = "Bob";
numVariable = anyVar;
var objVariable = {};
function printPlayerName(player) {
    console.log(player.name);
    return player.name;
}
var s = { name: "Bob" };
var optinalvar = {};
optinalvar.name = "David";
optinalvar.studentId = 5;
var readonlyVar = { studentId: 5, name: "Bob" };
//not allowed, since we already set it before
//Even though, we don't have to 
//readonlyVar.studentId = 5; 
var TalentPathStudent = /** @class */ (function () {
    function TalentPathStudent(id, name) {
        this.studentId = id;
        this.name = name;
    }
    return TalentPathStudent;
}());
//let tpStudent : TalentPathStudent = {studentId: 5 , name: "Bob"}; 
var tpStudent = new TalentPathStudent(5, "Bob");
tpStudent = { studentId: 5, name: "Bob" };
var testRunnable = {
    run: function (printMessage) {
        console.log(printMessage);
        return 0;
    }
};
var allEqual;
allEqual = function (a, b, c) {
    return true;
};
allEqual = function (a, b, c) {
    return true;
};
allEqual = function (a, b) {
    return true;
};
var num = 5;
num += 1;
//Not allowed 
//num  = 10; 
for (var i = 0; i < 100; i++) {
    num++;
    console.log(num);
}
var addTwoNumbers = function (a, b) {
    return a + b;
};
addTwoNumbers(5, num);
//Does not work 
//num = addTwoNumbers(5, num); 
var addTwoNumbers1 = function (a, b) {
    return (a + b);
};
console.log(addTwoNumbers1(5, 6));
var currentLight = "Red";
currentLight += "arrow";
console.log(currentLight);
