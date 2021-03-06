<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sbTags" uri="/WEB-INF/sbBlog-tags.tld"%>
<sbTags:template cssFiles="post.css,post_tags.css,resume.css" title="About">
	<div class="page-title">About inkDrop</div>
	<p class="v-margin-text-block">inkDrop is a blog application
		I created to share my Java coding adventures. The site functions as
		an outlet to share my programming experiences with others, as well as
		documentation of my work. This site also grants me the oppurtunity to
		reflect upon different programming concepts and practices.</p>

	<p class="v-margin-text-block">
		inkDrop also serves as a test bed for new ideas and the exploration
		of new technologies. <!-- The code behind toThought is available for review
		via GitHub in this  <a
			href="https://github.com/kmb385/toThought" target="_blank"> repository</a>.
		I invite you to fork this repository for review or development. Any feedback
		provided is greatly appreciated.-->
	</p>

	<!-- <p class="v-margin-text-block">I also enjoy solving
		coding issues on StackOverflow. Checkout my profile.</p> -->
	<!-- <a href="http://stackoverflow.com/users/714969/kevin-bowersox"> <img
		src="http://stackoverflow.com/users/flair/714969.png" width="208"
		height="58"
		alt="profile for Kevin Bowersox at Stack Overflow, Q&amp;A for professional and enthusiast programmers"
		title="profile for Kevin Bowersox at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
	</a> -->
	<jsp:include page="../partials/profile.jsp"/> 
</sbTags:template>