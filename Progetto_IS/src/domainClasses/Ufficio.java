package domainClasses;

import dao.UfficioDAO;

public class Ufficio {

		public Ufficio(String unIdUfficio, String unaEmail, String unaPassword, int unTipoAccount){
			idUfficio=unIdUfficio;
			email=unaEmail;
			password=unaPassword;
			tipoAccount=unTipoAccount;
		}
		
		public Ufficio() {
			idUfficio="";
			email="";
			password="";
			tipoAccount=1;
		}
		
		
		public String getIdUfficio() {
			return idUfficio;
		}

		public void setIdUfficio(String idUfficio) {
			this.idUfficio = idUfficio;
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
			return "Ufficio [idUfficio=" + idUfficio + ", email=" + email + ", password=" + password + ", tipoAccount="
					+ tipoAccount + "]";
		}
		
		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			UfficioDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			UfficioDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			UfficioDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			UfficioDAO.delete(this);
		}
		
		//METODI DA CANCELLARE
		public void trovaByEmail() throws Exception{
			UfficioDAO.findAllByEmail(this);
		}

		public void visualizzazionePf() throws Exception{
			UfficioDAO.visualizzaPf();
		}
		
		public void confermaPf(ProgettoFormativo progetto) throws Exception{
			UfficioDAO.confermaPf(progetto);
		}
		
		public void annullaPf(ProgettoFormativo progetto) throws Exception{
			UfficioDAO.annullaPf(progetto);
		}
		
		public void visionaPf() throws Exception{
			UfficioDAO.visionaPf();
		}
		
		String idUfficio;
		String email;
		String password;
		int tipoAccount;
}
