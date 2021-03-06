package com.videos.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.videos.application.YouTubeController;
import com.videos.proxy.YouTubeControllerProxy;

public class Main {
	private static YouTubeControllerProxy proxy = new YouTubeControllerProxy();

	public static void main(String[] args) throws Exception {

		final String OPCIO_PATTERN = "[1-5]";
		final Pattern opcioPattern = Pattern.compile(OPCIO_PATTERN);
		proxy.createUsuari("Pepe", "Maria", "123456");

		proxy.createUsuari("Marcel", "Maria", "bb123456");
		proxy.createUsuari("Maria", "Mariana", "12bb3456");
		proxy.createUsuari("Pepa", "Mario", "123456bb");
		proxy.createUsuari("CarlaPepe", "Garcia", "12bb3456");
		/*proxy.createVideo("www.pwpw", "meu", 1);
		proxy.createVideo("www.pwssspw", "bub bub", 1);
		proxy.createVideo("www.pwssdfpw", "kikiriiikii", 1);*/
		Scanner sc = new Scanner(System.in);

		String choice = "5";
		while (choice.equalsIgnoreCase("5")) {

			// Introducir LlicenciaConduir
			System.out.println(
					"\tIntrodueix opcio\n\t\t1-Alta usuari YouTube"
							+ "\n\t\t2-Crear video"
							+ "\n\t\t3-Mostrar usuaris "
							+ "\n\t\t4-Mostrar videos "
							+ "\n\t\t5-Acabar");

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
					sc.close();
					System.exit(0);
				default:
					System.out.println(
							"Entrada no valida. Torna a provar");

				}

			}

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
			String usuariNom = inputData(sc,"usuari");

			// Introduir Cognom usuari
			String usuariCognom=inputData(sc,"cognom");
			
			// Introduir password
			String usuariPassword=inputData(sc,"password");
			
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
	private static String inputData(Scanner sc,String cadena)
			throws EntradaBuidaException {
		// Introduir nom

		System.out.println("Introdueix "+cadena+ ": ");
		String usuariNom = sc.nextLine();
		if (usuariNom.isEmpty() || usuariNom.isBlank()) {
			throw new EntradaBuidaException(
					"\tError, els camps no poden quedar buits");
			
		}
		return usuariNom;
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
		String videoUrl =inputData(sc,"URL");
		
		// Introduir titol
		String videoTitol =inputData(sc,"titol");
		
		// Treure llistat usuaris per escollir id
		String allUsuaris = proxy.getTotsUsuaris();
		System.out.println("Usuaris: " + allUsuaris + " \n");
		
		//Introduir Id
		String usuariId=inputData(sc,"Id");
		

		proxy.createVideo(videoUrl, videoTitol,
				Integer.parseInt(usuariId));

	}

}
