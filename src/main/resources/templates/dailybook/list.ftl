<table>
    <tr>
        <th>no</th>
        <th>날짜</th>
        <th>수입</th>
        <th>지출</th>
        <th>잔액</th>
        <th>적요</th>
        <th>범주</th>
        <th>명령</th>
    </tr>
<#list list as record>
    <tr>
        <td><a href=/list/${record.id}>${record.id}</a></td>
        <td>${record.date}</td>
        <#if record.revenueOrExpense == "수입">
            <td>${record.amount}</td>
            <td></td>
        <#else>
            <td></td>
            <td>${record.amount}</td>
        </#if>
        <td>${record.balance}</td>
        <td>${record.summary}</td>
        <td>${record.category}</td>
        <td><a href=/dailybook/update/${record.id}>수정</a></td>
    </tr>
</#list>
    <tr><td><a href="/dailybook/add">추가</a></td></tr>
</table>
