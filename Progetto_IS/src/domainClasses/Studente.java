package domainClasses;

import java.sql.Date;
import java.util.Objects;

import dao.StudenteDAO;

public class Studente{

		public Studente(String unaMatricolaStudente, String unNome, String unCognome, Date unaDataDiNascita, String unLuogoDiNascita, String unaResidenza, String unTelefono, String unaMatricolaTutorAccademico, String unaEmail, String unaPassword, int unTipoAccount){
			matricolaStudente=unaMatricolaStudente;
			nome=unNome;
			cognome=unCognome;
			dataDiNascita=unaDataDiNascita;
			luogoDiNascita=unLuogoDiNascita;
			residenza=unaResidenza;
			telefono=unTelefono;
			matricolaTutorAccademico=unaMatricolaTutorAccademico;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public Studente() {
			matricolaStudente="";
			nome="";
			cognome="";
			dataDiNascita=null;
			luogoDiNascita="";
			residenza="";
			telefono="";
			matricolaTutorAccademico="";
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

		public Date getDataDiNascita() {
			return dataDiNascita;
		}

		public void setDataDiNascita(Date dataDiNascita) {
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

		public String getMatricolaTutorAccademico() {
			return matricolaTutorAccademico;
		}

		public void setMatricolaTutorAccademico(String matricolaTutorAccademico) {
			this.matricolaTutorAccademico = matricolaTutorAccademico;
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

	
		public String toString() {
			return "Studente [matricolaStudente=" + matricolaStudente + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + ", luogoDiNascita=" + luogoDiNascita + ", residenza="
					+ residenza + ", telefono=" + telefono + ", matricolaTutorAccademico=" + matricolaTutorAccademico + ", email=" + email
					+ ", password=" + password + ", tipoAccount=" + tipoAccount + "]";
		}

		public boolean equals(Object obj) {

	        if (obj == this) return true;
	        if (!(obj instanceof Studente)) {
	            return false;
	        }
	        Studente studente = (Studente) obj;
	        return nome.equals(studente.nome) &&
	        		cognome.equals(studente.cognome) &&
	        		matricolaStudente.equals(matricolaStudente) &&
	        		Objects.equals(dataDiNascita, studente.dataDiNascita) &&
	                luogoDiNascita.equals(luogoDiNascita) &&
	                residenza.equals(studente.residenza) &&
	                telefono.equals(studente.telefono) &&
	                matricolaTutorAccademico.equals(studente.matricolaTutorAccademico) &&
	                email.equals(studente.email) &&
	                password.equals(studente.password) &&
	                tipoAccount == studente.tipoAccount;
	    }

	 
	    public int hashCode() {
	        return Objects.hash(nome,cognome,matricolaStudente,dataDiNascita,luogoDiNascita,residenza,telefono,matricolaTutorAccademico,email,password,tipoAccount);
	    }


		String nome;
		String cognome;
		String matricolaStudente;
		Date dataDiNascita;
		String luogoDiNascita;
		String residenza;
		String telefono;
		String matricolaTutorAccademico;
		String email;
		String password;
		int tipoAccount;
	
}
