
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

var myKey = "2280658c27df8c0709b6a8c33e204b72";


var currentBreeds = "";

function getBreeds() {
    var getBreedsUrl = "https://api.thecatapi.com/v1/breeds?attach_breed=0&api_key=" + myKey;
    //get data from API 
    fetch(getBreedsUrl).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                for (var i = 0; i < data.length; i++) {
                    var myOptions = $("<option>").val(data[i].id).text(data[i].name);

                    $("#breed").append(myOptions);
                }

            });


        } else {
            console.log(response.statusText);
        }
    });
}
getBreeds();



var saveGeneratedBreads = function (selectedBreeds) { 
    var checkBreeds = recentBreeds.breeds.some(breed => breed.breedName === selectedBreeds); 
    if (!checkBreeds) { 
        recentBreeds.breeds.push({ 
            breedName: selectedBreeds
        });
        
    }
    localStorage.setItem("recentBreeds", JSON.stringify(recentBreeds));
};
function getBreed(selectedBreed) {


    var getBreedURL = "https://api.thecatapi.com/v1/breeds/search?q=" + selectedBreed + "&api_key=" + myKey;

    fetch(getBreedURL).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                fetch("https://api.thecatapi.com/v1/images/search?breed_id=" + data[0].id + "&limit=1&size=thumb&api_key=" + myKey).then(function (response) {
                    if (response.ok) {
                        response.json().then(function (urlInfo) {

                            var breedDisplay = document.getElementById("display")
                            breedDisplay.innerHTML = "";
                            var breedName = document.createElement("h3");
                            breedName.textContent = data[0].name;
                            var breedImage = document.createElement("div");
                            breedImage.innerHTML = '<img src="' + urlInfo[0].url + '">';
                            breedImage.className = "image-resize";
                            breedImage.width = "280px"; 
                            breedImage.margin = "auto"; 
                            breedImage.height = "260px"; 
                            var breedFacts = document.createElement("p");
                            breedFacts.className = "playnice";
                            breedFacts.textContent = data[0].description;
                            var learnMore = document.createElement("div");
                            learnMore.innerHTML = "<a href='" + data[0].wikipedia_url + "' target='_blank'> Learn More </a>";
                            breedDisplay.appendChild(breedName);
                            breedDisplay.appendChild(breedImage);
                            breedDisplay.appendChild(breedFacts);
                            breedDisplay.appendChild(learnMore);
                        })
                    }
            })
        });
}
    });


saveGeneratedBreads(selectedBreed);
showRecentBreeds(selectedBreed);
}

function loadRecentBreeds() { 
    recentBreeds = JSON.parse(localStorage.getItem("recentBreeds"));
    if (!recentBreeds) {
        recentBreeds = {
            breeds: []
        };
    }

};
loadRecentBreeds();



document.getElementById("submit").addEventListener('click', function (event) {
    var selectedBreed = $('#breed').find(":selected").text();
    getBreed(selectedBreed);
});
