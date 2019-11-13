package fr.uvsq.amine_charbel.compte;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompteTest {

	@Test
	public void consulterTest() {
		int soldeTest = 12;
		Compte c1 = new Compte(soldeTest);
		int solde = c1.consulter();
		assertTrue(solde == soldeTest);
	}
	
	@Test
	public void creditTest() {
		Compte c1 = new Compte(50);
		int creditAjouter = 20;
		int resultatAttendu = c1.consulter() + creditAjouter;
		c1.credit(creditAjouter);
		int resultat = c1.consulter();
		assertEquals(resultat,resultatAttendu);
	}
	
	@Test
	public void debitTest() {
		Compte c1 = new Compte(50);
		int creditDebiter = 20;
		int resultatAttendu = c1.consulter() - creditDebiter;
		c1.debit(creditDebiter);
		int resultat = c1.consulter();
		assertEquals(resultat,resultatAttendu);
	}
	
	@Test
	public void virementTest() {
		Compte c1 = new Compte(50);
		Compte c2 = new Compte(50);
		int montant = 20;
		int resultatAttenduc1 = c1.consulter() - montant;
		int resultatAttenduc2 = c2.consulter() + montant;;
		c1.virement(c2, montant);
		assertTrue (resultatAttenduc1 == c1.consulter() && resultatAttenduc2 == c2.consulter());
	}
}