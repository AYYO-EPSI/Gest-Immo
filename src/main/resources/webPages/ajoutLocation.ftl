<#include "/include/header.ftl">
<script>
    $(document).ready(function(){
       $("#b1").submit(function() {

           $.ajax({
               type: 'PUT',
               data: $(this).serialize() ,
               success: function( response ) {
                       alert("retour : " + response);
               },
               url: "/location"
           });

            return false;
       });
    });
</script>

<form action="/location" id="b1" >

    <input type="text" name="dateDebut" value="jj/mm/aaaa" />
    <input type="text" name="dateFin" value="jj/mm/aaaa" />

    <input type="hidden" name="idBien" value="1" />


    <input type="submit" value="Creer" />

</form>
<#include "/include/footer.ftl">