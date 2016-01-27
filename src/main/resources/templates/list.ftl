<table>
    <tr>
        <th>날짜</th>
        <th>수입</th>
        <th>지출</th>
        <th>잔액</th>
        <th>적요</th>
        <th>범주</th>
    </tr>
    <#list list as record>
    <tr>
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
    </tr>
    </#list>
</table>