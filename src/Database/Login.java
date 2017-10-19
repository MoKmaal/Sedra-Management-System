/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mohammed
 */
public class Login {

    private String username;
    private String password;
    private String query;
    public static int empID;

    public Login() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean execute() throws SQLException {
        Statement stmt = Connect.startConnection();
        query = "SELECT employeeID, employeeMail,employeePassword FROM Employee WHERE employeeMail='" + username
                + "' AND employeePassword='" + password + "'";

        ResultSet result = stmt.executeQuery(query);
        result.next();
        empID = result.getInt("employeeID");
        System.out.println(result.first());
        System.out.println(username);
        System.out.println(password);
        return result.first();

    }

    public static int getEmpID() {
        return empID;
    }
    

}
