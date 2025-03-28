<%@page import="com.expenseTracker.Entity.Income"%>
<%@page import="com.expenseTracker.Entity.Expense"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Income & Expense Summary</title>
    
  </head>
  <body>

    <% 
        List<Income> incomeList = (List<Income>) request.getAttribute("incomeList"); 
        List<Expense> expenseList = (List<Expense>) request.getAttribute("expenseList");

        double totalIncome = 0;
        double totalExpense = 0; 
        double remainingBalance;

        // Calculate total income
        for (Income income : incomeList) {
            totalIncome += income.getAmount();
        }

        // Calculate total expense
        for (Expense expense : expenseList) {
            totalExpense += expense.getAmount();
        }

        // Calculate remaining balance
        remainingBalance = totalIncome - totalExpense;
    %>
	
	<div class="text-center">
		<h1>Income & Expense Summary</h1>
			
		<div class="d-flex justify-content-center">
			<table border="1">
		        <tr>
		            <th>Amount</th>
		            <th>Date</th>
		            <th>Description</th>
		            <th>Type</th>
		        </tr>
		        <% for (Income income : incomeList) { %>
		            <tr>
		                <td><%= income.getAmount() %></td>
		                <td><%= income.getDate() %></td>
		                <td><%= income.getDescription() %></td>
		                <td><span class="text-success">Income</span></td>
		            </tr>
		        <% } %>

		        <% for (Expense expense : expenseList) { %>
		            <tr>
		                <td><%= expense.getAmount() %></td>
		                <td><%= expense.getDate() %></td>
		                <td><%= expense.getDescription() %></td>
		                <td><span class="text-danger">Expense</span></td>
		            </tr>
		        <% } %>

		        <!-- Total Income -->
		        <tr class="table-success">
		            <th colspan="3">Total Income</th>
		            <th><%= totalIncome %></th>
		        </tr>

		        <!-- Total Expense -->
		        <tr class="table-danger">
		            <th colspan="3">Total Expense</th>
		            <th><%= totalExpense %></th>
		        </tr>

		        <!-- Remaining Balance -->
		        <tr class="table-primary">
		            <th colspan="3">Remaining Balance</th>
		            <th><%= remainingBalance %></th>
		        </tr>
		    </table>
		</div>
	</div>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxh4U9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
