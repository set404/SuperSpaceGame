package ru.set404.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import ru.set404.GameMain;

public class Space {
    private final Texture[] spaceImages = new Texture[4];
    private int x = 0,y = 0;
    private int backI = 0;
    private int forward = 1;

    public Space() {
        spaceImages[0] = new Texture(Gdx.files.internal("space.jpeg"));
        spaceImages[1] = new Texture(Gdx.files.internal("space3.jpg"));
        spaceImages[2] = new Texture(Gdx.files.internal("space2.jpg"));
        spaceImages[3] = new Texture(Gdx.files.internal("space4.jpg"));
    }

    public void fly(GameMain game) {
        game.batch.draw(spaceImages[backI], x, y -= forward, 1500, 3000);
        if (y < -3000) {
            if (backI < 3) {
                backI++;
            }
            else {
                backI = 0;
            }
            y = 900;
        }
        if (y > 3000) y = -900;
    }
}
