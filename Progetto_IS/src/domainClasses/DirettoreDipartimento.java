package domainClasses;

import dao.DirettoreDipartimentoDAO;

public class DirettoreDipartimento{

		public DirettoreDipartimento(String unIdDirettoreDipartimento, String unNome, String unCognome, String unaEmail, String unaPassword, int unTipoAccount){
			idDirettoreDipartimento=unIdDirettoreDipartimento;
			nome=unNome;
			cognome=unCognome;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public DirettoreDipartimento() {
			idDirettoreDipartimento="";
			nome="";
			cognome="";
			email="";
			password="";
			tipoAccount=7;
		}
		
		public String getIdDirettoreDipartimento() {
			return idDirettoreDipartimento;
		}

		public void setIdDirettoreDipartimento(String idDirettoreDipartimento) {
			this.idDirettoreDipartimento = idDirettoreDipartimento;
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
			return "DirettoreDipartimento [idDirettoreDipartimento=" + idDirettoreDipartimento + ", nome=" + nome + ", cognome=" + cognome
					+ ", email=" + email + ", password=" + password + ", tipoAccount=" + tipoAccount + "]";
		}

		
		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			DirettoreDipartimentoDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			DirettoreDipartimentoDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			DirettoreDipartimentoDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			DirettoreDipartimentoDAO.delete(this);
		}
	
		
		String idDirettoreDipartimento;
		String nome;
		String cognome;
		String email;
		String password;
		int tipoAccount;
}
