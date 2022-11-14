package ru.set404.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.set404.GameMain;

public class DeadBackground implements Background{
    private final TextureRegion[] backgroundImage = new TextureRegion[120];
    private double state = 0;

    public DeadBackground() {
        for (int i = 0; i <= 119; i++) {
            backgroundImage[i] = new TextureRegion(new Texture(Gdx.files.internal("dead/dead-" + i + ".jpg")));
        }
    }

    public void render(GameMain game) {
        game.batch.draw(backgroundImage[getState()], 0, 0, 1500, 900);
        game.font.getData().setScale(10);
        game.font.setColor(Color.WHITE);
        game.font.draw(game.batch, "Game Over", 350, 550);
        game.font.getData().setScale(3);
        game.font.draw(game.batch, "Tap anywhere to begin!", 500, 100);
        game.font.getData().setScale(1);
        game.font.setColor(Color.WHITE);
    }

    private int getState() {
        if (state > 119) state = 0;
        state += 0.6;
        return (int) state;
    }
}
