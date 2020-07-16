package Psql;

import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherBase extends TeacherDesign{
    static Connection connect = null;
    Statement stmt = null;
    String[] sql = new String[8];
    public TeacherBase(){
        sql[0] = "select zby_term,zby_sno,sum(zby_score) as zby_sum from zhangbingyang_reports "
                + "group by zby_term,zby_sno";
        sql[1] = "select *,rank() over( order by zby_score desc) from zhangbingyang_reports";
        sql[2] = "select zby_cno,avg(zby_score) as zby_avg from zhangbingyang_reports group by zby_cno";
        sql[3] = "select zby_sno,sum(zby_value) as zby_sum from zhangbingyang_reports as zbyr"
                + " join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno "
                + "group by zbyr.zby_sno";
        sql[4] = "select zby_sno,zbyr.zby_cno,zby_name from  zhangbingyang_reports " +
                "as zbyr join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno";
        sql[5] = "select zby_score,zby_cno from zhangbingyang_reports where zby_sno =";
        sql[6] = "select * from zhangbingyang_courses where zby_tno =";
        sql[7] = "select * from zhangbingyang_courses where zby_csno =";
        try{
            Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zhangbingyang1801mis",
                    "postgres", "zhang");
            stmt = connect.createStatement();
        } catch (Exception e) {
            System.err.print("get data error!");
            e.printStackTrace();
        }
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				try{
					ResultSet rs = stmt.executeQuery(sql[0]);
					Psql0 psql0 = new Psql0();
					textArea.setText("");
					while (rs.next()) {
						psql0.setSno(rs.getString("zby_sno"));
						psql0.setTerm(rs.getString("zby_term"));
						psql0.setSum(rs.getInt("zby_sum"));
						String json = new Gson().toJson(psql0);
						textArea.append(json + "\n");
					}
					rs.close();
				}catch (Exception e1) {
					System.err.print("get data error!");
					e1.printStackTrace();
				}
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = stmt.executeQuery(sql[1]);
                    Srank srank = new Srank();
                    textArea.setText("");
                    while (rs.next()) {
                        srank.setSno(rs.getString("zby_sno"));
                        srank.setTerm(rs.getString("zby_term"));
                        srank.setCno(rs.getString("zby_cno"));
                        srank.setScore(rs.getInt("zby_score"));
                        srank.setTno(rs.getString("zby_tno"));
                        srank.setRank(rs.getInt("rank"));
                        String json = new Gson().toJson(srank);
                        textArea.append(json + "\n");
                    }
                    rs.close();
                }catch (Exception e2){
                    System.err.print("get data error!");
                    e2.printStackTrace();
                }
            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = stmt.executeQuery(sql[2]);
                    Psql2 psql2 = new Psql2();
                    textArea.setText("");
                    while (rs.next()) {
                        psql2.setCno(rs.getString("zby_cno"));
                        psql2.setAvg(rs.getDouble("zby_avg"));
                        String json = new Gson().toJson(psql2);
                        textArea.append(json + "\n");
                    }
                    rs.close();
                }catch (Exception e3){
                    System.err.print("get data error!");
                    e3.printStackTrace();
                }
            }
        });
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = stmt.executeQuery(sql[3]);
                    Psql3 psql3 = new Psql3();
                    textArea.setText("");
                    if(!rs.isBeforeFirst()){
                        textArea.setText("None\n");
                    }
                    else {
                        textArea.append("student's total counts\n");
                        while (rs.next()) {
                            psql3.setSno(rs.getString("zby_sno"));
                            psql3.setSum(rs.getInt("zby_sum"));
                            String json = new Gson().toJson(psql3);
                            textArea.append(json + "\n");
                        }
                        rs = stmt.executeQuery(sql[4]);
                        Psql4 psql4 = new Psql4();
                        textArea.append("student's courses\n");
                        while (rs.next()) {
                            psql4.setSno(rs.getString("zby_sno"));
                            psql4.setCno(rs.getString("zby_cno"));
                            psql4.setName(rs.getString("zby_name"));
                            String json = new Gson().toJson(psql4);
                            textArea.append(json + "\n");
                        }
                    }
                    rs.close();
                }catch (Exception e4){
                    System.err.print("get data error!");
                    System.exit(-1);
                    e4.printStackTrace();
                }
            }
        });
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = textField.getText();
                try{
                    String tmp = sql[5] + "'" + num + "'";
                    ResultSet rs = stmt.executeQuery(tmp);
                    Psql5 psql5 = new Psql5();
                    textArea.setText("");
                    if(!rs.isBeforeFirst()){
                        textArea.append("None\n");
                    }
                    else {
                        while (rs.next()) {
                            psql5.setSno(num);
                            psql5.setCno(rs.getString("zby_cno"));
                            psql5.setScore(rs.getInt("zby_score"));
                            String json = new Gson().toJson(psql5);
                            textArea.append(json + "\n");
                        }
                    }
                    rs.close();
                }catch (Exception e5){
                    System.err.print("get data error!");
                    e5.printStackTrace();
                    System.exit(-1);
                }
            }
        });
        /*btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String num = textField_1.getText();
                    String tmp = sql[6] + "'" + num + "'";
                    ResultSet rs = stmt.executeQuery(tmp);
                    textArea.setText("");
                    if(!rs.isBeforeFirst()){
                        textArea.setText("None\n");
                    }
                    else{
                        Courses courses = new Courses();
                        while (rs.next()) {
                            courses.setName(rs.getString("zby_name"));
                            courses.setTerm(rs.getString("zby_term"));
                            courses.setCno(rs.getString("zby_cno"));
                            courses.setTime(rs.getString("zby_time"));
                            courses.setTno(rs.getString("zby_tno"));
                            courses.setExam(rs.getString("zby_exam"));
                            courses.setValue(rs.getString("zby_value"));
                            String json = new Gson().toJson(courses);
                            textArea.append(json + "\n");
                        }
                    }
                    rs.close();
                }catch (Exception e5){
                    System.err.print("get data error!");
                    e5.printStackTrace();
                    System.exit(-1);
                }
            }
        });*/
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String num = textField_2.getText();
                    ResultSet rs = stmt.executeQuery(sql[7] + "'" + num + "'");
                    textArea.setText("");
                    if(!rs.isBeforeFirst()){
                        textArea.append("None");
                    }
                    else{
                        Courses courses = new Courses();
                        while (rs.next()) {
                            courses.setName(rs.getString("zby_name"));
                            courses.setTerm(rs.getString("zby_term"));
                            courses.setCno(rs.getString("zby_cno"));
                            courses.setTime(rs.getString("zby_time"));
                            courses.setTno(rs.getString("zby_tno"));
                            courses.setExam(rs.getString("zby_exam"));
                            courses.setValue(rs.getString("zby_value"));
                            String json = new Gson().toJson(courses);
                            textArea.append(json + "\n");
                        }
                    }
                    rs.close();
                }catch (Exception e6){
                    System.err.print("get data error!");
                    e6.printStackTrace();
                    System.exit(-1);
                }
            }
        });
    }
}
