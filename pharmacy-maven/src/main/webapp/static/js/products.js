$(document).ready(function() {
    $('#btn').on('click', function() {
        fetchProductsFromJSON($('#searchInput').val().trim())
    })
})

function fetchProductsFromJSON(name) {
    let xhr = new XMLHttpRequest()

    xhr.open('GET', `/pharmacy/products?name=${name}`, true)

    xhr.timeout = 5000
    xhr.ontimeout = (e) => onAPIError()

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) 
        {
            if (xhr.status === 200) {
                handleResults(JSON.parse(xhr.responseText))
            } else {
                onAPIError()
            }
        }
    }
    
    xhr.send()
}


function handleResults(response) {
    let productsList = response;
   
    if (jQuery.isEmptyObject(response)) {
    	$(".products-list").html("No product was found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let product of productsList) {
	        output += "<tr><td>"
	        + product.id
	        + "</td><td>"
	        + product.name
	        + "</td><td>"
	        + product.description
	        + "</td><td>"
	        + product.quantity
	        + "</td></tr>";
	    }
	
	    $(".products-list").html(output);
    }
}


function onAPIError() {
    alert('API Error')
}