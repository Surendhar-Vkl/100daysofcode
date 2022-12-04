import java.sql.*;
public class JdbcEx {
	public static void main(String[] args) throws ClassNotFoundException {
//		printUser();
//		addUser();
		addUserVarwithPST();
		
	}

	private static void printUser() throws ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/sura";
		String username="devuser";
		String password="sura1234";
		
		String query="select * from customers";
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection(url, username, password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("id = "+rs.getInt(1)+" name = "+rs.getString(2)+ " phno = "+rs.getString(3) );
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		private static void addUser() throws ClassNotFoundException {
			String url="jdbc:mysql://localhost:3306/sura";
			String username="devuser";
			String password="sura1234";
			
			String query="insert into customers values(6,'genie','7777777')";
			
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection con=DriverManager.getConnection(url, username, password);
				Statement st=con.createStatement();
				int noOfrows =st.executeUpdate(query);
				
				System.out.println("number of rows affected : "+noOfrows);
				
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			private static void addUserVar() throws ClassNotFoundException {
				String url="jdbc:mysql://localhost:3306/sura";
				String username="devuser";
				String password="sura1234";
				
				int id=7;
				String name="cheems";
				String phno="888888888";
				
				String query="insert into customers values("+id+",'"+name+"','"+phno+"')";
				System.out.println("adduserVar : "+query);
				
				Class.forName("com.mysql.jdbc.Driver");
				try {
					Connection con=DriverManager.getConnection(url, username, password);
					Statement st=con.createStatement();
					int noOfrows =st.executeUpdate(query);
					
					System.out.println("number of rows affected : "+noOfrows);
					
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
			private static void addUserVarwithPST() throws ClassNotFoundException {
				String url="jdbc:mysql://localhost:3306/sura";
				String username="devuser";
				String password="sura1234";
				
				int id=8;
				String name="doggy";
				String phno="99999";
				
				String query="insert into customers values(?,?,?)";
				System.out.println("adduserVarwithPST : "+query);
				
				Class.forName("com.mysql.jdbc.Driver");
				try {
					Connection con=DriverManager.getConnection(url, username, password);
				PreparedStatement pst=	con.prepareStatement(query);
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setString(3, phno);
				
			
					int noOfrows =pst.executeUpdate();
					
					System.out.println("number of rows affected : "+noOfrows);
					
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
		
}
