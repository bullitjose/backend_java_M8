package com.videos.proxy;

import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;

import com.videos.application.YouTubeController;
import com.videos.application.YouTubeControllerImpl;
import com.videos.domain.Usuari;

public class YouTubeControllerProxy extends JFrame implements YouTubeController {
	private YouTubeControllerImpl youTubeService;

	public YouTubeControllerProxy() {

		this.youTubeService = new YouTubeControllerImpl();
	}

	@Override
	public void createUsuari(String nom, String congnoms,
			String password) throws Exception {

		youTubeService.createUsuari(nom, congnoms, password);

	}



	/**
	 * 
	 * @return string, amb tos els videos
	 * 
	 *         Metode que torna els videos que hi ha al repostori
	 */
	@Override
	public String getTotsVideos() {

		return youTubeService.getTotsVideos();
	}

	/**
	 * 
	 * @return string, amb tots els usuaris del repositori
	 * 
	 *         Metode que torna tots els usuaris repostiri
	 */
	@Override
	public String getTotsUsuaris() {

		return youTubeService.getTotsUsuaris();
	}

	@Override
	public void createVideo(String url, String titol, int idUsuari)
			throws Exception {
		youTubeService.createVideo(url, titol, idUsuari);

		
	}
}
