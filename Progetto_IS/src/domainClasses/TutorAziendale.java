package domainClasses;

import dao.TutorAziendaleDAO;

public class TutorAziendale {

		public TutorAziendale(int unIdTutorAziendale, String unNome, String unCognome, int unIdAzienda, String unaEmail, String unaPassword, int unTipoAccount){
			idTutorAziendale=unIdTutorAziendale;
			nome=unNome;
			cognome=unCognome;
			idAzienda=unIdAzienda;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public TutorAziendale() {
			idTutorAziendale=0;
			nome="";
			cognome="";
			idAzienda=0;
			email="";
			password="";
			tipoAccount=2;
		}
		
		public int getIdTutorAziendale() {
			return idTutorAziendale;
		}

		public void setIdTutorAziendale(int idTutorAziendale) {
			this.idTutorAziendale = idTutorAziendale;
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
			return "TutorAziendale [idTutorAziendale=" + idTutorAziendale + ", nome=" + nome + ", cognome=" + cognome
					+ ", idAzienda=" + idAzienda + ", email=" + email + ", password=" + password + ", tipoAccount="
					+ tipoAccount + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			TutorAziendaleDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			TutorAziendaleDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			TutorAziendaleDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			TutorAziendaleDAO.delete(this);
		}
		
		int idTutorAziendale;
		String nome;
		String cognome;
		int idAzienda;
		String email;
		String password;
		int tipoAccount;

}
