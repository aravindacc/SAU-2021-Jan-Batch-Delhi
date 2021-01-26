<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalculatorProxyid" scope="session" class="com.jatin.assignment.CalculatorProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalculatorProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCalculatorProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCalculatorProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.jatin.assignment.Calculator getCalculator10mtemp = sampleCalculatorProxyid.getCalculator();
if(getCalculator10mtemp == null){
%>
<%=getCalculator10mtemp %>
<%
}else{
        if(getCalculator10mtemp!= null){
        String tempreturnp11 = getCalculator10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String value_1id=  request.getParameter("value16");
        double value_1idTemp  = Double.parseDouble(value_1id);
        double sinOf13mtemp = sampleCalculatorProxyid.sinOf(value_1idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sinOf13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 18:
        gotMethod = true;
        String value_2id=  request.getParameter("value21");
        double value_2idTemp  = Double.parseDouble(value_2id);
        double cosOf18mtemp = sampleCalculatorProxyid.cosOf(value_2idTemp);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(cosOf18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 23:
        gotMethod = true;
        String number_3id=  request.getParameter("number26");
        double number_3idTemp  = Double.parseDouble(number_3id);
        int factorial23mtemp = sampleCalculatorProxyid.factorial(number_3idTemp);
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(factorial23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
break;
case 28:
        gotMethod = true;
        String value_4id=  request.getParameter("value31");
        double value_4idTemp  = Double.parseDouble(value_4id);
        double tanOf28mtemp = sampleCalculatorProxyid.tanOf(value_4idTemp);
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(tanOf28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
break;
case 33:
        gotMethod = true;
        String value_5id=  request.getParameter("value36");
        double value_5idTemp  = Double.parseDouble(value_5id);
        String base_6id=  request.getParameter("base38");
        int base_6idTemp  = Integer.parseInt(base_6id);
        double logBase33mtemp = sampleCalculatorProxyid.logBase(value_5idTemp,base_6idTemp);
        String tempResultreturnp34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(logBase33mtemp));
        %>
        <%= tempResultreturnp34 %>
        <%
break;
case 40:
        gotMethod = true;
        String value_7id=  request.getParameter("value43");
        double value_7idTemp  = Double.parseDouble(value_7id);
        double log240mtemp = sampleCalculatorProxyid.log2(value_7idTemp);
        String tempResultreturnp41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(log240mtemp));
        %>
        <%= tempResultreturnp41 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>