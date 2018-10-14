package donnee;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Distinction;
import java.sql.ResultSet;
import java.sql.Statement;
import modele.Vainqueur;
 
 public class DistinctionDAO implements DistinctionSQL {
	private Connection connection = null;
	
	
 	public DistinctionDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Distinction> listerDistinctionsParVainqueur(int idVainqueur)
	{
		System.out.println("DistinctionDAO.listerDistinctions()");
		List<Distinction> listeDistinctions =  new ArrayList<Distinction>();			
		PreparedStatement requeteListeDistinctions;
		try {
			requeteListeDistinctions = connection.prepareStatement(SQL_LISTER_DISTINCTIONS_PAR_VAINQUEUR);
			requeteListeDistinctions.setInt(1, idVainqueur);
			ResultSet curseurListeDistinctions = requeteListeDistinctions.executeQuery();
			while(curseurListeDistinctions.next())
			{
				int id = curseurListeDistinctions.getInt("id");
				String titre = curseurListeDistinctions.getString("titre");
				String description = curseurListeDistinctions.getString("description");
				String prix = curseurListeDistinctions.getString("prix");	
				int idvainqueur = curseurListeDistinctions.getInt("idvainqueur");
				System.out.println("Distinction " + titre );
				
				Distinction distinction = new Distinction(titre, description, prix, idvainqueur);
				distinction.setId(id);
				listeDistinctions.add(distinction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerDistinctions();
		return listeDistinctions;
	}	
	
	public List<Distinction> listerDistinctions(){
		System.out.println("DistinctionDAO.listerDistinctions()");
		List<Distinction> listeDistinctions =  new ArrayList<Distinction>();			
		Statement requeteListeDistinctions;
		try {
			requeteListeDistinctions = connection.createStatement();
			ResultSet curseurListeDistinctions = requeteListeDistinctions.executeQuery("SELECT * FROM distinction WHERE vainqueur = 2");
			while(curseurListeDistinctions.next())
			{
				int id = curseurListeDistinctions.getInt("id");
				String titre = curseurListeDistinctions.getString("titre");
				String description = curseurListeDistinctions.getString("description");
				String prix = curseurListeDistinctions.getString("prix");
				int idvainqueur = curseurListeDistinctions.getInt("idvainqueur");				
				
				Distinction distinction = new Distinction(titre, description, prix, idvainqueur);
				distinction.setId(id);
				listeDistinctions.add(distinction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerDistinctions();
		return listeDistinctions;
		}	
		
		public List<Distinction> simulerListerDistinctions(){
		
		List<Distinction> listeDistinctions = new ArrayList<Distinction>();
		Distinction prix;
		prix = new Distinction("Meilleur equipe", "Meilleur equipe de la competition", "Medaille d'or", 1);
		listeDistinctions.add(prix);
		prix = new Distinction("Meilleur buteur", "L'equipe a le meilleur buteur de la competition", "Petite coupe", 1);
		listeDistinctions.add(prix);

		
		return listeDistinctions;
	}
	
}