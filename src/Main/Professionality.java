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
public class Professionality {
    private String id_professionality,professionality,basic_salary,professionality_allowance,professionality_level,professionality_status;

    public Professionality(String id_professionality, String professionality, String basic_salary, String professionality_allowance, String professionality_level, String professionality_status) {
        this.id_professionality = id_professionality;
        this.professionality = professionality;
        this.basic_salary = basic_salary;
        this.professionality_allowance = professionality_allowance;
        this.professionality_level = professionality_level;
        this.professionality_status = professionality_status;
    }

    public String getId_professionality() {
        return id_professionality;
    }

    public void setId_professionality(String id_professionality) {
        this.id_professionality = id_professionality;
    }

    public String getProfessionality() {
        return professionality;
    }

    public void setProfessionality(String professionality) {
        this.professionality = professionality;
    }

    public String getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(String basic_salary) {
        this.basic_salary = basic_salary;
    }

    public String getProfessionality_allowance() {
        return professionality_allowance;
    }

    public void setProfessionality_allowance(String professionality_allowance) {
        this.professionality_allowance = professionality_allowance;
    }

    public String getProfessionality_level() {
        return professionality_level;
    }

    public void setProfessionality_level(String professionality_level) {
        this.professionality_level = professionality_level;
    }

    public String getProfessionality_status() {
        return professionality_status;
    }

    public void setProfessionality_status(String professionality_status) {
        this.professionality_status = professionality_status;
    }
    
}
