<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Voir un bien">

Surface :               ${bien.getSurface()}       <br/>
Energie :               ${bien.getEnergie()}       <br/>
Adresse :               ${bien.getAdresse()}       <br/>
CP :                    ${bien.getCodePostal()}    <br/>
Ville :                 ${bien.getVille()}         <br/>
Taille du garage :      ${bien.getTailleGarage()}  <br/>
Nombre de pi&egrave;ces :      ${bien.getNbPieces()}      <br/>
Taille de la v&eacute;randa :  ${bien.getTailleVeranda()} <br/><br/>


    <#if (bien.getPeriodes()?has_content)>
	P&eacute;riodes de location : <br/>
        <#list bien.getPeriodes() as p>
        ${p_index + 1}. ${p.getLibelle()}<br/>
		Prix journalier : ${p.getMontant()} euros<br/>
        ${p.getPeriode().getStart().toString("dd/MM/YYYY")} - ${p.getPeriode().getEnd().toString("dd/MM/YYYY")}<br/>
		<br/>
        </#list>
    </#if>

<hr/>

    <#if (bien.getLocations()?has_content)>
	Réservation: <br/>
        <#list bien.getLocations() as x>
        ${x_index + 1}. ${x.getPeriode().getStart().toString("dd/MM/YYYY")} - ${x.getPeriode().getEnd().toString("dd/MM/YYYY")}
		<br/><br/>
		Montant de la location : ${bien.calculerMontantLocation(x.getId())} Euros
        </#list>
    </#if>
<hr/>

<a href="/bien/${bien.getIdBien()}/location">Ajouter une location pour ce bien</a>
<a href="/bien/${bien.getIdBien()}/periode">Ajouter une p&eacute;riode pour ce bien</a>

</@htmlTemplate.page>