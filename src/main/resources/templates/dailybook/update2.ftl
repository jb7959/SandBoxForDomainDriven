<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Update a Record</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Form</h1>
<!-- #12 -->
<form action="/dailybook/update" method="post">
    <p>Id: <input type="text" name="newRecord.id" id="newRecord.id" value="${oldRecord.id}" readonly/></p>
    <p>Date:<@spring.formInput newRecord.id/> , <!-- <input type="text" name="newRecord.date" id="newRecord.date" value="${oldRecord.date}"/>--></p>
    <p>RevenueOrExpense: <input type="newRecord.text" name="newRecord.revenueOrExpense" id="revenueOrExpense" value="${oldRecord.revenueOrExpense}" /></p>
    <p>amount:  <input type="text" name="newRecord.amount" id="newRecord.amount" value="${oldRecord.amount}" /></p>
    <p>balance:  <input type="text" name="newRecord.balance" id="newRecord.balance" value="${oldRecord.balance}"/></p>
    <p>summary: <input type="text" name="newRecord.summary" id="newRecord.summary" value="${oldRecord.summary}"/></p>
    <p>category: <input type="text" name="newRecord.category" id="newRecord.category" value="${oldRecord.category}"/></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>