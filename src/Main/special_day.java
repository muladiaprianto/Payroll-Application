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
public class special_day {
    private String id_special,date_name,date,every_year_event,religion,description;
    
    public special_day(String id_special,String date_name,String date,String every_year_event,String religion,String description)
    {
        this.id_special = id_special;
        this.date_name = date_name;
        this.date = date;
        this.every_year_event = every_year_event;
        this.religion = religion;
        this.description = description;
    }
    public String getid_special(){
        return id_special;
    }
    public String getdate_name(){
        return date_name;
    }
    public String getdate(){
        return date;
    }
    public String getevery_year_event(){
        return every_year_event;
    }
    public String getreligion(){
        return religion;
    }
    public String getdescription(){
        return description;
    }
    
}
