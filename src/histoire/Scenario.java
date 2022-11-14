package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import personnages.Musee;
import personnages.Trophee;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8 );
		Romain minus = new Romain("Minus",6);
		Musee musee = new Musee();
		
		Gaulois obelix = new Gaulois("Obélix",400);
		Druide panoramix = new Druide("Panoramix",5,10);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour à tous");
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
		Romain milexus = new Romain("Milexus",6);
		milexus.sEquiper(Equipement.CASQUE);
		asterix.frapper(milexus);
		asterix.frapper(milexus);
		
		asterix.faireUneDonnation(musee);
		
		System.out.println(musee.extraireInstructionsCaml());
	}

}
