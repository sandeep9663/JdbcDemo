package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JdbcDemo

{
	public static void main(String[] args) {
		JdbcDemo co = new JdbcDemo();
		try (Connection con = getConnection()) {
			Student s1 = new Student(10, "Saagr");

			co.createStudent(s1, con);
		    co.selectStudent(con);

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static Connection getConnection() {
		System.out.println(" connect with DataBase");
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "P@til9663");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	private void createStudent(Student s1, Connection con) throws SQLException {

		if (Objects.nonNull(s1) && Objects.nonNull(con)) {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO information (Id, Name) VALUES (?,?)");
			Student temp = s1;
			pstmt.setInt(1, (s1.getId()));
			pstmt.setString(2, s1.getName());

			pstmt.executeUpdate();
			System.out.println(" Record addedd to dataBase");
		}
	}


	private void selectStudent(Connection con) throws SQLException {

		String s1 = "select * from information";

		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(s1);

		while (result.next()) {

			String Name = result.getString(2);

			System.out.println(Name);
		}

		System.out.println("<<<<<<<<<<<<<<<my task is first latter of name given res. name fetch from database");

		String s2 = "select * from information where name like '__a%'";

		Statement statement1 = con.createStatement();
		ResultSet result1 = statement1.executeQuery(s2);

		while (result1.next()) {

			String Name1 = result1.getString(2);

			System.out.println(Name1);

		}
	}

}




















































































































