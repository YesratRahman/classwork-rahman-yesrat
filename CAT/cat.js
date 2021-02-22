
let generate_btn = document.querySelector(".generate_button"); 
generate_btn.addEventListener("click", getPictures); 
function getPictures(){
    let catImgDiv = document.querySelector(".catsImages")
    catImgDiv.innerHTML = ''   //clears the html after generating image
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

//gets all breeds by name 
function getBreeds() {
    let breedUrl = "https://api.thecatapi.com/v1/breeds?attach_breed=0";
    fetch(breedUrl)
    .then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                for (let i = 0; i < data.length; i++) {
                    //gets value and texts (<option value="abys">Abyssinian</option>)
                    let breedOptions = $("<option>").val(data[i].id).text(data[i].name);
                    $("#breed").append(breedOptions);
                }
            });
        } else {
            console.log(response.statusText);
        }
    });
}
getBreeds();


let saveGeneratedBreads = function (breedSelected) { 
    //checks if the recenct breed name matches the selected breed name 
    let findBreeds = recentBreeds.breeds.some(breed => breed.name === breedSelected); 
    if (!findBreeds) { 
        recentBreeds.breeds.push({ 
            name: breedSelected
        });
        
    }
    localStorage.setItem("recentBreeds", JSON.stringify(recentBreeds)); 
    //stringify converts a JavaScript object or value to a JSON string
};

//Checks if there is any memory in local, gets that array and pushes into it.
//else create a blank array of breeds and add it to the recent breed memory
function loadRecentBreeds() { 
    recentBreeds = JSON.parse(localStorage.getItem("recentBreeds"));
    if (!recentBreeds) {
        recentBreeds = {
            breeds: []
        };
    }

};
loadRecentBreeds();

function getBreed(selectedBreed) {
    let breedUrl = "https://api.thecatapi.com/v1/breeds/search?q=" + selectedBreed;

    fetch(breedUrl).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                fetch("https://api.thecatapi.com/v1/images/search?limit=1&size=thumb&breed_id=" + data[0].id)
                .then(function (response) {
                if (response.ok) {
                        response.json().then(function (infoOfUrl) {

                            let showBreed = document.getElementById("display")
                            showBreed.innerHTML = "";

                            let name = document.createElement("h2");
                            name.textContent = data[0].name;
        
                            let altName = document.createElement("p");
                            if(data[0].alt_names === ""){
                                altName.textContent = "Alternative Name: " + data[0].alt_names + "None";
                            }
                            else {
                                altName.textContent = "Alternative Name: " + data[0].alt_names;

                            }
                            
                            let image = document.createElement("div");
                            image.innerHTML = '<img src="' + infoOfUrl[0].url + '">';

                            let origin = document.createElement("h3");
                            origin.textContent = "Origin: " + data[0].origin;

                            let weight = document.createElement("h4");
                            weight.textContent = "Weight (Imperial): " + data[0].weight.imperial + " lb"+ " (Metric): " + data[0].weight.metric +" kg";


                             let lifeSpan = document.createElement("h4");
                             lifeSpan.textContent = "Life Span: " + data[0].life_span + " yr";


                            let temperament = document.createElement("h4");
                            temperament.className = "infoSize";
                            temperament.textContent = "Temperament: " + data[0].temperament;


                            let description = document.createElement("p");
                            description.textContent = data[0].description;

                            let wekiInfo = document.createElement("div");
                            wekiInfo.className = "moreInfo";
                            wekiInfo.innerHTML = "<a href='" + data[0].wikipedia_url + "' target='_blank'> Wikipedia </a>";
                            
                            let catVet = document.createElement("div");
                            catVet.className = "moreInfo";
                            catVet.innerHTML = "<a href='" + data[0].vcahospitals_url + "' target='_blank'> VCA(Traits) </a>";

                            let learnInfo = document.createElement("div");
                            learnInfo.className = "moreInfo";
                            learnInfo.innerHTML = "<a href='" + data[0].cfa_url + "' target='_blank'> Learn More </a>";

                            showBreed.appendChild(name);
                            showBreed.appendChild(altName);
                            showBreed.appendChild(image);
                            showBreed.appendChild(document.createElement("br"));
                            showBreed.appendChild(origin);
                            showBreed.appendChild(weight);
                            showBreed.appendChild(lifeSpan);
                            showBreed.appendChild(temperament);
                            showBreed.appendChild(description);
                            showBreed.appendChild(wekiInfo);
                            showBreed.appendChild(catVet);
                            showBreed.appendChild(learnInfo);
                            showBreed.appendChild(document.createElement("br"));
                        })
                    }
            })
        });
}
    });
saveGeneratedBreads(selectedBreed);
}




document.getElementById("submit").addEventListener('click', function (event) {
    let selectedBreed = $('#breed').find(":selected").text(); //Gets texts from the selected dropdown menu 
    getBreed(selectedBreed); //then calls the getBreed() method
});






// const getBreed = function() {

//     let dropdown = $('#breed-dropdown');
    
//     dropdown.empty();
    
//     dropdown.append('<option selected="true" disabled>Choose Breed</option>');
//     dropdown.prop('selectedIndex', 0);
    
//     const url = 'https://api.thecatapi.com/v1/breeds?'; 
    
//     $.getJSON(url, function (data) {
//       $.each(data, function (key, value) {
//         dropdown.append($('<option></option>').attr('value', value.id).text(value.name));
    
//       });
//        console.log( data );
               
//     })
//     getBreedInformation();
//     } ;
    
    
//     function getBreedInformation() {
    
//       const url = 'https://api.thecatapi.com/v1/breeds?'; 
    
//       $('#breed-dropdown').on('change', function() {
//         let temp =  $(this).find('option:selected').attr('value');
//         // alert(temp);
//         $.getJSON(url, function (data) {
//           Object.keys(data).forEach(function(key){
//             if(data[key]["id"] == temp) {
             
//              return (data[key]["life_span"]);
    
//             }
//           })
          
//         });
        
//       })    
//     }
//     $()
//     getBreed();