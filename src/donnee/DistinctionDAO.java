package donnee;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Distinction;
import java.sql.ResultSet;
import java.sql.Statement;
import modele.Vainqueur;
 
 public class DistinctionDAO {
	private Connection connection = null;
	
	
 	public DistinctionDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Distinction> listerDistinctions(int idVainqueur)
	{
		System.out.println("DistinctionDAO.listerDistinctions()");
		List<Distinction> listeDistinctions =  new ArrayList<Distinction>();			
		Statement requeteListeDistinctions;
		try {
			requeteListeDistinctions = connection.createStatement();
			ResultSet curseurListeDistinctions = requeteListeDistinctions.executeQuery("SELECT * FROM distinction WHERE vainqueur = " + idVainqueur);
			while(curseurListeDistinctions.next())
			{
				int id = curseurListeDistinctions.getInt("id");
				int annee = curseurListeDistinctions.getInt("annee");
				String titre = curseurListeDistinctions.getString("titre");
				String detail = curseurListeDistinctions.getString("detail");				
				System.out.println("Distinction " + titre + " donnée en " + annee);
				
				Distinction distinction = new Distinction(annee, titre);
				distinction.setDetail(detail);
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
				int annee = curseurListeDistinctions.getInt("annee");
				String titre = curseurListeDistinctions.getString("titre");
				String detail = curseurListeDistinctions.getString("detail");				
				System.out.println("Distinction " + titre + " donnée en " + annee);
				
				Distinction distinction = new Distinction(annee, titre);
				distinction.setDetail(detail);
				distinction.setId(id);
				listeDistinctions.add(distinction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerDistinctions();
		return listeDistinctions;
		}	
		
		public List<Distinction> simulerListerDistinctions()
		
		List<Distinction> listeDistinctions = new ArrayList<Distinction>();
		Distinction prix;
		prix = new Distinction(2015, "Meilleur equipe");
		listeDistinctions.add(prix);
		prix = new Distinction(2016, "Equipe a prendre le moins de but");
		listeDistinctions.add(prix);
		prix = new Distinction(2016, "Equipe a mettre le plus de but");
		listeDistinctions.add(prix);
		prix = new Distinction(2016, "Meilleur entraineur de la competition");
		listeDistinctions.add(prix);

		
		return listeDistinctions;
	}
	
}