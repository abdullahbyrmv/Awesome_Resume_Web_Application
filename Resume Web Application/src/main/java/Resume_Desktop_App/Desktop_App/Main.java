package Resume_Desktop_App.Desktop_App;
import Resume_Desktop_App.JDBC.dao.*;
import Resume_Desktop_App.JDBC.entity.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

public class Main extends javax.swing.JFrame {

    List<UserSkill> userSkill;

    private UserInterface userDao = Context.instanceUserDao();
    private CountryInterface countryDao = Context.instanceCountryDao();
    private SkillInterface skillDao = Context.instanceSkillDao();
    private UserSkillInterface userskillDao = Context.instanceUserSkillDao();
    private NationalityInterface nationalityDao = Context.instanceNationalityDao();
    private EmploymentHistoryInterface employmentHistoryDao = Context.instanceEmploymentHistoryDao();
    User loggedInUser;

    public Main() {
        initComponents();
        loggedInUser = userDao.getByID(8);
        fillCountry();
        fillNationality();
        fillSkills();
        fillEmploymentHistory();
        fillUserComponents();
    }

    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

    private void fillCountry() {
        List<Country> countries = countryDao.getAllCountries();
        for (Country c : countries) {
            BirthPlace_Combobox.addItem(c);
        }
    }

    private void fillNationality() {
        List<Nationality> nationalities = nationalityDao.getAllNationalities();
        for (Nationality a : nationalities) {
            Nationality_Combobox.addItem(a);
        }
    }

    private void fillSkills() {
        List<Skill> skills = skillDao.getAllSkills();
        for (Skill s : skills) {
            Skill_ComboBox.addItem(s);
        }
        fillTable();
    }

    private void fillEmploymentHistory() {
        List<EmploymentHistory> history = employmentHistoryDao.getAllEmploymentHistory(8);
        for (int i = 0; i < history.size(); i++) {
            Date date1 = loggedInUser.getBegin_date();
            String beginDate = dateformat.format(date1);
            Date date2 = loggedInUser.getEnd_date();
            String endDate = dateformat.format(date2);
            Header_Text.setText(loggedInUser.getHeader());
            Begin_Date_Text.setText(beginDate);
            End_Date_Text.setText(endDate);
            Job_Description_Text.setText(loggedInUser.getJob_description());
        }
    }

    private void fillTable() {
        userSkill = userskillDao.getAllSkillByUserId(loggedInUser.getId());

        Vector<Vector> rows = new Vector<>();
        for (UserSkill s : userSkill) {
            Vector<Object> row = new Vector<>();
            row.add(s.getSkill());
            row.add(s.getPower());
            rows.add(row);
        }

        Vector<String> columns = new Vector<>();
        columns.add("Skill");
        columns.add("Power");

        DefaultTableModel model = new DefaultTableModel(rows, columns);
        Skills_Table.setModel(model);
    }

    private void fillUserComponents() {
        Date date = loggedInUser.getBirthDate();
        String Birth_Date = dateformat.format(date);
        Date begin = loggedInUser.getBegin_date();
        String begin1 = dateformat.format(begin);
        Date end = loggedInUser.getEnd_date();
        String end1 = dateformat.format(end);
        Name_Text.setText(loggedInUser.getName());
        Surname_Text.setText(loggedInUser.getSurname());
        txtAreaProfile.setText(loggedInUser.getProfileDescription());
        Phone_Number_Text.setText(loggedInUser.getPhone());
        BirthDate_Text.setText(Birth_Date);
        Email_Text.setText(loggedInUser.getEmail());
        Address_Text.setText(loggedInUser.getAddress());
        BirthPlace_Combobox.setSelectedItem(loggedInUser.getBirthPlace());
        Skill_ComboBox.setSelectedItem(loggedInUser.getSkills());
        Nationality_Combobox.setSelectedItem(loggedInUser.getNationality());
        Header_Text.setText(loggedInUser.getHeader());
        Begin_Date_Text.setText(begin1);
        End_Date_Text.setText(end1);
        Job_Description_Text.setText(loggedInUser.getJob_description());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        Name_Text = new javax.swing.JTextField();
        Surname = new javax.swing.JLabel();
        Surname_Text = new javax.swing.JTextField();
        Save_Button = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Profile = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaProfile = new javax.swing.JTextArea();
        Details = new javax.swing.JPanel();
        Details_Address = new javax.swing.JLabel();
        Address_Text = new javax.swing.JTextField();
        Details_phone_number = new javax.swing.JLabel();
        Phone_Number_Text = new javax.swing.JTextField();
        Details_Email = new javax.swing.JLabel();
        Email_Text = new javax.swing.JTextField();
        Details_BirthDate = new javax.swing.JLabel();
        BirthDate_Text = new javax.swing.JTextField();
        Details_BirthPlace = new javax.swing.JLabel();
        Details_Nationality = new javax.swing.JLabel();
        BirthPlace_Combobox = new javax.swing.JComboBox<>();
        Nationality_Combobox = new javax.swing.JComboBox<>();
        Message1 = new javax.swing.JLabel();
        Skills = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Skills_Table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Skills_skill = new javax.swing.JLabel();
        Skill_Text = new javax.swing.JTextField();
        Skills_Skill_Power = new javax.swing.JLabel();
        Skill_Power_Slider = new javax.swing.JSlider();
        Skill_ComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Skills_Save_Button = new javax.swing.JButton();
        Delete_Button = new javax.swing.JButton();
        Add_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EmploymentHistory = new javax.swing.JPanel();
        Employment_Header = new javax.swing.JLabel();
        Header_Text = new javax.swing.JTextField();
        Employment_Begin_Date = new javax.swing.JLabel();
        Begin_Date_Text = new javax.swing.JTextField();
        Employment_End_Date = new javax.swing.JLabel();
        End_Date_Text = new javax.swing.JTextField();
        Employment_Job_Description = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Job_Description_Text = new javax.swing.JTextArea();
        Message2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.yellow);

