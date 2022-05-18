
async function displayRobotInformation(){
    response = await fetch(apiUrl+"status")
    .then(response => response.json())
    .then(data => {return data});
    return response
}

async function startHomeJS(){
    console.log(":)")
    console.log(await displayRobotInformation())
}