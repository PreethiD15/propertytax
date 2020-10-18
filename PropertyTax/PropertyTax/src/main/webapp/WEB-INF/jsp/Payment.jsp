<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tax Calculation</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script>
function yearValidation(year,ev) {

	  var text = /^[0-9]+$/;
	  if(ev.type=="blur" || year.length==4 && ev.keyCode!=8 && ev.keyCode!=46) {
	    if (year != 0) {
	        if ((year != "") && (!text.test(year))) {

	            alert("Please Enter Numeric Values Only");
	            return false;
	        }

	        if (year.length != 4) {
	            alert("Year is not proper. Please check");
	            return false;
	        }
	        var current_year=new Date().getFullYear();
	        if((year < 1920) || (year > current_year))
	            {
	            alert("Year should be in range 1920 to current year");
	            return false;
	            }
	        return true;
	    } }
	}
$(function() { 
    $(':submit').click(function(e) {
            $(':text, textarea,number,email').each(function() {
                    if ($(this).val().length == 0) {
                    	 alert('Please enter the fields.');
                            $(this).css('border', '2px solid red');
                            e.preventDefault();
                    }
            });
          
    });
});
$(function() { 
	$("#total_amount").focus(function(){
		var data=$("#form").serialize();
		$.post('totaltax',data,function(data){
			$("#total_amount").val(data);
		});
	});
$("form").submit(function(){
	alert("Tax details are saved successfully");
});
});
</script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
form {
	display: table;
}

p {
	display: table-row;
}

label {
	display: table-cell;
}

input {
	display: table-cell;
}
td
{
    padding:0 15px;
   
}
button
{
 background-color: blue;
 color: white;
}

</style>
<body>
	<h1>Self Assessment of Property Tax Form</h1>

	<div class="container">
		<form action="addUserTax" method="post" name="form" id="form">
			<p>
				<label for="year_assessment">Year of Assessment</label> <input
					type="text" id="year_assessment" name="year" onblur="yearValidation(this.value,event)" 
        onkeypress="yearValidation(this.value,event)"><br>
				<br>
			</p>
			<p>
				<label for="fname"> Name of the Owner</label> <input type="text"
					id="owner_name" name="owner_Name"><br> <br>
			</p>
			<p>
				<label for="email">Email</label> <input type="email" id="email"
					name="email"><br> <br>
			</p>
			<p>
				<label for="address">Address of property</label>
				<textarea id="address" name="address"></textarea>
				<br> <br>
			</p>
			<p>
				<label for="zoneclassification">Zone Classification</label> 
				 <select name="zone">
					<c:forEach items="${allZone}" var="tb">
						<option value="${tb.getZonenum_Id()}">${tb.getZone_Name()}</option>
					</c:forEach>
				</select>
			</p>
			<br>
			<p>
				<label for="desc_Building">Description of the Property</label>
				<select  name="property_Description">
					<c:forEach items="${allProperty}" var="tb">
						<option value="${tb.getBuilding_Id()}">${tb.getBuilding_Type()}</option>
					</c:forEach>
				</select>
			</p>
			<br>
			<p>
				<label for="Status">Status</label> <select name="Status">
					<c:forEach items="${allStatus}" var="tb" >
						<option value="${tb.getStatus_id()}">${tb.getStatus_name()}</option>
					</c:forEach>
				</select>

			</p>
           <br>
			<p>
				<label for="build_year">Building Constructed Year</label> <input
					type="text" id="constructed_year" name="constructed_year" onblur="yearValidation(this.value,event)" 
        onkeypress="yearValidation(this.value,event)"><br> <br>
			</p>
			<p>
				<label for="area">Build Up Area(square feet)</label> <input
					type=number id="square_feet" name="square_feet" ><br> <br>
			</p>
			<p>
				<label for="tax">Total Tax Payable</label> <input type="number "
					id="total_amount" name="total_amount">(computation for detail provide above)<br>
				<br>
			</p>
			<table cellspacing="10px">
			<tr >
			<td >
         <a href="home"><button type="button" >Cancel</button></a>
    </td>
    <td>
			 <button type="submit" value="Submit">Pay Tax</button>
			 </td>
  </tr>
</table>
		</form>
	</div>
</body>

</html>
