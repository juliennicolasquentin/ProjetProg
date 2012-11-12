package banque.controller;


import banque.model.dao.ClientDAO;
import banque.model.entites.Banque;
import banque.model.entites.client.Client;
import banque.view.Appli;

public class Controleur {

	// la vue
	private Appli fenetre;

	// les DAO
	private ClientDAO daoClient = new ClientDAO();
	
	// le modele
	private Banque maBanque;

	public Controleur(Appli laFenetre) {
		this.maBanque = new Banque("mybank");
		for(Client unClient : daoClient.recupererClientsParticuliers()){
			this.maBanque.ajouterClient(unClient);
		}
		this.fenetre = laFenetre;
		this.fenetre.initVue(this, this.maBanque.getClients());
	}

}
