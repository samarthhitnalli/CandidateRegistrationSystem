package com.candidate.controller;

import com.candidate.dao.CandidateDAO;
import com.candidate.model.Candidate;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Candidate c = new Candidate();
        c.setName(request.getParameter("name"));
        c.setEmail(request.getParameter("email"));
        c.setPhone(request.getParameter("phone"));
        c.setQualification(request.getParameter("qualification"));

        try {
            CandidateDAO dao = new CandidateDAO();

            if (dao.isEmailOrPhoneExists(c.getEmail(), c.getPhone())) {
                request.setAttribute("message", "Error: Email or Phone already exists!");
            } else {
                dao.saveCandidate(c);
                request.setAttribute("message", "Candidate registered successfully!");
            }

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An unexpected error occurred.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
