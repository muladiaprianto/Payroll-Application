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
public class attendance {
    private String identity_number,date,attendance,description;
    
    public attendance(String identity_number,String date,String attendance,String description)
    {
        this.identity_number = identity_number;
        this.date = date;
        this.attendance = attendance;
        this.description = description;
    }
    public String getidentity_number(){
        return identity_number;
    }
    public String getdate(){
        return date;
    }
    public String getattendance(){
        return attendance;
    }
    public String getdescription(){
        return description;
    }
    
}
