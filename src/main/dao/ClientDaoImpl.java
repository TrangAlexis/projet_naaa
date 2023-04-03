package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.model.Client;

public class ClientDaoImpl implements ClientDao{

	@Override
	public void insert(Client obj) {
		try {
			PreparedStatement preparedStatement = Context.getContext().getConnection().prepareStatement(
					"insert into client"
					+ "(id_client,statut,nom,prenom,compte,mot_de_passe,points_de_succes,e_mail,id_succes) "
					+ "values(null,?,?,?,?,?,0,?,null)");
			preparedStatement.setString(1, obj.getStatut());
			preparedStatement.setString(2, obj.getNom());
			preparedStatement.setString(3, obj.getPrenom());
			preparedStatement.setString(4, obj.getCompte());
			preparedStatement.setString(5, obj.getMotDePasse());
			preparedStatement.setString(6, obj.getE_mail());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void update(Client obj) {
		 try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"update client "
					+ "set statut=?, nom=?, prenom=?, "
					+ "compte=?, mot_de_passe=?, points_de_succes=?, "
					+ "e_mail=?, id_succes=? "
					+ "where id_client=?");
			preparedStatement.setString(1, obj.getStatut());
			preparedStatement.setString(2, obj.getNom());
			preparedStatement.setString(3, obj.getPrenom());
			preparedStatement.setString(4, obj.getCompte());
			preparedStatement.setString(5, obj.getMotDePasse());
			preparedStatement.setInt(6, obj.getPointsDeSucces());
			preparedStatement.setString(7, obj.getE_mail());
			preparedStatement.setInt(8, obj.getIdSucces());
			preparedStatement.setInt(9, obj.getIdClient());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"delete from client where id_client=?");
			preparedStatement.setInt(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}
	
	public void deleteByCompte(String key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"delete from client where compte=?");
			preparedStatement.setString(1,key);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		
	}

	@Override
	public void delete(Client obj) {
		deleteByKey(obj.getIdClient());
		
	}

	@Override
	public Client findByKey(Integer key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * "
					+ "from client "
					+ "where id_client=?");
			preparedStatement.setInt(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Client clientRes = new Client(rs.getInt("id_client"), rs.getString("statut"), rs.getString("nom")
						, rs.getString("prenom"), rs.getString("compte"), rs.getString("mot_de_passe")
						, rs.getInt("points_de_succes"), rs.getString("e_mail"), rs.getInt("id_succes"));
				return clientRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}
	
	public Client findByCompte(String key) {
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * "
					+ "from client "
					+ "where compte=?");
			preparedStatement.setString(1,key);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				Client clientRes = new Client(rs.getInt("id_client"), rs.getString("statut"), rs.getString("nom")
						, rs.getString("prenom"), rs.getString("compte"), rs.getString("mot_de_passe")
						, rs.getInt("points_de_succes"), rs.getString("e_mail"), rs.getInt("id_succes"));
				return clientRes;
			}
			preparedStatement.close();
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}

		System.out.println("findKey unsuccessful");
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clientAll=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=Context.getContext().getConnection().prepareStatement(
					"select * from client ");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				clientAll.add(new Client(rs.getInt("id_client"), rs.getString("statut"), rs.getString("nom")
						, rs.getString("prenom"), rs.getString("compte"), rs.getString("mot_de_passe")
						, rs.getInt("points_de_succes"), rs.getString("e_mail"), rs.getInt("id_succes")));}
		} catch (SQLException e) {e.printStackTrace();} finally {Context.destroy();}
		return clientAll;
	}

}
