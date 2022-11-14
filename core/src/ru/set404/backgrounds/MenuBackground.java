package ru.set404.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.set404.GameMain;

public class MenuBackground implements Background{
    private final TextureRegion[] backgroundImage = new TextureRegion[12];
    private double state = 0;

    public MenuBackground() {
        for (int i = 0; i <= 11; i++) {
            backgroundImage[i] = new TextureRegion(new Texture(Gdx.files.internal("back/background-" + i + ".png")));
        }
    }

    public void render(GameMain game) {
        game.batch.draw(backgroundImage[getState()], 0, 0, 1500, 900);

        game.font.getData().setScale(10);
        game.font.setColor(Color.WHITE);
        game.font.draw(game.batch, "Tamerlan in the Space", 20, 550);
        game.font.setColor(Color.PINK);
        game.font.draw(game.batch, "Tamerlan in the Space", 30, 540);
        game.font.getData().setScale(3);
        game.font.draw(game.batch, "Tap anywhere to begin!", 500, 100);
        game.font.getData().setScale(1);
        game.font.setColor(Color.WHITE);

    }

    private int getState() {
        if (state > 11) state = 0;
        state += .1;
        return (int) state;
    }

}
