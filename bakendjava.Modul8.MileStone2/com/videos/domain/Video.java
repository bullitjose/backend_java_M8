package com.videos.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




/**
 * @author casa
 *
 */
public class Video {
	protected enum EstatPujada {
		UPLOADING, VERIFYING, PUBLIC
	}

	protected int id;
	
	protected String url;
	protected String titol;
	protected Calendar dataPujada;
	protected List<String> tags = new ArrayList<>();
	private static int COUNTERMEMBERS = 1;

	public Video(String url, String titol) throws Exception {
		if (url.equals(""))
			throw new Exception();
		if (titol.equals(""))
			throw new Exception();

		this.url = url;
		this.titol = titol;
		id = generarCodi();
		dataPujada = setDataPujada();
		// JavaTimerScheduleAtFixedRate();

		pujarVideoServidor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((titol == null) ? 0 : titol.hashCode());
		result = prime * result
				+ ((url == null) ? 0 : url.hashCode());
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
		Video other = (Video) obj;
		if (titol == null) {
			if (other.titol != null)
				return false;
		} else if (!titol.equals(other.titol))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	
	
	/**
	 * 
	 * @return int, codi creat pel video
	 */
	public int generarCodi() {
		return COUNTERMEMBERS++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	/**
	 * 
	 * @return String, string amb totes les paraules tags
	 */
	public String getAllTags() {

		StringBuilder llistaTags = new StringBuilder();

		for (String tag : tags) {

			llistaTags.append(" " + tag + ",");

		}

		return llistaTags.toString();
	}

	/**
	 * 
	 * @param tag
	 * 
	 *            Metode que afegeix tag al video
	 */
	public void addTag(String tag) {
		this.tags.add(tag);
	}

	public int getCOUNTERMEMBERS() {
		return COUNTERMEMBERS;
	}

	public void setCOUNTERMEMBERS(int cOUNTERMEMBERS) {
		COUNTERMEMBERS = cOUNTERMEMBERS;
	}

	public Calendar getDataPujada() {
		return dataPujada;
	}

	public Calendar setDataPujada() {

		SimpleDateFormat formatter = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm:ss");
		// Torna data actual
		Calendar calendar = Calendar.getInstance();

		System.out.println("Data de pujada: "
				+ formatter.format(calendar.getTime()));
		System.out.println("Id de registre: " + getId());
		return this.dataPujada = calendar;
	}

	private void pujarVideoServidor() throws InterruptedException {
		System.out.print("Connectant al servidor ... ");
	
		int i = 0;
		while (i < 4) {
			++i;
			if (i == 1) {
						
				setEstatPujada(EstatPujada.UPLOADING);
				System.out.println("\n\t"+EstatPujada.UPLOADING);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
			if (i == 2) {
				setEstatPujada(EstatPujada.VERIFYING);
				System.out.println("\t"+EstatPujada.VERIFYING);
				try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			}

			if (i == 3) {
				setEstatPujada(EstatPujada.PUBLIC);
				
				System.out.println("\t"+EstatPujada.PUBLIC);
				System.out.println("Operació complerta!");

			}

		}

	}

	private void setEstatPujada(EstatPujada uploading) {
		// TODO Auto-generated method stub
		
	}

}
