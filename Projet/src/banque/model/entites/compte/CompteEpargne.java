package banque.model.entites.compte;

import banque.exceptions.EcritureRefuseeException;

public class CompteEpargne extends CompteAbstrait {

	public static final float PLAFOND = 7700;

	public CompteEpargne(int id, String numeroCompte, float solde) {
		super(id, numeroCompte, solde);
	}

	public CompteEpargne(String numeroCompte, float solde) {
		super(numeroCompte, solde);
	}

	@Override
	public void addEcriture(Ecriture e) throws EcritureRefuseeException {
		// TODO Auto-generated method stub
		if (this.solde + e.getMontant() < 0) {
			throw new EcritureRefuseeException(
					"La somme debitee est trop importante");
		}
		if (this.solde + e.getMontant() > CompteEpargne.PLAFOND) {
			throw new EcritureRefuseeException(
					"La somme creditee depasse le plafond");
		}
		this.solde += e.getMontant();
		this.lesEcritures.add(e);
	}

}
