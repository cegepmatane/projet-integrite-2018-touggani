package donnee;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import modele.Vainqueur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class VainqueurDAO implements VainqueurSQL {
	
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
			ResultSet curseurListeVainqueur = requeteListeVainqueur.executeQuery(SQL_LISTER_VAINQUEUR);
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
			PreparedStatement requeteAjouterVainqueur = connection.prepareStatement(SQL_AJOUTER_VAINQUEUR);
			requeteAjouterVainqueur.setString(1, vainqueur.getNomEquipe());
			requeteAjouterVainqueur.setString(2, vainqueur.getDate());
			requeteAjouterVainqueur.setString(3, vainqueur.getEntraineur());
			requeteAjouterVainqueur.setString(4, vainqueur.getCapitaine());
			
			System.out.println("SQL : " + SQL_AJOUTER_VAINQUEUR);
			requeteAjouterVainqueur.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifierVainqueur(Vainqueur vainqueur)
	{
		System.out.println("VainqueurDAO.modifierVainqueur()");
		try {
			PreparedStatement requeteModifierVainqueur = connection.prepareStatement(SQL_MODIFIER_VAINQUEUR);
			requeteModifierVainqueur.setString(1, vainqueur.getNomEquipe());
			requeteModifierVainqueur.setString(2, vainqueur.getDate());
			requeteModifierVainqueur.setString(3, vainqueur.getEntraineur());
			requeteModifierVainqueur.setString(4, vainqueur.getCapitaine());
			requeteModifierVainqueur.setInt(5, vainqueur.getId());
			System.out.println("SQL : " + SQL_MODIFIER_VAINQUEUR);
			requeteModifierVainqueur.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vainqueur rapporterVainqueur(int idVainqueur)
	{
		PreparedStatement requeteVainqueur;
		try {
			requeteVainqueur = connection.prepareStatement(SQL_RAPPORTER_VAINQUEUR);
			requeteVainqueur.setInt(1, idVainqueur);

			System.out.println(SQL_RAPPORTER_VAINQUEUR);
			ResultSet curseurVainqueur = requeteVainqueur.executeQuery();

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