package DatabaseRepository;

import com.company.DatabaseController.DatabaseController;
import com.company.data.DBManager;
import com.company.entities.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DatabaseRepository {

    private final DBManager dbManager;

    public DatabaseRepository(DBManager dbManager) {
        this.dbManager = dbManager;
    }
    public  boolean signIn(Employee employee) {

           Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee1 (name, age, dateofregistration, status,accname,password) VALUES(?,?,?,?,?,?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getAge());
            preparedStatement.setDate(3, Date.valueOf(employee.getDateofregistration()));
            preparedStatement.setString(4, employee.getStatus());
            preparedStatement.setString(5,employee.getAccname());
            preparedStatement.setString(6,employee.getPassword());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    public  String logIn(String accname){
        Connection connection = null;
        String password;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM employee1 WHERE accname=?");

            preparedStatement.setString(1, accname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("password");
                return password;
            }






        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;




    }
    public Employee getEmployeeById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee1 WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = new Employee();

            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));

                employee.setStatus(resultSet.getString("status"));

            }

            return employee;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}


