package domainClasses;

import dao.TirocinioDAO;

public class Tirocinio {

		public Tirocinio(String unIdTirocinio, String unIdResponsabile, String unIdTutorAziendale, String unaDescrizione, String unaTematica, String unaNote, String unaDataInizio, String unaDataFine){
			idTirocinio=unIdTirocinio;
			idResponsabile=unIdResponsabile;
			idTutorAziendale=unIdTutorAziendale;
			descrizione=unaDescrizione;
			tematica=unaTematica;
			note=unaNote;
			dataInizio=unaDataInizio;
			dataFine=unaDataFine;
		}
		
		public Tirocinio() {
			idTirocinio="";
			idResponsabile="";
			idTutorAziendale="";
			descrizione="";
			tematica="";
			note="";
			dataInizio="";
			dataFine="";
		}
		
		
		public String getIdTirocinio() {
			return idTirocinio;
		}

		public void setIdTirocinio(String idTirocinio) {
			this.idTirocinio = idTirocinio;
		}

		public String getIdResponsabile() {
			return idResponsabile;
		}

		public void setIdResponsabile(String idResponsabile) {
			this.idResponsabile = idResponsabile;
		}

		public String getIdTutorAziendale() {
			return idTutorAziendale;
		}

		public void setIdTutorAziendale(String idTutorAziendale) {
			this.idTutorAziendale = idTutorAziendale;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		public String getTematica() {
			return tematica;
		}

		public void setTematica(String tematica) {
			this.tematica = tematica;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getDataInizio() {
			return dataInizio;
		}

		public void setDataInizio(String dataInizio) {
			this.dataInizio = dataInizio;
		}

		public String getDataFine() {
			return dataFine;
		}

		public void setDataFine(String dataFine) {
			this.dataFine = dataFine;
		}


		public String toString() {
			return "Tirocinio [idTirocinio=" + idTirocinio + ", idResponsabile=" + idResponsabile
					+ ", idTutorAziendale=" + idTutorAziendale + ", descrizione=" + descrizione + ", tematica="
					+ tematica + ", note=" + note + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + "]";
		}

		//Metodi DAO
		public void leggiDatiDaDB() throws Exception{
			TirocinioDAO.load(this);
		}
		
		public void inserisciDatiSuDB() throws Exception{
			TirocinioDAO.insert(this);
		}
		
		public void aggiornaDatiSuDB() throws Exception{
			TirocinioDAO.update(this);
		}
		
		public void cancellaDatiDaDB() throws Exception{
			TirocinioDAO.delete(this);
		}
		
		//METODI DA CANCELLARE
		public void trovaTutti() throws Exception{
			TirocinioDAO.findAll();
		}
		
		String idTirocinio;
		String idResponsabile;
		String idTutorAziendale;
		String descrizione;
		String tematica;
		String note;
		String dataInizio;
		String dataFine;
	
}
