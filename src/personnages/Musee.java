package personnages;

public class Musee {
	int nbTrophees = 0;
	Trophee[] trophee= new Trophee[200];
	
	
	public Musee() {
		super();
	}

	public String extraireInstructionsCaml() {
		String newLine = System.getProperty("line.separator");
		String chaineCaml = "let musee = [";
		for(int i=0;i<nbTrophees-1;i++) {
			chaineCaml += newLine + "\t\""+trophee[i].donnerNom()+"\", \""+trophee[i].getEquipement().toString()+"\";";
		}
		if(this.nbTrophees > 0) {
			chaineCaml += newLine + "\t\""+trophee[this.nbTrophees-1].donnerNom()+"\", \""+trophee[this.nbTrophees-1].getEquipement().toString()+"\""+newLine;
		}
		chaineCaml +="]";
		return chaineCaml;
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if(this.nbTrophees < 200) {
			trophee[nbTrophees]=new Trophee(gaulois,equipement);
			nbTrophees+=1;
		}
	}
	
}
