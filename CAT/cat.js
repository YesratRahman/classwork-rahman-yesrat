
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

let myKey = "2280658c27df8c0709b6a8c33e204b72";


let currentBreeds = "";

function getBreeds() {
    let breedUrl = "https://api.thecatapi.com/v1/breeds?attach_breed=0&api_key=" + myKey;
    fetch(breedUrl).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                for (let i = 0; i < data.length; i++) {
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
    let findBreeds = recentBreeds.breeds.some(breed => breed.name === breedSelected); 
    if (!findBreeds) { 
        recentBreeds.breeds.push({ 
            name: breedSelected
        });
        
    }
    localStorage.setItem("recentBreeds", JSON.stringify(recentBreeds));
};
function getBreed(selectedBreed) {


    let breedUrl = "https://api.thecatapi.com/v1/breeds/search?q=" + selectedBreed + "&api_key=" + myKey;

    fetch(breedUrl).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                fetch("https://api.thecatapi.com/v1/images/search?breed_id=" + data[0].id + "&limit=1&size=thumb&api_key=" + myKey).then(function (response) {
                    if (response.ok) {
                        response.json().then(function (infoOfUrl) {

                            let showBreed = document.getElementById("display")
                            showBreed.innerHTML = "";
                            let name = document.createElement("h3");
                            name.textContent = data[0].name;
                            
                            showBreed.appendChild(name);
                            
                        })
                    }
            })
        });
}
    });

