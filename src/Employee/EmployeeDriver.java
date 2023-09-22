package Employee;

import java.util.Scanner;

public class EmployeeDriver {

	public static void main(String[] args) {
		while (true) {
			System.out.println("1) for saving employee data");
			System.out.println("2) for view the employee data");
			System.out.println("3) for deleting employee data");
			System.out.println("4) for Update employee data");
			System.out.println("5) for exit");
			Scanner scanner = new Scanner(System.in);
			int key = scanner.nextInt();
			switch (key) {
			case 1: {
				Employee employee = new Employee();
				System.out.println("Enter id");
				employee.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter Name");
				employee.setName(scanner.nextLine());
				System.out.println("Enter sal");
				employee.setSal(scanner.nextInt());
				System.out.println("Enter phone number");
				employee.setPhone(scanner.nextLong());
				EmployeeCRUD.saveEmployee(employee);
			}
				break;
			case 2: {
				EmployeeCRUD.viewEmployee();
			}
				break;
			case 3: {
				System.out.println("Enter id for deleting employee");
				int id = scanner.nextInt();
				EmployeeCRUD.deleteEmployee(id);
			}
				break;
			case 4: {
				System.out.println("1) for Update name");
				System.out.println("2) for Update sal");
				System.out.println("3) for Update phone");
				int key2 = scanner.nextInt();
				switch (key2) {
				case 1: {
					System.out.println("Enter id of Updating name");
					int id = scanner.nextInt();
					System.out.println("Enter Update Name");
					scanner.nextLine();
					String name = scanner.nextLine();
					EmployeeCRUD.updateName(name, id);
				}

					break;
				case 2: {
					System.out.println("Enter id of Updating sal");
					int id = scanner.nextInt();
					System.out.println("Enter Update sal Amount");
					int sal = scanner.nextInt();
					EmployeeCRUD.updateSal(sal, id);
				}
					break;
				case 3: {
					System.out.println("Enter id of Updating phone number");
					int id = scanner.nextInt();
					System.out.println("Enter Update phone number");
					long phone = scanner.nextLong();
					EmployeeCRUD.updatePhone(phone, id);
				}
					break;
				default:
					System.out.println("Enter correct option");
					break;
				}
			}
				break;
			case 5: {
				EmployeeCRUD.closeConnection();
				System.out.println("** Thank You **");
				return;
			}
			default:
				System.out.println("Enter correct option");
				break;
			}
		}
	}

}
