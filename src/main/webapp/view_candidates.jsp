<%@ page import="java.util.*, com.candidate.model.Candidate, com.candidate.dao.CandidateDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Candidates</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="p-4 bg-light">
    <div class="container">
        <h2>Registered Candidates</h2>
        <table class="table table-bordered">
            <thead>
                <tr><th>Name</th><th>Email</th><th>Phone</th><th>Qualification</th></tr>
            </thead>
            <tbody>
                <%
                    CandidateDAO dao = new CandidateDAO();
                    List<Candidate> list = dao.getAllCandidates();
                    for (Candidate c : list) {
                %>
                <tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getEmail() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getQualification() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
