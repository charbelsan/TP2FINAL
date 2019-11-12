package fr.uvsq.amine_charbel.compte;

public class Compte {
private int solde;
	
	public Compte(int solde) {
		if (solde > 0){
			this.solde = solde;
		}
		else throw new IllegalArgumentException("Un compte ne peut pas etre à decouvert !");
	}
	public int consulter() {
		return this.solde;
	}
	public void credit(int credit) {
		if (credit < 0) {
			throw new IllegalArgumentException("Seules des sommes positives peuvent être creditées");
		}
		else this.solde += credit;
	}
	public void debit(int debit) {
		if (debit < 0) {
			throw new IllegalArgumentException("Seules des sommes positives peuvent être debitées");
		}
		else if (debit < this.solde) {
			this.solde -= debit;
		}
		else throw new IllegalArgumentException("L'invocation du débit ne peut se faire qu’avec une somme inférieure au solde du compte concerné.");
	}
	public void virement(Compte c, int montant) {
		if (montant < 0) {
			throw new IllegalArgumentException("Seules des sommes positives peuvent être virées");
		}
		else if (montant > this.solde) {
			throw new IllegalArgumentException("L'invocation du virement ne peut se faire qu’avec une somme inférieure au solde du compte concerné.");
		}
		else {
			c.credit(montant);
			this.debit(montant);
		}
			
	}
}
