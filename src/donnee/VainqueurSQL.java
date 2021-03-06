package donnee;
 public interface VainqueurSQL {

	public static final String SQL_LISTER_VAINQUEUR = "SELECT * FROM vainqueur";
	public static final String SQL_AJOUTER_VAINQUEUR= "INSERT into vainqueur(nomequipe, date, entraineur, capitaine) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_VAINQUEUR = "UPDATE vainqueur SET nomequipe = ?, date = ?, entraineur = ?, capitaine = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_VAINQUEUR = "SELECT * FROM vainqueur WHERE id = ?";
 }