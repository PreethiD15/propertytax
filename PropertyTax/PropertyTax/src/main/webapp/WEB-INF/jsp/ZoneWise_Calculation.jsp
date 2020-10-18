<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zone Wise Calculation </title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script>
function createTable() {
    $("#dynamicTable").append("<table>");
    $("#dynamicTable").append("<caption>My table</caption>");
    $("#dynamicTable").append("<thead>");
    $("#dynamicTable").append("<tr>");
    $("#dynamicTable").append("<th>Zone Name</th>");
    $("#dynamicTable").append("<th> Status Name</th>");
    $("#dynamicTable").append("<th>Total Amount</th>");
    $("#dynamicTable").append("</tr>");
    $("#dynamicTable").append("</thead>");
   
    $("#dynamicTable").append("<tbody>");

    $("#dynamicTable").append("<tr>");
    <c:forEach items="${allZoneReport}" var="tb">
    $("#dynamicTable").append("<td>${tb.getZone_name()}</td>");
    $("#dynamicTable").append("<td>${tb.getStatus_name()}</td>");
    $("#dynamicTable").append("<td>${tb.getTotal_amount()}</td>");
    </c:forEach>
    $("#dynamicTable").append("</tr>");


    $("#dynamicTable").append("</tbody>");
    $("#dynamicTable").append("</table>");
    $('#dynamicTable').show();

    $('#dynamicTable table').addClass("dynamicTable");
    $('#dynamicTable table thead').addClass("dynamicTableTh");
    $('#dynamicTable table tbody td').addClass("dynamicTableTd");
}
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

button
{
 background-color: blue;
 color: white;
}
#dynamicTable{
    position:fixed;
    top: 50%;
    left: 50%;
    width:30em;
    height:18em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
    border: 1px solid #ccc;
    background-color: #f3f3f3;
}
.dynamicTable { font:.7em Arial; border:1px solid gray; }
.dynamicTableTh { background-color:#584df0; color:White;}
.dynamicTableTd { padding:3px; width:90px; color:red }
</style>
<body>
<h1>Zone Wise Report Generation</h1>

		<form action="taxReport" name="form" id="form">
		<label for="year_assessment">Enter the Year   </label>
		<input type="number" name="yearreport" onblur="yearValidation(this.value,event)" 
        onkeypress="yearValidation(this.value,event)"></input>
    <div id="dynamicTable">
  <center>  <h3>Zone wise Collection of Property Tax for the year </h3></center>
  <table align="center">
   
    <thead>
    <tr>
  <th>Zone Name</th>
  <th> property Type</th>
   <th>Amount collected</th>
   </tr>
    </thead>
   
    <tbody>

    
    <c:forEach items="${allZoneReport}" var="tb">
    <tr>
   <td>${tb.getZone_name()}</td>
  <td>${tb.getStatus_name()}</td>
  <td>${tb.getTotal_amount()}</td>
     </tr>
    </c:forEach>


</tbody>
   </table>
    </div>
    
			 <button type="submit" value="submit" onclick="createTable()">Generate Report</button>
					</form>
</body>
</html>