<%-- 
    Document   : ispisPodataka
    Created on : 01.07.2011., 23:05:03
    Author     : Martina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%

java.util.ArrayList ispis = null;
java.lang.String poruka = "";
if (request.getMethod().equals("POST")) {
	if(request.getParameter("zip") != null){
		if((request.getParameter("datumOd") != "") && (request.getParameter("datumDo") != "")){

			ispis = org.foi.nwtis.msimicic.aplikacija.Podaci.getDataInterval(request.getParameter("zipcode"), 
                                org.foi.nwtis.msimicic.aplikacija.Podaci.formatDate(request.getParameter("datumOd")), 
                                org.foi.nwtis.msimicic.aplikacija.Podaci.formatDate(request.getParameter("datumDo")));
		}
		else {
			ispis = org.foi.nwtis.msimicic.aplikacija.Podaci.getDataByZip(request.getParameter("zip"));
		}
	} else ispis = org.foi.nwtis.msimicic.aplikacija.Podaci.getAllData();
}
else ispis = org.foi.nwtis.msimicic.aplikacija.Podaci.getAllData();
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ispis prikupljenih podataka</title>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/default.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/displaytag.css" type="text/css" />

	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery-ui.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.ui.datepicker-hr.js"></script>

        <script type="text/javascript">
        $(function() {
                $("#datumOd").datepicker();
                $("#datumDo").datepicker();
                $("#datumOd").datepicker('option', {dateFormat: "dd.mm.yy"});
                $("#datumOd").datepicker('option', $.datepicker.regional['hr']);
                $("#datumDo").datepicker('option', {dateFormat: "dd.mm.yy"});
                $("#datumDo").datepicker('option', $.datepicker.regional['hr']);
        });
        </script>
</head>
<body>
    <form id="dataForm" action="ispisPodataka.jsp" method="POST">
        <table>
            <tr>
                <td>
                    <select size="6" name="zip">
                        <c:forEach items="<%= org.foi.nwtis.msimicic.aplikacija.Podaci.getZipCodes() %>" var="zip">
                            <option value="${zip}" id="${zip}" >${zip}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <label for="datumOd" >Datum od:</label><br>
                    <input type="text" name="datumOd" id="datumOd"/><br>
                    <label for="datumDo" >Datum do:</label><br>
                    <input type="text" name="datumDo" id="datumDo" />
                </td>
                <td>
                    <input type="submit" value="Pretraži" />
                </td>
            </tr>
	</table>
	
        </form>  
            <p><%= poruka %></p>
            <display:table name="<%= ispis %>" pagesize="20" export="true" sort="list">
                <display:column property="currDesc" title="Opis" sortable="true" headerClass="sortable"></display:column> 
                <display:column property="gustWindSpeed" title="Brzina vjetra" sortable="true" headerClass="sortable"></display:column>
                <display:column property="gustWindSpeedUnit" title="Mj. jed" sortable="true" headerClass="sortable"></display:column>
                <display:column property="gustWindDirectionString" title="Smjer" sortable="true" headerClass="sortable"></display:column>
                <display:column property="obDate" title="Datum" sortable="true" headerClass="sortable"></display:column>
                <display:column property="city" title="Grad" sortable="true" headerClass="sortable"></display:column>
                <display:column property="zip" title="Zip kod" sortable="true" headerClass="sortable"></display:column>
                <display:column property="state" title="Država" sortable="true" headerClass="sortable"></display:column>
                <display:column property="rainToday" title="Kiša" sortable="true" headerClass="sortable"></display:column>
                <display:column property="rainUnit" title="Opis" sortable="true" headerClass="sortable"></display:column>
                <display:column property="stationName" title="Met. Stanica" sortable="true" headerClass="sortable"></display:column>
                <display:column property="temperature" title="Temperatura" sortable="true" headerClass="sortable"></display:column>
                <display:column property="temperatureUnit" title="Mj. jed" sortable="true" headerClass="sortable"></display:column>
            </display:table>
	</body>
</html>