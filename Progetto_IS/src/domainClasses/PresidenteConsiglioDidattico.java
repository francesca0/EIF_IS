package domainClasses;

import dao.PresidenteConsiglioDidatticoDAO;

public class PresidenteConsiglioDidattico {

		public PresidenteConsiglioDidattico(String unIdPresidente, String unNome, String unCognome, String unaEmail, String unaPassword, int unTipoAccount){
			idPresidente=unIdPresidente;
			nome=unNome;
			cognome=unCognome;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public PresidenteConsiglioDidattico() {
			idPresidente="";
			nome="";
			cognome="";
			email="";
			password="";
			tipoAccount=6;
		}
		
		public String getIdPresidente() {
			return idPresidente;
		}

		public void setIdPresidente(String idPresidente) {
			this.idPresidente = idPresidente;
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
			return "PresidenteConsiglioDidattico [idPresidente=" + idPresidente + ", nome=" + nome + ", cognome="
					+ cognome + ", email=" + email + ", password=" + password + ", tipoAccount=" + tipoAccount + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			PresidenteConsiglioDidatticoDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			PresidenteConsiglioDidatticoDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			PresidenteConsiglioDidatticoDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			PresidenteConsiglioDidatticoDAO.delete(this);
		}
		
		//METODI DA CANCELLARE
		public void trovaByEmail() throws Exception{
			PresidenteConsiglioDidatticoDAO.findAllByEmail(this);
		}
		
		public void visualizzazionePf() throws Exception{
			PresidenteConsiglioDidatticoDAO.visualizzaPf();
		}
		
		public void firmaPf(ProgettoFormativo progetto) throws Exception{
			PresidenteConsiglioDidatticoDAO.firmaPf(progetto);
		}
		
		public void visionaPf() throws Exception{
			PresidenteConsiglioDidatticoDAO.visionaPf();
		}

		
		String idPresidente;
		String nome;
		String cognome;
		String email;
		String password;
		int tipoAccount;
		
}
