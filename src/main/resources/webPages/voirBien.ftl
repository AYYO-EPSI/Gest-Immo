<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Voir un bien">

Surface :               ${bien.getSurface()}       <br />
Energie :               ${bien.getEnergie()}       <br />
Adresse :               ${bien.getAdresse()}       <br />
CP :                    ${bien.getCodePostal()}    <br />
Ville :                 ${bien.getVille()}         <br />
Taille du garage :      ${bien.getTailleGarage()}  <br />
Nombre de pi&egrave;ces :      ${bien.getNbPieces()}      <br />
Taille de la v&eacute;randa :  ${bien.getTailleVeranda()} <br />


<#if (bien.getLocations()?has_content)>
    Réservation: <br />
    <#list bien.getLocations() as x>
        ${x_index + 1}. ${x.getPeriode().getStart().toString()} - ${x.getPeriode().getEnd().toString()}<br />
    </#list>
</#if>


<a href="/bien/${bien.getIdBien()}/location">Ajouter une location pour ce bien</a>

</@htmlTemplate.page>