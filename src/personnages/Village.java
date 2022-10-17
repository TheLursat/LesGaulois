package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if(this.nbVillageois < this.villageois.length ) {
			this.villageois[nbVillageois] = gaulois;
			this.nbVillageois += 1;
		}
	}
	
	public Gaulois trouverHabitant(int nHabitant) {
		return this.villageois[nHabitant];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+this.chef+" vivent les légendaires gaulois :");
		for(int i=0; i<this.nbVillageois;i++) {
			System.out.println("- "+this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// out of bond car on dépasse la taille du tableau villageois
		Chef abraracourcix = new Chef("Abraracourcix",6,1,village);
		Gaulois asterix = new Gaulois("Asterix",8 );
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Cela retourne null car l'habitant 1 n'existe pas, le seul habitant du village est l'habitant 0 soit astérix
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
}
