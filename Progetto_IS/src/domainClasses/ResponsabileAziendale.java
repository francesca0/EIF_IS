package domainClasses;

import dao.ResponsabileAziendaleDAO;

public class ResponsabileAziendale{

		public ResponsabileAziendale(int unIdResponsabileAziendale, String unNome, String unCognome, int unIdAzienda, String unaEmail, String unaPassword, int unTipoAccount){
			idResponsabileAziendale=unIdResponsabileAziendale;
			nome=unNome;
			cognome=unCognome;
			idAzienda=unIdAzienda;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public ResponsabileAziendale() {
			idResponsabileAziendale=0;
			nome="";
			cognome="";
			idAzienda=0;
			email="";
			password="";
			tipoAccount=5;
		}
		
		public int getIdResponsabileAziendale() {
			return idResponsabileAziendale;
		}

		public void setIdResponsabileAziendale(int idResponsabileAziendale) {
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

		public int getIdAzienda() {
			return idAzienda;
		}

		public void setIdAzienda(int idAzienda) {
			this.idAzienda = idAzienda;
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
					+ ", idAzienda=" + idAzienda + ", email=" + email + ", password=" + password + ", tipoAccount="
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
		

		
		int idResponsabileAziendale;
		String nome;
		String cognome;
		int idAzienda;
		String email;
		String password;
		int tipoAccount;
}
