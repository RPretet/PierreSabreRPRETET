package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	public int getReputation() {
		return reputation;
	}

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
		this.reputation = 0;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		parler(victime.getNom() + ", si tu tiens � la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J'ai piqu� les " + gain + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi ! Hi !");
		reputation += 1;
	}

	protected int perdre() {
		int perte = getArgent();
		parler("J'ai perdu mon duel et mes " + perte + " sous, snif... J'ai d�shonor� le clan de " + clan + ".");
		perdreArgent(perte);
		return perte;
	}

	protected void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan " + clan + " ? Je l'ai d�pouill� de ses " + gain
				+ " sous.");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}
}
