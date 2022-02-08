$("#previous").on('click', function() {
    var start = parseInt(getUrlParameter('start'));
    var count = parseInt(getUrlParameter('fetchCount'));

    if(isNaN(start) || isNaN(count)) {
        start = 0;
        count = 15;
    }
    if(start == 0) {
        return;
    } else if(start > 0) {
        window.location.href = './product?start='+(start-1) + '&fetchCount=' + count;
    }
});

$("#next").on('click', function() {
    var start = parseInt(getUrlParameter('start'));
    var count = parseInt(getUrlParameter('count'));

    if(isNaN(start) || isNaN(count)) {
        count = 15;
    }

    window.location.href = './product?start='+(start+1) + '&fetchCount=' + count;
});

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};