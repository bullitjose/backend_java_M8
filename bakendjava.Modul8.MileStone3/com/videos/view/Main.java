
package com.videos.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.videos.proxy.YouTubeControllerProxy;

public class Main {
	// PATROID, per controlar que només introduim nombre, 1 digit pels ids, i 3 per
	// la durada
	private static final String PATROID = "(^\\d{1,3}$)";
	private static YouTubeControllerProxy proxy = new YouTubeControllerProxy();

	public static void main(String[] args) throws Exception {

		final String OPCIO_PATTERN = "[1-5]";
		final Pattern opcioPattern = Pattern.compile(OPCIO_PATTERN);

		// Crear usuaris
		proxy.createUsuari("Pepe", "Maria", "123456");
		proxy.createUsuari("Marcel", "Maria", "bb123456");
		proxy.createUsuari("Maria", "Mariana", "12bb3456");
		proxy.createUsuari("Pepa", "Mario", "123456bb");
		proxy.createUsuari("CarlaPepe", "Garcia", "12bb3456");

		Scanner sc = new Scanner(System.in);

		String choice = "6";
		while (choice.equalsIgnoreCase("6")) {

			// Introducir LlicenciaConduir
			System.out.println(
					"\tIntrodueix opcio\n\t\t1-Alta usuari YouTube"
							+ "\n\t\t2-Crear video"
							+ "\n\t\t3-Mostrar usuaris "
							+ "\n\t\t4-Mostrar videos "
							+ "\n\t\t5-Reproduir video "
							+ "\n\t\t6-Acabar");

			String opcio = sc.nextLine();
			Matcher matcher = opcioPattern.matcher(opcio);
			if (matcher.matches()) {
				switch (opcio) {
				case "1":

					createUsuari(sc);

					break;

				case "2":
					createVideo(sc);
					break;
				case "3":
					String allUsuaris = proxy.getTotsUsuaris();
					System.out.println(
							"Usuaris: " + allUsuaris + " \n");
					break;

				case "4":
					String allVideos = proxy.getTotsVideos();
					System.out.println(
							"Videos: " + " \n" + allVideos + " \n");
					break;
				
				case "5":
					// Introduir id Video
					reproduirVideo(sc);
					break;
				case "6":
					sc.close();
					System.exit(0);
				default:
					System.out.println(
							"Entrada no valida. Torna a provar");

				}

			}

		}

	}

	private static void reproduirVideo(Scanner sc) throws Exception {
		// Treure llistat videos per escollir id a reproduir
		String allVideos = proxy.getTotsVideos();
		System.out.println("Videos: " + " \n" + allVideos + " \n");

		// Escullir id
		try {
			int idVideo = validarInt(sc, "escull id video ");
			// passar parametres per crear video
			proxy.reproduirVideo(idVideo);
		} catch (EntradaBuidaException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	/**
	 * @param sc
	 * @throws Exception
	 * 
	 *                   Metode per crear un usuari recull i valida dades i crida a
	 *                   YouTubeControllerProxy de com.videos.proxy per crear
	 *                   lusuari
	 */
	private static void createUsuari(Scanner sc) throws Exception {
		try {
			// Introduir Nom usuari
			String usuariNom = inputData(sc, "usuari");

			// Introduir Cognom usuari
			String usuariCognom = inputData(sc, "cognom");

			// Introduir password
			String usuariPassword = inputData(sc, "password");

			proxy.createUsuari(usuariNom, usuariCognom,
					usuariPassword);
		} catch (EntradaBuidaException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * @param sc
	 * @return
	 * @throws EntradaBuidaException
	 */
	private static String inputData(Scanner sc, String cadena) {

		String entradaText;
		// Introduir nom
		while (true) {
			try {
				System.out.println("Introdueix " + cadena + ": ");
				entradaText = sc.nextLine();
				if (entradaText.isEmpty() || entradaText.isBlank()) {
					throw new EntradaBuidaException(
							"\tError EntradaBuidaException, els camps no poden quedar buits");

				} else
					break;

			} catch (EntradaBuidaException e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
		}
		return entradaText;
	}

	/**
	 * @param sc
	 * @throws Exception
	 * 
	 *                   Metode per crear un video recull i valida dades i crida a
	 *                   YouTubeControllerProxy de com.videos.proxy per crear el
	 *                   video
	 */
	private static void createVideo(Scanner sc) throws Exception {

		// Introduir URL
		String videoUrl = inputData(sc, "URL ");

		// Introduir titol
		String videoTitol = inputData(sc, "titol ");

		// Introduir durada en segons
		int videoDurada = validarInt(sc, "durada(en segons) ");

		// Treure llistat usuaris per escollir id
		String allUsuaris = proxy.getTotsUsuaris();
		System.out.println("Usuaris: " + allUsuaris + " \n");

		// Escullir id
		int idUsuari = validarInt(sc, "escull id usuari ");

		// passar parametres per crear video
		proxy.createVideo(videoUrl, videoTitol, idUsuari,
				videoDurada);

	}

	private static int validarInt(Scanner sc, String text)
			throws EntradaBuidaException {

		int i = 0;
		while (true) {

			String validarInt = inputData(sc, text);
			// Controlar entrada del ID que sigui correcta
			if (Pattern.matches(PATROID, validarInt)) {
				i = Integer.parseInt(validarInt);
				break;

			} else {
				System.out.println(
						"\tError!. Entrada no valida. Torna a provar");
			}

		}
		return i;
	}

}
