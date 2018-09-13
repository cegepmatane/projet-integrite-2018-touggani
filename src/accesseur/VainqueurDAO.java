package accesseur;
import java.util.ArrayList;
import java.util.List;
import modele.Vainqueur;


public class VainqueurDAO {

	private List<Vainqueur> simulerListerVainqueur()
	{
		List listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		return listeVainqueurTest;
	}
	public List<Vainqueur> listerVainqueur()
	{
		return this.simulerListerVainqueur();
	}
}