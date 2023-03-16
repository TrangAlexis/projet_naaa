package appli_naaa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import appli_naaa.model.Client;
import appli_naaa.model.Succes;

public class SuccesDaoImpl implements SuccesDao{

	@Override
	public void insert(Succes obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement(
					"insert into succes"
					+ "(id_succes, nom_succes, description, points_gagnes) "
					+ "values(?,?,?,?)");
			preparedStatement.setInt(1, obj.getIdSucces());
			preparedStatement.setString(2, obj.getNomSucces());
			preparedStatement.setString(3, obj.getDescription());
			preparedStatement.setInt(4, obj.getPointGagnes());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void update(Succes obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"update succes "
					+ "set nom_succes=?, description=?, points_gagnes=? "
					+ "where id_succes=?");
			preparedStatement.setString(1, obj.getNomSucces());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getPointGagnes());
			preparedStatement.setInt(4, obj.getIdSucces());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"delete from succes where id_succes=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
	}

	@Override
	public void delete(Succes obj) {
		deleteByKey(obj.getIdSucces());
	}

	@Override
	public Succes findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * "
					+ "from succes "
					+ "where id_succes=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Succes succesRes = new Succes(rs.getInt("id_succes"), rs.getString("nom_succes"),
						rs.getString("description"), rs.getInt("points_gagnes"));
				return succesRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}

	@Override
	public List<Succes> findAll() {
		List<Succes> succesAll=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * from succes ");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				succesAll.add(new Succes(rs.getInt("id_succes"), rs.getString("nom_succes"),
						rs.getString("description"), rs.getInt("points_gagnes")));}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return succesAll;
	}

}
