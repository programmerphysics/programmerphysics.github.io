function linha() {
    // F = K * (|Q1| * |Q2|) / Distancia^2
    var d;

    var d1 = parseFloat($("#posicao01").text().trim());
    var d2 = parseFloat($("#posicao02").text().trim());
    var d3 = parseFloat($("#posicao03").text().trim());

    var q1 = parseFloat($("#carga01").text().trim());
    var q2 = parseFloat($("#carga02").text().trim());
    var q3 = parseFloat($("#carga03").text().trim());

    if ((q1 > 0) && (q2 > 0) && (q3 > 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha5.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 < 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha4.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 < 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha3.png");
    } else if ((q1 > 0) && (q2 < 0) && (q3 > 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha3.5.png");
    } else if ((q1 > 0) && (q2 < 0) && (q3 < 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha2.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 > 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha2.5.png");
    } else if ((q1 > 0) && (q2 > 0) && (q3 < 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha1.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 > 0)) {
        $("#linhaimg").attr("src", "img/linha/Linha2.png");
    }


    if ((!isNaN(d1)) && (!isNaN(d2)) && (!isNaN(d3)) && (!isNaN(q1)) && (!isNaN(q2)) && (!isNaN(q3))) {

        var f1 = forcaResultante(d1, d2, q1, q2);
        var f2 = forcaResultante(d2, d3, q2, q3);

        var f = f1 + f2;
        console.log("f = " + f);



        if (f == Infinity) {
            $('#forca').html("F = <i class='fas fa-infinity'></i>");
        } else {
            $('#forca').html("F = " + f);
        }

    } else if ((!isNaN(d1)) && (!isNaN(d2)) && (!isNaN(q1)) && (!isNaN(q2))) {

        var f = forcaResultante(d1, d2, q1, q2);
        if (f == Infinity) {
            $('#forca').html("F = <i class='fas fa-infinity'></i>");
        } else {
            $('#forca').html("F = " + f);
        }
    }
}

function forcaResultante(d1, d2, q1, q2) {
    var µ = Math.pow(10, -6);
    var n = Math.pow(10, -9);
    var d = d1 - d2;
    if (d < 0) {
        d = d * (-1);
    }

    var f;
    var k;

    if ($('#micro1').is(':checked')) {
        q1 = q1 * µ;
    }
    if ($('#nano1').is(':checked')) {
        q1 = q1 * n;
    }

    if ($('#micro2').is(':checked')) {
        q2 = q2 * µ;
    }
    if ($('#nano2').is(':checked')) {
        q2 = q2 * n;
    }


    if (q1 < 0) {
        q1 = q1 * (-1);
    }

    if (q2 < 0) {
        q2 = q2 * (-1);
    }

    k = 9 * Math.pow(10, 9);
    var d;

    f = k * (q1 * q2) / Math.pow(d, 2);
    console.log("Força: " + f);
    console.log("carga1: " + q1);
    console.log("carga2: " + q2);
    console.log("distancia: " + d);
    console.log("Distancia01: " + d1);
    console.log("Distancia02: " + d2);
    console.log("Constante: " + k);


    return f;



    
function rad_to_degrees(graus) {
}
    return (graus * (Math.PI / 180));

}

function triangulo() {

    var q1 = parseFloat($("#carga01").text().trim());
    var q2 = parseFloat($("#carga02").text().trim());
    var q3 = parseFloat($("#carga03").text().trim());
    var d = parseFloat($("#distancia").text().trim());
    if (((q1) && (q2) > 0) && ((q3) < 0)) {} else
    if (((q1) && (q3) > 0) && ((q2) < 0)) {
        f13 = forcaResultante(0, d, q1, q3);


        f23 = forcaResultante(0, d, q2, q3);


        fr = Math.pow(f13, 2) + Math.pow(f23, 2) - (2 * f13 * f23 * Math.cos(rad_to_degrees(120)));

        fr = Math.sqrt(fr);

        f = fr;

        if (f == Infinity) {
            $('#forca').html("F = <i class='fas fa-infinity'></i>");
        } else {
            $('#forca').html("F = " + f);
        }


    } else
    if (((q2) && (q3) > 0) && ((q1) < 0)) {} else
    if (((q1) && (q2) < 0) && ((q3) > 0)) {} else
    if (((q1) && (q3) < 0) && ((q2) > 0)) {} else
    if (((q2) && (q3) < 0) && ((q1) > 0)) {}



}



function quadrado() {

    var q1 = parseFloat($("#carga01").text().trim());
    var q2 = parseFloat($("#carga02").text().trim());
    var q3 = parseFloat($("#carga03").text().trim());
    var q4 = parseFloat($("#carga04").text().trim());
    var d = parseFloat($("#distancia").text().trim());
    k = 9 * Math.pow(10, 9);


    if ((q1 > 0) && (q2 > 0) && (q3 > 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado1.5.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 < 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado1.png");
    } else if ((q1 > 0) && (q2 > 0) && (q3 > 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado2.5.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 < 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado2.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 > 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado3.5.png");
    } else if ((q1 > 0) && (q2 > 0) && (q3 < 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado3.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 < 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado4.5.png");
    } else if ((q1 > 0) && (q2 < 0) && (q3 > 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado4.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 > 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado5.5.png");
    } else if ((q1 > 0) && (q2 < 0) && (q3 < 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado5.png");
    } else if ((q1 > 0) && (q2 > 0) && (q3 < 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado6.5.png");
    } else if ((q1 < 0) && (q2 < 0) && (q3 > 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado6.png");
    } else if ((q1 > 0) && (q2 < 0) && (q3 > 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado7.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 < 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado7.5.png");
    } else if ((q1 < 0) && (q2 > 0) && (q3 > 0) & (q4 < 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado8.png");
    }else if ((q1 > 0) && (q2 < 0) && (q3 < 0) & (q4 > 0)) {
        $("#quadradoimg").attr("src", "img/quadrado/Quadrado8.5.png");
    }






    f14 = forcaResultante(0, d, q1, q4);
    f24 = forcaResultante(0, d, q2, q4);
    f34 = forcaResultante(0, d, q3, q4);


    fr = Math.pow(f14, 2) + Math.pow(f24, 2) + Math.pow(f34, 2);

    fr = Math.sqrt(fr);

    f = fr;


    console.log("Força: " + f14);
    console.log("Força: " + f24);
    console.log("Força: " + f34);
    console.log("carga1: " + q1);
    console.log("carga2: " + q2);
    console.log("carga3: " + q3);
    console.log("carga4: " + q4);
    console.log("distancia: " + d);
    console.log("Constante: " + k);

    if (f == Infinity) {
        $('#forca').html("F = <i class='fas fa-infinity'></i>");
    } else {
        $('#forca').html("F = " + f);
    }


}

function haste_fora_do_eixo() {


    var distancia_x = $("#distancia_x").val();
    var exp_dist_x = $("#exp_distancia_x").val();;
    var unidade_distancia_x = ($("#unidade_distancia_x option:selected").text().trim());
    var carga = $("#carga").val();
    var expCarga = $("#exp_carga").val();
    var unidade_carga = ($("#unidade_carga option:selected").text().trim());
    var comprimentoInicial = $("#comp_inicial").val();
    var expComprimentoInicial = $("#exp_comp_inicial").val();
    var unidade_comp_inicial = ($("#unidade_comp_inicial option:selected").text().trim());
    var distanciaX = $("#distancia_x").val();
    var unidade_distancia = ($("#unidade_distancia option:selected").text().trim());
    var expCarga = $("#exp_distancia").val();

    var epsilon = 8.85 * Math.pow(10, -12);
    var resultado = null;

    K = Math.pow(9, 10) ^ 9

    carga *= Math.pow(10, expCarga);
    comprimentoInicial *= Math.pow(10, expComprimentoInicial);
    distanciaX *= Math.pow(10, exp_dist_x);



    if (unidade_distancia_x == "cm") {
        distanciaX *= Math.pow(10, -2);
    } else if (unidade_distancia_x == "mm") {
        distanciaX *= Math.pow(10, -4);
    }

    if (unidade_comp_inicial == "cm") {
        comprimentoInicial *= Math.pow(10, -2);
    } else if (unidade_comp_inicial == "mm") {
        comprimentoInicial *= Math.pow(10, -4);
    }

    if (unidade_carga == "uc") {
        carga *= Math.pow(10, -6);
    } else if (unidade_carga == "nc") {
        carga *= Math.pow(10, -9);
    }

    if (unidade_distancia == "cm") {
        carga *= Math.pow(10, -2);
    } else if (unidade_carga == "mm") {
        carga *= Math.pow(10, -4);
    }

    resultado = carga / (4 * Math.PI * epsilon * distanciaX *
        (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5)));


    var resolucao = ("E = Q / 4 * π * Ԑ0 * x * (x² + a²)¹/²");

    resolucao += ("\n E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * (" + distanciaX +
        "² + " + comprimentoInicial + "²)¹/²");

    resolucao += ("\n E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * (" +
        Math.pow(distanciaX, 2) + " + " + Math.pow(comprimentoInicial, 2) + ")¹/²");

    resolucao += ("\n E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * " +
        (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5)));

    resolucao += ("\n E = " + carga + " / " + (4 * Math.PI * epsilon * distanciaX *
        (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5))));
    resolucao += ("\n " + resultado);

    $('#resolucao').html(resolucao);
    $('#resultado').html("Resultado : " + resultado);
}

function haste_no_eixo() {
    var comprimentoHaste = $("#comprimento_haste").val();;
    var expComprimentoHaste = $("#exp_haste").val();;
    var unidadeComp = ($("#unidade_comprimento option:selected").text().trim());
    var carga = $("#carga").val();
    var expCarga = $("#exp_carga").val();
    var unidade_carga = ($("#unidade_carga option:selected").text().trim());
    var comprimentoInicial = $("#comp_inicial").val();
    var expComprimentoInicial = $("#exp_comp_inicial").val();
    var unidade_comp_inicial = ($("#unidade_comp_inicial option:selected").text().trim());
    var epsilon = 8.85 * Math.pow(10, -12);
    var resultado = null;
    K = Math.pow(9, 10) ^ 9


    comprimentoHaste *= Math.pow(10, expComprimentoHaste);
    carga *= Math.pow(10, expCarga);
    comprimentoInicial *= Math.pow(10, expComprimentoInicial);




    if (unidadeComp == "cm") {
        comprimentoHaste *= Math.pow(10, -2);
    } else if (unidadeComp == "mm") {
        comprimentoHaste *= Math.pow(10, -4);
    }

    if (unidade_comp_inicial == "cm") {
        comprimentoInicial *= Math.pow(10, -2);
    } else if (unidade_comp_inicial == "mm") {
        comprimentoInicial *= Math.pow(10, -4);
    }

    if (unidade_carga == "uc") {
        carga *= Math.pow(10, -6);
    } else if (unidade_carga == "nc") {
        carga *= Math.pow(10, -9);
    }

    resultado = carga / (4 * Math.PI * epsilon * comprimentoInicial * (comprimentoHaste + comprimentoInicial));


    var resolucao = ("E = Q / 4 * π * Ԑ0 * a * (l + a)");

    resolucao += ("\n E = " + carga + " / 4 * π * " + epsilon + " * " + comprimentoInicial + " * (" +
        comprimentoHaste + " + " + comprimentoInicial + ")");
    resolucao += ("\n E = " + carga + " / 4 * π * " + epsilon + " * " + comprimentoInicial + " * " +
        (comprimentoHaste + comprimentoInicial));
    resolucao += ("\n E = " + carga + " / " +
        4 * Math.PI * epsilon * comprimentoInicial * (comprimentoHaste + comprimentoInicial));


    resolucao += ("\n E = " + resultado);




    $('#resolucao').html(resolucao);
    $('#resultado').html("Resultado : " + resultado);
}