package Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Employee.ConnectionHelper;
import Employee.Employee;

public class EmployeeCRUD {
	static Connection connection = ConnectionHelper.getConnectionObj();
	public static boolean saveEmployee(Employee employee) {
		String queryString = "INSERT INTO employee VALUES ("+employee.getId()+", '"+employee.getName()+"', "+employee.getSal()+", "+employee.getPhone()+")";
		try {
			Statement statement = connection.createStatement();
			statement.execute(queryString);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void viewEmployee() {
		String queryString = "SELECT * FROM employee";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			while (resultSet.next()) {
				System.out.println("------------------------------");
				System.out.println("id      :"+ resultSet.getInt(1));
				System.out.println("name    :"+ resultSet.getString(2));
				System.out.println("sal     :"+ resultSet.getInt(3));
				System.out.println("phone   :"+ resultSet.getLong(4));
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static boolean deleteEmployee(int id) {
		String queryString = "DELETE FROM employee where id ="+id;
		try {
			Statement statement = connection.createStatement();
			statement.execute(queryString);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateName(String name, int id) {
		String queryString = "UPDATE employee set name = '"+name+"' where id ="+id;
		try {
			Statement statement = connection.createStatement();
			statement.execute(queryString);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateSal(int sal, int id) {
		String queryString = "UPDATE employee set sal = "+sal+" where id ="+id;
		
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(queryString);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean updatePhone(long phone, int id) {
		String queryString = "UPDATE employee set phone = "+phone+" where id = "+id;
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(queryString);
			return true ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
