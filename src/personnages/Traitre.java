package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int traitrise ;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
		this.traitrise = 0;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + traitrise + ". Chut !");
	}
	public void ranconner(Commercant commercant) {
		if (traitrise == 3) {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
		else {
			
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif");
		}
		else {
			Random random = new Random();
			int i = random.nextInt(nbConnaissance);
			int don = getArgent() / 20;
			String nomAmi = memoire[i].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi +".");
			parler("Bonjour l'ami ! " + "" );
		}
	}
}
