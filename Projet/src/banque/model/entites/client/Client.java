package banque.model.entites.client;

import java.util.List;

import banque.exceptions.CompteDejaExistantException;
import banque.exceptions.CompteInexistantException;
import banque.exceptions.EcritureRefuseeException;
import banque.model.entites.compte.Compte;

public interface Client {
	
	public int getId();
	public void setId(int id);
	public Identite getIdentite();
	public String getAdresse();
	public List<Compte> getComptes();
	public boolean equals(Object o);
	public void ajouterCompte(Compte unCompte) throws CompteDejaExistantException;
	public Compte getCompte(String numero) throws CompteInexistantException;
	public void addEcriture(String numCompte, String intitule, java.util.Date date, float montant) throws CompteInexistantException, EcritureRefuseeException;
	public float soldeCumule();
	
}
