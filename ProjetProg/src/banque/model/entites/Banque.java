package banque.model.entites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import banque.exceptions.CompteDejaExistantException;
import banque.exceptions.CompteInexistantException;
import banque.model.entites.client.Client;
import banque.model.entites.client.ComparateurSoldeCumule;
import banque.model.entites.compte.Compte;
import banque.model.entites.compte.CompteCheque;
import banque.model.entites.compte.CompteEpargne;

public class Banque {
	
	private String nom;
	private List<Client> lesClients;
	private Map<String, Client> lesComptesClient;
	
	public Banque(String nom){
		this.nom = nom;
		this.lesClients = new ArrayList<Client>();
		this.lesComptesClient = new HashMap<String, Client>();
	}

	public String getNom(){
		return this.nom;
	}
	
	public List<Client> getClients() {
		return this.lesClients;
	} 
	
	public void ajouterClient(Client unClient) {
		this.lesClients.add(unClient);
		for (Compte unCompte : unClient.getComptes()){
			this.lesComptesClient.put(unCompte.getNumeroCompte(), unClient);
		}
	}
	
	public void creeCompteCheque(String numCpte, Float solde, Float decouvert, Client client) throws CompteDejaExistantException { 
		if ( this.lesComptesClient.containsKey(numCpte)){
			throw new CompteDejaExistantException("Le compte numero " + numCpte + " existe deja");
		}
		CompteCheque cpteChq = new CompteCheque(numCpte, solde, decouvert); 
		client.ajouterCompte(cpteChq); 
		this.lesComptesClient.put(numCpte,client); 
	} 

	public void creeCompteEpargne(String numCpte, Float solde,
			Client client) throws CompteDejaExistantException {
		if ( this.lesComptesClient.containsKey(numCpte)){
			throw new CompteDejaExistantException("Le compte numero " + numCpte + " existe deja");
		}
		CompteEpargne cpteEp = new CompteEpargne(numCpte, solde);
		client.ajouterCompte(cpteEp);
		this.lesComptesClient.put(numCpte, client);
	}
	
	public List<Client> clientsARisque() { 
		List<Client> result = new ArrayList<Client>(); 
		Iterator<Client> it = lesClients.iterator(); 
		while (it.hasNext()) { 
			Client client = it.next(); 
			boolean clientArisque = false;
			Iterator<Compte> cptIt = client.getComptes().iterator(); 
			while(cptIt.hasNext() && ! clientArisque) { 
				Compte cpt = cptIt.next(); 
				if (cpt.getSolde() < 0) {
					clientArisque = true;
					result.add(client); 
				}
			} 
		} 
		return result; 
	} 

	public Client getClient(String numCpte) throws CompteInexistantException { 
		if ( ! this.lesComptesClient.containsKey(numCpte)){
			throw new CompteInexistantException("Le compte numero " + numCpte + " n'existe pas");
		}
		return this.lesComptesClient.get(numCpte);
	}
 
	public Client[] dixMeilleursClients() { 
		List<Client> lesClients = new ArrayList<Client>(this.lesClients);
		// on trie les clients par ordre croissant
		// le premier de la liste aura le plus petit solde cumulé
		Collections.sort(lesClients, new ComparateurSoldeCumule());
		Client[] dixMeilleurs = new Client[10]; 
		ListIterator<Client> it = lesClients.listIterator(lesClients.size());
		int idx = 0;
		while (it.hasPrevious() && idx < 10) { 
			dixMeilleurs[idx] = it.previous(); 
			idx++; 
		}
		return dixMeilleurs; 
	}


}
