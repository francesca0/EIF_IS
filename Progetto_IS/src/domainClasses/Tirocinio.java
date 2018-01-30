package domainClasses;

import java.sql.Date;

import dao.TirocinioDAO;

public class Tirocinio{

		public Tirocinio(int unIdTirocinio, int unIdResponsabileAziendale, int unIdTutorAziendale, String unaDescrizione, String unaTematica, String unaNote, Date unaDataInizio, Date unaDataFine){
			idTirocinio=unIdTirocinio;
			idResponsabileAziendale=unIdResponsabileAziendale;
			idTutorAziendale=unIdTutorAziendale;
			descrizione=unaDescrizione;
			tematica=unaTematica;
			note=unaNote;
			dataInizio=unaDataInizio;
			dataFine=unaDataFine;
		}
		
		public Tirocinio() {
			idTirocinio=0;
			idResponsabileAziendale=0;
			idTutorAziendale=0;
			descrizione="";
			tematica="";
			note="";
			dataInizio=null;
			dataFine=null;
		}
		
		
		public int getIdTirocinio() {
			return idTirocinio;
		}

		public void setIdTirocinio(int idTirocinio) {
			this.idTirocinio = idTirocinio;
		}

		public int getIdResponsabileAziendale() {
			return idResponsabileAziendale;
		}

		public void setIdResponsabileAziendale(int idResponsabileAziendale) {
			this.idResponsabileAziendale = idResponsabileAziendale;
		}

		public int getIdTutorAziendale() {
			return idTutorAziendale;
		}

		public void setIdTutorAziendale(int idTutorAziendale) {
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

		public Date getDataInizio() {
			return dataInizio;
		}

		public void setDataInizio(Date dataInizio) {
			this.dataInizio = dataInizio;
		}

		public Date getDataFine() {
			return dataFine;
		}

		public void setDataFine(Date dataFine) {
			this.dataFine = dataFine;
		}


		public String toString() {
			return "Tirocinio [idTirocinio=" + idTirocinio + ", idResponsabileAziendale=" + idResponsabileAziendale
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
		


		int idTirocinio;
		int idResponsabileAziendale;
		int idTutorAziendale;
		String descrizione;
		String tematica;
		String note;
		Date dataInizio;
		Date dataFine;
	
}