        Name.setText("Name");
        Name.setToolTipText("Enter Your Name");

        Name_Text.setBackground(new java.awt.Color(255, 255, 255));
        Name_Text.setForeground(new java.awt.Color(0, 0, 0));
        Name_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Name_TextActionPerformed(evt);
            }
        });

        Surname.setText("Surname");

        Surname_Text.setBackground(new java.awt.Color(255, 255, 255));
        Surname_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Surname_TextActionPerformed(evt);
            }
        });

        Save_Button.setText("Save");
        Save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Surname_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(Save_Button)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Surname)
                                        .addComponent(Surname_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Save_Button))
                                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.setToolTipText("");

        txtAreaProfile.setColumns(20);
        txtAreaProfile.setRows(5);
        jScrollPane1.setViewportView(txtAreaProfile);

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
                ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        ProfileLayout.setVerticalGroup(
                ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Profile", Profile);

        Details_Address.setText("Address");
        Details_Address.setToolTipText("Enter Your Name");

        Address_Text.setBackground(new java.awt.Color(255, 255, 255));
        Address_Text.setForeground(new java.awt.Color(0, 0, 0));
        Address_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Address_TextActionPerformed(evt);
            }
        });

        Details_phone_number.setText("Phone Number ; ");
        Details_phone_number.setToolTipText("Enter Your Name");

        Phone_Number_Text.setBackground(new java.awt.Color(255, 255, 255));
        Phone_Number_Text.setForeground(new java.awt.Color(0, 0, 0));
        Phone_Number_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Phone_Number_TextActionPerformed(evt);
            }
        });

        Details_Email.setText("Email");
        Details_Email.setToolTipText("Enter Your Name");

        Email_Text.setBackground(new java.awt.Color(255, 255, 255));
        Email_Text.setForeground(new java.awt.Color(0, 0, 0));
        Email_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Email_TextActionPerformed(evt);
            }
        });

        Details_BirthDate.setText("Birth Date : ");
        Details_BirthDate.setToolTipText("Enter Your Name");

        BirthDate_Text.setBackground(new java.awt.Color(255, 255, 255));
        BirthDate_Text.setForeground(new java.awt.Color(0, 0, 0));
        BirthDate_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthDate_TextActionPerformed(evt);
            }
        });

        Details_BirthPlace.setText("Birth Place : ");
        Details_BirthPlace.setToolTipText("Enter Your Name");

        Details_Nationality.setText("Nationality : ");
        Details_Nationality.setToolTipText("Enter Your Name");

        BirthPlace_Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthPlace_ComboboxActionPerformed(evt);
            }
        });

        Nationality_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new Nationality[]{}));

        Message1.setText("Important : Birth Date should be in year-month-day format. For example : 2020-09-21");

        javax.swing.GroupLayout DetailsLayout = new javax.swing.GroupLayout(Details);
        Details.setLayout(DetailsLayout);
        DetailsLayout.setHorizontalGroup(
                DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DetailsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DetailsLayout.createSequentialGroup()
                                                .addComponent(Message1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(DetailsLayout.createSequentialGroup()
                                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DetailsLayout.createSequentialGroup()
                                                                .addComponent(Details_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Email_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DetailsLayout.createSequentialGroup()
                                                                .addComponent(Details_BirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(BirthPlace_Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(53, 53, 53))
                                                        .addGroup(DetailsLayout.createSequentialGroup()
                                                                .addComponent(Details_Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Address_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(62, 62, 62)
                                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(DetailsLayout.createSequentialGroup()
                                                                .addComponent(Details_phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Phone_Number_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailsLayout.createSequentialGroup()
                                                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Details_BirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Details_Nationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(Nationality_Combobox, 0, 159, Short.MAX_VALUE)
                                                                        .addComponent(BirthDate_Text))))
                                                .addGap(170, 170, 170))))
        );
        DetailsLayout.setVerticalGroup(
                DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DetailsLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Details_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Address_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Phone_Number_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Details_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Email_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Details_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Details_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BirthDate_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Details_BirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BirthPlace_Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Details_Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nationality_Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Message1)
                                .addContainerGap(275, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Details", Details);

        Skills_Table.setModel(new DefaultTableModel(
                new Object[][]{
                        {},
                        {},
                        {},
                        {}
                },
                new String[]{

                }
        ));
        jScrollPane2.setViewportView(Skills_Table);

        Skills_skill.setText("Skill:");

        Skill_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Skill_TextActionPerformed(evt);
            }
        });

        Skills_Skill_Power.setText("Power:");

        Skill_Power_Slider.setMaximum(10);
        Skill_Power_Slider.setMinimum(1);
        Skill_Power_Slider.setPaintLabels(true);

        jLabel1.setText("Type You Own Skill : ");

        Skills_Save_Button.setText("Save");
        Skills_Save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Skills_Save_ButtonActionPerformed(evt);
            }
        });

        Delete_Button.setText("-");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Add_Button.setText("+");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Add Skill : ");

        jLabel3.setText("Delete Skill :  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(Skills_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Skill_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(Skills_Skill_Power, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Skill_Power_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Skills_Save_Button))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Skill_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Skills_skill)
                                                        .addComponent(Skill_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Skills_Skill_Power))
                                                .addGap(10, 10, 10))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Skill_Power_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(Skill_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Skills_Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout SkillsLayout = new javax.swing.GroupLayout(Skills);
        Skills.setLayout(SkillsLayout);
        SkillsLayout.setHorizontalGroup(
                SkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SkillsLayout.setVerticalGroup(
                SkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SkillsLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Skills", Skills);

        Employment_Header.setText("Company Name : ");

        Header_Text.setBackground(new java.awt.Color(255, 255, 255));

        Employment_Begin_Date.setText("Begin Date : ");

        Begin_Date_Text.setBackground(new java.awt.Color(255, 255, 255));

        Employment_End_Date.setText("End Date : ");

        End_Date_Text.setBackground(new java.awt.Color(255, 255, 255));

        Employment_Job_Description.setText("Job Description : ");

        Job_Description_Text.setBackground(new java.awt.Color(255, 255, 255));
        Job_Description_Text.setColumns(20);
        Job_Description_Text.setRows(5);
        jScrollPane3.setViewportView(Job_Description_Text);

        Message2.setText("Important : Begin Date and End Date should be in year-month-day format. For example : 2020-09-21");

        javax.swing.GroupLayout EmploymentHistoryLayout = new javax.swing.GroupLayout(EmploymentHistory);
        EmploymentHistory.setLayout(EmploymentHistoryLayout);
        EmploymentHistoryLayout.setHorizontalGroup(
                EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                                .addComponent(Employment_Job_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3))
                                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                                .addGroup(EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                                                .addComponent(Employment_Header)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(Header_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Employment_Begin_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Begin_Date_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(Employment_End_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(End_Date_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 134, Short.MAX_VALUE))))
        );
        EmploymentHistoryLayout.setVerticalGroup(
                EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Employment_Header)
                                        .addComponent(Header_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Employment_Begin_Date)
                                        .addComponent(Begin_Date_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Employment_End_Date)
                                        .addComponent(End_Date_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Message2)
                                .addGroup(EmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(EmploymentHistoryLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(Employment_Job_Description)))
                                .addContainerGap(238, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employment History", EmploymentHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>

    private void Surname_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void Name_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void Save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String name = Name_Text.getText();
            String surname = Surname_Text.getText();
            String profileDescription = txtAreaProfile.getText();
            String birthDate = BirthDate_Text.getText();
            String email = Email_Text.getText();
            String phone = Phone_Number_Text.getText();
            String address = Address_Text.getText();
            Country birthplace = (Country) BirthPlace_Combobox.getSelectedItem();
            Nationality nationality = (Nationality) Nationality_Combobox.getSelectedItem();
            String header = Header_Text.getText();
            String begin_date = Begin_Date_Text.getText();
            String end_date = End_Date_Text.getText();
            String job_description = Job_Description_Text.getText();

            Date bd = new Date(dateformat.parse(birthDate).getTime());
            Date begin_date_updated = new Date(dateformat.parse(begin_date).getTime());
            Date end_date_updated = new Date(dateformat.parse(end_date).getTime());

            loggedInUser.setName(name);
            loggedInUser.setSurname(surname);
            loggedInUser.setProfileDescription(profileDescription);
            loggedInUser.setBirthDate(bd);
            loggedInUser.setEmail(email);
            loggedInUser.setPhone(phone);
            loggedInUser.setAddress(address);
            loggedInUser.setBirthPlace(birthplace);
            loggedInUser.setNationality(nationality);
            loggedInUser.setHeader(header);
            loggedInUser.setBegin_date(begin_date_updated);
            loggedInUser.setEnd_date(end_date_updated);
            loggedInUser.setJob_description(job_description);


            userDao.updateUser(loggedInUser);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Address_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void Phone_Number_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void Email_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void BirthDate_TextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void BirthPlace_ComboboxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void Skill_TextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int index = Skills_Table.getSelectedRow();
        UserSkill skill = userSkill.get(index);
        userskillDao.removeUserSkill(skill.getId());
        fillTable();
    }

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String skillText = Skill_Text.getText();
        Skill skill = new Skill(0, skillText);
        if (Skill_Text != null && !skillText.trim().isEmpty()) {
            skillDao.insertSkill(skill);
        } else {
            skill = (Skill) Skill_ComboBox.getSelectedItem();
        }

        int power = Skill_Power_Slider.getValue();
        UserSkill userskill = new UserSkill(null, loggedInUser, skill, power);
        userskillDao.insertUserSkill(userskill);
        fillTable();
    }

    private void Skills_Save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserSkill userskill = userSkill.get(Skills_Table.getSelectedRow());
        String skillText = Skill_Text.getText();
        Skill skill;
        if (Skill_Text != null && !skillText.trim().isEmpty()) {
            skill = new Skill(0, skillText);
            skillDao.insertSkill(skill);
        } else {
            skill = (Skill) Skill_ComboBox.getSelectedItem();
        }

        int power = Skill_Power_Slider.getValue();

        userskill.setSkill(skill);
        userskill.setPower(power);

        userskillDao.updateUserSkill(userskill);
        fillTable();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Add_Button;
    private javax.swing.JTextField Address_Text;
    private javax.swing.JTextField Begin_Date_Text;
    private javax.swing.JTextField BirthDate_Text;
    private javax.swing.JComboBox<Country> BirthPlace_Combobox;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JPanel Details;
    private javax.swing.JLabel Details_Address;
    private javax.swing.JLabel Details_BirthDate;
    private javax.swing.JLabel Details_BirthPlace;
    private javax.swing.JLabel Details_Email;
    private javax.swing.JLabel Details_Nationality;
    private javax.swing.JLabel Details_phone_number;
    private javax.swing.JTextField Email_Text;
    private javax.swing.JPanel EmploymentHistory;
    private javax.swing.JLabel Employment_Begin_Date;
    private javax.swing.JLabel Employment_End_Date;
    private javax.swing.JLabel Employment_Header;
    private javax.swing.JLabel Employment_Job_Description;
    private javax.swing.JTextField End_Date_Text;
    private javax.swing.JTextField Header_Text;
    private javax.swing.JTextArea Job_Description_Text;
    private javax.swing.JLabel Message1;
    private javax.swing.JLabel Message2;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField Name_Text;
    private javax.swing.JComboBox<Nationality> Nationality_Combobox;
    private javax.swing.JTextField Phone_Number_Text;
    private javax.swing.JPanel Profile;
    private javax.swing.JButton Save_Button;
    private javax.swing.JComboBox<Skill> Skill_ComboBox;
    private javax.swing.JSlider Skill_Power_Slider;
    private javax.swing.JTextField Skill_Text;
    private javax.swing.JPanel Skills;
    private javax.swing.JButton Skills_Save_Button;
    private javax.swing.JLabel Skills_Skill_Power;
    private javax.swing.JTable Skills_Table;
    private javax.swing.JLabel Skills_skill;
    private javax.swing.JLabel Surname;
    private javax.swing.JTextField Surname_Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtAreaProfile;
    // End of variables declaration
}
