package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom
				+ " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int preparerPotion() {
		Random random = new Random();
		int forcePotion = random.nextInt(effetPotionMax - effetPotionMin) + effetPotionMin;

		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force");
		}

		return forcePotion;
	}

	public void boste(Gaulois gaulois) {
		if (forcePotion == 1) {
			forcePotion = preparerPotion();
		}

		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
			return;
		}

		gaulois.boirePotion(forcePotion);
	}

	// FONCTION MAIN
	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.preparerPotion();
	}
}