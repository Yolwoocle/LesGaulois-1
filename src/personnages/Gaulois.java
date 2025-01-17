package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(effetPotion * force / 3);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	// FONCTION MAIN
	public static void main(String[] args) {
		Druide druide = new Druide("Druidix", 5, 10);
		Gaulois gaulois = new Gaulois("Gaulux", 3);
		Romain romain = new Romain("Rominus", 3);

		int force = druide.preparerPotion();
		gaulois.boirePotion(force);

		gaulois.parler("Je suis un gaulois");
		gaulois.frapper(romain);
	}
}