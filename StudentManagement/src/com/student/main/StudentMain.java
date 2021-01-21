package com.student.main;

import java.util.*;
import java.sql.SQLException;
import com.student.bean.StudentBean;
import com.student.crud.StudentCRUD;
public class StudentMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		StudentBean sb=new StudentBean();
		StudentCRUD si=new StudentCRUD();
		int ch;
		while(true)
		{
			System.out.println("Please select the operation u want to do on the database\n1.Insert into database\n2.Delete from database\n3.Update database\n4.Retrive the database\n5.Exit\nEnter your option:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Register Number of the Student:");
				sb.setRegno(sc.nextLong());
				System.out.println("Enter the Name of the Student:");
				sb.setName(sc.next());
				System.out.println("Enter the Email Address of the Student:");
				sb.setEmail(sc.next());
				int i=si.StudentInsert(sb);
				if(i>0)
				{
					System.out.println("Insertion Successfull");
				}
				else
				{
					System.out.println("Insertion Failure");
				}
				break;
			case 2:
				System.out.println("Enter the Student Id You want to delete");
				String id=sc.next();
				i=si.StudentDelete(sb,id);
				if(i>0)
				{
					System.out.println("Deletion Successfull");
				}
				else
				{
					System.out.println("Deletion Failure");
				}
				break;
			case 3:
				System.out.println("Enter the Student ID to update the Student Details:");
				long id1=sc.nextLong();
				System.out.println("Enter the field you want to update:\n1.Name\n2.ID Number\n3.Email\nEnter your Choice:");
				int cho=sc.nextInt();
				switch(cho)
				{
				case 1:
					System.out.println("Enter the New Name you want to update : ");
					i=si.StudentUpdate(1, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				case 2:
					System.out.println("Enter the New ID NUMBER you want to update : ");
					i=si.StudentUpdate(2, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				case 3:
					System.out.println("Enter the New Email you want to update : ");
					i=si.StudentUpdate(3, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				}
				break;
			case 4:
				si.Retrive();
				break;
			case 5:
				System.exit(0);
			}
			
		}
	}

}