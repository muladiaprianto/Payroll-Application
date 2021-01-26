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
public class special_payment {
    private String id_payment,identity_number,id_special,date,payment_value,executor,description;
    
    public special_payment(String id_payment,String identity_number,String id_special,String date,String payment_value,String executor,String description)
    {
        this.id_payment = id_payment;
        this.identity_number = identity_number;
        this.id_special = id_special;
        this.date = date;
        this.payment_value = payment_value;
        this.executor = executor;
        this.description = description;
    }
    public String getid_payment(){
        return id_payment;
    }
    public String getidentity_number(){
        return identity_number;
    }
    public String getid_special(){
        return id_special;
    }
    public String getdate(){
        return date;
    }
    public String getpayment_value(){
        return payment_value;
    }
    public String getexecutor(){
        return executor;
    }
    public String getdescription(){
        return description;
    }
    
}
