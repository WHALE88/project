/* add to cart */
function getProductJson(element) {

    var product = new Object();
    product.id = $(element).find('.prodId').text();
    product.brand = $(element).find('.prodBrand').text();
	product.model = $(element).find('.prodModel').text();
	product.size = $(element).find('.prodSize').text();
    product.price = $(element).find('.prodPrice').text();
    console.log(JSON.stringify(product));
    return JSON.stringify(product);
}


function sendProductToCart(url, productJson) {
    $.ajax({
        type: "post",
        url: url,
        data: {product: productJson},
        dataType: "json",
        success: function (data) {
            alert("Product added to cart");
            $(".totalAmountCart").text(data.totalAmount);
            $(".totalItemsCart").text(data.totalItems);
        },
        error: function (jqxhr, status, errorMsg) {
            alert("Error: " + errorMsg);
        },
        complete: function () {
        }
    });
}

$(function () {

    $(".add-to-cart").each(function () {
        $(this).click(
            function (e) {
                e.preventDefault();
                sendProductToCart("addTocart", getProductJson($(this)));
            });
    });

});