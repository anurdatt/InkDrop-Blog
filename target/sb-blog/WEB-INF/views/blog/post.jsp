<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/sbBlog-tags.tld" prefix="sbTags" %>

<sbTags:template cssFiles="post.css,post_tags.css,comments.css" sideBar="blogSideBar.jsp"
jsFiles="blog.js" title="${post.title}">

	<jsp:include page="../partials/post.jsp"></jsp:include>
	<jsp:include page="../partials/comments.jsp"></jsp:include>
	<jsp:include page="../partials/commentForm.jsp"></jsp:include>

</sbTags:template>
