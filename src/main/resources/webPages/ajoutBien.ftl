<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Ajouter un bien">

<form action="/bien" method="post" accept-charset="UTF-8">
    <label>Surface: </label><input type="text" name="surface" /> <br />
    <label>Energie: </label><input type="text" name="energie" /> <br />
    <label>Adresse: </label><input type="text" name="adresse" /> <br />
    <label>CodePostal: </label><input type="text" name="codePostal" /> <br />
    <label>Ville: </label><input type="text" name="ville" /> <br />
    <label>Taille du garage: </label><input type="text" name="tailleGarage" /> <br />
    <label>Nombre de pieces: </label><input type="text" name="nbPieces" /> <br />
    <label>Taille Veranda: </label><input type="text" name="tailleVeranda" /> <br />

    <input type="submit" value="Créer" />
</form>

</@htmlTemplate.page>