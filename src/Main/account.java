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
public class account {
    private String username,password,account_status,identity_number;
    
    public account(String username,String password, String identity_number, String account_status)
    {
        this.username = username;
        this.password = password;
        this.identity_number = identity_number;
        this.account_status = account_status;
    }
    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }
    public String getidentity_number(){
        return identity_number;
    }
    public String getaccount_status(){
        return account_status;
    }
    System.out.println("User Account");
    
}
