

const getBreed = function() {

let dropdown = $('#breed-dropdown');

dropdown.empty();

dropdown.append('<option selected="true" disabled>Choose Breed</option>');
dropdown.prop('selectedIndex', 0);

const url = 'https://api.thecatapi.com/v1/breeds?2280658c27df8c0709b6a8c33e204b72';

$.getJSON(url, function (data) {
  $.each(data, function (key, entry) {
    dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));

   // $("#reportHeader").text(`Information for ${entry.name}` );
   // $("#lifeSpan").text(data.life_span);



  })
})
} ;