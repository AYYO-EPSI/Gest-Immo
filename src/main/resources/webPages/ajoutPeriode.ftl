<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Ajouter une période">


<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/ajoutPeriode.js"></script>


<form action="/bien/${bienId}/periode" method="post" accept-charset="UTF-8">
	<label>Libell&eacute; de p&eacute;riode : </label><input type="text" name="libelle" value="" /><br/>
	<label>Date d&eacute;but : </label><input type="text" name="dateDebut" id="from" /><br/>
	<label>Date fin : </label><input type="text" name="dateFin" id="to" /><br/>
	<label>Prix journalier : </label><input type="text" name="prix" value="" /> euros<br/>

	<input type="submit" value="Creer"/>
</form>

</@htmlTemplate.page>