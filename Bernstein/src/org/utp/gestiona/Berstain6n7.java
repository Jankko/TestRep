package org.utp.gestiona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;


public class Berstain6n7
{
   String cadenain ;
   String query="";
	
	public void dbConnect(String db_connect_string,
            String db_userid,
            String db_password,String sqlquery)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string,
                  db_userid, db_password);
         System.out.println("Connected...");
         Statement statement = conn.createStatement();
         statement.executeUpdate("truncate table Berstain");
         statement.executeUpdate("truncate table Berstain2");
         statement.executeUpdate(sqlquery);
         statement.executeUpdate("exec Step6");
         statement.executeUpdate("exec Step7");
         //String queryString = sqlquery;
        
         
         //String queryString = "select * from names ";
         //String queryString = sqlquery;
         
         //ResultSet rs = statement.executeQuery(queryString);
         System.out.println("Ready...");
        /* while (rs.next()) {
            System.out.println(rs.getString(2));
         }*/
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public String getcadenaafter4 (String Cadena4)
   {
	   
	   int x=0,y=0,z=0;
	   
	   cadenain = Cadena4;
	   cadenain = cadenain.replace(",", "");
	    
	   String[] data = cadenain.split(";");

   
   while(x < data.length)
   {
 
	 
   	y=x+1;

	   StringTokenizer line = new StringTokenizer(data[x], ">");
	   while (line.hasMoreElements())
	   {
			  
		  query = query + "insert into Berstain values ("+ y + ",'" + line.nextElement() + "','"+ line.nextElement() +"');";
		   
		   
	   }
	   

  	x++;
   }
   System.out.println(query);

  dbConnect("jdbc:sqlserver://JankkoLenovo;databaseName=DBA", "sa","nanamizuki22$$",query);
  
   return cadenain;  	 
   }
   
   public String setcadenaafter4()
   {
	   return this.cadenain;
   }

   


	public static void main(String[] args) {
		
		//System.out.println("Hola Mundo");
		//String line;
		int x=0;
		//String [] cName = new String [100];
		
		
		 final String PLAYER = "A,B,C,D";
	
	        String[] data = PLAYER.split(",");
	        System.out.println(Arrays.toString(data));
	       // System.out.println(data.length);
	        
	        while(x < data.length)
	        {
	        	System.out.println(data[x]);
	        	x++;
	        }
	        		
		//Berstain6n7 connServer = new Berstain6n7();
	    //connServer.dbConnect("jdbc:sqlserver://JankkoLenovo;databaseName=DBA", "sa","nanamizuki22$$");
		// TODO Auto-generated method stub

	}
}


