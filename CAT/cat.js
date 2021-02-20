
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


let currentBreeds = "";
function getBreeds() {
    let breedUrl = "https://api.thecatapi.com/v1/breeds?attach_breed=0&2280658c27df8c0709b6a8c33e204b72";
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


    let breedUrl = "https://api.thecatapi.com/v1/breeds/search?api_key=2280658c27df8c0709b6a8c33e204b72&q=" + selectedBreed;

    fetch(breedUrl).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                fetch("https://api.thecatapi.com/v1/images/search?limit=1&size=thumb&api_key=2280658c27df8c0709b6a8c33e204b72&breed_id=" + data[0].id)
                .then(function (response) {
                   
                if (response.ok) {
                        response.json().then(function (infoOfUrl) {

                            let showBreed = document.getElementById("display")
                            showBreed.innerHTML = "";
                            let name = document.createElement("h3");
                            name.textContent = data[0].name;
                            let image = document.createElement("div");
                            image.innerHTML = '<img src="' + infoOfUrl[0].url + '">';
                            let description = document.createElement("p");
                            description.className = "description";
                            description.textContent = data[0].description;
                            let moreInformation = document.createElement("div");
                            moreInformation.innerHTML = "<a href='" + data[0].wikipedia_url + "' target='_blank'> Wikipedia </a> <br/>";
                            showBreed.appendChild(name);
                            showBreed.appendChild(image);
                            showBreed.appendChild(description);
                            showBreed.appendChild(moreInformation);
                        })
                    }
            })
        });
}
    });


saveGeneratedBreads(selectedBreed);
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
    let selectedBreed = $('#breed').find(":selected").text();
    getBreed(selectedBreed);
});
