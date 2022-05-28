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
						<h2>Manage <b>Product</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
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
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Image</th>
						<th>Information</th>
						<th>Weight</th>
						<th>Type</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="tbody_user">
				
				<c:forEach var="i" begin="0" end="${size_products}" >
					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
						<td >${products[i].idProduct}</td>
						<td >${products[i].name}</td>
						<td>${products[i].price}</td>
						<td>${products[i].images}</td>
						<td>${products[i].information}</td>
						<td>${products[i].weight}</td>
						<td>${products[i].idType}</td>
						<td>
							<a href="#editEmployeeModal" class="edit" data-toggle="modal" onclick="getUser(${i})" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="#deleteEmployeeModal" class="delete" data-toggle="modal" onclick="removeUser(${i})"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing  <b>${size}</b> entries</div>
				
			</div>
		</div>
	</div>        
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Products" method="post" enctype="multipart/form-data">
				<div class="modal-header">						
					<h4 class="modal-title">Add Product</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<div class="form-group">
						<label>Product ID</label>
						<input  type="text" class="form-control" name="idProduct"	id="idProduct" required value="${managera.userName}">
					</div>				
					<div class="form-group">
						<label>Product name</label>
						<input id="name" type="text" class="form-control" 	name="name" required>
					</div>
					<div class="form-group">
						<label>Price</label>
						<input id="price" type="number" class="form-control " name="price" required>
					</div>
					<div class="form-group">
						<label>Image</label>
						<input id="images" type="file" class="form-control" name="images_flie" required>
					</div>
					<div class="form-group">
						<label>Information</label>
						<input id="information" type="text" class="form-control" name="information" required>
					</div>
					<div class="form-group">
						<label>Weight</label>
						<input id="weight" type="text" class="form-control" name="weight" required>
					</div>	
					<div class="form-group">
						<label>Type ID</label>
						<select name="idType" id="">
							<option value="FL">FI</option>
							<option value="MT">MT</option>
						</select>
					</div>	
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-success" value="Add" formaction="/ASM_JAVA_4/Products/create">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Products" method="post" enctype="multipart/form-data">
				<div class="modal-header">						
					<h4 class="modal-title">Edit Product</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">	
					<div class="form-group">
						<label>Product ID</label>
						<input  type="text" class="form-control" name="idProduct"	id="idProduct" required value="${managera.userName}">
					</div>				
					<div class="form-group">
						<label>Product name</label>
						<input id="name" type="text" class="form-control" 	name="name" required>
					</div>
					<div class="form-group">
						<label>Price</label>
						<input id="price" type="number" class="form-control " name="price" required>
					</div>
					<div class="form-group">
						<label>Image</label>
						<input id="images" type="file" class="form-control" name="images_flie" required>
					</div>
					<div class="form-group">
						<label>Information</label>
						<input id="information" type="text" class="form-control" name="information" required>
					</div>
					<div class="form-group">
						<label>Weight</label>
						<input id="weight" type="text" class="form-control" name="weight" required>
					</div>	
					<div class="form-group">
						<label>Type ID</label>
						<select name="idType" id="">
							<option value="FL">FI</option>
							<option value="MT">MT</option>
						</select>
					</div>	
								
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-info" value="Save" formaction="/ASM_JAVA_4/Products/update">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/ASM_JAVA_4/Products" method="post">
				<div class="modal-header">						
					<h4 class="modal-title">Delete Product</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<p>Are you sure you want to delete Product :</p>
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
		document.getElementById("idProduct").setAttribute("value",user)
		
		var pass=document.getElementById("tbody_user").children[x].children[2].innerHTML;
		document.getElementById("name").setAttribute("value",pass); 

		var fullname=document.getElementById("tbody_user").children[x].children[3].innerHTML;
		document.getElementById("price").setAttribute("value",fullname);
		
		var email=document.getElementById("tbody_user").children[x].children[4].innerHTML;
		document.getElementById("images").setAttribute("value",email);
		
		var phone=document.getElementById("tbody_user").children[x].children[5].innerHTML;
		document.getElementById("information").setAttribute("value",phone);
		
		var phone=document.getElementById("tbody_user").children[x].children[5].innerHTML;
		document.getElementById("weight").setAttribute("value",phone);
		
		
	}
	
	function removeUser(x){
		var user=document.getElementById("tbody_user").children[x].children[1].innerHTML;
		document.getElementById("user_delete").innerHTML=	user
		document.getElementById("delete_user_button").setAttribute("formaction","/ASM_JAVA_4/Products/delete?username="+user)
	}

	
	
	
	
</script>
</body>

</html>