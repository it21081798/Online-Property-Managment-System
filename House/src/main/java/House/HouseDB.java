package House;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HouseDB {


	
	    String url= "jdbc:mysql://localhost:3306/house?useSSL=false";
		String user = "root";
		String password = "adc123";
		

		private static final String INSERT_HOUSE_SQL = "INSERT INTO details" + " (type,address, description, price,phoneNo,email) VALUES " 
														+ " (?, ?, ?, ?, ?, ?);";
		private static final String SELECT_HOUSE_BY_ID = "SELECT id,type,address,description,price,phoneNo,email FROM details WHERE id =?";
		private static final String SELECT_ALL_HOUSE = "SELECT * FROM details";
		private static final String DELETE_HOUSE_SQL = "DELETE FROM details WHERE id = ?;";
		private static final String UPDATE_HOUSE_SQL = "UPDATE details set type = ?, address = ?, description = ?, price = ?, phoneNo = ?, email = ? WHERE id = ?;";
		
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}

		//insert Houses
		
		public void inserthouse(House house) throws SQLException {
			try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSE_SQL)){
				preparedStatement.setString(1,house.getType());
				preparedStatement.setString(2,house.getAddress());
				preparedStatement.setString(3,house.getDescription());
				preparedStatement.setString(4,house.getPrice());
				preparedStatement.setString(5,house.getPhoneNo());
				preparedStatement.setString(6,house.getEmail());
				preparedStatement.executeUpdate();

			   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//update houses
		
		public boolean updatehouse(House house) throws SQLException{
			boolean rowUpdate;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_HOUSE_SQL);){
						statement.setString(1,house.getType());
						statement.setString(2,house.getAddress());
						statement.setString(3,house.getDescription());
						statement.setString(4,house.getPrice());
						statement.setString(5,house.getPhoneNo());
						statement.setString(6,house.getEmail());
						statement.setInt(7,house.getId());
						
						rowUpdate = statement.executeUpdate()>0;
			}
			return rowUpdate;
		}
		
		//select houses by id
		
		public House selecthouse(int id) {
			House house = null;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSE_BY_ID);){
				preparedStatement.setInt(1, id);
				System.out.print(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					
					String type = rs.getString("type");
					String address = rs.getString("address");
					String description = rs.getString("description");
					String price = rs.getString("price");
					String phoneNo = rs.getString("phoneNo");
					String email = rs.getString("email");
					house = new House (id,type,address,description,price,phoneNo,email); 
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return house;
		}
		
		//select houses
		
		public List<House> selectallhouse() {
		List <House> house = new ArrayList<>();
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOUSE);){
				System.out.print(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String type = rs.getString("type");
					String address = rs.getString("address");
					String description = rs.getString("description");
					String price = rs.getString("price");
					String phoneNo = rs.getString("phoneNo");
					String email = rs.getString("email");
					house.add(new House(id,type,address,description,price,phoneNo,email)); 
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return house;
			
		}
		
		//delete houses
		
		public boolean deletethouse(int id) throws SQLException{
			boolean rowDeleted;
			
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_HOUSE_SQL);){
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
					
			return rowDeleted;
			
		}

		
		
			
		
	}


