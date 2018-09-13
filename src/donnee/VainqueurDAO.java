package donnee;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import modele.Vainqueur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class VainqueurDAO {

	private List<Vainqueur> simulerListerVainqueur()
	{
		List<Vainqueur> listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		return listeVainqueurTest;
	}
	public List<Vainqueur> listerVainqueur()
	{
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/Competition";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "root";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Vainqueur> listeVainqueur =  new ArrayList<Vainqueur>();
		try {
			Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			Statement requeteListeVainqueur = connection.createStatement();
			ResultSet curseurListeVainqueur = requeteListeVainqueur.executeQuery("SELECT * FROM vainqueur");
			while(curseurListeVainqueur.next())
			{
				String nomEquipe = curseurListeVainqueur.getString("nomEquipe");
				String date = curseurListeVainqueur.getString("date");
				String entraineur = curseurListeVainqueur.getString("entraineur");
				String capitaine = curseurListeVainqueur.getString("capitaine");
				System.out.println("Vainqueur " + nomEquipe + " a gagné le " + date + " avec le coach " + entraineur + " et le capitaine " + capitaine);
				Vainqueur mouton = new Vainqueur(nomEquipe, date, entraineur, capitaine);
				listeVainqueur.add(mouton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return this.simulerListerVainqueur();
		return listeVainqueur;
		
	}
}