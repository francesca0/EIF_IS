package domainClasses;

import dao.TutorAziendaleDAO;

public class TutorAziendale {

		public TutorAziendale(String unIdTutorAziendale, String unNome, String unCognome, String unaAziendaTaz, String unaEmail, String unaPassword, int unTipoAccount){
			idTutorAziendale=unIdTutorAziendale;
			nome=unNome;
			cognome=unCognome;
			aziendaTaz=unaAziendaTaz;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public TutorAziendale() {
			idTutorAziendale="";
			nome="";
			cognome="";
			aziendaTaz="";
			email="";
			password="";
			tipoAccount=2;
		}
		
		public String getIdTutorAziendale() {
			return idTutorAziendale;
		}

		public void setIdTutorAziendale(String idTutorAziendale) {
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

		public String getAziendaTaz() {
			return aziendaTaz;
		}

		public void setAziendaTaz(String aziendaTaz) {
			this.aziendaTaz = aziendaTaz;
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
					+ ", aziendaTaz=" + aziendaTaz + ", email=" + email + ", password=" + password + ", tipoAccount="
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
		
		//METODI DA CANCELLARE
		public void trovaTutti() throws Exception{
			TutorAziendaleDAO.findAll();
		}
		
		public void trovaByEmail() throws Exception{
			TutorAziendaleDAO.findAllByEmail(this);
		}
		
		public void visualizzazionePf() throws Exception{
			TutorAziendaleDAO.visualizzaPf(this);
		}
		
		public void firmaPf(ProgettoFormativo progetto) throws Exception{
			TutorAziendaleDAO.firmaPf(progetto, this);
		}
		
		public void visionaPf() throws Exception{
			TutorAziendaleDAO.visionaPf(this);
		}
		
		String idTutorAziendale;
		String nome;
		String cognome;
		String aziendaTaz;
		String email;
		String password;
		int tipoAccount;

}
