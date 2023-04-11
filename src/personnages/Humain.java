package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	private int tailleMemoire = 30;
	protected Humain[] memoire = new Humain[tailleMemoire];
	protected int nbConnaissance = 0;

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche.Je ne peux même pas m'offrir " + bien + " à " + prix
					+ " sous.");
		}
	}

	protected void gagnerArgent(int gain) {
		argent = argent + gain;
	}

	protected void perdreArgent(int perte) {
		argent = argent - perte;
	}

	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}

	private void memoriser(Humain humain) {
		if ((nbConnaissance) == tailleMemoire) {
			for (int i = 0; i < tailleMemoire - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[tailleMemoire - 1] = humain;
		} else {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	public void listerConnaissance() {
		String phrase = "Je connais beaucoup de monde dont : ";
		for (int i = 0; i < nbConnaissance; i++) {
			phrase += memoire[i].getNom();
			if (i != nbConnaissance - 1) {
				phrase += ", ";
			}
		}
		parler(phrase);
	}
}
