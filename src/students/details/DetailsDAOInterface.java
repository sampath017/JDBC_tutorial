package students.details;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DetailsDAOInterface {
	Details findById(int id) throws SQLException;

	ArrayList<Details> findAll() throws SQLException;

	void insert(Details student) throws SQLException;

	void update(Details student) throws SQLException;

	void delete(int id) throws SQLException;
}
