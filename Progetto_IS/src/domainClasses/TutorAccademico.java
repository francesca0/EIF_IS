package domainClasses;

import dao.TutorAccademicoDAO;

public class TutorAccademico{

		public TutorAccademico(String unaMatricolaTutorAccademico, String unNome, String unCognome, String unaEmail, String unaPassword, int unTipoAccount){
			matricolaTutorAccademico=unaMatricolaTutorAccademico;
			nome=unNome;
			cognome=unCognome;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public TutorAccademico() {
			matricolaTutorAccademico="";
			nome="";
			cognome="";
			email="";
			password="";
			tipoAccount=3;
		}
		
		public String getMatricolaTutorAccademico() {
			return matricolaTutorAccademico;
		}

		public void setMatricolaTutorAccademico(String matricolaTutorAccademico) {
			this.matricolaTutorAccademico = matricolaTutorAccademico;
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
			return "TutorAccademico [matricolaTutorAccademico=" + matricolaTutorAccademico + ", nome=" + nome + ", cognome=" + cognome
					+ ", email=" + email + ", password=" + password + ", tipoAccount=" + tipoAccount + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			TutorAccademicoDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			TutorAccademicoDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			TutorAccademicoDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			TutorAccademicoDAO.delete(this);
		}
	
		
		String matricolaTutorAccademico;
		String nome;
		String cognome;
		String email;
		String password;
		int tipoAccount;
}
