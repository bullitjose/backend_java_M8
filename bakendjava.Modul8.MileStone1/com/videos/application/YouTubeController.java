package com.videos.application;

import com.videos.domain.Usuari;

public interface YouTubeController {
	
 void createUsuari(String nom, String congnoms, String password) throws Exception;
 void createVideo(String url, String titol,int idUsuari) throws Exception;
 String getTotsUsuaris();
 String getTotsVideos();
}
