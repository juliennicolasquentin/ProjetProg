package banque.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {

	protected String url = null;
	protected String username = null;
	protected String password = null;
	protected String driver = null;

	public DAO() {
			// charger les propri�t�s depuis le fichier properties
			// charger le driver
	}

	protected Connection getConnection() throws SQLException {
		// retourne une connexion � la base
		return null;
	}

	private void initProperties() {
		// charge le fichier properties
		// initialise les attributs d'apr�s les valeurs
		// indiqu�es dans le fichier
	}

}