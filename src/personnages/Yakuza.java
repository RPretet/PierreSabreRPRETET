package personnages;

public class Yakuza extends Humain {
	public String clan;
	public int reputation;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.nom + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J'ai piqué les " + gain + " sous de " + victime.nom + ", ce qui me fait "
				+ getArgent() + " sous dans ma poche. Hi ! Hi !");
		reputation += 1;
	}
}
