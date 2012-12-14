$(document).ready(function () {
	switch (location.pathname) {
		case "/ajoutBien":
			$("#formBien").submit(function () {
				$(this).children("input[type='submit']").replaceWith('<img src="/images/ajax-loader.gif" alt="Chargement" />');
				$.ajax({
					url:'/bien',
					type:'PUT',
					data:$(this).serialize(),
					success:function (response) {
						if (response != "0") {
							window.location.href='/bien/'+response;
						} else {
							alert('Erreur critique');
						}
					}
				});
				return false;
			});
			break;

		case "/ajoutLocation":
			$("#createLoc").submit(function () {
				$(this).children("input[type='submit']").replaceWith('<img src="/images/ajax-loader.gif" alt="Chargement" />');
				$.ajax({
					url:"/location",
					type:'PUT',
					data:$(this).serialize(),
					success:function (response) {
						alert("retour : " + response);
					}
				});

				return false;
			});
			break;
	}
});