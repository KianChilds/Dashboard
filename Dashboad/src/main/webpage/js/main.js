let apiUrl = 'http://localhost:8080/'


function changeDisplayToMotors(){
    document.getElementById("mainDisplay").src = "motors.html"
}

function changeDisplayToHome(){
    document.getElementById("mainDisplay").src = "home.html"
}

function changeDisplayToConfig(){
    document.getElementById("mainDisplay").src = "config.html"
}


async function isReady(){
    response = await fetch(apiUrl+"status")
    .then(response => response.json())
    .then(data => {
        console.log(data)
        return data});
    return response.ready
}

async function startStatusUpdating(){
    while(true){
        try{
            if(await isReady()){
                document.getElementById("status-indicator").style["background-color"] = "green"
            }else{
                document.getElementById("status-indicator").style["background-color"] = "yellow"
            }
        }catch(e){
            if(e.toString().substring(0,26) === "TypeError: Failed to fetch")
            document.getElementById("status-indicator").style["background-color"] = "red"  
        }
        await new Promise(resolve => setTimeout(resolve, 500))
    }
    
}
