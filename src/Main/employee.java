/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author User
 */
public class employee {
    private String identity_number,employee_name,date_birth,phone_number;
    private String email,gender,religion,employement_start;
    private String employement_end,employement_type,address;
    
    public employee(String identity_number,String employee_name,String date_birth,String phone_number,String email,String gender,String religion,String employement_start,String employement_end,String employement_type,String address)
    {
        this.identity_number = identity_number;
        this.employee_name = employee_name;
        this.date_birth = date_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.gender = gender;
        this.religion = religion;
        this.employement_start = employement_start;
        this.employement_end = employement_end;
        this.employement_type = employement_type;
        this.address = address;
    }
    public String getidentity_number(){
        return identity_number;
    }
    public String getemployee_name(){
        return employee_name;
    }
    public String getdate_birth(){
        return date_birth;
    }
    public String getphone_number(){
        return phone_number;
    }
    public String getemail(){
        return email;
    }
    public String getgender(){
        return gender;
    }
    public String getreligion(){
        return religion;
    }
    public String getemployement_start(){
        return employement_start;
    }
    public String getemployement_end(){
        return employement_end;
    }
    public String getemployement_type(){
        return employement_type;
    }
    public String getaddress(){
        return address;
    }
    
}
