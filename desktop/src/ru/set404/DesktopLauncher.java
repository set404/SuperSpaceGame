package ru.set404;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Space Tamerlan Game");
		config.setWindowedMode(1500, 900);
		config.useVsync(true);
		config.setForegroundFPS(90);

		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());

		new Lwjgl3Application(new GameMain(), config);


	}
}
