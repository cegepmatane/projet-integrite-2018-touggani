
public class Competitions {
	protected String nomCompetition;
	protected String ampleurCompetition;

	
	
	
	public Competitions(String nomCompetition, String ampleurCompetition) {
		super();
		this.nomCompetition = nomCompetition;
		this.ampleurCompetition = ampleurCompetition;
	}
	
	
	public String getNomCompetition() {
		return nomCompetition;
	}
	public void setNomCompetition(String nomCompetition) {
		this.nomCompetition = nomCompetition;
	}
	public String getAmpleurCompetition() {
		return ampleurCompetition;
	}
	public void setAmpleurCompetition(String ampleurCompetition) {
		this.ampleurCompetition = ampleurCompetition;
	}
	
}


