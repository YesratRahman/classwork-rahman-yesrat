if( 0 == false ){
    console.log( 'javascript is weird');
}

let isVisible = false;

function toggleAllElements(){
    let elementToToggle = document.getElementById( 'toggletext' );
    //console.log( elementToToggle.style.display );
    //elementToToggle.style.display = 'block';
    // if( elementToToggle.style.display === 'none' ){
    //     elementToToggle.style.display = 'block';
    // } else {
    //     elementToToggle.style.display = 'none';
    // }

    if( isVisible ){
        elementToToggle.style.display = 'none';
    } else {
        elementToToggle.style.display = 'block';
    }

    isVisible = !isVisible;

}


function buttonIsClicked( buttonId ){
    console.log( buttonId );
    let toDisable = document.getElementById('button' + buttonId);
    toDisable.disabled = true;
}


