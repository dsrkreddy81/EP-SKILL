package com.student.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.student.bean.StudentBean;
import com.student.connection.StudentDBUtil;

public class StudentCRUD {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException 
	{
		Connection con=StudentDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
		ps.setLong(1, student.getRegno());
		ps.setString(2, student.getName());
		ps.setString(3, student.getEmail());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentDelete(StudentBean student,String id) throws ClassNotFoundException, SQLException 
	{
		Connection con=StudentDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("delete from student where regno="+id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentUpdate(int para,String upval,long id) throws ClassNotFoundException, SQLException
	{
		Connection con=StudentDBUtil.DBConnection();
		String qry="";
		if(para==1) {
			qry="update student "+"set name=? "+"where regno=?";
		}
		else if(para==2) {
			qry="update student "+"set rego=? "+"where regno=?";
		}
		else
		{
			qry="update student "+"set email=? "+"where regno=?";
		}
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, upval);
		ps.setLong(2, id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public  void Retrive() throws ClassNotFoundException, SQLException
	{
		Connection con=StudentDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rst=ps.executeQuery();
		System.out.println("Regno\t\tName\t\tEmail");
		while(rst.next())
		{
			System.out.println(rst.getLong(1)+"\t"+rst.getString(2)+"\t\t"+rst.getString(3));
		}
		con.close();
	}
	{
		
	}

}