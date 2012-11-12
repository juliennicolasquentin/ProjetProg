package banque.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banque.model.entites.client.Client;
import banque.model.entites.client.Particulier;

public class ClientDAO extends DAO {

	public ClientDAO() {
		super();
	}

	public List<Client> recupererClientsParticuliers() {
		List<Client> lesClients = new ArrayList<Client>();
		try {
			Connection con = this.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT ID_PARTICULIER, NOM, PRENOM, ADRESSE FROM particulier");
			while (rs.next()) {
				Particulier p = new Particulier(rs.getString("NOM"),
						rs.getString("PRENOM"), rs.getString("ADRESSE"));
				p.setId(rs.getInt("ID_PARTICULIER"));
				lesClients.add(p);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		return lesClients;
	}

}
