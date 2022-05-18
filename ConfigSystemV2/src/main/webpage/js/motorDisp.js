let motorIds = []

async function getMotorIds(x){

    return fetch(apiUrl+"motor/ids")
    .then(response => response.json())
    .then(data => {
        return data});
}

async function addMotors(){
    ids = await getMotorIds()
    for(i in ids){
        document.getElementById("motorSelector").innerHTML = document.getElementById("motorSelector").innerHTML.concat("<option>"+ids[i]+"</option>")
        motorIds.push(ids[i])
    }
}

async function fetchMotor(id){
    return fetch(apiUrl+"motor/"+id)
    .then(response => response.json())
    .then(data => {
        return data});
}

async function dispMotor(motorId, htmlID){
    let attr = []
    let motor = await fetchMotor(motorId)

    console.log(motor)

    attr.push("<h2>Motor id " + motorId +"</h2>")
    attr.push("<div name=\"pidf\">")
    attr.push("<h3 >PIDF</h3>")
    attr.push("<table>")
    attr.push("<tr><td>P:</td><td>"+motor.pidf.p.toString()+"</td></tr>")
    attr.push("<tr><td>I:</td><td>"+motor.pidf.i.toString()+"</td></tr>")
    attr.push("<tr><td>D:</td><td>"+motor.pidf.d.toString()+"</td></tr>")
    attr.push("<tr><td>F:</td><td>"+motor.pidf.f.toString()+"</td></tr>")
    attr.push("</table>")

    let fin = ""
    for(let i=0; i < attr.length; i++){
        fin += attr[i]
    }
    document.getElementById(htmlID).innerHTML = fin
}

function selectMotor(){
    dispMotor(document.getElementById("motorSelector").value, "motorDisp")
}

async function chechForConnection(){

}

async function wait(){
    
}

async function startMotorJS(){
    await addMotors()
    dispMotor(motorIds[0], "motorDisp")
}