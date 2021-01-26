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
public class salary {
    private String id_salary,identity_number,date,basic_salary,allowance_total,fine_total,total_salary,executor,description;
    
    public salary(String id_salary,String identity_number,String date,String basic_salary,String allowance_total,String fine_total,String total_salary,String executor,String description)
    {
        this.id_salary = id_salary;
        this.identity_number = identity_number;
        this.date = date;
        this.basic_salary = basic_salary;
        this.allowance_total = allowance_total;
        this.fine_total = fine_total;
        this.total_salary = total_salary;
        this.executor = executor;
        this.description = description;
    }
    public String getid_salary(){
        return id_salary;
    }
    public String getidentity_number(){
        return identity_number;
    }
    public String getdate(){
        return date;
    }
    public String getbasic_salary(){
        return basic_salary;
    }
    public String getallowance_total(){
        return allowance_total;
    }
    public String getfine_total(){
        return fine_total;
    }
    public String gettotal_salary(){
        return total_salary;
    }
    public String getexecutor(){
        return executor;
    }
    public String getdescription(){
        return description;
    }
    
}
