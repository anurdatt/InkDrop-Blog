<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div id="header" class="bg3">
	<div id="top-banner">
		<div id="logo"></div>
		<div id="logout">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				Logged in user:
				<sec:authentication property="principal.username" />
				| Roles:
				<sec:authentication property="principal.authorities"/>
				<div>
					<c:url var="logoutUrl" value="/logout" />
					<form action="${logoutUrl}" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="submit" value="LogOut">
					</form>
				</div>
			</sec:authorize>
		</div>
		<div id="social-icons">
			<a target="_blank" href="https://twitter.com/anuran4u"><img src="/images/twitter-482.png" /></a>
			<a target="_blank" href="https://www.facebook.com/anuran.datta"><img src="/images/facebook-481.png" /></a>
		</div>
	</div>
	<div id="nav-menu" class="clearfix">
		<ul>
			<li class="font-large fg1"><a href="/blog/page/0">Blog</a></li><li class="font-large fg1"><a href="/about">About</a></li>
		</ul>
	</div>
</div>