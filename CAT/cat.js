
let generate_btn = document.querySelector(".generate_button"); 
generate_btn.addEventListener("click", getPictures); 
function getPictures(){
    let catImgDiv = document.querySelector(".catsImages")
    catImgDiv.innerHTML = ''
    fetch('https://api.thecatapi.com/v1/images/search')
    .then(response => response.json())
    .then((data) => {
       let catsImageUrl = data[0].url

       let catImageElement = document.createElement("img")
       catImageElement.setAttribute('src', `${catsImageUrl}`)
       catImageElement.classList.add("imageResize")
       let catImgDiv = document.querySelector(".catsImages")
       catImgDiv.append(catImageElement)
    })
    .catch(err=> console.log(err))

}



const getBreed = function() {

let dropdown = $('#breed-dropdown');

dropdown.empty();

dropdown.append('<option selected="true" disabled>Choose Breed</option>');
dropdown.prop('selectedIndex', 0);

const url = 'https://api.thecatapi.com/v1/breeds?2280658c27df8c0709b6a8c33e204b72';

$.getJSON(url, function (data) {
  $.each(data, function (key, value) {
    dropdown.append($('<option></option>').attr('value', value.id).text(value.name));

    $("#lifeSpan").attr('value', key).text(value.life_span);
   // $( "<img>" ).attr( "src", value.image ).appendTo( "#images" );


   // $("#reportHeader").text(`Information for ${entry.name}` );
  //  $("#lifeSpan").attr('value', key).text(entry.life_span);
  //$('#lifeSpan').val(entry.life_span);

  });
  console.log( data );
           
})
} ;






getBreed(); 

