async function testmotorget(){
    response = await fetch(apiUrl+"motorConfigs")
    .then(response => response.json())
    .then(data => {return data});
    return response
}