<%

    String empty_msg = (String) session.getAttribute("empty_message");

    if (empty_msg != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= empty_msg%>
</div>

<%
        session.removeAttribute("empty_message");
    }

%>




<%

    String msg = (String) session.getAttribute("message");

    if (msg != null) {
%>
<div class="alert alert-success" role="alert">
    <%= msg%>
</div>

<%
        session.removeAttribute("message");
    }

%>



<%

    String email_msg = (String) session.getAttribute("email_message");

    if (email_msg != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= email_msg%>
</div>

<%
        session.removeAttribute("email_message");
    }

%>


<%

    String phone_msg = (String) session.getAttribute("phone_message");

    if (phone_msg != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= phone_msg%>
</div>

<%
        session.removeAttribute("phone_message");
    }

%>


<%

    String error_msg = (String) session.getAttribute("error_message");

    if (error_msg != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= error_msg%>
</div>

<%
        session.removeAttribute("error_message");
    }

%>


<%

    String category_msg = (String) session.getAttribute("error_category");

    if (category_msg != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= category_msg%>
</div>

<%
        session.removeAttribute("error_category");
    }

%>