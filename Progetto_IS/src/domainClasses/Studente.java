package domainClasses;

import dao.StudenteDAO;

public class Studente {

		public Studente(String unNome, String unCognome, String unaMatricolaStudente, String unaDataDiNascita, String unLuogoDiNascita, String unaResidenza, String unTelefono, String unTutorAccademico, String unaEmail, String unaPassword, int unTipoAccount){
			nome=unNome;
			cognome=unCognome;
			matricolaStudente=unaMatricolaStudente;
			dataDiNascita=unaDataDiNascita;
			luogoDiNascita=unLuogoDiNascita;
			residenza=unaResidenza;
			telefono=unTelefono;
			tutorAccademico=unTutorAccademico;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public Studente() {
			nome="";
			cognome="";
			matricolaStudente="";
			dataDiNascita="";
			luogoDiNascita="";
			residenza="";
			telefono="";
			tutorAccademico="";
			email="";
			password="";
			tipoAccount=4;
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

		public String getMatricolaStudente() {
			return matricolaStudente;
		}

		public void setMatricolaStudente(String matricolaStudente) {
			this.matricolaStudente = matricolaStudente;
		}

		public String getDataDiNascita() {
			return dataDiNascita;
		}

		public void setDataDiNascita(String dataDiNascita) {
			this.dataDiNascita = dataDiNascita;
		}

		public String getLuogoDiNascita() {
			return luogoDiNascita;
		}

		public void setLuogoDiNascita(String luogoDiNascita) {
			this.luogoDiNascita = luogoDiNascita;
		}

		public String getResidenza() {
			return residenza;
		}

		public void setResidenza(String residenza) {
			this.residenza = residenza;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getTutorAccademico() {
			return tutorAccademico;
		}

		public void setTutorAccademico(String tutorAccademico) {
			this.tutorAccademico = tutorAccademico;
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
			return "Studente [nome=" + nome + ", cognome=" + cognome + ", matricolaStudente=" + matricolaStudente
					+ ", dataDiNascita=" + dataDiNascita + ", luogoDiNascita=" + luogoDiNascita + ", residenza="
					+ residenza + ", telefono=" + telefono + ", tutorAccademico=" + tutorAccademico + ", email=" + email
					+ ", password=" + password + ", tipoAccount=" + tipoAccount + "]";
		}

		
		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			StudenteDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			StudenteDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			StudenteDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			StudenteDAO.delete(this);
		}
		
		//METODI DA CANCELLARE
		/*public void trovaTutti() throws Exception{
			StudenteDAO.findAll();
		}
		
		public void trovaByEmail() throws Exception{
			StudenteDAO.findByEmail();
		}
		
		public void visionaPf() throws Exception{
			StudenteDAO.visionaPf(this);
		}*/
		
		
		String nome;
		String cognome;
		String matricolaStudente;
		String dataDiNascita;
		String luogoDiNascita;
		String residenza;
		String telefono;
		String tutorAccademico;
		String email;
		String password;
		int tipoAccount;
	
}
