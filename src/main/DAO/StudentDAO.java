package main.DAO;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import main.utilities.*;
import main.modes.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO
{
    Connection con = db.connect();

    public StudentDAO() throws SQLException, ClassNotFoundException {
    }


    public void createstudent(studentModel studentobj) throws SQLException, ClassNotFoundException
    {
        //stablish our connection class here



        String sql = "INSERT INTO `student`(`fullname`, `address`, `phone`, `gender`) VALUES (?,?,?,?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, studentobj.getFulname());
        statement.setString(2, studentobj.getAddress());
        statement.setString(3, studentobj.getPhone());
        statement.setString(4, studentobj.getGender());

        int result = statement.executeUpdate();

        if (result == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, " Xogta Waa la Save Gareeyay");
             alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, " Weli waxbaa kaa qaldan");
            alert.show();

        }

    }

    public void deleteStudent(studentModel studentobj) throws SQLException {
        String delete = "DELETE FROM `student` WHERE `fullname`=?";

        PreparedStatement statement = con.prepareStatement(delete);
        statement.setString(1, studentobj.getFulname());
        int result =statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"Deleted Data ");
        }else
        {
            JOptionPane.showMessageDialog(null,"something went wrong");

        }

    }


    public void updateStudent(studentModel studentobj) throws SQLException {
        String update = "UPDATE `student` SET `fullname`=?,`address`=?,`phone`=?,`gender`=? WHERE `fullname`=?";



        PreparedStatement statement = con.prepareStatement(update);
        statement.setString(1, studentobj.getFulname());
        statement.setString(2, studentobj.getAddress());
        statement.setString(3, studentobj.getPhone());
        statement.setString(4, studentobj.getGender());
        statement.setString(5, studentobj.getFulname());
        int result =statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"updated");
        }else
        {
            JOptionPane.showMessageDialog(null,"something went wrong");

        }


    }






        }






