<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
<head>	
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>CRUD</title>
<!-- <link rel = "icon" href = 
"https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200X200.png" type = "image/x-icon"> -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>

body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}
.header-list{
	margin-top: 10px;
	margin: 0 auto;
	width: 1110px;
	height: 40px;
	background-color: #435d7d;
	color:white;
	line-height: 40px;
}
.header-list a{
	color: white;
	margin-left: 10px;
}
.table-responsive {
    margin: 30px 0;
}
.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	min-width: 1000px;
	box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {        
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	min-width: 100%;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}
.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}
.table-title .btn-group {
	float: right;
}
.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}
.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}
.table-title .btn span {
	float: left;
	margin-top: 2px;
}
table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}
table.table tr th:first-child {
	width: 60px;
}
table.table tr th:last-child {
	width: 100px;
}
table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}
table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}	
table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}
table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}
table.table td a:hover {
	color: #2196F3;
}
table.table td a.edit {
	color: #FFC107;
}
table.table td a.delete {
	color: #F44336;
}
table.table td i {
	font-size: 19px;
}
table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}
.pagination {
	float: right;
	margin: 0 0 5px;
}
.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}
.pagination li a:hover {
	color: #666;
}	
.pagination li.active a, .pagination li.active a.page-link {
	background: #03A9F4;
}
.pagination li.active a:hover {        
	background: #0397d6;
}
.pagination li.disabled i {
	color: #ccc;
}
.pagination li i {
	font-size: 16px;
	padding-top: 6px
}
.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}    
/* Custom checkbox */
.custom-checkbox {
	position: relative;
}
.custom-checkbox input[type="checkbox"] {    
	opacity: 0;
	position: absolute;
	margin: 5px 0 0 3px;
	z-index: 9;
}
.custom-checkbox label:before{
	width: 18px;
	height: 18px;
}
.custom-checkbox label:before {
	content: '';
	margin-right: 10px;
	display: inline-block;
	vertical-align: text-top;
	background: white;
	border: 1px solid #bbb;
	border-radius: 2px;
	box-sizing: border-box;
	z-index: 2;
}
.custom-checkbox input[type="checkbox"]:checked + label:after {
	content: '';
	position: absolute;
	left: 6px;
	top: 3px;
	width: 6px;
	height: 11px;
	border: solid #000;
	border-width: 0 3px 3px 0;
	transform: inherit;
	z-index: 3;
	transform: rotateZ(45deg);
}
.custom-checkbox input[type="checkbox"]:checked + label:before {
	border-color: #03A9F4;
	background: #03A9F4;
}
.custom-checkbox input[type="checkbox"]:checked + label:after {
	border-color: #fff;
}
.custom-checkbox input[type="checkbox"]:disabled + label:before {
	color: #b8b8b8;
	cursor: auto;
	box-shadow: none;
	background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}
.modal .modal-header, .modal .modal-body, .modal .modal-footer {
	padding: 20px 30px;
}
.modal .modal-content {
	border-radius: 3px;
	font-size: 14px;
}
.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}
.modal .modal-title {
	display: inline-block;
}
.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}
.modal textarea.form-control {
	resize: vertical;
}
.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}	
.modal form label {
	font-weight: normal;
}	
</style>
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
</head>
<body >
	<!-- Header -->
<div  class="header-list">
	<a href="/ASM_JAVA_4/Products">Products</a>
	<a href="/ASM_JAVA_4/ProductType">Product Type</a>
	<a href="/ASM_JAVA_4/Manager">Manager</a>

</div>


