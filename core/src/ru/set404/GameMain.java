package ru.set404;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.set404.screens.MenuScreen;


public class GameMain extends com.badlogic.gdx.Game {
    public SpriteBatch batch;
    public BitmapFont font;

    public void create() {
        batch = new SpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();
        this.setScreen(new MenuScreen(this, MenuScreen.MenuType.MAIN));
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}