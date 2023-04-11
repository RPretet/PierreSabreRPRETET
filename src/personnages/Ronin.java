package personnages;

public class Ronin extends Humain {
	private int honneur;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
		this.honneur = 1;
	}

	public void donner(Commercant beneficiaire) {
		int bourse = getArgent();
		bourse = bourse / 10;
		parler(beneficiaire.getNom() + " prend ces " + bourse + " sous.");
		perdreArgent(bourse);
		beneficiaire.recevoir(bourse);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if ((honneur * 2) >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			honneur++;
			gagnerArgent(adversaire.perdre());
		} else {
			int perte = getArgent();
			honneur--;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(perte);
			perdreArgent(perte);
		}
	}
}
