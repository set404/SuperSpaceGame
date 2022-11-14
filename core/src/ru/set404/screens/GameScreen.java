package ru.set404.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.set404.GameMain;
import ru.set404.objects.*;

public class GameScreen implements Screen {
    private final GameMain game;
    private final Ship ship;
    //private Space space;
    private final Array<Planet> planets;
    private final OrthographicCamera camera;
    private final Array<Asteroid> asteroids;
    private final Array<Star> stars;
    private int angle;
    private int livesTime = 0;

    public GameScreen(final GameMain game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1500, 900);
        angle = 0;

        ship = new Ship();
        //space = new Space();
        planets = new Array<>();
        for (int i = 0; i < 3; i++) {
            Planet planet = new Planet();
            planets.add(planet);
        }
        asteroids = new Array<>();
        for (int i = 0; i < 5; i++) {
            Asteroid asteroid = new Asteroid();
            asteroids.add(asteroid);
        }
        stars = new Array<>();
        game.font.getData().setScale(1, 2);
        for (int i = 0; i < 80; i++) {
            Star star = new Star();
            stars.add(star);
        }
    }

    @Override
    public void render(float delta) {


        ScreenUtils.clear(0.08f, 0.08f, 0.13f, 1.0f);
        if (angle < 0) angle = 1080 + angle;
        if (angle > 1080) angle = 1;
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        //space.fly(game);
        for (Planet planet : planets) {
            planet.fly(game, angle);
        }
        for (Asteroid asteroid : asteroids) {
            asteroid.fly(game, angle);
            if (asteroid.getAsteroid().overlaps(ship.getShip())) {
                asteroid.collapse(ship);
                livesTime = 0;
            }
        }
        for (Star star : stars) {
            star.fly(game, angle);
        }
        ship.fly(game);

        game.font.getData().setScale(2);
        game.font.setColor(Color.WHITE);
        if (livesTime < 100) {
            game.font.draw(game.batch, "Lives: " + ship.getLives(), 50, 850);
            livesTime++;
        }

        if (ship.getLives() == 0) {
            game.setScreen(new MenuScreen(game, MenuScreen.MenuType.DEAD));
            dispose();
        }

        game.batch.end();
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2) {
                angle += 3;
                ship.rotate(angle);
            } else {
                angle -= 3;
                ship.rotate(angle);
            }
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            angle += 3;
            ship.rotate(angle);
        }
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            System.exit(0);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            angle -= 3;
            ship.rotate(angle);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }

}
