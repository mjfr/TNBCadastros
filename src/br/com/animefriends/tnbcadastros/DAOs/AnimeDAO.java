package br.com.animefriends.tnbcadastros.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.animefriends.tnbcadastros.connectionFactory.ConnectionFactory;
import br.com.animefriends.tnbcadastros.models.Anime;
import br.com.animefriends.tnbcadastros.models.User;

@Repository
public class AnimeDAO {

	private ConnectionFactory connectionFactory;

	public AnimeDAO() {
		connectionFactory = new ConnectionFactory();
	}

	public Anime search(Long id) {
		String sql = "SELECT name FROM animes WHERE id = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet result = stmt.executeQuery();
			Anime a = new Anime();
			if (result.next()) {
				a.setId(id);
				a.setName(result.getString("name"));
			}
			result.close();
			return a;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public List<Anime> searchAllByUser(User user) {
		String sql = "SELECT id, name, registerDate FROM animes WHERE users_id = ?";
		List<Anime> listAnimes = new ArrayList<>(100);
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, user.getId());
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Anime a = new Anime();
				a.setId(result.getLong("id"));
				a.setName(result.getString("name"));
				a.setRegisterDate(result.getDate("registerDate"));
				listAnimes.add(a);
			}
			result.close();
			return listAnimes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void alter(Anime anime) {
		String sql = "UPDATE animes SET name = ?, registerDate = ? WHERE id = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, anime.getName());
			stmt.setDate(2, new Date(anime.getRegisterDate().getTime()));
			stmt.setLong(3, anime.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void delete(Anime anime) {
		String sql = "DELETE FORM animes WHERE id = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, anime.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void insert(Anime anime) {
		String sql = "INSERT INTO animes SET users_id = ?, name = ?, registerDate = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, anime.getUser().getId());
			stmt.setString(2, anime.getName());
			stmt.setDate(3, new Date(anime.getRegisterDate().getTime()));
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}
}