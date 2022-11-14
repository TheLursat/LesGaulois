package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophee(Gaulois gaulois, Equipement equipement) {
		super();
		this.gaulois = gaulois;
		this.equipement = equipement;
	}

	/**
	 * @return the gaulois
	 */
	public Gaulois getGaulois() {
		return gaulois;
	}

	/**
	 * @return the equipement
	 */
	public Equipement getEquipement() {
		return equipement;
	}
	
	public String donnerNom() {
		return this.getGaulois().getNom();
	}
}
