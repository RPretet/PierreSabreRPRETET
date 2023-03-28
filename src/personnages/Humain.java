package personnages;

public class Humain {
	public String nom;
	public String boissonFavorite;
	private int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		super();
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
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du "
				+ boissonFavorite + ".");
	}
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	public void acheter(String bien,int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien
					+ " � " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche.Je ne peux m�me pas m'offrir "
					+ bien + " � " + prix + " sous.");
		}
	}
	protected void gagnerArgent(int gain) {
		argent = argent + gain;
	}
	
	protected void perdreArgent(int perte) {
		argent = argent - perte;
	}
}
