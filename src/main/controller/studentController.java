package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import main.DAO.*;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import main.modes.*;
import main.modes.studentModel;
import main.utilities.*;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class studentController implements Initializable
{
    @FXML
    private TextField txt_fullname;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_phone;

    @FXML
    private Button btn_Insert;

    @FXML
    private TableView<studentModel> tableview;

    @FXML
    private TableColumn<studentModel, String> collfulname;

    @FXML
    private TableColumn<studentModel, String> colladdress;

    @FXML
    private TableColumn<studentModel, String> collphone;

    @FXML
    private TableColumn<studentModel, String> collgender;

    @FXML
    private ComboBox<String> combogender;
    @FXML
    private TextField SearchStdnt;

    @FXML
    private Label lbltotal;



    @FXML
    private Button btndelete;

    @FXML
    private PieChart pchart;

    @FXML
    private Button btnupdate;
    Connection con=db.connect();

    public studentController() throws SQLException, ClassNotFoundException {
    }

    //insert code below
    @FXML
    void Insert(ActionEvent event) throws Exception {
        String name=txt_fullname.getText();
        String address=txt_address.getText();
        String phone=txt_phone.getText();
        String gender=combogender.getValue();


        // creating obj called studentobj

        studentModel studentobj=new studentModel();
        studentobj.setAddress(address);
        studentobj.setFulname(name);
        studentobj.setPhone(phone);
        studentobj.setGender(gender);
        tableview.getItems().add(studentobj);

        StudentDAO studentDAOobj=new StudentDAO();
        studentDAOobj.createstudent(studentobj);
        sshow();
        totalshow();

    }
    
    //end of insert


    //update code below

    @FXML
    void updatestudent(ActionEvent event) throws Exception {
        String name=txt_fullname.getText();
        String address=txt_address.getText();
        String phone=txt_phone.getText();
        String gender=combogender.getValue();

        studentModel studentobj=new studentModel();
        studentobj.setAddress(address);
        studentobj.setFulname(name);
        studentobj.setPhone(phone);
        studentobj.setGender(gender);
//      tableview.getItems().add(studentobj);

        StudentDAO so=new StudentDAO();
        so.updateStudent(studentobj);
        sshow();
        mouseclick();
        totalshow();

    }

    //end of update code

    //delete code below

    @FXML
    void deletestudent(ActionEvent event) throws Exception {

        String name=txt_fullname.getText();
        studentModel studentobj=new studentModel();
        studentobj.setFulname(name);
        StudentDAO so=new StudentDAO();
        so.deleteStudent(studentobj);
        sshow();
        totalshow();



    }







    @FXML
    void mouseevent(MouseEvent event)
    {
        mouseclick();

    }





    public void totalshow () throws Exception
    {
        try {
            con= db.connect();
            String query="SELECT COUNT(id) FROM student where status='available' ";
            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String count=rs.getString("COUNT(id)");

                lbltotal.setText(count);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void mouseclick()
    {

        studentModel mobj=new studentModel();

        mobj=tableview.getSelectionModel().getSelectedItem();
        if(mobj!=null) {
            txt_fullname.setText(mobj.getFulname());
            txt_address.setText(mobj.getAddress());
            txt_phone.setText(mobj.getPhone());
            combogender.setValue(mobj.getGender());
        }
    }


    public void sshow()
    {
        collfulname.setCellValueFactory(new PropertyValueFactory<>("fulname"));
        colladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        collphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        collgender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        String sqyert="SELECT * FROM `student` where status='available' ";
        ObservableList<studentModel>patientlist=FXCollections.observableArrayList();
        try {
            PreparedStatement patietnstatement=con.prepareStatement(sqyert);
            ResultSet rs7=patietnstatement.executeQuery();
            while (rs7.next())
            {
                patientlist.add(new studentModel(


                        rs7.getString("fullname"),rs7.getString("address"),rs7.getString("phone"),rs7.getString("gender")));

//



            }
            tableview.setItems(patientlist);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  void piichart()
    {
        try {
            ObservableList<PieChart.Data>data= FXCollections.observableArrayList();

            con = db.connect();
            String query="SELECT * FROM student";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            while (rs.next()){
                data.add(new PieChart.Data(rs.getString("address"),rs.getInt("id")));
            }

//
            pchart.setData(data);


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }




    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            // Inizatilabe Gender
            ObservableList<String> gender = FXCollections.observableArrayList("male", "female");
            combogender.setItems(gender);

            // Initialize Id in variable
            sshow();
            mouseclick();
            totalshow();
            piichart();
















        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    }








