/*add size*/
$(function() {
	$("#selectSize").each(function() {
		$(this).change(function() {
			if($("#selectSize").val()){
				$('.add-to-cart').attr('disabled', this.value!=='0'?false:true);
				$(".prodSize").text($("#selectSize option:selected").text());
			}
		});
	});
});