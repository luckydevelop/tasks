<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.springautowire.AutowireTest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>@Autowire demonstration</title>
    </head>
    <body>
        <%
            ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
            AutowireTest autowireTest = new AutowireTest( appContext );
            autowireTest.testAutowire( out );
        %>
    </body>
</html>
