package personnages;

public class Ronin extends Humain {
	public int honneur;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
		this.honneur = 1;
	}
	public void donner(Commercant beneficiaire) {
		int bourse = getArgent();
		bourse = bourse / 10 ;
		parler(beneficiaire.getNom() + " prend ces " + bourse + " sous.");
		perdreArgent(bourse);
		beneficiaire.recevoir(bourse);
	}
}
