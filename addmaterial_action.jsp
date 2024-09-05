<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Material</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom Styles -->
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #495057;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: 500;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
            font-weight: bold;
            padding: 10px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Add Material</h2>

        <!-- Form to add material -->
        <form action="addmaterial_action.jsp" method="POST">
            <div class="mb-3">
                <label for="materialName" class="form-label">Material Name</label>
                <input type="text" class="form-control" id="materialName" name="materialName" required>
            </div>

            <div class="mb-3">
                <label for="materialType" class="form-label">Material Type</label>
                <select class="form-select" id="materialType" name="materialType" required>
                    <option value="">Select Material Type</option>
                    <option value="Linen">Linen</option>
                    <option value="Chiffon">Chiffon</option>
                    <option value="Satin">Satin</option>
                    <option value="Georgette">Georgette</option>
                    <option value="Silk">Silk</option>
                    <option value="Crepe">Crepe</option>
                    <option value="Nylon">Nylon</option>
                    <option value="Velvet">Velvet</option>
                    <option value="Rayon">Rayon</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Add Material</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
