package students.details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailsDAO implements DetailsDAOInterface {
	private Connection conn;

	public DetailsDAO(Connection conn) {
		this.conn = conn;
	}

	public Details findById(int id) throws SQLException {
		String sql = "SELECT * FROM details WHERE id = ?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			Details student = new Details(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));

			return student;
		}

		return null;
	}

	public ArrayList<Details> findAll() throws SQLException {
		ArrayList<Details> details = new ArrayList<>();
		String sql = "SELECT id, name, age FROM details";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Details detail = new Details(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));

			details.add(detail);
		}
		
		return details;
	}

	public void insert(Details detail) throws SQLException {
		String sql = "INSERT INTO details (name, age) VALUES (?, ?)";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setString(1, detail.getName());
		pst.setInt(2, detail.getAge());

		pst.executeUpdate();

		pst.close();
	}

	public void update(Details detail) throws SQLException {
		String sql = "UPDATE details SET name = ?, age = ? WHERE id = ?";
		PreparedStatement pst = this.conn.prepareStatement(sql);

		pst.setString(1, detail.getName());
		pst.setInt(2, detail.getAge());
		pst.setInt(3, detail.getId());

		pst.executeUpdate();

		pst.close();
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM details WHERE id = ?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

		pst.close();
	}
}
