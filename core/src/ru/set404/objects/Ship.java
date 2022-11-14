package ru.set404.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.set404.GameMain;

public class Ship {
    private final TextureRegion[] shipImage = new TextureRegion[67];
    private int angle;
    private final Rectangle ship;
    private double state;

    private int lives = 3;

    public Ship() {
        angle = 0;
        state = 66;
        ship = new Rectangle();
        ship.x = 700;
        ship.y = 100;
        ship.width = 90;
        ship.height = 120;
        for (int i = 0; i <= 66; i++) {
            shipImage[i] = new TextureRegion(new Texture(Gdx.files.internal("ship/ship-" + i + ".png")));
        }
    }

    public void fly(GameMain game) {
        game.batch.draw(shipImage[getState()], ship.x, ship.y, 60,150,
                60, 200, 1, 1, Math.abs(angle / 3));
    }

    public void rotate(int angle) {
        this.angle = angle;
    }

    private int getState() {
        if (state == 0) state=66;
        state-=.5;
        return (int) state;
    }

    public Rectangle getShip() {
        return ship;
    }

    public int getLives() {
        return lives;
    }

    public void dropLive() {
        this.lives--;
    }
}
