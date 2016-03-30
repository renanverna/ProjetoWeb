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
	
	
	
	$('#btinserir').click(function(){
		var dsc = $('#idescricao').val();
		var valorc = $('#ivalorcompra').val();
		var valorv = $('#ivalorvenda').val();
		var qtes = $('#iqntes').val();
		
		alert("Produto inserido com sucesso");
		$.post("ManterController.do",{
		 acao:"inserir",
		 idesc:dsc,
		 ivcompra:valorc,
		 ivvenda:valorv,
		 iqnt:qtes
		},function(){});
	});
	
	
	
	$('#btinserirv').click(function(){
		var codvenda = $('#icodvenda').val();
		var codprodv = $('#icodproduto').val();
		var vquantidade = $('#iquantidade').val();
		var valortotalv = $('#ivalortotal').val();
		
		alert("Produto inserido com sucesso");
		$.post("ManterController.do",{
		 acao:"inserir",
		 covendav:codvenda,
		 codprodv:codprodv,
		 qntv:vquantidade,
		 vtotalv:valortotalv
		},function(){});
	});
	
	
$('#btp1').click(function(){
var vid = $('#iidp').val();
var dsc = $('#idescricao').val();
var valorc = $('#ivalorcompra').val();
var valorv = $('#ivalorvenda').val();
var qtes = $('#iqntes').val();
alert("Produto alterado com sucesso");
$.post("ManterController.do",{
	
acao:"alterar",
iid:vid,
idesc:dsc,
ivcompra:valorc,
ivvenda:valorv,
iqnt:qtes
},function(){});
});


$('#btp2').click(function(){

		$('#myformcontroller').attr('action', 'Produto.jsp');
});

$('#btp2').click(function(){
	var vid = $('#iidp').val();
	$.post("ManterController.do",{
		acao:"consultar",
		iid:vid
	},function(){});
});
	
	
	$('#btp3').click(function(){
		var vid = $('#iidp').val();
		alert("Produto excluido com sucesso");
		$.post("ManterController.do",{
			acao:"excluir",
			iid:vid
		},function(){});
	});
	

	$('#btvoltar').click(function(){
		$('#hcontrolleractualize').html("");
		$('#tformproduto').hide();
		$('#tformproduto2').hide();
		$('#btinserir').hide();
		$('#btp1').hide();
		$('#btp2').hide();
		$('#btp3').hide();
		$('#btvoltar').hide();
		$('#tformvenda').hide();
		$('#tformvenda2').hide();
		$('#btinserir').hide();
		$('#btvoltar').hide();
		$('#controllerbc').show("Slow");
		
	});
		
		
});
});

