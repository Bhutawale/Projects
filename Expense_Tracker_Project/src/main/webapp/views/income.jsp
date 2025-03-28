<!doctype html>
<%@page import="com.expenseTracker.Entity.Income"%>
<%@page import="java.util.List"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Income</title>
  </head>
  <body>

    <% List<Income> incomeList=(List<Income>) request.getAttribute("incomeList");
    double totalIncome = 0;
    for (Income income : incomeList) {
        totalIncome += income.getAmount();
    }
    
    %>
	
	<div class="text-center">
		<h1>Income Details</h1>
	</div>
			<div class="d-flex justify-content-center">
			 <table border="1">
        <tr><th>Description</th><th>Date</th><th>Amount</th></tr>
        <% for (Income income : incomeList) { %>
            <tr>
               
                <td><%= income.getDescription() %></td>
               	 <td><%= income.getDate() %></td>
                 <td><%= income.getAmount() %></td>
            </tr>
        <% } %>
        <tr>
		            <th colspan="2">Total Income</th>
		            <th><%= totalIncome %></th>
		        </tr>
    </table>
    </div>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>