package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MaterialBean;

public class MaterialDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "password";

	private static final String INSERT_MATERIAL_SQL = "INSERT INTO materials (material_name, material_type, description) VALUES (?, ?, ?)";
	private static final String SELECT_ALL_MATERIALS_SQL = "SELECT * FROM materials";
	private static final String SELECT_MATERIAL_BY_ID_SQL = "SELECT * FROM materials WHERE id = ?";
	private static final String UPDATE_MATERIAL_SQL = "UPDATE materials SET material_name = ?, material_type = ?, description = ? WHERE id = ?";
	private static final String DELETE_MATERIAL_SQL = "DELETE FROM materials WHERE id = ?";

	// Get a database connection
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
	}

	// Retrieve all materials
	public List<MaterialBean> getAllMaterials() {
		List<MaterialBean> materials = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_MATERIALS_SQL);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				MaterialBean material = new MaterialBean();
				material.setMaterialId(rs.getInt("id"));
				material.setName(rs.getString("material_name"));
				material.setType(rs.getString("material_type"));
				material.setDescription(rs.getString("description"));
				materials.add(material);
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception in getAllMaterials: " + e.getMessage());
			e.printStackTrace();
		}
		return materials;
	}

	// Retrieve a material by its ID
	public MaterialBean getMaterialById(int id) throws SQLException {
		MaterialBean material = null;
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_MATERIAL_BY_ID_SQL)) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					material = new MaterialBean();
					material.setMaterialId(rs.getInt("id"));
					material.setName(rs.getString("material_name"));
					material.setType(rs.getString("material_type"));
					material.setDescription(rs.getString("description"));
				}
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception in getMaterialById: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return material;
	}

	// Add a new material
	public void addMaterial(MaterialBean material) throws SQLException {
		String query = "INSERT INTO materials (material_name, material_type, description) VALUES (?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, material.getName());
			stmt.setString(2, material.getType());
			stmt.setString(3, material.getDescription());

			// Print the query for debugging
			System.out.println("Executing query: " + query);
			System.out.println(
					"Parameters: " + material.getName() + ", " + material.getType() + ", " + material.getDescription());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Material added successfully.");
			} else {
				System.err.println("Failed to add material. No rows affected.");
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception in addMaterial: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// Update an existing material
	public boolean updateMaterial(MaterialBean material) throws SQLException {
		boolean updated = false;
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE_MATERIAL_SQL)) {

			stmt.setString(1, material.getName());
			stmt.setString(2, material.getType());
			stmt.setString(3, material.getDescription());
			stmt.setInt(4, material.getMaterialId());
			int rowsAffected = stmt.executeUpdate();
			updated = rowsAffected > 0;
		} catch (SQLException e) {
			System.err.println("SQL Exception in updateMaterial: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return updated;
	}

	// Delete a material by ID
	public boolean deleteMaterial(int id) throws SQLException {
		boolean deleted = false;
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_MATERIAL_SQL)) {

			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.err.println("SQL Exception in deleteMaterial: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return deleted;
	}
}
