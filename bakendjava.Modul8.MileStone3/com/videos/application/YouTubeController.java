package com.videos.application;


public interface YouTubeController   {
	
 void createUsuari(String nom, String congnoms, String password) throws Exception;
 void createVideo(String url, String titol,int idUsuari,int durada) throws Exception;
 void reproduirVideo(int idVideo)throws Exception;
 String getTotsVideos();
}
