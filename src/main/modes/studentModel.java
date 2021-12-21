package main.modes;

public class studentModel {

    public static String getFulname;
    private String fulname;
    private String address;
    private String phone;
    private String gender;

    public studentModel() {
    }
    //constructers


    public studentModel(String fulname, String address, String phone, String gender) {
        this.fulname = fulname;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFulname() {
        return fulname;
    }

    public void setFulname(String fulname) {
        this.fulname = fulname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}