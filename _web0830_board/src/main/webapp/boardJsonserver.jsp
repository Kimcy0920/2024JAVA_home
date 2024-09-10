<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String jdbcUrl = "jdbc:mysql://localhost:3306/spring5fs";
    String jdbcUser = "root";
    String jdbcPassword = "mysql";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	
    // server page, ex) servlet
    String action = request.getParameter("action"); // ?action
    String responseJson = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        
        if ("create".equalsIgnoreCase(action)) {
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String sql = "INSERT INTO board (writer, title, content, regtime, hits) VALUES (?, ?, ?, now(), 0)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("read".equalsIgnoreCase(action)) {
            String sql = "SELECT * FROM board";
            pstmt = conn.prepareStatement(sql); // sql select문
            rs = pstmt.executeQuery();

            JSONArray jsonArray = new JSONArray(); // 배열에 저장
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("num", rs.getInt("num"));
                jsonObject.put("writer", rs.getString("writer"));
                jsonObject.put("title", rs.getString("title"));
                jsonObject.put("content", rs.getString("content"));
                jsonObject.put("regtime", rs.getString("regtime"));
                jsonObject.put("hits", rs.getInt("hits"));
                jsonArray.put(jsonObject);
            }
            responseJson = jsonArray.toString();

        } else if ("update".equalsIgnoreCase(action)) {
            int num = Integer.parseInt(request.getParameter("num"));
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String regtime = request.getParameter("regtime");
            int hits = Integer.parseInt(request.getParameter("hits"));

            String sql = "UPDATE board SET writer=?, title=?, content=?, regtime=now(), hits=? WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.setInt(4, hits);
            pstmt.setInt(5, num);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("delete".equalsIgnoreCase(action)) {
            int num = Integer.parseInt(request.getParameter("num"));

            String sql = "DELETE FROM board WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseJson = "{\"error\":\"An error occurred while processing the request.\"}";
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }

    out.print(responseJson);
%>