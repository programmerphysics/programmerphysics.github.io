function linha() {
    // F = K * (|Q1| * |Q2|) / Distancia^2
    var d;

    var d1 = parseFloat($("#posicao01").text().trim());
    var d2 = parseFloat($("#posicao02").text().trim());
    var d3 = parseFloat($("#posicao03").text().trim());

    var q1 = parseFloat($("#carga01").text().trim());
    var q2 = parseFloat($("#carga02").text().trim());
    var q3 = parseFloat($("#carga03").text().trim());


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



}

function rad_to_degrees(graus) {
    return (graus * (Math.PI / 180));

}

function triangulo() {

    'var q1 = parseFloat($("#carga01").text().trim());'
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
