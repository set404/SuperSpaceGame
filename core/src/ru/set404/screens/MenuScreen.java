package ru.set404.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.set404.GameMain;
import ru.set404.backgrounds.Background;
import ru.set404.backgrounds.DeadBackground;
import ru.set404.backgrounds.MenuBackground;

public class MenuScreen implements Screen {

    final GameMain game;
    OrthographicCamera camera;
    Background background;


    public enum MenuType {
        MAIN, DEAD
    }

    public MenuScreen(final GameMain gam, MenuType type) {
        game = gam;
        if (type == MenuType.MAIN) {
            background = new MenuBackground();
        } else {
            background = new DeadBackground();
        }
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1500, 900);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        background.render(game);


        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
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
