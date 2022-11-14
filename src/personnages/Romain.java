package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipements = new Equipement[2];

	
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert this.force >0;
//		int forcetmp=this.force;
//		this.force -= forceCoup;
//		if (this.force > 0 && this.force < forcetmp) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//	}
	
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement){
			
		case 2:
			System.out.println("Le soldat "+this.getNom()+" est déjà bien protégé !");
			break;
			
		default:
			int y=0;
			for (int i = 0 ; i < this.nbEquipement ;i++) {
				if(this.equipements[i] == equipement) {
					System.out.println("Le soldat "+this.getNom()+" possède déjà un "+this.equipements[i].toString());
					y=1;
				}
			}
			if(y==0) {
				this.equipements[this.nbEquipement]=equipement;
				this.nbEquipement+=1;
				System.out.println("Le soldat "+this.getNom()+" s'équipe d'un "+equipement.toString());
			}
			break;
		}
			
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
			 parler("Aïe");
		 } else {
			 equipementEjecte = ejecterEquipement();
			 parler("J'abandonne...");
		 }
//		switch (force) {
//		case 0:
//			parler("Aïe");
//			break;
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
		}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement;i++) {
				if (this.equipements[i] != null && this.equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte+="\nMais heureusement, grace à mon équipement sa force est diminué de "+ resistanceEquipement + " !";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup <0) {
			forceCoup = 0; 
		}
		return forceCoup;
		}
	
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		this.nbEquipement=0;
		return equipementEjecte;
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
