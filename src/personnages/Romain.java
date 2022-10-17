package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipement = new Equipement[2];
	
	public Romain(String nom, int force) {
		assert force>0;
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
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert this.force >0;
		int forcetmp=this.force;
		this.force -= forceCoup;
		if (this.force > 0 && this.force < forcetmp) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public enum Equipement{
		CASQUE("casque"),BOUCLIER("bouclier");
		private String nom;
		
		private Equipement(String nom) {
			this.nom=nom;
		}
		
		public String toString() {
			return this.nom;
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement){
			
		case 2:
			System.out.println("Le soldat "+this.getNom()+" est déjà bien protégé !");
			break;
			
		default:
			int y=0;
			for (int i = 0 ; i < this.nbEquipement ;i++) {
				if(this.equipement[i] == equipement) {
					System.out.println("Le soldat "+this.getNom()+" possède déjà un "+this.equipement[i].toString());
					y=1;
				}
			}
			if(y==0) {
				this.equipement[this.nbEquipement]=equipement;
				this.nbEquipement+=1;
				System.out.println("Le soldat "+this.getNom()+" s'équipe d'un "+equipement.toString());
			}
			break;
		}
		
		
	}

	public static void main(String[] args) {
		Romain romulus = new Romain("Romulus",6);
		Romain minus = new Romain("Minus",6);
		
		romulus.prendreParole();
		romulus.parler("Bonsoir");
		romulus.recevoirCoup(2);
		romulus.recevoirCoup(4);
		
		System.out.println(Equipement.BOUCLIER.toString());
		System.out.println(Equipement.CASQUE.toString());
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
}
