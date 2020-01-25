package GaMEAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.util.ResultSetUtil;

public class GameyutilityImpl implements gameUtility {
	//connection DB
  	private static Connection connection=ConnectionDao.getInstance().getConnection();
	
	public int insertGame(GameEntity GameEntity) {
		String PlayerName=GameEntity.getPlayersName();
		char PlayerGender=GameEntity.getPlayersGender();
		int team=GameEntity.getTeam();
		int gameTime=GameEntity.getGameTime();
		String Location=GameEntity.getLocation();
		int result=0;
		try{
		 // connection=ConnectionDao.getInstance().getConnection();

			String sqlpQuery="'insert into gameData(playersName,playersGender,team,gameTime ,Location,reg_date) values(?,?,?,?,?,?)'";
			   
			String insertTableSQL = "INSERT INTO gameData(playersName,playersGender,team,gameTime ,Location,reg_date)"
					+ "(playersName, playersGender, team, gameTime,Location,reg_date) VALUES"
					+ "(?,?,?,?,?,?)";

			/*
			 * String
			 * sqlquery="insert into gameData(playersName,playersGender,team,gameTime ,Location,reg_date) values('"
			 * +PlayerName + "','" + PlayerGender + "','" + team + "','" + gameTime +
			 * "','"+Location+"',CURRENT_TIMESTAMP)";
			 */
			PreparedStatement p=connection.prepareStatement(insertTableSQL);
			p.setString(1,PlayerName);
			p.setString(2, String.valueOf(PlayerGender));
			p.setInt(3,team);
			p.setInt(4,gameTime);
			p.setString(5, Location);
			//p.setString(5,'CURRENT_TIMESTAMP');
			p.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

			 result=p.executeUpdate(sqlpQuery);
            
			 
			//Statement s=statementReturn(p); 
			//result=s.executeUpdate(sqlquery);
		}catch(SQLException e){
			  e.printStackTrace();
		}
		
		return result;
	}

	public List<GameEntity> getAllGame() {
	    List<GameEntity> ls=new ArrayList<GameEntity>();
		try {

			Statement s=statementReturn(connection);
			String sqlQuery="select * from gameData";
			 ResultSet rs=s.executeQuery(sqlQuery);
			 while(rs.next()){
				 GameEntity ge=new GameEntity(rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getString(6));
				 ls.add(ge);
			 }
		} catch (SQLException e) {
	      e.printStackTrace();
		 }
		return ls;
	}

	@Override
	public List<GameEntity> getGameLocation(String loc) {
		 List<GameEntity> ls=new ArrayList<GameEntity>();
			try {

				Statement s=statementReturn(connection);
				String sqlQuery="select * from gameData where Location='"+loc.toLowerCase()+"'";
				 ResultSet rs=s.executeQuery(sqlQuery);
				 while(rs.next()){
					 GameEntity ge=new GameEntity(rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getString(6));
					 ls.add(ge);
				 }
			} catch (SQLException e) {
		      e.printStackTrace();
			 }
			return ls;
	}

	@Override
	public List<String> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllMalePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllFemalePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePlayers(String players) {
		int del =0;
		try {
			Statement s=statementReturn(connection);
			String delete="delete from gameData where playersName='"+players.toLowerCase()+"' ";
			del=s.executeUpdate(delete);
			//System.out.println("del:::"+del);
		} catch (Exception e) {
		    e.printStackTrace();
		    
		}
		return (del>0)?true:false;
	}
	/*method statementReturn
	 * This is use for create statement 
	*
	*  @param connection 
	*/
	private  Statement statementReturn(Connection connection) throws SQLException {
		
		   return (Statement) connection.createStatement();
	}

}
