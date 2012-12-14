<#include "/include/header.ftl">
<script type="text/Javascript">
$(document).ready(function() {
	$("#formBien").submit(function() {
			$.ajax({
				url: '/bien',
				type: 'PUT',
				data: $(this).serialize(),
				success: function( response )
				 {	
				 alert("retour : " + response);
				}
			});
		return false;
	});
});


</script>



<form id="formBien">

Surface : <input type="text" name="surface" /> <br />
Energie : <input type="text" name="energie" /> <br />
Adresse : <input type="text" name="adresse" /> <br />
CodePostal : <input type="text" name="codePostal" /> <br />
Ville : <input type="text" name="ville" /> <br />
Taille du garage : <input type="text" name="tailleGarage" /> <br />
Nombre de pieces : <input type="text" name="nbPieces" /> <br />
Taille Veranda : <input type="text" name="tailleVeranda" /> <br />

<input type="submit" value="OK" />

	
</form>
<#include "/include/footer.ftl">