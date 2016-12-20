 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<%@include file="Header.jsp" %>



		<form:form class="form-horizontal" method="post" action="register"	commandName="UserDetails" >
			<fieldset>

			<!-- Form Name -->
				<legend>Registration </legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">UserId
					</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" path="userId" ></form:input>

					</div>
					<form:errors path="userId" style="color:red;"></form:errors>
				</div>

				<!-- Text input-->
				

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">UserName
						</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="userName" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Password
						</label>
					<div class="col-md-4">
						<form:password class="form-control" path="password" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Name
				</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="true" path="name" ></form:input>
<form:errors path="name" style="color:red;"></form:errors>
					</div>
				</div>

  <div class="form-group">
					<label class="col-md-4 control-label" for="comments">Mobile
						</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="mobile" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Email
						</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="email" />
					</div>
				</div>
				
				
			
					<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>
	
	
	<%@include file="Footer.jsp" %>


	