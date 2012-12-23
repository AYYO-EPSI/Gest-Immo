<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Ajouter une location">


<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/ajoutLocation.js"></script>


<form action="/bien/${bienId}/location" method="post" accept-charset="UTF-8">
	<label>Date d&eacute;but: </label><input type="text" name="dateDebut" id="from" /><br/>
	<label>Date fin: </label><input type="text" name="dateFin" id="to" /><br/>

	<input type="submit" value="Creer"/>
</form>

</@htmlTemplate.page>