package br.com.animefriends.tnbcadastros.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.animefriends.tnbcadastros.connectionFactory.ConnectionFactory;
import br.com.animefriends.tnbcadastros.models.Game;
import br.com.animefriends.tnbcadastros.models.GameCategory;
import br.com.animefriends.tnbcadastros.models.User;

@Repository
public class GameDAO {

	private ConnectionFactory connectionFactory;

	public GameDAO() {
		connectionFactory = new ConnectionFactory();
	}

	public Game search(Long id) {
		String sql = "SELECT name FROM games WHERE id = ?";
		try {
			connectionFactory.open();// Abre conexão com o banco
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);// Adiciona o parâmetro do filtro
			ResultSet result = stmt.executeQuery();// Realiza a busca
			Game g = new Game();
			if (result.next()) {
				g.setId(id);
				g.setName(result.getString("name"));
			}
			result.close(); // Após o término do ResultSet, ele é fechado
			return g; // Retorna o jogo
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();// Fecha a conexão com o banco
		}
	}

	public List<Game> searchAllByUser(User user) {
		String sql = "SELECT id, name, category, registerDate FROM games WHERE users_id = ?";
		List<Game> listGames = new ArrayList<>(100);
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, user.getId());
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Game g = new Game();
				g.setId(result.getLong("id"));
				g.setName(result.getString("name"));
				g.setCategory(GameCategory.valueOf(result.getString("category")));
				g.setRegisterDate(result.getDate("registerDate"));
				listGames.add(g);
			}
			result.close();
			return listGames;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void alter(Game game) {
		String sql = "UPDATE games SET name = ?, category = ?, registerDate = ? WHERE id = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getCategory().toString());
			stmt.setDate(3, new Date(game.getRegisterDate().getTime()));
			stmt.setLong(4, game.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void delete(Game game) {
		String sql = "DELETE FROM games WHERE id = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, game.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	public void insert(Game game) {
		String sql = "INSERT INTO games SET users_id = ?, name = ?, category = ?, registerDate = ?";
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, game.getUser().getId());
			stmt.setString(2, game.getName());
			stmt.setString(3, game.getCategory().toString());
			stmt.setDate(4, new Date(game.getRegisterDate().getTime()));
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}
}