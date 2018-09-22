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
	
	private Connection connection = null;
	
	public VainqueurDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	private List<Vainqueur> simulerListerVainqueur()
	{
		List<Vainqueur> listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		return listeVainqueurTest;
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
	
	public void modifierVainqueur(Vainqueur vainqueur)
	{
		System.out.println("VainqueurDAO.modifierVainqueur()");
		try {
			Statement requeteModifierVainqueur = connection.createStatement();
			String SQL_MODIFIER_VAINQUEUR = "UPDATE vainqueur SET nom = '"+vainqueur.getNomEquipe()+"', couleur = '"+vainqueur.getDate()+"', poids = '"+vainqueur.getEntraineur()+"', naissance = '"+vainqueur.getCapitaine()+"' WHERE id = " + vainqueur.getId();
			System.out.println("SQL : " + SQL_MODIFIER_VAINQUEUR);
			requeteModifierVainqueur.execute(SQL_MODIFIER_VAINQUEUR);
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