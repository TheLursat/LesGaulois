package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	/**
	 * @return the nom
	 */
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
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est "+this.effetPotion+" fois décuplée. ");
	}
		
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8 );
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		
		asterix.prendreParole();
		asterix.parler("Bonsoir");
		Romain romulus = new Romain("Romulus",5);
		asterix.frapper(romulus);
		asterix.boirePotion(5);
	}

	
}
