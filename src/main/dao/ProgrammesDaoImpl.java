package appli_naaa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import appli_naaa.model.Exercices;
import appli_naaa.model.Programmes;

public class ProgrammesDaoImpl implements ProgrammesDao{

	@Override
	public void insert(Programmes obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement(
					"insert into programmes"
					+ "(id_programme, nom_programme, liste_exercices) "
					+ "values(?,?,?)");
			preparedStatement.setInt(1, obj.getIdProgramme());
			preparedStatement.setString(2, obj.getNomProgramme());
			preparedStatement.setString(3, obj.getListeExercicesString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void update(Programmes obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"update programmes "
					+ "set nom_programme=?, liste_exercices=? "
					+ "where id_programme=?");
			preparedStatement.setString(1, obj.getNomProgramme());
			preparedStatement.setString(2, obj.getListeExercicesString());
			preparedStatement.setInt(3, obj.getIdProgramme());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"delete from programmes where id_programme=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void delete(Programmes obj) {
		deleteByKey(obj.getIdProgramme());
		
	}

//	private List<Exercices> findListeExercices(ResultSet rs) throws SQLException{
////		System.out.println("A");
//		ExercicesDao exercicesDao = Context.getExercicesDao();
//		List<Exercices> listExos = new ArrayList<>();
//		for (String s:rs.getString("liste_exercices").split(",")) {
//			Exercices exo=exercicesDao.findByKey(Integer.parseInt(s.split(":")[0]));
//			exo.setRepetition(Integer.parseInt(s.split(":")[1]));
//			listExos.add(exo);
//		}
//		return listExos;
//	}
	@Override
	public Programmes findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * "
					+ "from programmes "
					+ "where id_programme=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				//System.out.println(rs.getInt("id_programme")+" "+rs.getString("nom_programme")+" "+rs.getString("liste_exercices"));
				Programmes programmeRes = new Programmes(rs.getInt("id_programme"), rs.getString("nom_programme"),rs.getString("liste_exercices"));
				programmeRes.setListeExercices(programmeRes.getListeExercicesList());
				return programmeRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}

	@Override
	public List<Programmes> findAll() {
		List<Programmes> programmesAll=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * from programmes");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				programmesAll.add(new Programmes(rs.getInt("id_programme"), rs.getString("nom_programme"),rs.getString("liste_exercices")));
				}
				
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
		for (Programmes p:programmesAll) {
			p.setListeExercices(p.getListeExercicesList());
		}
		return programmesAll;

	}

}
