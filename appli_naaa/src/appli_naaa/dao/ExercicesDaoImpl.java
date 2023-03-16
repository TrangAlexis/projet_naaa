package appli_naaa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import appli_naaa.model.Exercices;

public class ExercicesDaoImpl implements ExercicesDao{

	@Override
	public void insert(Exercices obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement(
					"insert into exercices"
					+ "(id_exercices, nom_exercice, description) "
					+ "values(?,?,?)");
			preparedStatement.setInt(1, obj.getIdExercices());
			preparedStatement.setString(2, obj.getNomExercice());
			preparedStatement.setString(3, obj.getDescription());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void update(Exercices obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"update exercices "
					+ "set nom_exercice=?, description=? "
					+ "where id_exercices=?");
			preparedStatement.setString(1, obj.getNomExercice());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getIdExercices());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
		
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"delete from exercices where id_exercices=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void delete(Exercices obj) {
		deleteByKey(obj.getIdExercices());
		
	}

	@Override
	public Exercices findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * "
					+ "from exercices "
					+ "where id_exercices=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Exercices exerciceRes = new Exercices(rs.getInt("id_exercices"), rs.getString("nom_exercice"),
						rs.getString("description"));
				return exerciceRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}

	@Override
	public List<Exercices> findAll() {
		List<Exercices> exercicesAll=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * from exercices ");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				exercicesAll.add(new Exercices(rs.getInt("id_exercices"), rs.getString("nom_exercice"),
						rs.getString("description")));}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return exercicesAll;
	}

}