<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Manage <b>Manager</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Manager</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>User Name</th>
						<th>Password</th>
						<th>Full name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Role</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="tbody_user">
				
				<c:forEach var="i" begin="${begin}" end="${end}" >
					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
						<td >${manager[i].userName}</td>
						<td >${manager[i].password}</td>
						<td>${manager[i].fullName}</td>
						<td>${manager[i].email}</td>
						<td>${manager[i].phoneNumber}</td>
						<td>${manager[i].role}</td>
						<td>
							<a href="#editEmployeeModal" class="edit" data-toggle="modal" onclick="getUser(${i})" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="#deleteEmployeeModal" class="delete" data-toggle="modal" onclick="removeUser(${i})"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing <b>5</b> out of <b>${size}</b> entries</div>
				<ul class="pagination">
					<li class="page-item disabled" ><a  href="/ASM_JAVA_4/Manager" onclick="previousPage()" id="previous_page" >Previous</a></li>
					<li class="page-item"><a href="/ASM_JAVA_4/Manager" class="page-link">1</a></li>
					<c:forEach var="i" begin="2" end ="${page_count}">
						<li class="page-item"><a href="/ASM_JAVA_4/Manager?page=${i}" class="page-link">${i}</a></li>
					</c:forEach>
					<li class="page-item " ><a href="/ASM_JAVA_4/Manager" id="next_page" onclick="nextPage()">Next</a></li>
					<!-- class="page-link" -->
					
					
					
				</ul>
			</div>
		</div>
	</div>        
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Manager" method="post">
				<div class="modal-header">						
					<h4 class="modal-title">Add Manager</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<div class="form-group">
						<label>User name</label>
						<input type="text" class="form-control" name="userName" required>
					</div>
					<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Comfirm password</label>
						<input type="password" class="form-control" name="password" required>
					</div>
					<div class="form-group">
						<label>Full name</label>
						<input type="text" class="form-control" name="fullName" required>
					</div>
					<div class="form-group">
						<label>Email</label>
						<input type="email" class="form-control" name="email" required>
					</div>
					<div class="form-group">
						<label>Phone</label>
						<input type="text" class="form-control" name="phoneNumber" required>
					</div>	
					<div class="form-group">
						<label>Role :</label>
						<input type="radio" name="role" style="margin: 0 10px ;" value="Admin" required>Admin
						<input type="radio" name="role" style="margin: 0 10px;" value="Staff" required>Staff
					</div>				
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-success" value="Add" formaction="/ASM_JAVA_4/Manager/create">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Manager" method="post">
				<div class="modal-header">						
					<h4 class="modal-title">Edit Manager</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">	
					<div class="form-group">
						<label>User name</label>
						<input  type="text" class="form-control" name="userName"	id="user_name" required value="${managera.userName}">
					</div>				
					<div class="form-group">
						<label>Password</label>
						<input id="pass_edit" type="password" class="form-control" 	 required>
					</div>
					<div class="form-group">
						<label>Confirm password</label>
						<input id="comfirmpass_edit" type="password" class="form-control " name="password" required>
					</div>
					<div class="form-group">
						<label>Full name</label>
						<input id="fullname_edit" type="text" class="form-control" name="fullName" required>
					</div>
					<div class="form-group">
						<label>Email</label>
						<input id="email_edit" type="text" class="form-control" name="email" required>
					</div>
					<div class="form-group">
						<label>Phone</label>
						<input id="phone_edit" type="text" class="form-control" name="phoneNumber" required>
					</div>	
					<div class="form-group">
						<label>Role :</label>
						<input id="admin_edit" type="radio" name="role" style="margin: 0 10px ;" value="Admin" required>Admin
						<input  id="staff_edit" type="radio" name="role" style="margin: 0 10px;"  value="Staff" required>Staff
					</div>				
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-info" value="Save" formaction="/ASM_JAVA_4/Manager/update">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Manager" method="post">
				<div class="modal-header">						
					<h4 class="modal-title">Delete Manager</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<p>Are you sure you want to delete User :</p>
					<p class="text-warning"><b style="color:red" id="user_delete"></b></p>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" id="delete_user_button" class="btn btn-danger" value="Delete" >
				</div>
			</form>
		</div>
	</div>
</div>
<script>
var count=1;
	function getUser(x){
		var user=document.getElementById("tbody_user").children[x].children[1].innerHTML;
		document.getElementById("user_name").setAttribute("value",user)
		
		var pass=document.getElementById("tbody_user").children[x].children[2].innerHTML;
		document.getElementById("pass_edit").setAttribute("value",pass); 
		document.getElementById("comfirmpass_edit").setAttribute("value",pass); 
		var fullname=document.getElementById("tbody_user").children[x].children[3].innerHTML;
		document.getElementById("fullname_edit").setAttribute("value",fullname);
		
		var email=document.getElementById("tbody_user").children[x].children[4].innerHTML;
		document.getElementById("email_edit").setAttribute("value",email);
		
		var phone=document.getElementById("tbody_user").children[x].children[5].innerHTML;
		document.getElementById("phone_edit").setAttribute("value",phone);
		
		var admin=document.getElementById("tbody_user").children[x].children[6].innerHTML;
		if(admin=="Admin"){
			document.getElementById("admin_edit").checked=true;
		}else{
			document.getElementById("staff_edit").checked=true;
		}
	}
	
	function removeUser(x){
		var user=document.getElementById("tbody_user").children[x].children[1].innerHTML;
		document.getElementById("user_delete").innerHTML=	user
		document.getElementById("delete_user_button").setAttribute("formaction","/ASM_JAVA_4/Manager/delete?username="+user)
	}
	var pageCurrent=1;
	function previousPage(){
		var x=window.location.href
		pageCurrent =x.substring(x.length-1,x.length);
		if(pageCurrent==2){
			document.getElementById("previous_page").href="/ASM_JAVA_4/Manager";
		}else{
			pageCurrent--;
			document.getElementById("previous_page").href="/ASM_JAVA_4/Manager?page="+pageCurrent;
		}
	}
	
	
	
	 function nextPage(){
		var x=window.location.href;
			pageCurrent =x.substring(x.length-1,x.length);
		var max_page=${size}/5;
		
		if(pageCurrent>=(max_page)){//Xu li khi đang ở page cuối
			document.getElementById("next_page").href="/ASM_JAVA_4/Manager?page="+pageCurrent;
		}else if(pageCurrent>0){//Xu li khi dang o page 
			pageCurrent++;
			document.getElementById("next_page").href="/ASM_JAVA_4/Manager?page="+pageCurrent;
		}else{
			pageCurrent=2;
			document.getElementById("next_page").href="/ASM_JAVA_4/Manager?page="+pageCurrent;
		}
	 
	} 
</script>
</body>

</html>