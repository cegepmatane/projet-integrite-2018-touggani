

public class Vainqueur {
 	protected String nomEquipe;
	protected String entraineur;
	protected String date;
	protected String capitaine;
	
	
	public Vainqueur(String nomEquipe) {
		super();
		this.nomEquipe = nomEquipe;
	}
	public Vainqueur(String nomEquipe, String date) {
		super();
		this.nomEquipe = nomEquipe;
		this.date = date;
	}
	public Vainqueur(String nomEquipe, String date, String entraineur, String capitaine) {
		super();
		this.nomEquipe = nomEquipe;
		this.date = date;
		this.entraineur = entraineur;
		this.capitaine = capitaine;
	}
	
	
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getEntraineur() {
		return entraineur;
	}
	public void setEntraineur(String entraineur) {
		this.entraineur = entraineur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCapitaine() {
		return capitaine;
	}
	public void setCapitaine(String capitaine) {
		this.capitaine = capitaine;
	}
	
}

