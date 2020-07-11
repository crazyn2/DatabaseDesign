package Psql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import com.google.gson.Gson;


public class Psqlbase extends Design{
	static Connection connect = null;
	Statement stmt = null;
	String[] sql = new String[8];
//			{"select zby_term,zby_sno,sum(zby_score) as zby_sum from zhangbingyang_reports "
//			+ "group by zby_term,zby_sno",
//			"select *,rank() over( order by zby_score desc) from zhangbingyang_reports",
//			"select zby_cno,avg(zby_score) as zby_avg from zhangbingyang_reports group by zby_cno",
//			"select zby_sno,sum(zby_value) as zby_sum from zhangbingyang_reports as zbyr"
//					+ " join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno "
//					+ "group by zbyr.zby_sno",
//			"select zby_sno,zbyr.zby_cno,zby_name from  zhangbingyang_reports " +
//					"as zbyr join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno",
//			"select zby_score,zby_cno from zhangbingyang_reports where zby_sno =",
//			"select * from zhangbingyang_courses where zby_tno =",
//			"select * from zhangbingyang_courses where zby_csno ="
//	};
	String csno = "R01";
//	sql[1] = String("select *,rank() over( order by zby_score desc) from zhangbingyang_reports");
//	sql[0] = "select zby_term,zby_sno,sum(zby_score) as zby_sum from zhangbingyang_reports "
//			+ "group by zby_term,zby_sno";
//	sql[2] = "select zby_cno,avg(zby_score) as zby_avg from zhangbingyang_reports group by zby_cno";
//	sql[3] = "select zby_sno,sum(zby_value) as zby_sum from zhangbingyang_reports as zbyr"
//			+ " join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno "
//			+ "group by zbyr.zby_sno";
//	sql[4] = "select zby_sno,zbyr.zby_cno,zby_name from  zhangbingyang_reports " +
//			"as zbyr join zhangbingyang_courses as zbyc on zbyr.zby_cno=zbyc.zby_cno";
//	sql[5] = "select zby_score,zby_cno from zhangbingyang_reports where zby_sno =";
//	sql[6] = "select * from zhangbingyang_courses where zby_tno =";
//	sql[7] = "select * from zhangbingyang_courses where zby_csno =";
	public Psqlbase(){
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

			}
		});
	}
	public void countByYear(){
		try{
			ResultSet rs = stmt.executeQuery(sql[0]);
			Psql0 psql0 = new Psql0();
			while (rs.next()) {
				psql0.setSno(rs.getString("zby_sno"));
				psql0.setTerm(rs.getString("zby_term"));
				psql0.setSum(rs.getInt("zby_sum"));
				String json = new Gson().toJson(psql0);
				System.out.println(json);
			}
			rs.close();
		}catch (Exception e) {
			System.err.print("get data error!");
			e.printStackTrace();
		}
	}
	public void orderByScore(){
		try{
			ResultSet rs = stmt.executeQuery(sql[1]);
			Srank srank = new Srank();
			while (rs.next()) {
				srank.setSno(rs.getString("zby_sno"));
				srank.setTerm(rs.getString("zby_term"));
				srank.setCno(rs.getString("zby_cno"));
				srank.setScore(rs.getInt("zby_score"));
				srank.setTno(rs.getString("zby_tno"));
				srank.setRank(rs.getInt("rank"));
				String json = new Gson().toJson(srank);
				System.out.println(json);
			}
			rs.close();
		}catch(Exception e){
			System.err.print("get data error!");
			e.printStackTrace();
		}
	}
	public void countByAvg(){
		try{
			ResultSet rs = stmt.executeQuery(sql[2]);
			Psql2 psql2 = new Psql2();
			while (rs.next()) {
				psql2.setCno(rs.getString("zby_cno"));
				psql2.setAvg(rs.getDouble("zby_avg"));
				String json = new Gson().toJson(psql2);
				System.out.println(json);
			}
			rs.close();
		}catch (Exception e){
			System.err.print("get data error!");
			e.printStackTrace();
		}
	}
	public void countByCourses(){
		
	}
	public static void main(String args[]) {
		try {
			Class.forName("org.postgresql.Driver");

//			Statement stmt = connect.createStatement();
			Psqlbase psqlbase = new Psqlbase();
			if(args.length == 0) {
				psqlbase.setVisible(true);
				System.out.println("Usage:\n{--count-by-year " +
						"| --order-by-score | --count-by-avg " +
						"| -qs <students number> | -qt <teacher nummber> " +
						"| -qr <classroom number> }");
				return;
			}
			switch(args[0]){
				case "--count-by-year": {
					psqlbase.countByYear();
//					ResultSet rs = stmt.executeQuery(sql[0]);
//					Psql0 psql0 = new Psql0();
//					while (rs.next()) {
//						psql0.setSno(rs.getString("zby_sno"));
//						psql0.setTerm(rs.getString("zby_term"));
//						psql0.setSum(rs.getInt("zby_sum"));
//						String json = new Gson().toJson(psql0);
//						System.out.println(json);
//					}
//					rs.close();
				};
				break;
				case "--order-by-score":{
					psqlbase.orderByScore();
//					ResultSet rs = stmt.executeQuery(sql[1]);
//					Srank srank = new Srank();
//					while (rs.next()) {
//						srank.setSno(rs.getString("zby_sno"));
//						srank.setTerm(rs.getString("zby_term"));
//						srank.setCno(rs.getString("zby_cno"));
//						srank.setScore(rs.getInt("zby_score"));
//						srank.setTno(rs.getString("zby_tno"));
//						srank.setRank(rs.getInt("rank"));
//						String json = new Gson().toJson(srank);
//						System.out.println(json);
//					}
//					rs.close();
				};
				break;
				case "--count-by-avg":{
					psqlbase.countByYear();
//					ResultSet rs = stmt.executeQuery(sql[2]);
//					Psql2 psql2 = new Psql2();
//					while (rs.next()) {
//						psql2.setCno(rs.getString("zby_cno"));
//						psql2.setAvg(rs.getDouble("zby_avg"));
//						String json = new Gson().toJson(psql2);
//						System.out.println(json);
//					}
//					rs.close();
				}
				break;
				case "--count-by-courses":{
					ResultSet rs = stmt.executeQuery(sql[3]);
					Psql3 psql3 = new Psql3();
					if(!rs.isBeforeFirst()){
						System.out.println("查无课程统计学分");
						break;
					}
					System.out.println("student course score count");
					while (rs.next()) {
						psql3.setSno(rs.getString("zby_sno"));
						psql3.setSum(rs.getInt("zby_sum"));
						String json = new Gson().toJson(psql3);
						System.out.println(json);
					}
					rs = stmt.executeQuery(sql[4]);
					Psql4 psql4 = new Psql4();
					if(!rs.isBeforeFirst()){
						System.out.println("查无");
						break;
					}
					System.out.println("student's courses count");
					while (rs.next()) {
						psql4.setSno(rs.getString("zby_sno"));
						psql4.setCno(rs.getString("zby_cno"));
						psql4.setName(rs.getString("zby_name"));
						String json = new Gson().toJson(psql4);
						System.out.println(json);
					}
					rs.close();
				}
				break;
				/*case "-qs":{
					sql[5] = sql[5] + "'" + args[1] + "'";
					ResultSet rs = stmt.executeQuery(sql[5]);
					Psql5 psql5 = new Psql5();
					if(!rs.isBeforeFirst()){
						System.out.println("查无此人");
						break;
					}
					while (rs.next()) {
						psql5.setSno(args[1]);
						psql5.setCno(rs.getString("zby_cno"));
						psql5.setScore(rs.getInt("zby_score"));
						String json = new Gson().toJson(psql5);
						System.out.println(json);
					}
					rs.close();
				}
				break;
				case "-qt":{
					sql[6] = sql[6] + "'" + args[1] + "'";
					ResultSet rs = stmt.executeQuery(sql[6]);
					if(!rs.isBeforeFirst()){
						System.out.println("查无此人");
						break;
					}
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
						System.out.println(json);
					}
					rs.close();
				}
				break;
				case "-qr":{
					sql[7] = sql[7] + "'" + args[1] + "'" ;
					ResultSet rs = stmt.executeQuery(sql[7]);
					if(!rs.isBeforeFirst()){
						System.out.println("查无此班");
						break;
					}
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
						System.out.println(json);
					}
					rs.close();
				}
				break;*/
				default:
					System.out.println("Usage:\n{--count-by-year " +
							"| --order-by-score | --count-by-avg " +
							"| -qs <students number> | -qt <teacher nummber> " +
							"| -qr <classroom number> }");
			}
			System.out.println("Complete");
//			stmt.close();
//			connect.close();
		} catch (Exception e) {
			System.err.print("get data error!");
			e.printStackTrace();
		}
//		guiClass.setVisible(true);
	}
	protected void destructor(){
		try {
			stmt.close();
			connect.close();
		}catch (SQLException e){
			System.err.print("get data error!");
			e.printStackTrace();
		}
	}
}
