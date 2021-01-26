/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;

import Main.employee;
import Main.Professionality;
import Main.account;
import Main.allowance;
import Main.attendance;
import Main.salary;
import Main.special_day;
import Main.special_payment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Name;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author User
 */
public class Menu extends javax.swing.JFrame {
    PreparedStatement pst;
    Connection con;
    ResultSet rs;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        show_data();
        show_data1();
        show_data2();
        show_data3();
        show_data4();
        show_data5();
        show_data6();
        show_data7();
        refresh();
        refresh1();
        combobox_item();
        combobox_item1();
        combobox_item2();
        combobox_item3();
        combobox_item4();
        combobox_item5();
        Date date = new Date();
        int a = date.getYear()+1900;
        int b = date.getMonth()+1;
        int c = date.getDate();
        lblattdate.setText(a+"-"+b+"-"+c);
    }
    
    
    //MENU EMPLOYEE
    public ArrayList<employee> List(){
        ArrayList<employee> List = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url, user, pass);
            String query1= "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List;
    }

    // show data menu employee
    public void show_data(){
        ArrayList<employee> list = List();
        DefaultTableModel model = (DefaultTableModel)tblemp.getModel();
        Object[] row = new Object[11];
        for(int i = 0;i<list.size();i++){
            row[0] = list.get(i).getidentity_number();
            row[1] = list.get(i).getemployee_name();
            row[2] = list.get(i).getdate_birth();
            row[3] = list.get(i).getphone_number();
            row[4] = list.get(i).getemail();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getreligion();
            row[7] = list.get(i).getemployement_start();
            row[8] = list.get(i).getemployement_end();
            row[9] = list.get(i).getemployement_type();
            row[10] = list.get(i).getaddress();
            model.addRow(row);
        }
    }
    //ARRAY LIST UNTUK MENU EMPLOYEE
    public ArrayList<Professionality> List1(){
        ArrayList<Professionality> List1 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url, user, pass);
            String query1= "select * from professionality";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Professionality conn;
            while(rs.next()){
                conn = new Professionality(rs.getString("id_professionality"),rs.getString("professionality"),rs.getString("basic_salary"),rs.getString("professionality_allowance"),rs.getString("professionality_level"),rs.getString("professionality_status"));
                List1.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List1;
    }
    
    public void combobox_item(){
        cmbempplace.removeAllItems();
        ArrayList<Professionality> list1 = List1();
        for(int i = 0;i<list1.size();i++){
            cmbempplace.addItem(list1.get(i).getId_professionality());
        }
    }
    
    //menu allowance
    private void refresh(){
        btnalsave.setVisible(false);
        btnalinsert.setVisible(true);
        txtalauto.setText("AUTO");
        txtalname.setText("");
        txtalvalue.setText("");
        txtalsearch.setText("");
        cmbal.setSelectedIndex(0);
        rbt2.setSelected(false);
        rbt1.setSelected(true);
        rbs2.setSelected(false);
        rbs1.setSelected(true);
        DefaultTableModel model = (DefaultTableModel)tblal.getModel();
        model.setRowCount(0);
        show_data1();
    }
    //arraylist untuk menu allowance
    public ArrayList<allowance> List2(){
        ArrayList<allowance> List2 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from allowance";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            allowance conn;
            while(rs.next()){
                conn = new allowance(rs.getString("id_allowance"),rs.getString("allowance_name"),rs.getString("allowance_value"),rs.getString("allowance_type"),rs.getString("allowance_status"));
                List2.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List2;
    }
    
    public void show_data1(){
        ArrayList<allowance> list2 = List2();
        DefaultTableModel model = (DefaultTableModel)tblal.getModel();
        Object[] row = new Object[5];
        for(int i = 0;i<list2.size();i++){
            row[0] = list2.get(i).getid_allowance();
            row[1] = list2.get(i).getallowance_name();
            row[2] = list2.get(i).getallowance_value();
            row[3] = list2.get(i).getallowance_type();
            row[4] = list2.get(i).getallowance_status();
            model.addRow(row);
        }
    }
    
    //attendance menu
    public ArrayList<attendance> List3(){
        ArrayList<attendance> List3 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from attendance";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            attendance conn;
            while(rs.next()){
                conn = new attendance(rs.getString("identity_number"),rs.getString("date"),rs.getString("attendance"),rs.getString("description"));
                List3.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List3;
    }
    //show data attendance
    public void show_data2(){
        ArrayList<attendance> list3 = List3();
        DefaultTableModel model = (DefaultTableModel)tblattendance.getModel();
        Object[] row = new Object[4];
        for(int i = 0;i<list3.size();i++){
            row[0] = list3.get(i).getidentity_number();
            row[1] = list3.get(i).getdate();
            row[2] = list3.get(i).getattendance();
            row[3] = list3.get(i).getdescription();
            model.addRow(row);
        }
    }
    //arraylist employee untuk menu attendance
    public ArrayList<employee> List4(){
        ArrayList<employee> List4 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List4.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List4;
    }
    //combo box attendance menu
    public void combobox_item1(){
        cmbatt.removeAllItems();
        ArrayList<employee> list = List();
        for(int i = 0;i<list.size();i++){
            cmbatt.addItem(list.get(i).getidentity_number());
        }
    }
    
    //MENU SALARY
    //ARRAYLIST UNTUK SALARY
    public ArrayList<salary> List5(){
        ArrayList<salary> List5 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from salary";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            salary conn;
            while(rs.next()){
                conn = new salary(rs.getString("id_salary"),rs.getString("identity_number"),rs.getString("date"),rs.getString("basic_salary"),rs.getString("allowance_total"),rs.getString("fine_total"),rs.getString("total_salary"),rs.getString("executor"),rs.getString("description"));
                List5.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List5;
    }
    
    public void show_data3(){
        ArrayList<salary> list5 = List5();
        DefaultTableModel model = (DefaultTableModel)tblsalary.getModel();
        Object[] row = new Object[9];
        for(int i = 0;i<list5.size();i++){
            row[0] = list5.get(i).getid_salary();
            row[1] = list5.get(i).getidentity_number();
            row[2] = list5.get(i).getdate();
            row[3] = list5.get(i).getbasic_salary();
            row[4] = list5.get(i).getallowance_total();
            row[5] = list5.get(i).getfine_total();
            row[6] = list5.get(i).gettotal_salary();
            row[7] = list5.get(i).getexecutor();
            row[8] = list5.get(i).getdescription();
            model.addRow(row);
        }
    }
    //MEMANGGIL ARRAYLIST EMPLOYEE UNTUK MENU SALARY
    public ArrayList<employee> List6(){
        ArrayList<employee> List6 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List6.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List6;
    }
    //METHOD COMBO BOX UNTUK SALARY
    public void combobox_item2(){
        cmbsaliden.removeAllItems();
        ArrayList<employee> list6 = List6();
        for(int i = 0;i<list6.size();i++){
            cmbsaliden.addItem(list6.get(i).getidentity_number());
        }
    }
    
    //MENU PROFESSIONALITY
    public ArrayList<Professionality> List7(){
        ArrayList<Professionality> List7 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from professionality";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Professionality conn;
            while(rs.next()){
                conn = new Professionality(rs.getString("id_professionality"),rs.getString("professionality"),rs.getString("basic_salary"),rs.getString("professionality_allowance"),rs.getString("professionality_level"),rs.getString("professionality_status"));
                List7.add(conn);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List7;
    }
    //SHOW DATA PROFESSIONALITY
    public void show_data4(){
        ArrayList<Professionality> list7 = List7();
        DefaultTableModel model = (DefaultTableModel)tblpro.getModel();
        Object[] row = new Object[6];
        for (Professionality list : list7) {
            row[0] = list.getId_professionality();
            row[1] = list.getProfessionality();
            row[2] = list.getBasic_salary();
            row[3] = list.getProfessionality_allowance();
            row[4] = list.getProfessionality_level();
            row[5] = list.getProfessionality_status();
            model.addRow(row);
        }
    }
    
    //MENU ACCOUNT
    public ArrayList<account> List8(){
        ArrayList<account> List8 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from account";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            account conn;
            while(rs.next()){
                conn = new account(rs.getString("username"),rs.getString("password"),rs.getString("identity_number"),rs.getString("account_status"));
                List8.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List8;
    }
    
    public void show_data5(){
        ArrayList<account> list8 = List8();
        DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
        Object[] row = new Object[4];
        for(int i = 0;i<list8.size();i++){
            row[0] = list8.get(i).getusername();
            row[1] = list8.get(i).getpassword();
            row[2] = list8.get(i).getidentity_number();
            row[3] = list8.get(i).getaccount_status();
            model.addRow(row);
        }
    }
    
    public ArrayList<employee> List9(){
        ArrayList<employee> List9 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List9.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List9;
    }
    
    public void combobox_item3(){
        cmbacciden.removeAllItems();
        ArrayList<employee> list9 = List9();
        for(int i = 0;i<list9.size();i++){
            cmbacciden.addItem(list9.get(i).getidentity_number()+"||"+list9.get(i).getemployee_name());
        }
    }
    
    //MENU SPECIALDAY
    public ArrayList<special_day> List10(){
        ArrayList<special_day> List10 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from special_day";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            special_day conn;
            while(rs.next()){
                conn = new special_day(rs.getString("id_special"),rs.getString("date_name"),rs.getString("date"),rs.getString("every_year_event"),rs.getString("religion"),rs.getString("description"));
                List10.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List10;
    }
    
    public void show_data6(){
        ArrayList<special_day> list10 = List10();
        DefaultTableModel model = (DefaultTableModel)tblspday.getModel();
        Object[] row = new Object[6];
        for(int i = 0;i<list10.size();i++){
            row[0] = list10.get(i).getid_special();
            row[1] = list10.get(i).getdate_name();
            row[2] = list10.get(i).getdate();
            row[3] = list10.get(i).getevery_year_event();
            row[4] = list10.get(i).getreligion();
            row[5] = list10.get(i).getdescription();
            model.addRow(row);
        }
    }
    
    //MENU SPECIAL PAYMENT
    //ARRAYLIST SPECIAL PAYMENT
     public ArrayList<special_payment> List11(){
        ArrayList<special_payment> List11 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from special_payment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            special_payment conn;
            while(rs.next()){
                conn = new special_payment(rs.getString("id_payment"),rs.getString("identity_number"),rs.getString("id_special"),rs.getString("date"),rs.getString("payment_value"),rs.getString("executor"),rs.getString("description"));
                List11.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List11;
    }
    //SHOW DATA SPECIAL PAYMENT
    public void show_data7(){
        ArrayList<special_payment> list11 = List11();
        DefaultTableModel model = (DefaultTableModel)tblsppayment.getModel();
        Object[] row = new Object[7];
        for(int i = 0;i<list11.size();i++){
            row[0] = list11.get(i).getid_payment();
            row[1] = list11.get(i).getidentity_number();
            row[2] = list11.get(i).getid_special();
            row[3] = list11.get(i).getdate();
            row[4] = list11.get(i).getpayment_value();
            row[5] = list11.get(i).getexecutor();
            row[6] = list11.get(i).getdescription();
            model.addRow(row);
        }
    }
    //ARRAYLIST EMPLOYEE UNTUK MENU SPECIAL PAYMENT
    public ArrayList<employee> List12(){
        ArrayList<employee> List12 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List12.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List12;
    }
    //COMBOBOX METHOD SPECIAL PAYMENT
    public void combobox_item4(){
        cmbpayiden.removeAllItems();
        ArrayList<employee> list12 = List12();
        for(int i = 0;i<list12.size();i++){
            cmbpayiden.addItem(list12.get(i).getidentity_number());
        }
    }
    //ARRAYLIST SPECIALDAY UNTUK MENU SPECIAL PAYMENT
    public ArrayList<special_day> List13(){
        ArrayList<special_day> List13 = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from special_day";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            special_day conn;
            while(rs.next()){
                conn = new special_day(rs.getString("id_special"),rs.getString("date_name"),rs.getString("date"),rs.getString("every_year_event"),rs.getString("religion"),rs.getString("description"));
                List13.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List13;
    }
    //COMBOBOX METHOD UNTUK MENU SPECIAL PAYMENT
    public void combobox_item5(){
        cmbpayid.removeAllItems();
        ArrayList<special_day> list13 = List13();
        for(int i = 0;i<list13.size();i++){
            cmbpayid.addItem(list13.get(i).getid_special());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnEmployee = new rojerusan.RSButtonIconD();
        btnAllowance = new rojerusan.RSButtonIconD();
        btnAttendance = new rojerusan.RSButtonIconD();
        btnsalary = new rojerusan.RSButtonIconD();
        btnspecialday = new rojerusan.RSButtonIconD();
        btnsppayment = new rojerusan.RSButtonIconD();
        btnProfessionality = new rojerusan.RSButtonIconD();
        btnAccount = new rojerusan.RSButtonIconD();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        employeePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnempinsert = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        rbmale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        rbfemale = new javax.swing.JRadioButton();
        txtemail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtphonenumb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtempname = new javax.swing.JTextField();
        cmbemp = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtempsearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtidnumb = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbreligion = new javax.swing.JComboBox();
        birthdate = new com.toedter.calendar.JDateChooser();
        cmbempplace = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        rbcont = new javax.swing.JRadioButton();
        rbnoncont = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dateend = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        datestart = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblemp = new javax.swing.JTable();
        allowancePanel = new javax.swing.JPanel();
        btnalinsert = new javax.swing.JButton();
        txtalauto = new javax.swing.JLabel();
        txtalvalue = new javax.swing.JTextField();
        rbt2 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblal = new javax.swing.JTable();
        txtalname = new javax.swing.JTextField();
        btnalcancel = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtalsearch = new javax.swing.JTextField();
        cmbal = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        btnalsave = new javax.swing.JButton();
        rbs1 = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        rbs2 = new javax.swing.JRadioButton();
        rbt1 = new javax.swing.JRadioButton();
        attendancePanel = new javax.swing.JPanel();
        rbabsent = new javax.swing.JRadioButton();
        btnattsave = new javax.swing.JButton();
        cmbatt = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtattsearch = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cmbattcari = new javax.swing.JComboBox();
        rbpermit = new javax.swing.JRadioButton();
        rbpresent = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblattendance = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        btnattfree = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        lblattdate = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        rbsick = new javax.swing.JRadioButton();
        btnattinsert = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtattdesc = new javax.swing.JTextArea();
        rbleave = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        dcfdateatt = new com.toedter.calendar.JDateChooser();
        dcudateatt = new com.toedter.calendar.JDateChooser();
        salaryPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        cmbsaliden = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblsalary = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txtsal = new javax.swing.JTextField();
        txttax = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        txtnetsal = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        professionalityPanel = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        cmbpro = new javax.swing.JComboBox();
        txtprosearch = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblpro = new javax.swing.JTable();
        txtprosalary = new javax.swing.JTextField();
        cmbprolvl = new javax.swing.JComboBox();
        txtproallo = new javax.swing.JTextField();
        rbproactive = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtproname = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        btnproinsert = new javax.swing.JButton();
        rbprononactive = new javax.swing.JRadioButton();
        btnprosave = new javax.swing.JButton();
        lblproauto = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        btnaccsave = new javax.swing.JButton();
        cmbacciden = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbaccactive = new javax.swing.JRadioButton();
        rbaccnonactive = new javax.swing.JRadioButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtaccuser = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblacc = new javax.swing.JTable();
        cmbaccount = new javax.swing.JComboBox();
        txtaccsearch = new javax.swing.JTextField();
        txtaccpass = new javax.swing.JTextField();
        btnaccinsert = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        btnacccancel = new javax.swing.JButton();
        specialdayPanel = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtspdaydesc = new javax.swing.JTextArea();
        rbeventno = new javax.swing.JRadioButton();
        rbother = new javax.swing.JRadioButton();
        jLabel77 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        txtspdaynama = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        rbhindu = new javax.swing.JRadioButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblspday = new javax.swing.JTable();
        rbeventyes = new javax.swing.JRadioButton();
        jLabel78 = new javax.swing.JLabel();
        rbgeneral = new javax.swing.JRadioButton();
        lblspdayauto = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        cmbspday = new javax.swing.JComboBox();
        txtspdaysearch = new javax.swing.JTextField();
        rbislam = new javax.swing.JRadioButton();
        rbbuddha = new javax.swing.JRadioButton();
        rbchristian = new javax.swing.JRadioButton();
        datespday = new com.toedter.calendar.JDateChooser();
        specialpaymentPanel = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        cmbpayiden = new javax.swing.JComboBox();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        cmbpayid = new javax.swing.JComboBox();
        jButton13 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblsppayment = new javax.swing.JTable();
        jLabel92 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payroll Application");
        setBackground(new java.awt.Color(101, 212, 206));
        setMinimumSize(new java.awt.Dimension(1010, 666));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1010, 666));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        menuPanel.setkEndColor(new java.awt.Color(153, 255, 255));
        menuPanel.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payroll (2).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PAYROLL");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("APPLICATION");

        btnEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnEmployee.setForeground(new java.awt.Color(0, 0, 0));
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee (1).png"))); // NOI18N
        btnEmployee.setText("EMPLOYEE");
        btnEmployee.setColorText(new java.awt.Color(0, 51, 255));
        btnEmployee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnAllowance.setBackground(new java.awt.Color(255, 255, 255));
        btnAllowance.setForeground(new java.awt.Color(0, 0, 0));
        btnAllowance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payment.png"))); // NOI18N
        btnAllowance.setText("ALLOWANCE");
        btnAllowance.setColorText(new java.awt.Color(0, 51, 255));
        btnAllowance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllowanceActionPerformed(evt);
            }
        });

        btnAttendance.setBackground(new java.awt.Color(255, 255, 255));
        btnAttendance.setForeground(new java.awt.Color(0, 0, 0));
        btnAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check (1).png"))); // NOI18N
        btnAttendance.setText("ATTENDANCE");
        btnAttendance.setColorText(new java.awt.Color(0, 51, 255));
        btnAttendance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });

        btnsalary.setBackground(new java.awt.Color(255, 255, 255));
        btnsalary.setForeground(new java.awt.Color(0, 0, 0));
        btnsalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/salary.png"))); // NOI18N
        btnsalary.setText("SALARY");
        btnsalary.setColorText(new java.awt.Color(0, 51, 255));
        btnsalary.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalaryActionPerformed(evt);
            }
        });

        btnspecialday.setBackground(new java.awt.Color(255, 255, 255));
        btnspecialday.setForeground(new java.awt.Color(0, 0, 0));
        btnspecialday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calendar.png"))); // NOI18N
        btnspecialday.setText("SPECIAL DAY");
        btnspecialday.setColorText(new java.awt.Color(0, 51, 255));
        btnspecialday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnspecialday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnspecialdayActionPerformed(evt);
            }
        });

        btnsppayment.setBackground(new java.awt.Color(255, 255, 255));
        btnsppayment.setForeground(new java.awt.Color(0, 0, 0));
        btnsppayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check (2).png"))); // NOI18N
        btnsppayment.setText("SPECIAL PAYMENT");
        btnsppayment.setColorText(new java.awt.Color(0, 51, 255));
        btnsppayment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsppayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsppaymentActionPerformed(evt);
            }
        });

        btnProfessionality.setBackground(new java.awt.Color(255, 255, 255));
        btnProfessionality.setForeground(new java.awt.Color(0, 0, 0));
        btnProfessionality.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/work.png"))); // NOI18N
        btnProfessionality.setText("PROFESSIONALITY");
        btnProfessionality.setColorText(new java.awt.Color(0, 51, 255));
        btnProfessionality.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProfessionality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessionalityActionPerformed(evt);
            }
        });

        btnAccount.setBackground(new java.awt.Color(255, 255, 255));
        btnAccount.setForeground(new java.awt.Color(0, 0, 0));
        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        btnAccount.setText("ACCOUNT");
        btnAccount.setColorText(new java.awt.Color(0, 51, 255));
        btnAccount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnAllowance, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnsalary, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnspecialday, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnsppayment, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnProfessionality, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnspecialday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsppayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProfessionality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mainPanel.setBackground(new java.awt.Color(162, 155, 254));
        mainPanel.setLayout(new java.awt.CardLayout());

        employeePanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("EMPLOYEE MENU");

        btnempinsert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnempinsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        btnempinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnempinsertActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("In Coulumn :");

        rbmale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbmale.setSelected(true);
        rbmale.setText("Male");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("+62");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Phone Number");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Address");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N

        rbfemale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbfemale.setText("Female");

        txtemail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Email");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface.png"))); // NOI18N

        txtphonenumb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Gender");

        txtempname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cmbemp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Identity Number", "Employee Name", "Birth Date", "Phone Number", "Email", "Gender", "Religion", "Employeement Start", "Employeement End", "Employeement Type", "Address" }));

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtaddress.setLineWrap(true);
        txtaddress.setRows(5);
        jScrollPane2.setViewportView(txtaddress);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Religion");

        txtempsearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtempsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempsearchActionPerformed(evt);
            }
        });
        txtempsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtempsearchKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Identity Number");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText("Birth Date");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Employee Name");

        txtidnumb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Search :");

        cmbreligion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbreligion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Christian", "Hindu", "Budha", "Islam", "Other" }));

        cmbempplace.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbempplace.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Employee Placement");

        rbcont.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbcont.setText("Contract");

        rbnoncont.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbnoncont.setSelected(true);
        rbnoncont.setText("Non Contract");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Employement Type");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Employement End");

        jLabel21.setText("Employeement Start");

        tblemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identity Number", "Employee Name", "Birth Date", "Phone Number", "Email", "Gender", "Religion", "Employement Start", "Employement End", "Employement Type", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblemp.setToolTipText("");
        tblemp.getTableHeader().setReorderingAllowed(false);
        tblemp.setUpdateSelectionOnSort(false);
        tblemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblempMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblemp);

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(1044, 1044, 1044))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtphonenumb, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                                            .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel13))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(employeePanelLayout.createSequentialGroup()
                                                    .addComponent(rbmale)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(rbfemale))
                                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(employeePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtidnumb, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(employeePanelLayout.createSequentialGroup()
                                            .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel18))
                                            .addGap(18, 18, 18)
                                            .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                .addComponent(txtempname)))))
                                .addGap(34, 34, 34)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel21))
                                .addGap(21, 21, 21)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dateend, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addGroup(employeePanelLayout.createSequentialGroup()
                                                .addComponent(rbcont)
                                                .addGap(17, 17, 17)
                                                .addComponent(rbnoncont))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(datestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(36, 36, 36)
                                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(employeePanelLayout.createSequentialGroup()
                                                .addComponent(btnempinsert, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbempplace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(cmbreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel15)))
                                .addGap(18, 18, 18)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbemp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtempsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(204, 204, 204))))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtidnumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(cmbreligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtempname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(rbcont)
                            .addComponent(rbnoncont)
                            .addComponent(cmbempplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(23, 23, 23))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(15, 15, 15)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtphonenumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)))
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(rbmale)
                            .addComponent(rbfemale)))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(txtempsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnempinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        mainPanel.add(employeePanel, "card2");

        allowancePanel.setBackground(new java.awt.Color(162, 155, 254));

        btnalinsert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnalinsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        btnalinsert.setText("Insert");
        btnalinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalinsertActionPerformed(evt);
            }
        });

        txtalauto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtalauto.setText("AUTO");

        txtalvalue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        rbt2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbt2.setText("Object");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setText("Allowance Type");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel24.setText("Search :");

        tblal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Allowance", "Allowance Name", "Allowance Value", "Allowance Type", "Allowance Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblal.getTableHeader().setReorderingAllowed(false);
        tblal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblal);

        txtalname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnalcancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnalcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        btnalcancel.setText("Cancel");
        btnalcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalcancelActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setText("ID Allowance");

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ALLOWANCE");

        txtalsearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtalsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalsearchActionPerformed(evt);
            }
        });
        txtalsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtalsearchKeyReleased(evt);
            }
        });

        cmbal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Allowance", "Allowance Name", "Allowance Value", "Alowance Type", "Allowance Status" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel27.setText("Allowance Status");

        btnalsave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnalsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface (1).png"))); // NOI18N
        btnalsave.setText("Save");
        btnalsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalsaveActionPerformed(evt);
            }
        });

        rbs1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbs1.setSelected(true);
        rbs1.setText("Active");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setText("Allowance Name");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel29.setText("In Coulumn :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel30.setText("Allowance Value");

        rbs2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbs2.setText("Non Active");

        rbt1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbt1.setSelected(true);
        rbt1.setText("Money");

        javax.swing.GroupLayout allowancePanelLayout = new javax.swing.GroupLayout(allowancePanel);
        allowancePanel.setLayout(allowancePanelLayout);
        allowancePanelLayout.setHorizontalGroup(
            allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allowancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(allowancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtalsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbal, 0, 395, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, allowancePanelLayout.createSequentialGroup()
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(allowancePanelLayout.createSequentialGroup()
                                .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtalauto)
                                    .addGroup(allowancePanelLayout.createSequentialGroup()
                                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbt1)
                                            .addComponent(rbs1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbs2)
                                            .addComponent(rbt2)))
                                    .addComponent(txtalvalue)
                                    .addComponent(txtalname)))
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnalcancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnalsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnalinsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        allowancePanelLayout.setVerticalGroup(
            allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allowancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, allowancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalauto)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(6, 6, 6)
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbt1)
                            .addComponent(rbt2)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbs1)
                            .addComponent(rbs2)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnalinsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnalsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnalcancel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(allowancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtalsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(allowancePanel, "card3");

        attendancePanel.setBackground(new java.awt.Color(162, 155, 254));

        rbabsent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbabsent.setText("Absent");

        btnattsave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnattsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface (1).png"))); // NOI18N
        btnattsave.setText("Save");
        btnattsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattsaveActionPerformed(evt);
            }
        });

        cmbatt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbatt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel31.setText("Identity Number");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel32.setText("In Coulumn :");

        txtattsearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtattsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtattsearchActionPerformed(evt);
            }
        });
        txtattsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtattsearchKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ATTENDANCE");

        cmbattcari.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbattcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Identity Number", "Date", "Attendance", "Description" }));

        rbpermit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbpermit.setText("Permit");

        rbpresent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbpresent.setSelected(true);
        rbpresent.setText("Present");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel34.setText("Search :");

        tblattendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identity Number", "Date", "Attendance", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblattendance.getTableHeader().setReorderingAllowed(false);
        tblattendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblattendanceMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblattendance);

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        jButton8.setText("Cancel");

        btnattfree.setText("jButton4");
        btnattfree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattfreeActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel35.setText("Date");

        lblattdate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblattdate.setText("jLabel6");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel44.setText("From Date :");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel45.setText("Attendance");

        rbsick.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbsick.setText("Sick");
        rbsick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsickActionPerformed(evt);
            }
        });

        btnattinsert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnattinsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        btnattinsert.setText("Insert");
        btnattinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattinsertActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel46.setText("Until Date :");

        txtattdesc.setColumns(20);
        txtattdesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtattdesc.setLineWrap(true);
        txtattdesc.setRows(5);
        jScrollPane6.setViewportView(txtattdesc);

        rbleave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbleave.setText("Leave");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel47.setText("Description");

        javax.swing.GroupLayout attendancePanelLayout = new javax.swing.GroupLayout(attendancePanel);
        attendancePanel.setLayout(attendancePanelLayout);
        attendancePanelLayout.setHorizontalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcfdateatt, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(dcudateatt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnattfree, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnattsave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(btnattinsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel31)
                            .addComponent(jLabel45)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(attendancePanelLayout.createSequentialGroup()
                                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbleave)
                                    .addComponent(rbsick))
                                .addGap(35, 35, 35)
                                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbabsent)
                                    .addComponent(rbpresent)))
                            .addComponent(cmbatt, 0, 168, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblattdate)
                            .addComponent(rbpermit)))
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(txtattsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbattcari, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        attendancePanelLayout.setVerticalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(14, 14, 14)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(lblattdate))
                        .addGap(18, 18, 18)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbsick)
                            .addComponent(rbpresent)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbleave)
                            .addComponent(rbabsent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbpermit)
                        .addGap(18, 18, 18)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnattinsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnattsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(btnattfree, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attendancePanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel44))
                            .addGroup(attendancePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dcfdateatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46)
                    .addComponent(dcudateatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtattsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbattcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        mainPanel.add(attendancePanel, "card4");

        salaryPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("in Coulumn :");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel48.setText("Identity Number");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setText("AUTO");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        jButton4.setText("Cancel");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel50.setText("ID Salary");

        cmbsaliden.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbsaliden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel51.setText("Search :");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel52.setText("From Date :");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel53.setText("----------------------------------------------------------------------------------------------");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel54.setText("Until Date :");

        tblsalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Salary", "Identity Number", "Date", "Basic Salary", "Allowance Total", "Fine Total", "Total Salary", "Executor", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsalary.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tblsalary);

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("SALARY PAYMENT");

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel56.setText("Description");

        jLabel93.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel93.setText("Employee Salary  :");

        txttax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttaxActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel94.setText("Tax                        :");

        jLabel95.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel95.setText("Net Salary             :");

        jButton14.setText("OK");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Clear");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Exit");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salaryPanelLayout = new javax.swing.GroupLayout(salaryPanel);
        salaryPanel.setLayout(salaryPanelLayout);
        salaryPanelLayout.setHorizontalGroup(
            salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel48)
                            .addComponent(jLabel56))
                        .addGap(14, 14, 14)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel49)
                            .addComponent(cmbsaliden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14))
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel94)
                            .addComponent(jLabel93)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsal, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txttax)
                            .addComponent(txtnetsal))))
                .addGap(6, 6, 6)
                .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salaryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel54))
                            .addGroup(salaryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        salaryPanelLayout.setVerticalGroup(
            salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(cmbsaliden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnetsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addGap(35, 35, 35)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16)
                            .addComponent(jButton15)
                            .addComponent(jButton14)))
                    .addGroup(salaryPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salaryPanelLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51)))
                            .addGroup(salaryPanelLayout.createSequentialGroup()
                                .addGroup(salaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel52))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53)))))
                .addContainerGap(312, Short.MAX_VALUE))
        );

        mainPanel.add(salaryPanel, "card5");

        professionalityPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel57.setText("Professionality Level");

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("PROFESSIONALITY");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel59.setText("Professionality");

        cmbpro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbpro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Professionality", "Professionality", "Basic Salary", "Professionality Allowance", "Professionality Level", "Professionality Status" }));

        txtprosearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtprosearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprosearchActionPerformed(evt);
            }
        });
        txtprosearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprosearchKeyReleased(evt);
            }
        });

        tblpro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Professionality", "Professionality", "Basic Salary", "Professinality Allowance", "Professionality Level", "Professionality Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpro.getTableHeader().setReorderingAllowed(false);
        tblpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblproMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblpro);

        txtprosalary.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cmbprolvl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbprolvl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        txtproallo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        rbproactive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbproactive.setSelected(true);
        rbproactive.setText("Active");

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        jButton6.setText("Cancel");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel60.setText("Professionality Status");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel61.setText("Search :");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel62.setText("Professionality Allowance");

        txtproname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel63.setText("Basic Salary");

        btnproinsert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnproinsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface.png"))); // NOI18N
        btnproinsert.setText("Insert");
        btnproinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproinsertActionPerformed(evt);
            }
        });

        rbprononactive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbprononactive.setText("Non Active");

        btnprosave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnprosave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface.png"))); // NOI18N
        btnprosave.setText("Save");
        btnprosave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprosaveActionPerformed(evt);
            }
        });

        lblproauto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblproauto.setText("AUTO");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel65.setText("ID Professionality");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel66.setText("In Coulumn :");

        javax.swing.GroupLayout professionalityPanelLayout = new javax.swing.GroupLayout(professionalityPanel);
        professionalityPanel.setLayout(professionalityPanelLayout);
        professionalityPanelLayout.setHorizontalGroup(
            professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professionalityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(professionalityPanelLayout.createSequentialGroup()
                                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtprosearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbpro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(btnprosave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnproinsert)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, professionalityPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(rbproactive)
                                .addGap(18, 18, 18)
                                .addComponent(rbprononactive)
                                .addGap(41, 41, 41))))
                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addGroup(professionalityPanelLayout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtprosalary, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtproname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtproallo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbprolvl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel59)
                            .addComponent(jLabel63)
                            .addComponent(jLabel62)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(professionalityPanelLayout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addGap(95, 95, 95)
                                .addComponent(lblproauto))
                            .addComponent(jLabel66))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        professionalityPanelLayout.setVerticalGroup(
            professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professionalityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblproauto)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtproname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprosalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtproallo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbprolvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbproactive)
                            .addComponent(rbprononactive)
                            .addComponent(jLabel60))
                        .addGap(14, 14, 14)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(btnprosave)
                            .addComponent(btnproinsert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprosearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        mainPanel.add(professionalityPanel, "card6");

        accountPanel.setBackground(new java.awt.Color(162, 155, 254));

        btnaccsave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnaccsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface (1).png"))); // NOI18N
        btnaccsave.setText("Save");
        btnaccsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccsaveActionPerformed(evt);
            }
        });

        cmbacciden.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbacciden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel64.setText("Search :");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel67.setText("Account Status");

        rbaccactive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbaccactive.setText("Active");

        rbaccnonactive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbaccnonactive.setSelected(true);
        rbaccnonactive.setText("Non Active");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbaccactive)
                    .addComponent(rbaccnonactive))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbaccactive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbaccnonactive)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel68.setText("Identity Number");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel69.setText("Password");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel70.setText("In Coulumn :");

        txtaccuser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtaccuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccuserActionPerformed(evt);
            }
        });

        tblacc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblacc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Identity Number", "Account Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblacc.getTableHeader().setReorderingAllowed(false);
        tblacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaccMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblacc);

        cmbaccount.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbaccount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Username", "Password", "Identity Number", "Account Status" }));

        txtaccsearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtaccsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccsearchActionPerformed(evt);
            }
        });
        txtaccsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtaccsearchKeyReleased(evt);
            }
        });

        txtaccpass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtaccpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccpassActionPerformed(evt);
            }
        });

        btnaccinsert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnaccinsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        btnaccinsert.setText("Insert");
        btnaccinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccinsertActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel71.setText("Username");

        jLabel72.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("ACCOUNT");

        btnacccancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnacccancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        btnacccancel.setText("Cancel");
        btnacccancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacccancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaccsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbaccount, 0, 426, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, accountPanelLayout.createSequentialGroup()
                        .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, accountPanelLayout.createSequentialGroup()
                                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel67))
                                .addGap(18, 18, 18)
                                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtaccpass)
                                    .addComponent(txtaccuser)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbacciden, 0, 150, Short.MAX_VALUE)))
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnacccancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaccinsert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaccsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaccuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaccpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbacciden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnaccinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnaccsave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnacccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaccsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbaccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(accountPanel, "card7");

        specialdayPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel73.setText("Date");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel74.setText("In Coulumn :");

        jLabel75.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("SPECIAL DAY");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel76.setText("Religion");

        txtspdaydesc.setColumns(20);
        txtspdaydesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtspdaydesc.setLineWrap(true);
        txtspdaydesc.setRows(5);
        jScrollPane10.setViewportView(txtspdaydesc);

        rbeventno.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbeventno.setText("No");

        rbother.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbother.setText("Other");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel77.setText("Date Name");

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        jButton7.setText("Insert");

        txtspdaynama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        jButton9.setText("Cancel");

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface (1).png"))); // NOI18N
        jButton10.setText("Save");

        rbhindu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbhindu.setText("Hindu");

        tblspday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Special", "Date Name", "Date", "Every Year Event", "Religion", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblspday.getTableHeader().setReorderingAllowed(false);
        tblspday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspdayMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblspday);

        rbeventyes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbeventyes.setSelected(true);
        rbeventyes.setText("Yes");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel78.setText("Search :");

        rbgeneral.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbgeneral.setSelected(true);
        rbgeneral.setText("General");

        lblspdayauto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblspdayauto.setText("AUTO");

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel80.setText("Every Year Event");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel81.setText("ID Special");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel82.setText("Description");

        cmbspday.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbspday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id Special", "Date Name", "Date", "Every year event", "Religion", "Description" }));

        txtspdaysearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtspdaysearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtspdaysearchActionPerformed(evt);
            }
        });
        txtspdaysearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtspdaysearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtspdaysearchKeyTyped(evt);
            }
        });

        rbislam.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbislam.setText("Islam");

        rbbuddha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbbuddha.setText("Budha");

        rbchristian.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbchristian.setText("Christian");

        javax.swing.GroupLayout specialdayPanelLayout = new javax.swing.GroupLayout(specialdayPanel);
        specialdayPanel.setLayout(specialdayPanelLayout);
        specialdayPanelLayout.setHorizontalGroup(
            specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialdayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(specialdayPanelLayout.createSequentialGroup()
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel80))
                                .addComponent(jLabel82)
                                .addComponent(jLabel77)
                                .addComponent(jLabel81)
                                .addComponent(jLabel73))
                            .addComponent(jButton9))
                        .addGap(2, 2, 2)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(specialdayPanelLayout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10))
                            .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblspdayauto)
                                .addGroup(specialdayPanelLayout.createSequentialGroup()
                                    .addComponent(rbeventyes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbeventno))
                                .addGroup(specialdayPanelLayout.createSequentialGroup()
                                    .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbgeneral)
                                        .addComponent(rbhindu))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbbuddha)
                                        .addComponent(rbislam))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbchristian)
                                        .addComponent(rbother)))
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txtspdaynama)
                                .addComponent(datespday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(specialdayPanelLayout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtspdaysearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbspday, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        specialdayPanelLayout.setVerticalGroup(
            specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialdayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(specialdayPanelLayout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblspdayauto)
                            .addComponent(jLabel81))
                        .addGap(6, 6, 6)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtspdaynama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(datespday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbeventyes)
                            .addComponent(rbeventno)
                            .addComponent(jLabel80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbgeneral)
                            .addComponent(rbislam)
                            .addComponent(rbchristian)
                            .addComponent(jLabel76))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbhindu)
                            .addComponent(rbbuddha)
                            .addComponent(rbother))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton7)
                    .addComponent(jButton9)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtspdaysearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbspday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(362, Short.MAX_VALUE))
        );

        mainPanel.add(specialdayPanel, "card8");

        specialpaymentPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel79.setText("Until Date :");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel83.setText("From Date :");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel84.setText("in Coulumn :");

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technology.png"))); // NOI18N
        jButton11.setText("Insert");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel85.setText("Search :");

        cmbpayiden.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbpayiden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel86.setText("ID Payment");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane12.setViewportView(jTextArea2);

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel87.setText("ID Special Day");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel88.setText("Identity Number");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel89.setText("Description");

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel90.setText("Payment Value");

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbpayid.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbpayid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shapes-and-symbols.png"))); // NOI18N
        jButton13.setText("Cancel");

        jLabel91.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("SPECIAL PAYMENT");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField2.setToolTipText("");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        tblsppayment.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblsppayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Payment", "Identity Number", "ID Special Day", "Date", "Payment Value", "Executor", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsppayment.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tblsppayment);

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel92.setText("AUTO");

        javax.swing.GroupLayout specialpaymentPanelLayout = new javax.swing.GroupLayout(specialpaymentPanel);
        specialpaymentPanel.setLayout(specialpaymentPanelLayout);
        specialpaymentPanelLayout.setHorizontalGroup(
            specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                                .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel89)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel88)
                                    .addComponent(jLabel87)
                                    .addComponent(jLabel90))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbpayid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbpayiden, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92)))
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel83)
                        .addGap(8, 8, 8)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        specialpaymentPanelLayout.setVerticalGroup(
            specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79)))
                    .addGroup(specialpaymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addGap(17, 17, 17)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(jLabel92))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbpayiden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbpayid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(specialpaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83))))
                .addGap(357, 357, 357))
        );

        mainPanel.add(specialpaymentPanel, "card9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessionalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessionalityActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(professionalityPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnProfessionalityActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        // TODO add your handling code here:
        
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(employeePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllowanceActionPerformed
        // TODO add your handling code here:
        
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(allowancePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnAllowanceActionPerformed

    private void btnempinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnempinsertActionPerformed
        // TODO add your handling code here:
        String iden = txtidnumb.getText();
        String name = txtempname.getText();
        System.out.println("satu");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date tgll = new Date();
        tgll = birthdate.getDate();
        String tanggall = format1.format(tgll);
        java.sql.Date dt;
        dt = java.sql.Date.valueOf(tanggall);
        //        String birth = tanggall.toString();
        System.out.println("dua");
        String ph = "0" + txtphonenumb.getText();
        String mail = txtemail.getText();
        System.out.println("tiga");

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-mm-dd");
        Date tgll11 = new Date();
        String tanggall11 = format2.format(tgll11);
        java.sql.Date dt11;
        dt11 = java.sql.Date.valueOf(tanggall11);

                Date mulai = new Date();
                String start = mulai.toString();
        System.out.println("empat");

        String religion = cmbreligion.getSelectedItem().toString();
        String address = txtaddress.getText();
        System.out.println("lima");
        if (rbmale.isSelected()){
            String gender = "Male";
            if (rbcont.isSelected()){
                String type = "Contract";

                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date tgl = new Date();
                tgl = dateend.getDate();
                String tanggal = format.format(tgl);
                java.sql.Date dt1;
                dt1 = java.sql.Date.valueOf(tanggal);
                
                //Simpled
                //tanggall = jDateChooser3.getDate();
                
                //                Date end = dt1;
                System.out.println("enam");
                String query ="INSERT INTO [payroll].[dbo].[employee]([identity_number],[employee_name],[date_birth],[phone_number],[email],[gender],[religion],[employement_start],[employement_end],[employement_type],[address])VALUES('"+iden+"','"+name+"','"+tanggall+"','"+ph+"','"+mail+"','"+gender+"','"+religion+"','"+start+"','"+tanggall11+"','"+type+"','"+address+"')";
                executeSQLQuery(query);
                System.out.println("tujuh");
            }else if (rbnoncont.isSelected()){
                String type = "Non Contract";
                String query ="INSERT INTO [payroll].[dbo].[employee]([identity_number],[employee_name],[date_birth],[phone_number],[email],[gender],[religion],[employement_start],[employement_end],[employement_type],[address])VALUES('"+iden+"','"+name+"','"+tanggall+"','"+ph+"','"+mail+"','"+gender+"','"+religion+"','"+start+"','"+tanggall11+"','None','"+address+"')";
                executeSQLQuery(query);
                System.out.println("delapan");
            }
        }else if (rbfemale.isSelected()){
            String gender = "Female";
            if (rbcont.isSelected()){
                String type = "Contract";

                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date tgl = new Date();
                tgl = dateend.getDate();
                String tanggal = format.format(tgl);
                java.sql.Date dt1;
                dt1 = java.sql.Date.valueOf(tanggal);
                //                Date end = dt1;
                System.out.println("sembilan");
                String query ="INSERT INTO [payroll].[dbo].[employee]([identity_number],[employee_name],[date_birth],[phone_number],[email],[gender],[religion],[employement_start],[employement_end],[employement_type],[address])VALUES('"+iden+"','"+name+"','"+tanggall+"','"+ph+"','"+mail+"','"+gender+"','"+religion+"','"+start+"','"+tanggall11+"','"+type+"','"+address+"')";
                executeSQLQuery(query);
                System.out.println("sepuluh");
            }else if (rbnoncont.isSelected()){
                String type = "Non Contract";
                String query ="INSERT INTO [payroll].[dbo].[employee]([identity_number],[employee_name],[date_birth],[phone_number],[email],[gender],[religion],[employement_start],[employement_end],[employement_type],[address])VALUES('"+iden+"','"+name+"','"+tanggall+"','"+ph+"','"+mail+"','"+gender+"','"+religion+"','"+start+"','"+tanggall11+"','None','"+address+"')";
                executeSQLQuery(query);
                System.out.println("sebelas");
            }
        }
        System.out.println("dua belas");
        DefaultTableModel model = (DefaultTableModel)tblemp.getModel();
        model.setRowCount(0);
        show_data();
    }//GEN-LAST:event_btnempinsertActionPerformed
    //EXECUTE QUERY UNTUK MENU EMPLOYEE
    public void executeSQLQuery(String query)
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= query;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee userr;
            JOptionPane.showMessageDialog(null, "Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
    }
    private void txtempsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempsearchActionPerformed

    private void btnalinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalinsertActionPerformed
        // TODO add your handling code here:
        //MENU ALLOWANCE
        id_auto();
        String name = txtalname.getText();
        String value = txtalvalue.getText();
        String type,status;
        if((name.equals(""))||(value.equals(""))){
            JOptionPane.showMessageDialog(null, "Error, field cannot be empty");
        }else{
            if (rbt1.isSelected())
            {
                type = "Money";
                if(rbs1.isSelected())
                {
                    status = "Active";
                    String query ="INSERT INTO [payroll].[dbo].[allowance]([id_allowance],[allowance_name],[allowance_value],[allowance_type],[allowance_status])VALUES('"+id1+"','"+name+"','"+value+"','"+type+"','"+status+"')";
                    executeSQLQuery(query);
                }else if (rbs2.isSelected()){
                    status = "Non Active";
                    String query ="INSERT INTO [payroll].[dbo].[allowance]([id_allowance],[allowance_name],[allowance_value],[allowance_type],[allowance_status])VALUES('"+id1+"','"+name+"','"+value+"','"+type+"','"+status+"')";
                    executeSQLQuery(query);
                }

            }
            else if (rbt2.isSelected())
            {
                type = "Object";
                if(rbs1.isSelected())
                {
                    status = "Active";
                    String query ="INSERT INTO [payroll].[dbo].[allowance]([id_allowance],[allowance_name],[allowance_value],[allowance_type],[allowance_status])VALUES('"+id1+"','"+name+"','"+value+"','"+type+"','"+status+"')";
                    executeSQLQuery(query);
                }else if (rbs2.isSelected()){
                    status = "Non Active";
                    String query ="INSERT INTO [payroll].[dbo].[allowance]([id_allowance],[allowance_name],[allowance_value],[allowance_type],[allowance_status])VALUES('"+id1+"','"+name+"','"+value+"','"+type+"','"+status+"')";
                    executeSQLQuery(query);
                }
            }
            refresh();
        }
    }//GEN-LAST:event_btnalinsertActionPerformed

    private void tblalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblalMouseClicked
        // TODO add your handling code here:
        {
            int i = tblal.getSelectedRow();
            TableModel model = tblal.getModel();
            txtalauto.setText(model.getValueAt(i, 0).toString());
            txtalname.setText(model.getValueAt(i, 1).toString());
            txtalvalue.setText(model.getValueAt(i, 2).toString());

            if (model.getValueAt(i, 3).toString().equals("Money"))
            {
                rbt2.setSelected(false);
                rbt1.setSelected(true);
            }
            else if (model.getValueAt(i, 3).toString().equals("Object"))
            {
                rbt1.setSelected(false);
                rbt2.setSelected(true);
            }

            if (model.getValueAt(i, 4).toString().equals("Active"))
            {
                rbs2.setSelected(false);
                rbs1.setSelected(true);
            }
            else if (model.getValueAt(i, 4).toString().equals("Non Active"))
            {
                rbs1.setSelected(false);
                rbs2.setSelected(true);
            }
            btnalinsert.setVisible(false);
            btnalsave.setVisible(true);
        }
    }//GEN-LAST:event_tblalMouseClicked
    //EXECUTE QUERY UNTUK MENU ALLOWANCE
    public void executeSQLQuery1(String query){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= query;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            allowance userr;
            JOptionPane.showMessageDialog(null, "Success");
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//            System.out.println("error");
        }
    }
     
    public String id1;
    private void id_auto(){
        int id = tblal.getRowCount()+1;
        if (id<10)
        {
            id1 = "ALW000"+ id;
        }else if(id<100){
            id1 = "ALW00" + id;
        }else if(id<1000){
            id1 = "ALW0" + id;
        }else if(id<10000){
            id1 = "ALW" + id;
        }
        
    }
    private void btnalcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalcancelActionPerformed
        // TODO add your handling code here:
        //allowance menu
        refresh();
    }//GEN-LAST:event_btnalcancelActionPerformed

    private void txtalsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalsearchActionPerformed

    private void txtalsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalsearchKeyReleased
        // TODO add your handling code here:
        //allowance menu
        DefaultTableModel model = (DefaultTableModel)tblal.getModel();
        model.setRowCount(0);
        int cari = cmbal.getSelectedIndex();
        String tex = txtalsearch.getText();
        if (cari == 0){
            show_data_cari_allowance("id_allowance", tex);
        }else if (cari == 1){
            show_data_cari_allowance("allowance_name", tex);
        }else if (cari == 2){
            show_data_cari_allowance("allowance_value", tex);
        }else if (cari == 3){
            show_data_cari_allowance("allowance_type", tex);
        }else if (cari == 4){
            show_data_cari_allowance("allowance_status", tex);
        }
        btnalinsert.setVisible(false);
    }//GEN-LAST:event_txtalsearchKeyReleased

    private void btnalsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalsaveActionPerformed
        // TODO add your handling code here:
        //menu allowance
        String name = txtalname.getText();
        String value = txtalvalue.getText();
        String type,status;
        if((name.equals(""))||(value.equals(""))){
            JOptionPane.showMessageDialog(null, "Error, field cannot be empty");
        }else{
            if (rbt1.isSelected())
            {
                type = "Money";
                if(rbs1.isSelected())
                {
                    status = "Active";
                    String query ="UPDATE [payroll].[dbo].[allowance] SET [allowance_name] = '"+ name+"',[allowance_value] = '"+value+"',[allowance_type] = '"+type+"',[allowance_status] = '"+status+"'WHERE (id_allowance = '"+jLabel7.getText()+"')";
                    executeSQLQuery(query);
                }else if (rbs2.isSelected()){
                    status = "Non Active";
                    String query ="UPDATE [payroll].[dbo].[allowance] SET [allowance_name] = '"+ name+"',[allowance_value] = '"+value+"',[allowance_type] = '"+type+"',[allowance_status] = '"+status+"'WHERE (id_allowance = '"+jLabel7.getText()+"')";
                    executeSQLQuery(query);
                }

            }
            else if (rbt2.isSelected())
            {
                type = "Object";
                if(rbs1.isSelected())
                {
                    status = "Active";
                    String query ="UPDATE [payroll].[dbo].[allowance] SET [allowance_name] = '"+ name+"',[allowance_value] = '"+value+"',[allowance_type] = '"+type+"',[allowance_status] = '"+status+"'WHERE (id_allowance = '"+jLabel7.getText()+"')";
                    executeSQLQuery(query);
                }else if (rbs2.isSelected()){
                    status = "Non Active";
                    String query ="UPDATE [payroll].[dbo].[allowance] SET [allowance_name] = '"+ name+"',[allowance_value] = '"+value+"',[allowance_type] = '"+type+"',[allowance_status] = '"+status+"'WHERE (id_allowance = '"+jLabel7.getText()+"')";
                    executeSQLQuery(query);
                }
            }
            refresh();
        }
    }//GEN-LAST:event_btnalsaveActionPerformed
