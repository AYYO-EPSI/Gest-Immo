<#import "include/template.ftl" as htmlTemplate/>
<@htmlTemplate.page title="Ajouter un bien">

<form action="/bien" method="post" accept-charset="UTF-8">
    <label for="surface">Surface: </label><input type="text" name="surface" id="surface" /> <br />
    <label for="energie">&Eacute;nergie: </label>
    <select name="energie" id="energie">
        <option value="0"></option>
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
        <option value="D">D</option>
        <option value="E">E</option>
        <option value="F">F</option>
        <option value="G">G</option>
    </select><br />
    <label for="adresse">Adresse: </label><input type="text" name="adresse" id="adresse" /> <br />
    <label for="codePostal">CodePostal: </label><input type="text" name="codePostal" id="codePostal" /> <br />
    <label for="ville">Ville: </label><input type="text" name="ville" id="ville" /> <br />
    <label for="tailleGarage">Taille du garage: </label><input type="text" name="tailleGarage" id="tailleGarage" /> <br />
    <label for="nbPieces">Nombre de pi&egrave;ces: </label><input type="text" name="nbPieces" id="nbPieces" /> <br />
    <label for="tailleVeranda">Taille Veranda: </label><input type="text" name="tailleVeranda" id="tailleVeranda" /> <br />

    <input type="submit" value="Créer" />
</form>

</@htmlTemplate.page>