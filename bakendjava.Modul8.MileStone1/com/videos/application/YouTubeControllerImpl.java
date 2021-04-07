package com.videos.application;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.videos.domain.Usuari;
import com.videos.domain.Video;

import com.videos.repository.Repository;

public class YouTubeControllerImpl implements YouTubeController {
	private Repository repository;

	public YouTubeControllerImpl() {

		repository = new Repository();
	}

	/**
	 * 
	 * @param nom
	 * @param cognoms
	 * @param password
	 * @throws Exception
	 * 
	 *                   Metode que crear usari i lafegeix al repository
	 */
	@Override
	public void createUsuari(String nom, String cognoms,

			String password) throws Exception {

		Usuari usuari = new Usuari(nom, cognoms, password);
		repository.addUsuari(usuari);

	}

	/**
	 * 
	 * @param url
	 * @param titol
	 * @throws Exception
	 * 
	 *                   Metode que crear usari i lafegeix al repository
	 */
	@Override
	public void createVideo(String url, String titol, int idUsuari)
			throws Exception {

		Usuari usuari = repository.buscarUsuari(idUsuari);
		if (usuari == null) {
			System.out.println("Usuari no existeix");
			return;
		}

		Video video = new Video(url, titol);
		usuari.addVideo(video);
		repository.addVideo(video);
		// afegir tags
		System.out.println(
				"\tIntrodueix tags del video separats per ,");
		Scanner sc = new Scanner(System.in);
		String inputTags = sc.nextLine();
		//Afegir els tags al video
		convertirTexteArray(inputTags,video);
		
		
	}

	/**
	 * 
	 * @return string, amb tos els videos
	 * 
	 *         Metode que torna els videos que hi ha al repostori
	 */
	@Override
	public String getTotsVideos() {
		// Format de sortida de les dates

		StringBuilder repositoryToString = new StringBuilder();

		for (Video video : repository.getAllVideos()) {

			repositoryToString.append("\tTitol: " + video.getTitol()
					+ "\n\tURL: " + video.getUrl() + "\n\tTags: "
					+ video.getAllTags());

		}

		return repositoryToString.toString();
	}

	/**
	 * 
	 * @return string, amb tots els usuaris del repositori
	 * 
	 *         Metode que torna totes les persones del repostiri
	 */
	@Override

	public String getTotsUsuaris() {
		// Format de sortida de les dates
		SimpleDateFormat sdf = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm:ss");

		StringBuilder repositoryToString = new StringBuilder();

		for (Usuari usuari : repository.getAllUsuaris()) {
			repositoryToString.append("\nNom: " + usuari.getNom()
					+ " \nCognoms: " + usuari.getCognom() + "\nId: "
					+ usuari.getId() + " \nData data registre: "
					+ sdf.format(usuari.getDataRegistre().getTime())
					+ "\nLlista de videos:" + "\t"
					+ usuari.getAllVideos());

		}

		return repositoryToString.toString();
	}

	private void convertirTexteArray(String text, Video video) {
		
		String[] paraulesDelText=text.split(",");
		for(String ocurrencia : paraulesDelText)
		{
			video.addTag(ocurrencia);
		}
		
		

	}

}
