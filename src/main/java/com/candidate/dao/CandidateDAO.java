package com.candidate.dao;

import com.candidate.model.Candidate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/candidate_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root"; // change as per your setup

    private static final String INSERT_SQL = "INSERT INTO candidates (name, email, phone, qualification) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM candidates";
    private static final String CHECK_DUPLICATE_SQL = "SELECT COUNT(*) FROM candidates WHERE email = ? OR phone = ?";

    public void saveCandidate(Candidate c) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getPhone());
            stmt.setString(4, c.getQualification());
            stmt.executeUpdate();
        }
    }

    public boolean isEmailOrPhoneExists(String email, String phone) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(CHECK_DUPLICATE_SQL)) {

            stmt.setString(1, email);
            stmt.setString(2, phone);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public List<Candidate> getAllCandidates() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Candidate c = new Candidate();
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setQualification(rs.getString("qualification"));
                candidates.add(c);
            }
        }
        return candidates;
    }
}

