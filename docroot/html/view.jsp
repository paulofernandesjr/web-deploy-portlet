<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<% if( (Boolean) renderRequest.getAttribute("canDeploy")  ) { %>
<portlet:actionURL var="submitFileAction" name="submitFile"></portlet:actionURL>
<form action="<%= submitFileAction %>" method="post" enctype="multipart/form-data" >
	<h2><liferay-ui:message key="upload_file" /></h2>
	<input type="file" id="file" name='<portlet:namespace />file' size="50" />
	<input type="submit" value="Submit" />
</form>
<% } else { %>
<p><strong>auto.deploy.enabled</strong>: <liferay-ui:message key="message" />
<% } %>

 