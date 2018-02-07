package domainClasses;

import java.sql.Date;
import java.util.Objects;

import dao.TirocinioDAO;

public class Tirocinio{

		public Tirocinio(int unIdTirocinio, int unIdResponsabileAziendale, int unIdTutorAziendale, String unaDescrizione, String unaTematica, String unaNote, Date unaDataInizio, Date unaDataFine, int unTotaleOre, int unNumeroMesi){
			idTirocinio=unIdTirocinio;
			idResponsabileAziendale=unIdResponsabileAziendale;
			idTutorAziendale=unIdTutorAziendale;
			descrizione=unaDescrizione;
			tematica=unaTematica;
			note=unaNote;
			dataInizio=unaDataInizio;
			dataFine=unaDataFine;
			totaleOre=unTotaleOre;
			numeroMesi=unNumeroMesi;
			
		}
		
		public Tirocinio(int unIdResponsabileAziendale, int unIdTutorAziendale, String unaDescrizione, String unaTematica, String unaNote, Date unaDataInizio, Date unaDataFine, int unTotaleOre, int unNumeroMesi){
			idResponsabileAziendale=unIdResponsabileAziendale;
			idTutorAziendale=unIdTutorAziendale;
			descrizione=unaDescrizione;
			tematica=unaTematica;
			note=unaNote;
			dataInizio=unaDataInizio;
			dataFine=unaDataFine;
			totaleOre=unTotaleOre;
			numeroMesi=unNumeroMesi;
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
			totaleOre=0;
			numeroMesi=0;
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

		public int getTotaleOre() {
			return totaleOre;
		}

		public void setTotaleOre(int totaleOre) {
			this.totaleOre = totaleOre;
		}
		
		public int getNumeroMesi() {
			return numeroMesi;
		}

		public void setNumeroMesi(int numeroMesi) {
			this.numeroMesi = numeroMesi;
		}
		
		public String toString() {
			return "Tirocinio [idTirocinio=" + idTirocinio + ", idResponsabileAziendale=" + idResponsabileAziendale
					+ ", idTutorAziendale=" + idTutorAziendale + ", descrizione=" + descrizione + ", tematica="
					+ tematica + ", note=" + note + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", totaleOre=" + totaleOre + ", numeroMesi=" + numeroMesi + "]";
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
		
		public boolean equals(Object obj) {

	        if (obj == this) return true;
	        if (!(obj instanceof Tirocinio)) {
	            return false;
	        }
	        
	        Tirocinio tirocinio = (Tirocinio) obj;
	        return idTirocinio == tirocinio.idTirocinio &&
	        		idResponsabileAziendale == tirocinio.idResponsabileAziendale &&
	        		idTutorAziendale == tirocinio.idTutorAziendale &&
	        		descrizione.equals(tirocinio.descrizione) &&
	        		tematica.equals(tirocinio.tematica) &&
	        		note.equals(tirocinio.note) &&
	        		Objects.equals(dataInizio, tirocinio.dataInizio) &&
	        		Objects.equals(dataFine, tirocinio.dataFine);
	        		
		}    		
		int idTirocinio;
		int idResponsabileAziendale;
		int idTutorAziendale;
		int totaleOre;
		int numeroMesi;
		String descrizione;
		String tematica;
		String note;
		Date dataInizio;
		Date dataFine;
	
}
