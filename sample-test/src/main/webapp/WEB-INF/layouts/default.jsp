<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh"
           uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <link type="image/x-icon" href="${ctx}/static/images/favicon.ico"
          rel="shortcut icon">
    <script src="${ctx}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/jquery/jquery.cookie.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/auth.js" type="text/javascript"></script>
    <sitemesh:head/>
    <script type="text/javascript">
        $(document).ready(doCheck());
    </script>
</head>
<body>

<sitemesh:body/>
<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>
