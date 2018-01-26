package domainClasses;

import dao.ProgettoFormativoDAO;

public class ProgettoFormativo {

		public ProgettoFormativo(String unIdProgettoFormativo, String unaMatricolaStudente, String unIdTirocinio, String unIdTaz, String unIdTac, String unIdResponsabileAziendalePF, String unIdDd, String unIdPcd, int unaFirmaTaz,int unaApprovazioneRa, int unaFirmaTac, int unaFirmaDd, int unaFirmaPcd, int unaConfermaUst, String unNomeFile, int unRifiutato, int unAnnullato){
			idProgettoFormativo=unIdProgettoFormativo;
			matricolaStudente=unaMatricolaStudente;
			idTirocinio=unIdTirocinio;
			idTaz=unIdTaz;
			idTac=unIdTac;
			idResponsabileAziendalePF=unIdResponsabileAziendalePF;
			idDd=unIdDd;
			idPcd=unIdPcd;
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
			idProgettoFormativo="";
			matricolaStudente="";
			idTirocinio="";
			idTaz="";
			idTac="";
			idResponsabileAziendalePF="";
			idDd="";
			idPcd="";
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
		
		
		public String getIdProgettoFormativo() {
			return idProgettoFormativo;
		}

		public void setIdProgettoFormativo(String idProgettoFormativo) {
			this.idProgettoFormativo = idProgettoFormativo;
		}

		public String getMatricolaStudente() {
			return matricolaStudente;
		}

		public void setMatricolaStudente(String matricolaStudente) {
			this.matricolaStudente = matricolaStudente;
		}

		public String getIdTirocinio() {
			return idTirocinio;
		}

		public void setIdTirocinio(String idTirocinio) {
			this.idTirocinio = idTirocinio;
		}

		public String getIdTaz() {
			return idTaz;
		}

		public void setIdTaz(String idTaz) {
			this.idTaz = idTaz;
		}

		public String getIdTac() {
			return idTac;
		}

		public void setIdTac(String idTac) {
			this.idTac = idTac;
		}

		public String getIdResponsabileAziendalePF() {
			return idResponsabileAziendalePF;
		}

		public void setIdResponsabileAziendalePF(String idResponsabileAziendalePF) {
			this.idResponsabileAziendalePF = idResponsabileAziendalePF;
		}

		public String getIdDd() {
			return idDd;
		}

		public void setIdDd(String idDd) {
			this.idDd = idDd;
		}

		public String getIdPcd() {
			return idPcd;
		}

		public void setIdPcd(String idPcd) {
			this.idPcd = idPcd;
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
					+ matricolaStudente + ", idTirocinio=" + idTirocinio + ", idTaz=" + idTaz + ", idTac=" + idTac
					+ ", idResponsabileAziendalePF=" + idResponsabileAziendalePF + ", idDd=" + idDd + ", idPcd=" + idPcd + ", firmaTaz=" + firmaTaz
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
		
	
		
		String idProgettoFormativo;
		String matricolaStudente;
		String idTirocinio;
		String idTaz;
		String idTac;
		String idResponsabileAziendalePF;
		String idDd;
		String idPcd;
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
