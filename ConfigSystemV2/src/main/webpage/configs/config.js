
configNameToHTML = {
    "Drive Train":"drivetrain\\DriveTrainConfig.html",
    "Climber":"climber\\ClimberConfig.html"
}

function displayMotor(id, motor){

}

function configSelected(){
    let targConfig = document.getElementById("configSelector").value
    document.getElementById("configIframe").src = targConfig
    console.log(targConfig)
}

function populateDropDown(){
    for(i in configNameToHTML){
        curHtml = document.getElementById("configSelector").innerHTML
        curHtml += "<option value="+configNameToHTML[i]+">"+i+"</option>"
        document.getElementById("configSelector").innerHTML = curHtml;
    }
}

async function testmotorget(){
    response = await fetch(apiUrl+"motorConfigs")
    .then(response => response.json())
    .then(data => {return data});
    return response
}

async function startConfigJS(){
    populateDropDown()
    console.log(await testmotorget());
}