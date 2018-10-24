<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:if test="${fn:length(post.comments) > 0}">
	<div class="comments v-margin-20">
		<div class="clearfix">
			<div class="font-large bold subtle float-left">Comments</div>
			<a href="#postcomment" class="font-small subtle float-right">Post a Comment</a>
		</div>
		<c:forEach var="comment" items="${post.comments}">
			<div class="comment">
				<span class="bold subtle">${comment.author}</span> commented on
				<span class="bold subtle"><fmt:formatDate value="${comment.postedDt}" pattern="dd MMMM yyyy H:mm aa"/></span><br />
				<span>${comment.body}</span>
			
				<sec:authorize access="hasRole('ROLE_ADMIN')">			
						<a href="<c:url value="/secure/comment/${comment.commentId}/delete"/>" class="small-delete-btn h-margin-3"></a>
				</sec:authorize>
				<br />
				<c:if test="${! empty comment.email}">
					<a class="font-small" href="mailto:${comment.email}">Email</a>
				</c:if>
				<c:if test="${! empty comment.site}">
					<c:set var="site" value="${comment.site}"></c:set>	
					<c:if test="${!fn:startsWith(comment.site, 'http://') && !fn:startsWith(comment.site, 'https://')}">
						<c:set var="site" value="http://${comment.site}"></c:set>	
					</c:if>
					<a class="font-small" href="<c:url value="${site}" />" target="_blank">Site</a>
				</c:if>
			</div>
		</c:forEach>
	</div>
</c:if>