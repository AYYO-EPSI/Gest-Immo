<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Ajouter une location">

<form action="/bien/${bienId}/location" method="post" accept-charset="UTF-8">
	<label>Date d&eacute;but: </label><input type="text" name="dateDebut" value="jj/mm/aaaa"/><br/>
	<label>Date fin: </label><input type="text" name="dateFin" value="jj/mm/aaaa"/><br/>

	<input type="submit" value="Creer"/>
</form>

</@htmlTemplate.page>