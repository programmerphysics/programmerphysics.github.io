function calcularFr() {
    var aceleracao = parseFloat($("#aceleracao").text().trim());
    var massa = parseFloat($("#massa").text().trim());
    var fr = aceleracao * massa;

    console.log(fr);
    if(!isNaN(fr)){
        $('#forca_resultante').html(fr + "N");
    }else{
        $('#forca_resultante').html("Dados Inválidos");
    }
}

function calcularAceleracao() {
    var fr = parseFloat($("#forca_resultante").text().trim());
    var massa = parseFloat($("#massa").text().trim());
    var aceleracao = fr / massa;

    console.log(aceleracao);
    if(!isNaN(aceleracao)){
        $('#aceleracao').html(aceleracao);
    }else{
        $('#aceleracao').html("Dados Inválidos");
    }
}

function calcularMassa() {
    var aceleracao = parseFloat($("#aceleracao").text().trim());
    var fr = parseFloat($("#forca_resultante").text().trim());
    var massa = fr / aceleracao;

    console.log(massa);
    if(!isNaN(massa)){
        $('#massa').html(massa);
    }else{
        $('#massa').html("Dados Inválidos");
    }
}