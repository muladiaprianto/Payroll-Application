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
public class allowance {
     private String id_allowance,allowance_name,allowance_value,allowance_type,allowance_status;
    
    public allowance(String id_allowance,String allowance_name,String allowance_value,String allowance_type,String allowance_status)
    {
        this.id_allowance = id_allowance;
        this.allowance_name = allowance_name;
        this.allowance_value = allowance_value;
        this.allowance_type = allowance_type;
        this.allowance_status = allowance_status;
    }
    public String getid_allowance(){
        return id_allowance;
    }
    public String getallowance_name(){
        return allowance_name;
    }
    public String getallowance_value(){
        return allowance_value;
    }
    public String getallowance_type(){
        return allowance_type;
    }
    public String getallowance_status(){
        return allowance_status;
    }
}
