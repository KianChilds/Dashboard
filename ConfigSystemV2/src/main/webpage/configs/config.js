
configNameToHTML = {
    "Drive Train":"drivetrain\\DriveTrainConfig.html",
    "Climber":"climber\\ClimberConfig.html"
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

async function startConfigJS(){
    populateDropDown()
}