   
<!--    <body style="background-color:pink;"> -->
<jsp:include page="/WEB-INF/views/AdminHeader.jsp"/>


	<core:choose>
		<core:when test="${LoggedIn}">

			<core:choose>
				<core:when test="${Administrator}">
     Welcome <core:out value="{UserName}" />
				</core:when>
				<core:otherwise>
					<core:import url="Login.jsp" />
				</core:otherwise>
			</core:choose>
		</core:when>
		<core:otherwise>
			<core:import url="Login.jsp" />
		</core:otherwise>

	</core:choose>

	<div class="container"  >

  <div id="myCarousel" class="carousel slide" data-ride="carousel" >
  <br>
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    


<br/><br/>
 <%@include file="Footer.jsp"%>


