<html>
<head>
    <title>HTML Report</title>
</head>

<h1>HTML Report</h1>

<p>${catalog.name}</p>

<h2> Books </h2>
<#list books as book>
<h3>${book.id}, Title: ${book.title}, Path: ${book.location}</h3>
</#list>
<h2> Articles </h2>
<#list articles as article>
<h3>${article.id}, Title: ${article.title}, Path: ${article.location}</h3>
</#list>
<ul>
</ul>
</body>
</html>