<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Candidate Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="p-4 bg-light">
    <div class="container">
        <h2>Register Candidate</h2>

        <!-- Display success or error message -->
        <%
            String msg = (String) request.getAttribute("message");
            if (msg != null) {
                boolean isError = msg.toLowerCase().startsWith("error");
        %>
            <div class="alert <%= isError ? "alert-danger" : "alert-success" %>">
                <%= msg %>
            </div>
        <% } %>

        <form method="post" action="register">
            <div class="form-group">
                <label>Name *</label>
                <input type="text" name="name" class="form-control" required />
            </div>
            <div class="form-group">
                <label>Email *</label>
                <input type="email" name="email" class="form-control" required />
            </div>
            <div class="form-group">
                <label>Phone *</label>
                <input type="text" name="phone" class="form-control" required />
            </div>
            <div class="form-group">
                <label>Qualification *</label>
                <input type="text" name="qualification" class="form-control" required />
            </div>
            <button class="btn btn-success">Register</button>
            <a href="view_candidates.jsp" class="btn btn-primary ml-2">View Registered Candidates</a>
        </form>
    </div>
</body>
</html>