// allowance
     public ArrayList<allowance> List_cari_allowance(String kolom,String datanya){
        ArrayList<allowance> List_cari_allowance = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from allowance where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            allowance conn;
            while(rs.next()){
                conn = new allowance(rs.getString("id_allowance"),rs.getString("allowance_name"),rs.getString("allowance_value"),rs.getString("allowance_type"),rs.getString("allowance_status"));
                List_cari_allowance.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cari_allowance;
    }
    
    public void show_data_cari_allowance(String kolom1, String datanya1){
        ArrayList<allowance> List_cari_allowance = List_cari_allowance(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblal.getModel();
        Object[] row = new Object[5];
        for(int i = 0;i<List_cari_allowance.size();i++){
            row[0] = List_cari_allowance.get(i).getid_allowance();
            row[1] = List_cari_allowance.get(i).getallowance_name();
            row[2] = List_cari_allowance.get(i).getallowance_value();
            row[3] = List_cari_allowance.get(i).getallowance_type();
            row[4] = List_cari_allowance.get(i).getallowance_status();
            model.addRow(row);
        }
    }
    private void btnattsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattsaveActionPerformed
        // TODO add your handling code here:
        //menu attendance
        String identity = cmbatt.getSelectedItem().toString();
        String date = lblattdate.getText();
        String desc = txtattdesc.getText();
        String attendance;
        if (rbsick.isSelected()){
            attendance = "Sick";
            String query ="UPDATE [payroll].[dbo].[attendance] SET [attendance] = '"+ attendance+"',[description] = '"+desc+"'WHERE (identity_number = '"+identity+"')and(date = '"+date+"')";
            executeSQLQuery(query);
        }else if (rbpresent.isSelected()){
            attendance = "Present";
            String query ="UPDATE [payroll].[dbo].[attendance] SET [attendance] = '"+ attendance+"',[description] = '"+desc+"'WHERE (identity_number = '"+identity+"')and(date = '"+date+"')";
            executeSQLQuery(query);
        }else if (rbpermit.isSelected()){
            attendance = "Permit";
            String query ="UPDATE [payroll].[dbo].[attendance] SET [attendance] = '"+ attendance+"',[description] = '"+desc+"'WHERE (identity_number = '"+identity+"')and(date = '"+date+"')";
            executeSQLQuery(query);
        }else if (rbleave.isSelected()){
            attendance = "Leave";
            String query ="UPDATE [payroll].[dbo].[attendance] SET [attendance] = '"+ attendance+"',[description] = '"+desc+"'WHERE (identity_number = '"+identity+"')and(date = '"+date+"')";
            executeSQLQuery(query);
        }else if (rbabsent.isSelected()){
            attendance = "Absent";
            String query ="UPDATE [payroll].[dbo].[attendance] SET [attendance] = '"+ attendance+"',[description] = '"+desc+"'WHERE (identity_number = '"+identity+"')and(date = '"+date+"')";
            executeSQLQuery(query);
        }
        DefaultTableModel model = (DefaultTableModel)tblattendance.getModel();
        model.setRowCount(0);
        show_data2();
    }//GEN-LAST:event_btnattsaveActionPerformed

    private void txtattsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtattsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtattsearchActionPerformed

    private void txtattsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtattsearchKeyReleased
        // TODO add your handling code here:
        //SEARCH KEY MENU ATTENDANCE
        DefaultTableModel model = (DefaultTableModel)tblattendance.getModel();
        model.setRowCount(0);
        int cari = cmbattcari.getSelectedIndex();
        String tex = txtattsearch.getText();
        if (cari == 0){
            show_data_cari_attendance("identity_number", tex);
        }else if (cari == 1){
            show_data_cari_attendance("date", tex);
        }else if (cari == 2){
            show_data_cari_attendance("attendance", tex);
        }else if (cari == 3){
            show_data_cari_attendance("description", tex);
        }
    }//GEN-LAST:event_txtattsearchKeyReleased

    private void tblattendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblattendanceMouseClicked
        // TODO add your handling code here:
        //table attendance
        int i = tblattendance.getSelectedRow();
        TableModel model = tblattendance.getModel();

        int a = cmbatt.getItemCount();
        for (int b=0;b<a;b++)
        {
            String alpha = cmbatt.getItemAt(b).toString();
            String bravo = model.getValueAt(i, 0).toString();
            if (alpha.equals(bravo) )
            {
                cmbatt.setSelectedIndex(b);
                break;
            }
        }

        lblattdate.setText(model.getValueAt(i, 1).toString());

        if (model.getValueAt(i, 2).toString().equals("Sick"))
        {
            rbabsent.setSelected(false);
            rbleave.setSelected(false);
            rbpermit.setSelected(false);
            rbpresent.setSelected(false);
            rbsick.setSelected(true);
        }
        else if (model.getValueAt(i, 2).toString().equals("Present"))
        {
            rbabsent.setSelected(false);
            rbleave.setSelected(false);
            rbpermit.setSelected(false);
            rbpresent.setSelected(true);
            rbsick.setSelected(false);
        }
        else if (model.getValueAt(i, 2).toString().equals("Permit"))
        {
            rbabsent.setSelected(false);
            rbleave.setSelected(false);
            rbpermit.setSelected(true);
            rbpresent.setSelected(false);
            rbsick.setSelected(false);
        }
        else if (model.getValueAt(i, 2).toString().equals("Leave"))
        {
            rbabsent.setSelected(false);
            rbleave.setSelected(true);
            rbpermit.setSelected(false);
            rbpresent.setSelected(false);
            rbsick.setSelected(false);
        }
        else if (model.getValueAt(i, 2).toString().equals("Absent"))
        {
            rbabsent.setSelected(true);
            rbleave.setSelected(false);
            rbpermit.setSelected(false);
            rbpresent.setSelected(false);
            rbsick.setSelected(false);
        }

        txtattdesc.setText(model.getValueAt(i, 3).toString());

    }//GEN-LAST:event_tblattendanceMouseClicked
    //EXECUTE QUERY ATTENDANCE
    public void executeSQLQueryATT(String query)
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= query;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            attendance userr;
            JOptionPane.showMessageDialog(null, "Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
    }
    private void btnattfreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattfreeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblemp.getModel();
        model.setRowCount(0);

        int a = (dcfdateatt.getDate().getYear())+1900;
        int b = (dcfdateatt.getDate().getMonth())+1;
        int c = (dcfdateatt.getDate().getDate());
        int d = (dcudateatt.getDate().getYear())+1900;
        int e = (dcudateatt.getDate().getMonth())+1;
        int f = (dcudateatt.getDate().getDate());
        String tanggall = a +"-"+ b +"-"+ c;
        String tanggall1 = d +"-"+ e +"-"+ f;
        show_data_cari_attendance("date", tanggall+"')or(date <='"+tanggall1+"')and(date >='"+tanggall);
        System.out.println(tanggall);
        System.out.println(tanggall1);

        //        String date = (String)model.getValueAt(i, 2);
        //        try{
            //        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
            //        java.util.Date d = f.parse(date);
            //        jDateChooser1.setDate(d);
            //        }catch(Exception ex){
            //            System.out.println(ex);
            //        }

        //simpan tgl
        /**
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date tgll = new Date();
        tgll = jDateChooser1.getDate();
        String tanggall = dateFormat.format(tgll);
        java.sql.Date dt;
        dt = java.sql.Date.valueOf(tanggall);
        */
        //yg di save = tangall
    }//GEN-LAST:event_btnattfreeActionPerformed

    private void rbsickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbsickActionPerformed

    private void btnattinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattinsertActionPerformed
        // TODO add your handling code here:
        //ATTENDANCE
        String identity = cmbatt.getSelectedItem().toString();
        String date = lblattdate.getText();
        String desc = txtattdesc.getText();
        String attendance;
        if (rbsick.isSelected()){
            attendance = "Sick";
            String query ="INSERT INTO [payroll].[dbo].[attendance]([identity_number],[date],[attendance],[description])VALUES('"+identity+"','"+date+"','"+attendance+"','"+desc+"')";
            executeSQLQuery(query);
        }else if (rbpresent.isSelected()){
            attendance = "Present";
            String query ="INSERT INTO [payroll].[dbo].[attendance]([identity_number],[date],[attendance],[description])VALUES('"+identity+"','"+date+"','"+attendance+"','"+desc+"')";
            executeSQLQuery(query);
        }else if (rbpermit.isSelected()){
            attendance = "Permit";
            String query ="INSERT INTO [payroll].[dbo].[attendance]([identity_number],[date],[attendance],[description])VALUES('"+identity+"','"+date+"','"+attendance+"','"+desc+"')";
            executeSQLQuery(query);
        }else if (rbleave.isSelected()){
            attendance = "Leave";
            String query ="INSERT INTO [payroll].[dbo].[attendance]([identity_number],[date],[attendance],[description])VALUES('"+identity+"','"+date+"','"+attendance+"','"+desc+"')";
            executeSQLQuery(query);
        }else if (rbabsent.isSelected()){
            attendance = "Absent";
            String query ="INSERT INTO [payroll].[dbo].[attendance]([identity_number],[date],[attendance],[description])VALUES('"+identity+"','"+date+"','"+attendance+"','"+desc+"')";
            executeSQLQuery(query);
        }
        DefaultTableModel model = (DefaultTableModel)tblattendance.getModel();
        model.setRowCount(0);
        show_data2();
    }//GEN-LAST:event_btnattinsertActionPerformed

    //ATTENDANCE ARRAY LIST
    public ArrayList<attendance> List_cariattendance(String kolom,String datanya){
        ArrayList<attendance> List_cariattendance = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from attendance where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            attendance conn;
            while(rs.next()){
                conn = new attendance(rs.getString("identity_number"),rs.getString("date"),rs.getString("attendance"),rs.getString("description"));
                List_cariattendance.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cariattendance;
    }
    
    public void show_data_cari_attendance(String kolom1, String datanya1){
        ArrayList<attendance> List_cariattendance = List_cariattendance(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblattendance.getModel();
        Object[] row = new Object[4];
        for(int i = 0;i<List_cariattendance.size();i++){
            row[0] = List_cariattendance.get(i).getidentity_number();
            row[1] = List_cariattendance.get(i).getdate();
            row[2] = List_cariattendance.get(i).getattendance();
            row[3] = List_cariattendance.get(i).getdescription();
            model.addRow(row);
        }
    }
    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(attendancePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        show_data1();
        id_auto();
    }//GEN-LAST:event_formWindowActivated

    private void tblempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblempMouseClicked
        // TODO add your handling code here:
        int i = tblemp.getSelectedRow();
        TableModel model = tblemp.getModel();
        txtidnumb.setText(model.getValueAt(i, 0).toString());
        txtempname.setText(model.getValueAt(i, 1).toString());

        String date = (String)model.getValueAt(i, 2);
        try{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date d = f.parse(date);
            birthdate.setDate(d);
        }catch(Exception ex){
            System.out.println(ex);
        }

        String a = model.getValueAt(i, 3).toString();
        int b = a.length();
        String c = model.getValueAt(i, 3).toString().substring(1, b);
        txtphonenumb.setText(c);

        txtemail.setText(model.getValueAt(i, 4).toString());

        if (model.getValueAt(i, 5).toString().equals("Male"))
        {
            rbfemale.setSelected(false);
            rbmale.setSelected(true);
        }
        else if (model.getValueAt(i, 5).toString().equals("Female"))
        {
            rbmale.setSelected(false);
            rbfemale.setSelected(true);
        }

        int d = cmbreligion.getItemCount();
        for (int e=0;e<d;e++)
        {
            String alpha = cmbreligion.getItemAt(e).toString();
            String bravo = model.getValueAt(i, 6).toString();
            if (alpha.equals(bravo) )
            {
                cmbreligion.setSelectedIndex(e);
                break;
            }
        }

        if (model.getValueAt(i, 9).toString().equals("Contract"))
        {
            rbnoncont.setSelected(false);
            rbcont.setSelected(true);
            String date1 = (String)model.getValueAt(i, 8);
            try{
                SimpleDateFormat f1 = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date d1 = f1.parse(date1);
                dateend.setDate(d1);
            }catch(Exception exm){
                System.out.println(exm);
            }
        }
        else if (model.getValueAt(i, 9).toString().equals("Non Contract"))
        {
            rbcont.setSelected(false);
            rbnoncont.setSelected(true);
        }

        txtaddress.setText(model.getValueAt(i, 10).toString());
    }//GEN-LAST:event_tblempMouseClicked

    private void btnsalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalaryActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(salaryPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnsalaryActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtprosearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprosearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprosearchActionPerformed

    private void txtprosearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprosearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblpro.getModel();
        model.setRowCount(0);
        int cari = cmbpro.getSelectedIndex();
        String tex = txtprosearch.getText();
        if (cari == 0){
            show_data_cari_professionality("id_professionality", tex);
        }else if (cari == 1){
            show_data_cari_professionality("professionality", tex);
        }else if (cari == 2){
            show_data_cari_professionality("basic_salary", tex);
        }else if (cari == 3){
            show_data_cari_professionality("professionality_allowance", tex);
        }else if (cari == 4){
            show_data_cari_professionality("professionality_level", tex);
        }else if (cari == 5){
            show_data_cari_professionality("professionality_status", tex);
        }
    }//GEN-LAST:event_txtprosearchKeyReleased

    private void tblproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblproMouseClicked
        // TODO add your handling code here:
        int i = tblpro.getSelectedRow();
        TableModel model = tblpro.getModel();
        lblproauto.setText(model.getValueAt(i, 0).toString());
        txtproname.setText(model.getValueAt(i, 1).toString());
        txtprosalary.setText(model.getValueAt(i, 2).toString());
        txtproallo.setText(model.getValueAt(i, 3).toString());

        int a = cmbprolvl.getItemCount();
        for (int b=0;b<a;b++)
        {
            String alpha = cmbprolvl.getItemAt(b).toString();
            String bravo = model.getValueAt(i, 4).toString();
            if (alpha.equals(bravo) )
            {
                cmbprolvl.setSelectedIndex(b);
                break;
            }
        }

        if (model.getValueAt(i, 5).toString().equals("Active"))
        {
            rbprononactive.setSelected(false);
            rbproactive.setSelected(true);
        }
        else if (model.getValueAt(i, 5).toString().equals("Non Active"))
        {
            rbproactive.setSelected(false);
            rbprononactive.setSelected(true);
        }
    }//GEN-LAST:event_tblproMouseClicked

    //EXECUTE QUERY MENU PROFESSIONALITY
    public void executeSQLQueryProfessionality(String query)
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= query;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Professionality userr;
            JOptionPane.showMessageDialog(null, "Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
    }
    public String id12;
    private void id_auto2(){
        int id = tblpro.getRowCount()+1;
        if (id<10)
        {
            id1 = "PRF000"+ id;
        }else if(id<100){
            id1 = "PRF00" + id;
        }else if(id<1000){
            id1 = "PRF0" + id;
        }else if(id<10000){
            id1 = "PRF" + id;
        }
    }
    
    private void btnproinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproinsertActionPerformed
        // TODO add your handling code here:
        id_auto2();
        String id11 = id12;
        String name = txtproname.getText();
        String basic = txtprosalary.getText();
        String alw = txtproallo.getText();
        String level = cmbprolvl.getSelectedItem().toString();
        String status;
        if (rbproactive.isSelected())
        {
            status = "Active";
            String query ="INSERT INTO [payroll].[dbo].[professionality]([id_professionality],[professionality],[basic_salary],[professionality_allowance],[professionality_level],[professionality_status])VALUES('"+id11+"','"+name+"','"+basic+"','"+alw+"','"+level+"','"+status+"')";
            executeSQLQuery(query);
        }
        else if (rbprononactive.isSelected())
        {
            status = "Non Active";
            String query ="INSERT INTO [payroll].[dbo].[professionality]([id_professionality],[professionality],[basic_salary],[professionality_allowance],[professionality_level],[professionality_status])VALUES('"+id11+"','"+name+"','"+basic+"','"+alw+"','"+level+"','"+status+"')";
            executeSQLQuery(query);
        }
        DefaultTableModel model = (DefaultTableModel)tblpro.getModel();
        model.setRowCount(0);
        show_data4();
    }//GEN-LAST:event_btnproinsertActionPerformed

    private void btnprosaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprosaveActionPerformed
        // TODO add your handling code here:
        //PROFESSIONALITY SAVE BUTTON
        String id11 = lblproauto.getText();
        String name = txtproname.getText();
        String basic = txtprosalary.getText();
        String alw = txtproallo.getText();
        String level = cmbprolvl.getSelectedItem().toString();
        String status;
        if (rbproactive.isSelected())
        {
            status = "Active";
            String query ="UPDATE [payroll].[dbo].[professionality] SET [professionality] = '"+ name+"',[basic_salary] = '"+basic+"',[professionality_allowance] = '"+alw+"',[professionality_level] = '"+level+"',[professionality_status] = '"+status+"'WHERE (id_professionality = '"+lblproauto.getText()+"')";
            executeSQLQuery(query);
        }
        else if (rbprononactive.isSelected())
        {
            status = "Non Active";
            String query ="UPDATE [payroll].[dbo].[professionality] SET [professionality] = '"+ name+"',[basic_salary] = '"+basic+"',[professionality_allowance] = '"+alw+"',[professionality_level] = '"+level+"',[professionality_status] = '"+status+"'WHERE (id_professionality = '"+lblproauto.getText()+"')";
            executeSQLQuery(query);
        }
        DefaultTableModel model = (DefaultTableModel)tblpro.getModel();
        model.setRowCount(0);
        show_data4();
    }//GEN-LAST:event_btnprosaveActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(accountPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnaccsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccsaveActionPerformed
        // TODO add your handling code here:
        String username = txtaccuser.getText();
        String password = txtaccpass.getText();
        String identity = cmbacciden.getSelectedItem().toString().substring(0, 18);
        String status;
        if ("".equals(password)){
            JOptionPane.showMessageDialog(null, "Empty Field Not allowed");
        }else{
            if (rbaccactive.isSelected())
            {
                status = "Active";
                String query ="UPDATE [payroll].[dbo].[account] SET [password] = '"+ password+"',[account_status] = '"+status+"'WHERE (username = '"+username+"')and(identity_number = '"+identity+"')";
                executeSQLQuery(query);
            }
            else if (rbaccnonactive.isSelected())
            {
                status = "Non Active";
                String query ="UPDATE [payroll].[dbo].[account] SET [password] = '"+ password+"',[account_status] = '"+status+"'WHERE (username = '"+username+"')and(identity_number = '"+identity+"')";
                executeSQLQuery(query);
            }
            DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
            model.setRowCount(0);
            show_data5();
            refresh1();
        }
    }//GEN-LAST:event_btnaccsaveActionPerformed

    private void refresh1(){
        txtaccuser.setText("");
        txtaccpass.setText("");
        txtaccsearch.setText("");
        cmbacciden.setSelectedIndex(0);
        cmbaccount.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
        model.setRowCount(0);
        show_data5();
        rbaccnonactive.setSelected(false);
        rbaccactive.setSelected(true);
        btnaccsave.setVisible(false);
        btnaccinsert.setVisible(true);
        txtaccuser.setEnabled(true);
        cmbacciden.setEnabled(true);
    }
    private void txtaccuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccuserActionPerformed

    private void tblaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaccMouseClicked
        int i = tblacc.getSelectedRow();
        TableModel model = tblacc.getModel();
        txtaccuser.setText(model.getValueAt(i, 0).toString());
        txtaccpass.setText(model.getValueAt(i, 1).toString());

        int a = cmbacciden.getItemCount();
        for (int b=0;b<a;b++)
        {
            String alpha = cmbacciden.getItemAt(b).toString().substring(0, 18);
            String bravo = model.getValueAt(i, 2).toString();
            if (alpha.equals(bravo) )
            {
                cmbacciden.setSelectedIndex(b);
                break;
            }
        }
        if (model.getValueAt(i, 3).toString().equals("Active"))
        {
            rbaccnonactive.setSelected(false);
            rbaccactive.setSelected(true);
        }
        else if (model.getValueAt(i, 3).toString().equals("Non Active"))
        {
            rbaccactive.setSelected(false);
            rbaccnonactive.setSelected(true);
        }
        btnaccinsert.setVisible(false);
        btnaccsave.setVisible(true);
        txtaccuser.setEnabled(false);
        cmbacciden.setEnabled(false);
    }//GEN-LAST:event_tblaccMouseClicked

    //EXECUTE QUERY ACCOUNT
    public void executeSQLQueryACC(String query){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= query;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            account userr;
            JOptionPane.showMessageDialog(null, "Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Wrong. Username or Identity Number already used by an account");
            System.out.println("error");
        }
    }
    private void txtaccsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccsearchActionPerformed

    private void txtaccsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccsearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
        model.setRowCount(0);
        int cari = cmbaccount.getSelectedIndex();
        String tex = txtaccsearch.getText();
        if(tex == ""){

        }
        else{
            if (cari == 0){
                show_data_cari_account("username", tex);
            }else if (cari == 1){
                show_data_cari_account("password", tex);
            }else if (cari == 2){
                show_data_cari_account("identity_number", tex);
            }else if (cari == 3){
                show_data_cari_account("account_status", tex);
            }
        }
        btnaccinsert.setVisible(false);
    }//GEN-LAST:event_txtaccsearchKeyReleased

    private void txtaccpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccpassActionPerformed

    private void btnaccinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccinsertActionPerformed
        String username = txtaccuser.getText();
        String password = txtaccpass.getText();
        String identity = cmbacciden.getSelectedItem().toString().substring(0, 18);
        String status;
        if ((username.equals("")) || (password.equals(""))){
            JOptionPane.showMessageDialog(null, "Empty Field Not allowed");
        }else{
            if (rbaccactive.isSelected())
            {
                status = "Active";
                String query ="INSERT INTO [payroll].[dbo].[account]([username],[password],[identity_number],[account_status])VALUES('"+username+"','"+password+"','"+identity+"','"+status+"')";
                executeSQLQuery(query);
            }
            else if (rbaccnonactive.isSelected())
            {
                status = "Non Active";
                String query ="INSERT INTO [payroll].[dbo].[account]([username],[password],[identity_number],[account_status])VALUES('"+username+"','"+password+"','"+identity+"','"+status+"')";
                executeSQLQuery(query);
            }
            DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
            model.setRowCount(0);
            show_data5();
            refresh1();
        }
    }//GEN-LAST:event_btnaccinsertActionPerformed

    //MENU ACCOUNT
    public ArrayList<account> List_cari_account(String kolom,String datanya){
        ArrayList<account> List_cari_account = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from account where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            account conn;
            while(rs.next()){
                conn = new account(rs.getString("username"),rs.getString("password"),rs.getString("identity_number"),rs.getString("account_status"));
                List_cari_account.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cari_account;
    }
    
    public void show_data_cari_account(String kolom1, String datanya1){
        ArrayList<account> List_cari_account = List_cari_account(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblacc.getModel();
        Object[] row = new Object[5];
        for(int i = 0;i<List_cari_account.size();i++){
            row[0] = List_cari_account.get(i).getusername();
            row[1] = List_cari_account.get(i).getpassword();
            row[2] = List_cari_account.get(i).getidentity_number();
            row[3] = List_cari_account.get(i).getaccount_status();
            model.addRow(row);
        }
    }
    private void btnacccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacccancelActionPerformed
        // TODO add your handling code here:
        refresh1();
    }//GEN-LAST:event_btnacccancelActionPerformed

    private void btnspecialdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnspecialdayActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(specialdayPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnspecialdayActionPerformed

    private void tblspdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspdayMouseClicked
        // TODO add your handling code here:
        int i = tblspday.getSelectedRow();
        TableModel model = tblspday.getModel();
        lblspdayauto.setText(model.getValueAt(i, 0).toString());
        txtspdaynama.setText(model.getValueAt(i, 1).toString());

        Date tgl = new Date();
        tgl.setDate((int) model.getValueAt(i, 2));
        datespday.setDate(tgl);

        if (model.getValueAt(i, 3).toString().equals("Yes"))
        {
            rbeventno.setSelected(false);
            rbeventyes.setSelected(true);
        }
        else if (model.getValueAt(i, 3).toString().equals("No"))
        {
            rbeventyes.setSelected(false);
            rbeventno.setSelected(true);
        }

        if (model.getValueAt(i, 4).toString().equals("General"))
        {
            rbother.setSelected(false);
            rbbuddha.setSelected(false);
            rbhindu.setSelected(false);
            rbchristian.setSelected(false);
            rbislam.setSelected(false);
            rbgeneral.setSelected(true);
        }
        else if (model.getValueAt(i, 4).toString().equals("Islam"))
        {
            rbother.setSelected(false);
            rbbuddha.setSelected(false);
            rbhindu.setSelected(false);
            rbchristian.setSelected(false);
            rbgeneral.setSelected(false);
            rbislam.setSelected(true);
        }
        else if (model.getValueAt(i, 4).toString().equals("Christian"))
        {
            rbother.setSelected(false);
            rbbuddha.setSelected(false);
            rbhindu.setSelected(false);
            rbgeneral.setSelected(false);
            rbislam.setSelected(false);
            rbchristian.setSelected(true);
        }
        else if (model.getValueAt(i, 4).toString().equals("Hindu"))
        {
            rbother.setSelected(false);
            rbbuddha.setSelected(false);
            rbchristian.setSelected(false);
            rbgeneral.setSelected(false);
            rbislam.setSelected(false);
            rbhindu.setSelected(true);
        }
        else if (model.getValueAt(i, 4).toString().equals("Budha"))
        {
            rbother.setSelected(false);
            rbchristian.setSelected(false);
            rbhindu.setSelected(false);
            rbgeneral.setSelected(false);
            rbislam.setSelected(false);
            rbbuddha.setSelected(true);
        }
        else if (model.getValueAt(i, 4).toString().equals("Other"))
        {
            rbchristian.setSelected(false);
            rbbuddha.setSelected(false);
            rbhindu.setSelected(false);
            rbgeneral.setSelected(false);
            rbislam.setSelected(false);
            rbother.setSelected(true);
        }

        txtspdaydesc.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_tblspdayMouseClicked

    private void txtspdaysearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspdaysearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspdaysearchActionPerformed

    private void txtspdaysearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtspdaysearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspdaysearchKeyTyped

    private void btnsppaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsppaymentActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(specialpaymentPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnsppaymentActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
//private int check()
//    {   int f=1;
//        if(txtcpuser.getText().equals(""))
//        {    JOptionPane.showMessageDialog(null,"Username can't be empty!!!");
//             f=0;  
//        }
//        else if(txtcpold.getText().equals(""))
//        {
//            JOptionPane.showMessageDialog(null,"Old Password Field can't be empty!!!");
//            f=0;
//        }
//        else if(txtnewpw.getText().equals(""))
//        {
//            JOptionPane.showMessageDialog(null,"New Password Field can't be empty!!!");
//            f=0;
//        }
//        Pattern p=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//        Matcher m=p.matcher(txtcpuser.getText());
//        boolean b1=m.matches();
//        Boolean b2=Pattern.compile("[a-zA-Z0-9@#$]+{8,15}").matcher(txtcpold.getText()).matches();
//        Boolean b3=Pattern.compile("[a-zA-Z0-9@#$]+{8,15}").matcher(txtnewpw.getText()).matches();
//        if(b1==false)
//        {
//            JOptionPane.showMessageDialog(null,"Not a valid email id");
//            f=0;
//        }
//        else if(b2==false)
//        {
//            JOptionPane.showMessageDialog(null,"Wrong Password Format!!!");
//            f=0;
//        }
//        else if(b3==false)
//        {
//            JOptionPane.showMessageDialog(null,"Wrong Password Format!!!");
//            f=0;
//        }
//        if(txtcpold.getText().equals(txtnewpw.getText()))
//        {
//            f=0;
//            JOptionPane.showMessageDialog(null,"Can't assign the same password");
//        }
//        try
//        {     
//            if(cp1.getText().equals(txtcpuser.getText()) && cp2.getText().equals(txtcpold.getText()))
//                f=1;
//            else
//            {   
//                f=0;
//                JOptionPane.showMessageDialog(null,"Wrong Email id or password!!");
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,e);
//        }
//        if(f==1)
//            return 1;
//        else
//            return 0;
//    }
    
    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MousePressed

    private void txtempsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtempsearchKeyReleased
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)tblemp.getModel();
        model.setRowCount(0);
        int cari = cmbemp.getSelectedIndex();
        String tex = txtempsearch.getText();
        if (cari == 0){
            show_data_cari_employee("identity_number", tex);
        }else if (cari == 1){
            show_data_cari_employee("employee_name", tex);
        }else if (cari == 2){
            show_data_cari_employee("date_birth", tex);
        }else if (cari == 3){
            show_data_cari_employee("phone_number", tex);
        }else if (cari == 4){
            show_data_cari_employee("email", tex);
        }else if (cari == 5){
            show_data_cari_employee("gender", tex);
        }else if (cari == 6){
            show_data_cari_employee("religion", tex);
        }else if (cari == 7){
            show_data_cari_employee("employement_start", tex);
        }else if (cari == 8){
            show_data_cari_employee("employement_end", tex);
        }else if (cari == 9){
            show_data_cari_employee("employement_type", tex);
        }else if (cari == 10){
            show_data_cari_employee("address", tex);
        }
    }//GEN-LAST:event_txtempsearchKeyReleased

    private void txtspdaysearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtspdaysearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblspday.getModel();
        model.setRowCount(0);
        int cari = cmbspday.getSelectedIndex();
        String tex = txtspdaysearch.getText();
        if (cari == 0){
            show_data_cari_special_day("id_special", tex);
        }else if (cari == 1){
            show_data_cari_special_day("date_name", tex);
        }else if (cari == 2){
            show_data_cari_special_day("date", tex);
        }else if (cari == 3){
            show_data_cari_special_day("every_year_event", tex);
        }else if (cari == 4){
            show_data_cari_special_day("religion", tex);
        }else if (cari == 5){
            show_data_cari_special_day("description", tex);
        }
    }//GEN-LAST:event_txtspdaysearchKeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        double salary,tax,netsal;
        salary = Double.parseDouble(txtsal.getText());

        if (salary > 5000000)
        {
            tax = salary * 10/100;
        }
        else if (salary > 3500000)
        {
            tax = salary * 5/100;
        }
        else
        {
            tax = 0;
        }

        txttax.setText(String.valueOf(tax));

        netsal = salary - tax;

        txtnetsal.setText(String.valueOf(netsal));

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        txtsal.setText("");
        txttax.setText("");
        txtnetsal.setText("");
        txtsal.requestFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void txttaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttaxActionPerformed

    //Menu Special Day
    public ArrayList<special_day> List_cari_special_day(String kolom,String datanya){
        ArrayList<special_day> List_cari_special_day = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from special_day where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            special_day conn;
            while(rs.next()){
                conn = new special_day(rs.getString("id_special"),rs.getString("date_name"),rs.getString("date"),rs.getString("every_year_event"),rs.getString("religion"),rs.getString("description"));
                List_cari_special_day.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cari_special_day;
    }
    
    public void show_data_cari_special_day(String kolom1, String datanya1){
        ArrayList<special_day> List_cari_special_day = List_cari_special_day(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblspday.getModel();
        Object[] row = new Object[6];
        for(int i = 0;i<List_cari_special_day.size();i++){
            row[0] = List_cari_special_day.get(i).getid_special();
            row[1] = List_cari_special_day.get(i).getdate_name();
            row[2] = List_cari_special_day.get(i).getdate();
            row[3] = List_cari_special_day.get(i).getevery_year_event();
            row[4] = List_cari_special_day.get(i).getreligion();
            row[5] = List_cari_special_day.get(i).getdescription();
            model.addRow(row);
        }
    }
    
    //EMPLOYEE MENU
    public ArrayList<employee> List_cari_employee(String kolom,String datanya){
        ArrayList<employee> List_cari_employee = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from employee where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            employee conn;
            while(rs.next()){
                conn = new employee(rs.getString("identity_number"),rs.getString("employee_name"),rs.getString("date_birth"),rs.getString("phone_number"),rs.getString("email"),rs.getString("gender"),rs.getString("religion"),rs.getString("employement_start"),rs.getString("employement_end"),rs.getString("employement_type"),rs.getString("address"));
                List_cari_employee.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cari_employee;
    }
    
    public void show_data_cari_employee(String kolom1, String datanya1){
        ArrayList<employee> List_cari_employee= List_cari_employee(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblemp.getModel();
        Object[] row = new Object[12];
        for(int i = 0;i<List_cari_employee.size();i++){
            row[0] = List_cari_employee.get(i).getidentity_number();
            row[1] = List_cari_employee.get(i).getemployee_name();
            row[2] = List_cari_employee.get(i).getdate_birth();
            row[3] = List_cari_employee.get(i).getphone_number();
            row[4] = List_cari_employee.get(i).getemail();
            row[5] = List_cari_employee.get(i).getgender();
            row[6] = List_cari_employee.get(i).getreligion();
            row[7] = List_cari_employee.get(i).getemployement_start();
            row[8] = List_cari_employee.get(i).getemployement_end();
            row[9] = List_cari_employee.get(i).getemployement_type();
            row[10] = List_cari_employee.get(i).getaddress();
            model.addRow(row);
        }
    }
    
    //PROFESSIONALITY
    public ArrayList<Professionality> List_cari_professionality(String kolom,String datanya){
        ArrayList<Professionality> List_cari_professionality = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Connection con = DriverManager.getConnection(url,user,pass);
            String query1= "select * from professionality where ("+kolom+"='"+datanya+"')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Professionality conn;
            while(rs.next()){
                conn = new Professionality(rs.getString("id_professionality"),rs.getString("professionality"),rs.getString("basic_salary"),rs.getString("professionality_allowance"),rs.getString("professionality_level"),rs.getString("professionality_status"));
                List_cari_professionality.add(conn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("error");
        }
        return List_cari_professionality;
    }
    
    public void show_data_cari_professionality(String kolom1, String datanya1){
        ArrayList<Professionality> List_cari_professionality = List_cari_professionality(kolom1,datanya1);
        DefaultTableModel model = (DefaultTableModel)tblpro.getModel();
        Object[] row = new Object[6];
        for(int i = 0;i<List_cari_professionality.size();i++){
            row[0] = List_cari_professionality.get(i).getId_professionality();
            row[1] = List_cari_professionality.get(i).getProfessionality();
            row[2] = List_cari_professionality.get(i).getBasic_salary();
            row[3] = List_cari_professionality.get(i).getProfessionality_allowance();
            row[4] = List_cari_professionality.get(i).getProfessionality_level();
            row[5] = List_cari_professionality.get(i).getProfessionality_status();
            model.addRow(row);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private javax.swing.JPanel allowancePanel;
    private javax.swing.JPanel attendancePanel;
    private com.toedter.calendar.JDateChooser birthdate;
    private rojerusan.RSButtonIconD btnAccount;
    private rojerusan.RSButtonIconD btnAllowance;
    private rojerusan.RSButtonIconD btnAttendance;
    private rojerusan.RSButtonIconD btnEmployee;
    private rojerusan.RSButtonIconD btnProfessionality;
    private javax.swing.JButton btnacccancel;
    private javax.swing.JButton btnaccinsert;
    private javax.swing.JButton btnaccsave;
    private javax.swing.JButton btnalcancel;
    private javax.swing.JButton btnalinsert;
    private javax.swing.JButton btnalsave;
    private javax.swing.JButton btnattfree;
    private javax.swing.JButton btnattinsert;
    private javax.swing.JButton btnattsave;
    private javax.swing.JButton btnempinsert;
    private javax.swing.JButton btnproinsert;
    private javax.swing.JButton btnprosave;
    private rojerusan.RSButtonIconD btnsalary;
    private rojerusan.RSButtonIconD btnspecialday;
    private rojerusan.RSButtonIconD btnsppayment;
    private javax.swing.JComboBox cmbacciden;
    private javax.swing.JComboBox cmbaccount;
    private javax.swing.JComboBox cmbal;
    private javax.swing.JComboBox cmbatt;
    private javax.swing.JComboBox cmbattcari;
    private javax.swing.JComboBox cmbemp;
    private javax.swing.JComboBox cmbempplace;
    private javax.swing.JComboBox cmbpayid;
    private javax.swing.JComboBox cmbpayiden;
    private javax.swing.JComboBox cmbpro;
    private javax.swing.JComboBox cmbprolvl;
    private javax.swing.JComboBox cmbreligion;
    private javax.swing.JComboBox cmbsaliden;
    private javax.swing.JComboBox cmbspday;
    private com.toedter.calendar.JDateChooser dateend;
    private com.toedter.calendar.JDateChooser datespday;
    private com.toedter.calendar.JDateChooser datestart;
    private com.toedter.calendar.JDateChooser dcfdateatt;
    private com.toedter.calendar.JDateChooser dcudateatt;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblattdate;
    private javax.swing.JLabel lblproauto;
    private javax.swing.JLabel lblspdayauto;
    private javax.swing.JPanel mainPanel;
    private keeptoo.KGradientPanel menuPanel;
    private javax.swing.JPanel professionalityPanel;
    private javax.swing.JRadioButton rbabsent;
    private javax.swing.JRadioButton rbaccactive;
    private javax.swing.JRadioButton rbaccnonactive;
    private javax.swing.JRadioButton rbbuddha;
    private javax.swing.JRadioButton rbchristian;
    private javax.swing.JRadioButton rbcont;
    private javax.swing.JRadioButton rbeventno;
    private javax.swing.JRadioButton rbeventyes;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbgeneral;
    private javax.swing.JRadioButton rbhindu;
    private javax.swing.JRadioButton rbislam;
    private javax.swing.JRadioButton rbleave;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JRadioButton rbnoncont;
    private javax.swing.JRadioButton rbother;
    private javax.swing.JRadioButton rbpermit;
    private javax.swing.JRadioButton rbpresent;
    private javax.swing.JRadioButton rbproactive;
    private javax.swing.JRadioButton rbprononactive;
    private javax.swing.JRadioButton rbs1;
    private javax.swing.JRadioButton rbs2;
    private javax.swing.JRadioButton rbsick;
    private javax.swing.JRadioButton rbt1;
    private javax.swing.JRadioButton rbt2;
    private javax.swing.JPanel salaryPanel;
    private javax.swing.JPanel specialdayPanel;
    private javax.swing.JPanel specialpaymentPanel;
    private javax.swing.JTable tblacc;
    private javax.swing.JTable tblal;
    private javax.swing.JTable tblattendance;
    private javax.swing.JTable tblemp;
    private javax.swing.JTable tblpro;
    private javax.swing.JTable tblsalary;
    private javax.swing.JTable tblspday;
    private javax.swing.JTable tblsppayment;
    private javax.swing.JTextField txtaccpass;
    private javax.swing.JTextField txtaccsearch;
    private javax.swing.JTextField txtaccuser;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JLabel txtalauto;
    private javax.swing.JTextField txtalname;
    private javax.swing.JTextField txtalsearch;
    private javax.swing.JTextField txtalvalue;
    private javax.swing.JTextArea txtattdesc;
    private javax.swing.JTextField txtattsearch;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtempname;
    private javax.swing.JTextField txtempsearch;
    private javax.swing.JTextField txtidnumb;
    private javax.swing.JTextField txtnetsal;
    private javax.swing.JTextField txtphonenumb;
    private javax.swing.JTextField txtproallo;
    private javax.swing.JTextField txtproname;
    private javax.swing.JTextField txtprosalary;
    private javax.swing.JTextField txtprosearch;
    private javax.swing.JTextField txtsal;
    private javax.swing.JTextArea txtspdaydesc;
    private javax.swing.JTextField txtspdaynama;
    private javax.swing.JTextField txtspdaysearch;
    private javax.swing.JTextField txttax;
    // End of variables declaration//GEN-END:variables
}
