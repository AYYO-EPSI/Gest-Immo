<#macro page title>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<title>${title?html}</title>

	<link rel="stylesheet" href="/styles/master.css">

	<!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
	<![endif]-->

	<script src="/js/jquery-1.8.3.min.js"></script>
	<script src="/js/plugins.js"></script>
	<script src="/js/main.js"></script>
</head>

<body>
    <header>
        <nav>
	        <a href="/biens">Tous vos biens</a>
        </nav>
    </header>

    <section>
        <#nested/>
    </section>
</body>
</html>
</#macro>