package domainClasses;

import dao.ProgettoFormativoDAO;

public class ProgettoFormativo {

		public ProgettoFormativo(int unIdProgettoFormativo, String unaMatricolaStudente, int unIdTirocinio, int unIdTutorAziendale, String unaMatricolaTutorAccademico, int unIdResponsabileAziendale, int unaFirmaTaz, int unaApprovazioneRa, int unaFirmaTac, int unaFirmaDd, int unaFirmaPcd, int unaConfermaUst, String unNomeFile, int unRifiutato, int unAnnullato){
			idProgettoFormativo=unIdProgettoFormativo;
			matricolaStudente=unaMatricolaStudente;
			idTirocinio=unIdTirocinio;
			idTutorAziendale=unIdTutorAziendale;
			matricolaTutorAccademico=unaMatricolaTutorAccademico;
			idResponsabileAziendale=unIdResponsabileAziendale;
			firmaTaz=unaFirmaTaz;
			approvazioneRa=unaApprovazioneRa;
			firmaTac=unaFirmaTac;
			firmaDd=unaFirmaDd;
			firmaPcd=unaFirmaPcd;
			confermaUst=unaConfermaUst;
			nomeFile=unNomeFile;
			rifiutato=unRifiutato;
			annullato=unAnnullato;
			
		}
		
		public ProgettoFormativo() {
			idProgettoFormativo=0;
			matricolaStudente="";
			idTirocinio=0;
			idTutorAziendale=0;
			matricolaTutorAccademico="";
			idResponsabileAziendale=0;
			firmaTaz=0;
			approvazioneRa=0;
			firmaTac=0;
			firmaDd=0;
			firmaPcd=0;
			confermaUst=0;
			nomeFile="";
			rifiutato=0;
			annullato=0;
		}
		
		
		public int getIdProgettoFormativo() {
			return idProgettoFormativo;
		}

		public void setIdProgettoFormativo(int idProgettoFormativo) {
			this.idProgettoFormativo = idProgettoFormativo;
		}

		public String getMatricolaStudente() {
			return matricolaStudente;
		}

		public void setMatricolaStudente(String matricolaStudente) {
			this.matricolaStudente = matricolaStudente;
		}

		public int getIdTirocinio() {
			return idTirocinio;
		}

		public void setIdTirocinio(int idTirocinio) {
			this.idTirocinio = idTirocinio;
		}

		public int getIdTutorAziendale() {
			return idTutorAziendale;
		}

		public void setIdTutorAziendale(int idTutorAziendale) {
			this.idTutorAziendale = idTutorAziendale;
		}

		public String getMatricolaTutorAccademico() {
			return matricolaTutorAccademico;
		}

		public void setMatricolaTutorAccademico(String matricolaTutorAccademico) {
			this.matricolaTutorAccademico = matricolaTutorAccademico;
		}

		public int getIdResponsabileAziendale() {
			return idResponsabileAziendale;
		}

		public void setIdResponsabileAziendale(int idResponsabileAziendale) {
			this.idResponsabileAziendale = idResponsabileAziendale;
		}

		public int getFirmaTaz() {
			return firmaTaz;
		}

		public void setFirmaTaz(int firmaTaz) {
			this.firmaTaz = firmaTaz;
		}

		public int getApprovazioneRa() {
			return approvazioneRa;
		}

		public void setApprovazioneRa(int approvazioneRa) {
			this.approvazioneRa = approvazioneRa;
		}

		public int getFirmaTac() {
			return firmaTac;
		}

		public void setFirmaTac(int firmaTac) {
			this.firmaTac = firmaTac;
		}

		public int getFirmaDd() {
			return firmaDd;
		}

		public void setFirmaDd(int firmaDd) {
			this.firmaDd = firmaDd;
		}

		public int getFirmaPcd() {
			return firmaPcd;
		}

		public void setFirmaPcd(int firmaPcd) {
			this.firmaPcd = firmaPcd;
		}

		public int getConfermaUst() {
			return confermaUst;
		}

		public void setConfermaUst(int confermaUst) {
			this.confermaUst = confermaUst;
		}

		public String getNomeFile() {
			return nomeFile;
		}

		public void setNomeFile(String nomeFile) {
			this.nomeFile = nomeFile;
		}

		public int getRifiutato() {
			return rifiutato;
		}

		public void setRifiutato(int rifiutato) {
			this.rifiutato = rifiutato;
		}

		public int getAnnullato() {
			return annullato;
		}

		public void setAnnullato(int annullato) {
			this.annullato = annullato;
		}

		public String toString() {
			return "ProgettoFormativo [idProgettoFormativo=" + idProgettoFormativo + ", matricolaStudente="
					+ matricolaStudente + ", idTirocinio=" + idTirocinio + ", idTutorAziendale=" + idTutorAziendale + ", matricolaTutorAccademico=" + matricolaTutorAccademico
					+ ", idResponsabileAziendale=" + idResponsabileAziendale + ", firmaTaz=" + firmaTaz
					+ ", approvazioneRa=" + approvazioneRa + ", firmaTac=" + firmaTac + ", firmaDd=" + firmaDd
					+ ", firmaPcd=" + firmaPcd + ", confermaUst=" + confermaUst + ", nomeFile=" + nomeFile
					+ ", rifiutato=" + rifiutato + ", annullato=" + annullato + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			ProgettoFormativoDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			ProgettoFormativoDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			ProgettoFormativoDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			ProgettoFormativoDAO.delete(this);
		}
		
	
		
		int idProgettoFormativo;
		String matricolaStudente;
		int idTirocinio;
		int idTutorAziendale;
		String matricolaTutorAccademico;
		int idResponsabileAziendale;
		int firmaTaz;
		int approvazioneRa;
		int firmaTac;
		int firmaDd;
		int firmaPcd;
		int confermaUst;
		String nomeFile;
		int rifiutato;
		int annullato;

}
