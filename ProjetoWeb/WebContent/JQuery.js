$(document).ready(function(){
$('#controllerbc').change(function(){
	$('#controllerbc').hide("slow");

	
	if (($(this).val() == "oprodutos")){
	$('#hcontrolleractualize').html("Cadastro de produtos.");
	$('#tformproduto').toggle("slow");
	$('#tformproduto2').toggle("slow");
	$('#btinserir').toggle("slow");	
	$('#btp1').toggle("slow");	
	$('#btp2').toggle("slow");	
	$('#btp3').toggle("slow");	
	$('#btvoltar').toggle("slow");}
	
	if (($(this).val() == "ovenda")){
		$('#hcontrolleractualize').html("Cadastro de venda.");
		$('#tformvenda').toggle("slow");
		$('#tformvenda2').toggle("slow");
		$('#btinserir').toggle("slow");
		$('#btvoltar').toggle("slow");
	}
	
});


});