<%--
  Created by IntelliJ IDEA.
  User: ristes
  Date: 11/18/16
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WP Starting JSP page</title>
</head>
<body>
<h1>Print parameters from: ${servlet} </h1>
<div>
    Param name = <%=request.getParameter("name")  %> [${p_name}]

</div>
<div>
    redirected at: ${redirect}
</div>

<div>
    dispatching at: ${dispatching}
</div>
</body>
</html>
