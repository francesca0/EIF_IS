package domainClasses;

import dao.AziendaDAO;

public class Azienda {

		public Azienda(int unIdAzienda, String unNomeAzienda, String unaLocalitaAzienda, String unIndirizzoAzienda){
			idAzienda=unIdAzienda;
			nomeAzienda=unNomeAzienda;
			localitaAzienda=unaLocalitaAzienda;
			indirizzoAzienda=unIndirizzoAzienda;
		}
		
		public Azienda() {
			idAzienda=0;
			nomeAzienda="";
			localitaAzienda="";
			indirizzoAzienda="";
		}
		
		public int getIdAzienda() {
			return idAzienda;
		}

		public void setIdAzienda(int idAzienda) {
			this.idAzienda = idAzienda;
		}

		public String getNomeAzienda() {
			return nomeAzienda;
		}

		public void setNomeAzienda(String nomeAzienda) {
			this.nomeAzienda = nomeAzienda;
		}

		public String getLocalitaAzienda() {
			return localitaAzienda;
		}

		public void setLocalitaAzienda(String localitaAzienda) {
			this.localitaAzienda = localitaAzienda;
		}

		public String getIndirizzoAzienda() {
			return indirizzoAzienda;
		}

		public void setIndirizzoAzienda(String indirizzoAzienda) {
			this.indirizzoAzienda = indirizzoAzienda;
		}

		public String toString() {
			return "Azienda [idAzienda=" + idAzienda + ", nomeAzienda=" + nomeAzienda + ", localitaAzienda="
					+ localitaAzienda + ", indirizzoAzienda=" + indirizzoAzienda + "]";
		}
		
		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			AziendaDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			AziendaDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			AziendaDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			AziendaDAO.delete(this);
		}
		
		
		int idAzienda;
		String nomeAzienda;
		String localitaAzienda;
		String indirizzoAzienda;

}
