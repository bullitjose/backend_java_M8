package com.videos.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Usuari {
	protected String nom;
	protected String cognom;
	protected String password;
	protected Calendar dataRegistre;
	protected int id;
	private static int COUNTERMEMBERS = 1;
	protected List<Video> videos = new ArrayList<>();
	public Usuari(String nom, String cognom, String password)throws Exception{
		/*if (nom.equals(""))
			throw new Exception();
		if (cognom.equals(""))
			throw new Exception();
		if (password.equals(""))
			throw new Exception();*/
		if (nom==null)
			throw new Exception();
		if (cognom==null)
			throw new Exception();
		if (password==null)
			throw new Exception();
		this.nom = nom;
		this.cognom = cognom;
		this.password=password;
		id = generarCodi();
		dataRegistre=setDataRegistre();

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cognom == null) ? 0 : cognom.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuari other = (Usuari) obj;
		if (cognom == null) {
			if (other.cognom != null)
				return false;
		} else if (!cognom.equals(other.cognom))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCognom() {
		return cognom;
	}


	public void setCognom(String cognom) {
		this.cognom = cognom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Calendar getDataRegistre() {
		return dataRegistre;
	}


	public Calendar setDataRegistre() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		//Torna data actual
		Calendar calendar = Calendar.getInstance(); 

		System.out.println("Data de registre: "+formatter.format(calendar.getTime()));
		System.out.println("Id de registre: "+getId());
		return this.dataRegistre = calendar;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCOUNTERMEMBERS() {
		return COUNTERMEMBERS;
	}


	public void setCOUNTERMEMBERS(int cOUNTERMEMBERS) {

		COUNTERMEMBERS = cOUNTERMEMBERS;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public List<Video> getVideos() {
		return videos;
	}
	
	/**
	 * 
	 * @return string amb tots els videos de la llista i les seves dades
	 */
		public String getAllVideos() {

			StringBuilder llistaVideos = new StringBuilder();
			llistaVideos
					.append("\n\tNombre de videos: " + videos.size());

			for (Video video : videos) {
				
				llistaVideos.append("\n\tTitol: " + video.getTitol()
						+ "\n\tURL: " + video.getUrl()
						+ "\n\tTags: "+video.getAllTags());

			}

		
			return llistaVideos.toString();
		}
	
	
	
	/**
	 * 
	 * @param video
	 * 
	 * Metode que afegeix videos a lusuari
	 */
	public void addVideo(Video video){
		this.videos.add(video);
	}



	/**
	 * 
	 * @return int, codi creat pel video
	 */
	public int generarCodi() {
		return COUNTERMEMBERS++;

	}
}
