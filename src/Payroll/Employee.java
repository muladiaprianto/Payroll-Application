/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;

import Main.Professionality;
import Main.attendance;
import Main.employee;
import Main.special_day;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author User
 */
public class Employee extends javax.swing.JFrame {

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        show_data();
        show_data2();
        show_data4();
        show_data6();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        employeePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbemp = new javax.swing.JComboBox();
        txtempsearch = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblemp = new javax.swing.JTable();
        attendancePanel = new javax.swing.JPanel();
        txtattsearch = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cmbattcari = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblattendance = new javax.swing.JTable();
        professionalityPanel = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        cmbpro = new javax.swing.JComboBox();
        txtprosearch = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblpro = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        specialdayPanel = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblspday = new javax.swing.JTable();
        jLabel78 = new javax.swing.JLabel();
        cmbspday = new javax.swing.JComboBox();
        txtspdaysearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menuPanel = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnEmployee = new rojerusan.RSButtonIconD();
        btnAttendance = new rojerusan.RSButtonIconD();
        btnspecialday = new rojerusan.RSButtonIconD();
        btnProfessionality = new rojerusan.RSButtonIconD();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(162, 155, 254));
        mainPanel.setLayout(new java.awt.CardLayout());

        employeePanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("EMPLOYEE MENU");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("In Coulumn :");

        cmbemp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Identity Number", "Employee Name", "Birth Date", "Phone Number", "Email", "Gender", "Religion", "Employeement Start", "Employeement End", "Employeement Type", "Address", " " }));

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

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Search :");

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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employeePanelLayout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(cmbemp, 0, 221, Short.MAX_VALUE)
                                    .addComponent(txtempsearch))
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtempsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        mainPanel.add(employeePanel, "card2");

        attendancePanel.setBackground(new java.awt.Color(162, 155, 254));

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

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel32.setText("In Coulumn :");

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ATTENDANCE");

        cmbattcari.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbattcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Identity Number", "Date", "Attendance", "Description" }));

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

        javax.swing.GroupLayout attendancePanelLayout = new javax.swing.GroupLayout(attendancePanel);
        attendancePanel.setLayout(attendancePanelLayout);
        attendancePanelLayout.setHorizontalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(txtattsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbattcari, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addContainerGap(593, Short.MAX_VALUE))
        );
        attendancePanelLayout.setVerticalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtattsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbattcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        mainPanel.add(attendancePanel, "card4");

        professionalityPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("PROFESSIONALITY");

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

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel61.setText("Search :");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel66.setText("In Coulumn :");

        javax.swing.GroupLayout professionalityPanelLayout = new javax.swing.GroupLayout(professionalityPanel);
        professionalityPanel.setLayout(professionalityPanelLayout);
        professionalityPanelLayout.setHorizontalGroup(
            professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professionalityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(professionalityPanelLayout.createSequentialGroup()
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel61))
                        .addGap(73, 73, 73)
                        .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprosearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbpro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(538, Short.MAX_VALUE))
        );
        professionalityPanelLayout.setVerticalGroup(
            professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professionalityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprosearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(professionalityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        mainPanel.add(professionalityPanel, "card6");

        specialdayPanel.setBackground(new java.awt.Color(162, 155, 254));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel74.setText("In Coulumn :");

        jLabel75.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("SPECIAL DAY");

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

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel78.setText("Search :");

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

        javax.swing.GroupLayout specialdayPanelLayout = new javax.swing.GroupLayout(specialdayPanel);
        specialdayPanel.setLayout(specialdayPanelLayout);
        specialdayPanelLayout.setHorizontalGroup(
            specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialdayPanelLayout.createSequentialGroup()
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(specialdayPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(specialdayPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(specialdayPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(specialdayPanelLayout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addGap(18, 18, 18)
                                .addComponent(cmbspday, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(specialdayPanelLayout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addGap(30, 30, 30)
                                .addComponent(txtspdaysearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        specialdayPanelLayout.setVerticalGroup(
            specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialdayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtspdaysearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(specialdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbspday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(265, 265, 265))
        );

        mainPanel.add(specialdayPanel, "card8");

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

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnspecialday, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfessionality, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(jSeparator2)
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
                .addGap(18, 18, 18)
                .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnspecialday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProfessionality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private void tblattendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblattendanceMouseClicked
        // TODO add your handling code here:
        //table attendance
        int i = tblattendance.getSelectedRow();
        TableModel model = tblattendance.getModel();

    }//GEN-LAST:event_tblattendanceMouseClicked

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
    private void tblproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblproMouseClicked
        // TODO add your handling code here:
        int i = tblpro.getSelectedRow();
        TableModel model = tblpro.getModel();
    }//GEN-LAST:event_tblproMouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MousePressed

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

    private void tblempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblempMouseClicked
        // TODO add your handling code here:
        int i = tblemp.getSelectedRow();
        TableModel model = tblemp.getModel();

    }//GEN-LAST:event_tblempMouseClicked

    private void txtempsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempsearchActionPerformed

    private void txtspdaysearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtspdaysearchKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtspdaysearchKeyTyped

    private void txtspdaysearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspdaysearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspdaysearchActionPerformed

    private void tblspdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspdayMouseClicked
        // TODO add your handling code here:
        int i = tblspday.getSelectedRow();
        TableModel model = tblspday.getModel();
    }//GEN-LAST:event_tblspdayMouseClicked

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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attendancePanel;
    private rojerusan.RSButtonIconD btnAttendance;
    private rojerusan.RSButtonIconD btnEmployee;
    private rojerusan.RSButtonIconD btnProfessionality;
    private rojerusan.RSButtonIconD btnspecialday;
    private javax.swing.JComboBox cmbattcari;
    private javax.swing.JComboBox cmbemp;
    private javax.swing.JComboBox cmbpro;
    private javax.swing.JComboBox cmbspday;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private keeptoo.KGradientPanel menuPanel;
    private javax.swing.JPanel professionalityPanel;
    private javax.swing.JPanel specialdayPanel;
    private javax.swing.JTable tblattendance;
    private javax.swing.JTable tblemp;
    private javax.swing.JTable tblpro;
    private javax.swing.JTable tblspday;
    private javax.swing.JTextField txtattsearch;
    private javax.swing.JTextField txtempsearch;
    private javax.swing.JTextField txtprosearch;
    private javax.swing.JTextField txtspdaysearch;
    // End of variables declaration//GEN-END:variables
}
