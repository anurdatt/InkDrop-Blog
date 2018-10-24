<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div id="comment-form" class="bg4">
	<a id="postcomment" class="font-large bold subtle">Post a Comment</a>
	<form action="<c:url value="/comment/save" />" class="h-margin-20" method="POST">
	
		<div class="v-margin-5">
			<div class="bold subtle v-margin-4">
				<span class="required">*</span>Name
			</div>
			<input name=author class="input-medium" value="${comment.author}" />
		</div>
		<form:errors path="comment.author" cssClass="error field-error"></form:errors>
		<div class="v-margin-5">
			<div class="bold subtle v-margin-4">
				Email
			</div>
			<input name="email" class="input-medium" value="${comment.email}" />
		</div>
		<div class="v-margin-5">
			<div class="bold subtle v-margin-4">
				Site
			</div>
			<input name="site" class="input-medium" value="${comment.site}" />
		</div>
		<div class="v-margin-5 clearfix">
			<div class="bold subtle v-margin-4">
				<span class="required">*</span>Comment
			</div>
			<textarea name="body" class="input-large">${comment.body}</textarea>
		</div>
		<form:errors path="comment.body" cssClass="error field-error"></form:errors>
		<div>
			<input type="submit" class="control" value="Submit" />
		</div>
		<input type="hidden" name="post" value="${post.postId}" />
		<input type="hidden" name="mandatory"/>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>