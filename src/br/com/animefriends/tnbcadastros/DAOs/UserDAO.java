package br.com.animefriends.tnbcadastros.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import br.com.animefriends.tnbcadastros.connectionFactory.ConnectionFactory;
import br.com.animefriends.tnbcadastros.models.Gender;
import br.com.animefriends.tnbcadastros.models.User;

@Repository
public class UserDAO {

	private ConnectionFactory connectionFactory;
	public UserDAO() {
		connectionFactory = new ConnectionFactory();
	}
	
	public void insert(User user) {
		String sql = "INSERT INTO users SET name = ?, email = ?, password = ?, birthday = ?, gender = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setDate(4, new Date(user.getBirthday().getTime()));
			stmt.setString(5, user.getGender().toString());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			connectionFactory.close();
		}
	}
	
	public User auth(User user) {
		String sql = "SELECT id, name, birthday, gender FROM users WHERE email = ? AND password = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			ResultSet returns = stmt.executeQuery();
			User authUser = null;
			if(returns.next()) {
				authUser = new User();
				authUser.setId(returns.getLong("id"));
				authUser.setName(returns.getString("name"));
				authUser.setBirthday(returns.getDate("birthday"));
				authUser.setGender(Gender.valueOf(returns.getString("gender")));
				authUser.setEmail(user.getEmail());
				authUser.setPassword(user.getPassword());				
				}
			returns.close();
			return authUser;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			connectionFactory.close();
		}
	}
}