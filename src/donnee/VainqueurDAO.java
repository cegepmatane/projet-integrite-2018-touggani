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
	
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/Competition";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "root";	
	private Connection connection = null;
	
	public VainqueurDAO()
	{		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Vainqueur> listerVainqueur()
	{
 		List<Vainqueur> listeVainqueur =  new ArrayList<Vainqueur>();			
		Statement requeteListeVainqueur;
		try {
			requeteListeVainqueur = connection.createStatement();
			ResultSet curseurListeVainqueur = requeteListeVainqueur.executeQuery("SELECT * FROM vainqueur");
			while(curseurListeVainqueur.next())
			{
				int id = curseurListeVainqueur.getInt("id");
				String nomEquipe = curseurListeVainqueur.getString("nomEquipe");
				String date = curseurListeVainqueur.getString("date");
				String entraineur = curseurListeVainqueur.getString("entraineur");
				String capitaine = curseurListeVainqueur.getString("capitaine");
				System.out.println("Vainqueur " + nomEquipe + " a gagné le " + date + " avec le coach " + entraineur + " et avec le capitaine " + capitaine);
				Vainqueur vainqueur = new Vainqueur(nomEquipe, date, entraineur, capitaine);
				vainqueur.setId(id);
				listeVainqueur.add(vainqueur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return this.simulerListerVainqueur();
		return listeVainqueur;
	}
	
	public void ajouterVainqueur(Vainqueur vainqueur)
	{
		System.out.println("VainqueurDAO.ajouterVainqueur()");
		try {
			Statement requeteAjouterVainqueur = connection.createStatement();
			String sqlAjouterVainqueur = "INSERT into vainqueur (date, entraineur, capitaine, nomEquipe) VALUES ('"+vainqueur.getDate()+"','"+vainqueur.getEntraineur()+"','"+vainqueur.getCapitaine()+"','"+vainqueur.getNomEquipe()+"')";
			System.out.println("SQL : " + sqlAjouterVainqueur);	
			requeteAjouterVainqueur.execute(sqlAjouterVainqueur);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Vainqueur rapporterVainqueur(int idVainqueur)
	{
		Statement requeteVainqueur;
		try {
			requeteVainqueur = connection.createStatement();
			String SQL_RAPPORTER_VAINQUEUR = "SELECT * FROM vainqueur WHERE id = " + idVainqueur;
			System.out.println(SQL_RAPPORTER_VAINQUEUR);
			ResultSet curseurVainqueur = requeteVainqueur.executeQuery(SQL_RAPPORTER_VAINQUEUR);
			curseurVainqueur.next();
			int id = curseurVainqueur.getInt("id");
			String nomEquipe = curseurVainqueur.getString("nomEquipe");
			String date = curseurVainqueur.getString("date");
			String entraineur = curseurVainqueur.getString("entraineur");
			String capitaine = curseurVainqueur.getString("capitaine");
			System.out.println("Vainqueur " + nomEquipe + " a gagné le " + date + " avec " + entraineur + " comme entraineur et le capitaine " + capitaine);
			Vainqueur vainqueur = new Vainqueur(nomEquipe, date, entraineur, capitaine);
			vainqueur.setId(id);
			return vainqueur;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
}
}