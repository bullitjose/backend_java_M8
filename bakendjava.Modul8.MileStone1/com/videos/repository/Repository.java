package com.videos.repository;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import com.videos.domain.Usuari;
import com.videos.domain.Video;

public class Repository {
	private static List<Usuari> usuaris = new ArrayList<>();
	private static List<Video> videos = new ArrayList<>();

	public Repository() {

	}

	/**
	 * 
	 * @param usuari
	 * @throws Exception
	 * 
	 *                   Metode per afegir vehicle a la llista de usuaris que fa de
	 *                   repository
	 */
	public void addUsuari(Usuari usuari) throws Exception {
		if (usuari == null)
			throw new Exception();
		usuaris.add(usuari);
	}

	/**
	 * 
	 * @param video
	 * @throws Exception
	 * 
	 *                   Metode per afegir video a la llista de videos que fa de
	 *                   repository
	 */
	public void addVideo(Video video) throws Exception {
		if (video == null)
			throw new Exception();
		videos.add(video);
	}

	/**
	 * 
	 * @return List<Video>, torna llista de tots els videos
	 */
	public List<Video> getAllVideos() {
		return new ArrayList<>(videos);
	}

	/**
	 * 
	 * @return List<Usuari>, torna llista de tots els usuaris
	 */
	public List<Usuari> getAllUsuaris() {
		return new ArrayList<>(usuaris);
	}
/**
 * 
 * @param idUsuari
 * @return
 */
	public Usuari buscarUsuari(int idUsuari) {

		int id;
		for (Usuari u : usuaris) {
			id = u.getId();

			if (id == idUsuari) {
				System.out.println("Id existeix pot afegir video a l'usuari "
						+ u.getNom()+" "+u.getCognom());
				return u;
			}
		}

		return null;
	}
}
