package domainClasses;

import java.sql.Date;

import dao.TirocinioDAO;

public class Tirocinio{

		public Tirocinio(String unIdTirocinio, String unIdResponsabileAziendaleTrc, String unIdTutorAziendale, String unaDescrizione, String unaTematica, String unaNote, Date unaDataInizio, Date unaDataFine){
			idTirocinio=unIdTirocinio;
			idResponsabileAziendaleTrc=unIdResponsabileAziendaleTrc;
			idTutorAziendale=unIdTutorAziendale;
			descrizione=unaDescrizione;
			tematica=unaTematica;
			note=unaNote;
			dataInizio=unaDataInizio;
			dataFine=unaDataFine;
		}
		
		public Tirocinio() {
			idTirocinio="";
			idResponsabileAziendaleTrc="";
			idTutorAziendale="";
			descrizione="";
			tematica="";
			note="";
			dataInizio=null;
			dataFine=null;
		}
		
		
		public String getIdTirocinio() {
			return idTirocinio;
		}

		public void setIdTirocinio(String idTirocinio) {
			this.idTirocinio = idTirocinio;
		}

		public String getIdResponsabileAziendaleTrc() {
			return idResponsabileAziendaleTrc;
		}

		public void setIdResponsabileAziendaleTrc(String idResponsabileAziendaleTrc) {
			this.idResponsabileAziendaleTrc = idResponsabileAziendaleTrc;
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
			return "Tirocinio [idTirocinio=" + idTirocinio + ", idResponsabileAziendaleTrc=" + idResponsabileAziendaleTrc
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
		


		String idTirocinio;
		String idResponsabileAziendaleTrc;
		String idTutorAziendale;
		String descrizione;
		String tematica;
		String note;
		Date dataInizio;
		Date dataFine;
	
}
