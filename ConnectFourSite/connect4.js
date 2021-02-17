let boardElements = [];
let blackTurn = true;

let populatePage = function() {

    // document.getElementById()
    // document.getElementsByClassName()
    // document.getElementsByTagName()

    let allBodyTags = document.getElementsByTagName("body");

    let bodyTag = allBodyTags[0];

    let gameDivTag = document.createElement("div");
    gameDivTag.style.height = "600px";
    gameDivTag.style.width = "700px";
    gameDivTag.style.lineHeight = "0";
    gameDivTag.style.border = "7px solid #141BB4";

    let darkSquare = true;
    for( let col = 0; col < 7; col++ ){
        boardElements.push( [] );
        for( let row = 0; row < 6; row++ ){
            boardElements[col].push(document.createElement("div"));

            boardElements[col][row].style.height = "80px";
            boardElements[col][row].style.width = "80px";
            boardElements[col][row].style.display = "inline-block";

            boardElements[col][row].style.border = "10px solid #7F7F7F"
            boardElements[col][row].style.borderRadius = "50px"

            
            boardElements[col][row].style.backgroundColor = (darkSquare ? "#AFAFAF" : "#FFFFFF");
            darkSquare = !darkSquare;
        }
        darkSquare = !darkSquare;
    }

    for( let row = 0; row < 6; row++ ){
        for( let col = 0; col < 7; col++ ){
            gameDivTag.appendChild( boardElements[col][row ]);
        }
        gameDivTag.appendChild( document.createElement("br") );
    }


    bodyTag.appendChild( gameDivTag );

    for( let col = 0; col < 7; col++ ){
        let columnButton = document.createElement("button");
        columnButton.style.width = "100px";
        columnButton.style.height = "100px";

        if( col === 0 ){
            columnButton.style.marginLeft = "7px";
        }

        columnButton.addEventListener( 
            'click', 
            function() { 
                makeMove(col);
            }
        );

        

        bodyTag.appendChild(  columnButton );
    }

    bodyTag.appendChild( document.createElement("br"));

    let resetButton = document.createElement("button");

    resetButton.addEventListener('click', reset);

    resetButton.append( "RESET" );

    bodyTag.appendChild( resetButton );


}

let reset = function() {

    let allBodyTags = document.getElementsByTagName("body");

    let bodyTag = allBodyTags[0];

    let children = bodyTag.childNodes;

    let allChildren = [ ...children ];

    for( let child of allChildren ){
        if( child.tagName === "DIV" || child.tagName === "BUTTON" ||    child.tagName === "BR" ){

            child.remove();
        }
    }

    boardElements = [];
    blackTurn = true;

    populatePage();

}

let makeMove = function(col) {

    let placedRow = -1;
    
    //TODO: make sure col is actually empty
    for( let row = 0; row < 6; row++ ){
        if( 
            row === 5 || 
            boardElements[col][row + 1].style.backgroundColor === "rgb(255, 0, 0)" ||
            boardElements[col][row + 1].style.backgroundColor === "rgb(0, 0, 0)"
        ){
            placedRow = row;
            boardElements[col][row].style.backgroundColor = blackTurn ? "#000000" : "#FF0000";
            blackTurn = !blackTurn;
            break;
        }
    }

    let placedCol = col;

    checkRows( col, placedRow );

    checkCols( col, placedRow );
    

    checkDiags( col, placedRow );



}

function checkRows( col, row ){

    let count = 0;
    for( let rOffset = 0; rOffset < 4; rOffset++ ){
        let currRow = row + rOffset;
        if( currRow> 5 ) break;
        if( boardElements[col][currRow].style.backgroundColor ===
            boardElements[col][row].style.backgroundColor
            ){
                count++;
            }
    }
    if( count == 4 ){
        alert( "you won!");
        return;
    }


    count = 0;
    for( let rOffset = 0; rOffset > -4; rOffset-- ){
        let currRow = row + rOffset;
        if( currRow < 0 ) break;
        if( boardElements[col][currRow].style.backgroundColor ===
            boardElements[col][row].style.backgroundColor
            ){
                count++;
            }
    }
    if( count == 4 ){
        alert( "you won!");
        return;
    }


}

function checkCols( col, row ){

    count = 0;
    for( let cOffset = 0; cOffset < 4; cOffset++ ){
        var currCol = col + cOffset;
        if( currCol > 6 ) break;
        if( boardElements[currCol][row].style.backgroundColor ===
            boardElements[col][row].style.backgroundColor
            ){
                count++;
            }
    }
    if( count == 4 ){
        alert( "you won!");
        return;
    }

    count = 0;
    for( let cOffset = 0; cOffset > -4; cOffset-- ){
        var currCol = col + cOffset;
        if( currCol < 0 ) break;
        if( boardElements[currCol][row].style.backgroundColor ===
            boardElements[col][row].style.backgroundColor
            ){
                count++;
            }
    }
    if( count == 4 ){
        alert( "you won!");
        return;
    }

}

function checkDiags( col, row ){

}


populatePage();