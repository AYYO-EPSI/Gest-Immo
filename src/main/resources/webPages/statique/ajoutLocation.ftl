<#include "/include/header.ftl">

<form action="/location" id="createLoc">
    <input type="hidden" name="idBien" value="1" />

    <label>Date début: </label><input type="text" name="dateDebut" value="jj/mm/aaaa" /><br />
    <label>Date fin: </label><input type="text" name="dateFin" value="jj/mm/aaaa" /><br />

    <input type="submit" value="Creer" />
</form>

<#include "/include/footer.ftl">