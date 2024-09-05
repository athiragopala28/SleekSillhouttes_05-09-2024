<%@ page import="dao.MaterialDao" %>
<%@ page import="bean.MaterialBean" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Materials</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            margin-top: 20px;
        }
        .table thead th {
            background-color: #007bff;
            color: #ffffff;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-link {
            color: #007bff;
            text-decoration: none;
        }
        .btn-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">View Materials</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Material Name</th>
                    <th>Material Type</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Fetch materials from the database
                    MaterialDao materialDao = new MaterialDao();
                    List<MaterialBean> materials = materialDao.getAllMaterials();

                    // Display materials
                    for (MaterialBean material : materials) {
                %>
                    <tr>
                        <td><%= material.getMaterialId() %></td>
                        <td><%= material.getName() %></td>
                        <td><%= material.getType() %></td>
                        <td><%= material.getDescription() %></td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
        <div class="text-center mt-3">
            <a href="addmaterial.jsp" class="btn btn-primary mb-3">Add New Material</a>
        </div>
        <div class="text-center mt-4">
            <a href="index.jsp" class="btn btn-link">Back to Home</a>
        </div>
    </div>
</body>
</html>
