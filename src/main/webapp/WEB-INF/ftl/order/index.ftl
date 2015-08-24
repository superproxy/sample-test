<#if Session["order"]?exists>
<p><h1>订单</h1>  </p>
    <#list  Session["order"].items as item>
    ${item} <br/>
    </#list>
</#if>
