package domainClasses;

import dao.ResponsabileAziendaleDAO;

public class ResponsabileAziendale{

		public ResponsabileAziendale(String unIdResponsabileAziendale, String unNome, String unCognome, String unaAziendaRa, String unaEmail, String unaPassword, int unTipoAccount){
			idResponsabileAziendale=unIdResponsabileAziendale;
			nome=unNome;
			cognome=unCognome;
			aziendaRa=unaAziendaRa;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public ResponsabileAziendale() {
			idResponsabileAziendale="";
			nome="";
			cognome="";
			aziendaRa="";
			email="";
			password="";
			tipoAccount=5;
		}
		
		public String getIdResponsabileAziendale() {
			return idResponsabileAziendale;
		}

		public void setIdResponsabileAziendale(String idResponsabileAziendale) {
			this.idResponsabileAziendale = idResponsabileAziendale;
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
			return "ResponsabileAziendale [idResponsabileAziendale=" + idResponsabileAziendale + ", nome=" + nome + ", cognome=" + cognome
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
		

		
		String idResponsabileAziendale;
		String nome;
		String cognome;
		String aziendaRa;
		String email;
		String password;
		int tipoAccount;
}
