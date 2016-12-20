<%@include file="AdminHeader.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
  var cat = ${data};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.categ=cat;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>

<c:choose>
<c:when test="${check}">

<div class="container">
    <h1 class="well">Add Category</h1>
	<div class="col-lg-12 well"> 
	<div class="row">
				<form:form method="post" action="category" commandName="category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input  path="id" placeholder="" class="form-control" ></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category  Name</label>
								<form:input type="text" path="name" placeholder="" class="form-control"></form:input>
							</div>
							
						</div>					
						<div class="form-group">
							<label>Category Descriptionn</label>
							<form:textarea path="description" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
			 	</form:form> 
				
				
 
				</div>
	</div> 
	</div>
		<div ng-app="repeatSample" ng-controller="repeatController">
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Category Id</th>
<th>Category name<t/th>
<th>Category Description</th>
<th>Edit</th>
<th>Delete</th>
</tr> 
<tr class="success" ng-repeat="c in categ|filter:searchprd">
                <td>{{c.id}}</a></td> 
                 <td>{{c.name}}</td>
                <td> {{c.description}}</td>
            <td><a href="UpdateCategory?id={{c.id}}">Edit</a></td>
                <td><a href="delcategory?id={{c.id}}">Delete</a></td>
               <!--   <td><img src="./Resources/img/{{product.img}}.jpg" height="50px" width="50px"/></td> -->  
</tr>
</table>
</div>  
</c:when>
<c:otherwise >
<div class="container">
    <h1 class="well">Update category</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="UpdateCategory" commandName="category">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Category Id</label>
								<form:input  path="id" placeholder="" class="form-control" readonly="true"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category Name</label>
								<form:input type="text" path="name" placeholder="" class="form-control"></form:input>
							</div>
							
											
						<div class="form-group">
							<label>Category Description</label>
							<form:textarea path="description" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
	</c:otherwise>

</c:choose>



<%@include file="Footer.jsp"%>
