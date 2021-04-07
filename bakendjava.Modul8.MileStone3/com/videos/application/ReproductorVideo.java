package com.videos.application;

//Codi modificat de l'original: https://github.com/AnmolGrewal/
//Simple-Java-Stopwatch-GUI/blob/master/StopWatch.java

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

import com.videos.domain.Video;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.text.DecimalFormat;

/**
 * <p>
 * * Basically a java class that is called by StopWatchPanel that creates a very
 * very simple StopWatch that runs on on your computer. It shows the time in
 * seconds and tenthes of a second. Has three buttons start, Stop and restart.
 * </p>
 *
 * @author Anmol Grewal
 * @version 1.0
 */
public class ReproductorVideo extends JFrame {

	/** Panel Length. */
	static final int WIDTH = 400;
	/** Panel Height. */
	static final int HEIGHT = 100;
	private int maxTime;

	/** The Stop Watch Panel. */
	private final class PanelReproductorVideo extends JPanel {
		/** Start Button. */
		private JButton start = new JButton("Reproduir");
		/** Stop Button. */
		private JButton stop = new JButton("Pausar");
		/** Timing Label. */
		private JLabel time = new JLabel("0000", JLabel.CENTER);
		/** This is a button for reseting the timer. */
		private JButton reset = new JButton("Parar");
		/** Sets format to tenth of Seconds. */
		private DecimalFormat fmt = new DecimalFormat("0000");
		/** Button Listener for Buttons. */
		private ButtonListener listener = new ButtonListener();
		/** Starting Variable which initializes. */
		private float setTimer;
		/** Timer that keeps track of time using Delay. */
		private Timer timer = new Timer(1000, new TimerListener());

		/** Adds Stop, Reset, Start & Time Along with listeners for buttons. */
		private PanelReproductorVideo() {
			setLayout(new GridLayout(3, 3));
			start.addActionListener(listener);
			stop.addActionListener(listener);
			reset.addActionListener(listener);
			add(start);
			add(stop);
			add(reset);
			add(time);

		}

		/** Updates Time JLabel. */
		private class TimerListener implements ActionListener {

			/**
			 * .
			 * <p>
			 * Changes JLabel Time
			 * </p>
			 * 
			 * @param event The timer change
			 */
			public void actionPerformed(ActionEvent event) {

				setTimer += 1;
				if (setTimer > maxTime) {
					timer.stop();
					setTimer = maxTime;
					time.setText("fi " + fmt.format(setTimer));

				} else {
					time.setText(fmt.format(setTimer));
				}

			}
		}

		/** Button Listener per Para, Pausar i Reproduir. */
		private class ButtonListener implements ActionListener {
			/**
			 * This method start and stop the timer.
			 * 
			 * @param event Button Clicks
			 */
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == start) {
					timer.start();
				} else if (event.getSource() == stop) {
					timer.stop();
				} else {
					timer.stop();
					setTimer = 0;
					time.setText(fmt.format(setTimer));
					

				}
			}
		}
	}

	/** Panel Constructor. */
	public ReproductorVideo(Video video) {
		
		// The Name on Top
		super("Reproductor. Titol video: " + video.getTitol());
		setContentPane(new PanelReproductorVideo());
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	
		//Passar temps de reproduccio
		this.maxTime = video.getDurada();
		
		
	
	}

	/**
	 * <p>
	 * This is the main method (entry point) that gets called by the JVM.
	 * </p>
	 * 
	 * @param args command line arguments.
	 */
	// public static void main(String[] args) {
	// new StopWatchTest1();
	// }

}
