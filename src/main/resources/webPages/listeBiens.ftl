<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Vos biens">


<#if (listeBiens?has_content)>
    Liste de vos biens: <br/>
    <#list listeBiens as unBien>
        <article>
            Type: ${unBien.getType()} <br/>
            <a href="/bien/${unBien.getIdBien()}">Acc&eacute;der &agrave; votre bien</a>
        </article>
    </#list>
<#else>
    Vous n'avez enregistr&eacute; aucun biens.
</#if>

<hr />
<a href="/bien">Ajouter un bien</a>


</@htmlTemplate.page>