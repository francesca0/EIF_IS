package domainClasses;

import dao.ResponsabileAziendaleDAO;

public class ResponsabileAziendale {

		public ResponsabileAziendale(String unIdResponsabile, String unNome, String unCognome, String unaAziendaRa, String unaEmail, String unaPassword, int unTipoAccount){
			idResponsabile=unIdResponsabile;
			nome=unNome;
			cognome=unCognome;
			aziendaRa=unaAziendaRa;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public ResponsabileAziendale() {
			idResponsabile="";
			nome="";
			cognome="";
			aziendaRa="";
			email="";
			password="";
			tipoAccount=5;
		}
		
		public String getIdResponsabile() {
			return idResponsabile;
		}

		public void setIdResponsabile(String idResponsabile) {
			this.idResponsabile = idResponsabile;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getAziendaRa() {
			return aziendaRa;
		}

		public void setAziendaRa(String aziendaRa) {
			this.aziendaRa = aziendaRa;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getTipoAccount() {
			return tipoAccount;
		}

		public void setTipoAccount(int tipoAccount) {
			this.tipoAccount = tipoAccount;
		}

		
		public String toString() {
			return "ResponsabileAziendale [idResponsabile=" + idResponsabile + ", nome=" + nome + ", cognome=" + cognome
					+ ", aziendaRa=" + aziendaRa + ", email=" + email + ", password=" + password + ", tipoAccount="
					+ tipoAccount + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			ResponsabileAziendaleDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			ResponsabileAziendaleDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			ResponsabileAziendaleDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			ResponsabileAziendaleDAO.delete(this);
		}
		
		//METODI DA CANCELLARE
		public void trovaTutti() throws Exception{
			ResponsabileAziendaleDAO.findAll();
		}
		
		public void trovaByEmail() throws Exception{
			ResponsabileAziendaleDAO.findAllByEmail(this);
		}
		
		public void visualizzazionePf() throws Exception{
			ResponsabileAziendaleDAO.visualizzaPf(this);
		}
		
		public void approvaPf(ProgettoFormativo progettoFormativo) throws Exception{
			ResponsabileAziendaleDAO.approvaPf(progetto, this);
		}
		
		public void rifiutaPf(ProgettoFormativo progettoFormativo) throws Exception{
			ResponsabileAziendaleDAO.rifiutaPf(progetto, this);
		}
		
		public void visionaPf() throws Exception{
			ResponsabileAziendaleDAO.visionaPf(this);
		}
		
		String idResponsabile;
		String nome;
		String cognome;
		String aziendaRa;
		String email;
		String password;
		int tipoAccount;
		ProgettoFormativo progetto;
}
