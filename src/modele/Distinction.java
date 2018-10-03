package modele;
 public class Distinction {
	
	 
	protected int id;
	protected String titre;
	protected String description;
	protected String prix;
	protected int idvainqueur;
	 
	 public Distinction(String titre, String description, String prix, int idvainqueur) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.idvainqueur = idvainqueur;
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public int getIdvainqueur() {
		return idvainqueur;
	}
	public void setIdvainqueur(int idvainqueur) {
		this.idvainqueur = idvainqueur;
	}

 }