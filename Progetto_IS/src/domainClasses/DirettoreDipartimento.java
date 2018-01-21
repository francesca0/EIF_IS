package domainClasses;

import dao.DirettoreDipartimentoDAO;

public class DirettoreDipartimento {

		public DirettoreDipartimento(String unIdDirettore, String unNome, String unCognome, String unaEmail, String unaPassword, int unTipoAccount){
			idDirettore=unIdDirettore;
			nome=unNome;
			cognome=unCognome;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public DirettoreDipartimento() {
			idDirettore="";
			nome="";
			cognome="";
			email="";
			password="";
			tipoAccount=7;
		}
		
		public String getIdDirettore() {
			return idDirettore;
		}

		public void setIdDirettore(String idDirettore) {
			this.idDirettore = idDirettore;
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
			return "DirettoreDipartimento [idDirettore=" + idDirettore + ", nome=" + nome + ", cognome=" + cognome
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
		
		//METODI DA CANCELLARE
		public void trovaByEmail() throws Exception{
			DirettoreDipartimentoDAO.findAllByEmail(this);
		}
		
		public void visualizzazionePf() throws Exception{
			DirettoreDipartimentoDAO.visualizzaPf();
		}
		
		public void firmaPf(ProgettoFormativo progetto) throws Exception{
			DirettoreDipartimentoDAO.firmaPf(progetto);
		}
		
		public void visionaPf() throws Exception{
			DirettoreDipartimentoDAO.visionaPf();
		}
		
		String idDirettore;
		String nome;
		String cognome;
		String email;
		String password;
		int tipoAccount;
}
