package ru.set404.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import ru.set404.GameMain;

public class Asteroid {
    private final TextureRegion[] asteroidImage = new TextureRegion[15];
    private final TextureRegion[] bangImage = new TextureRegion[22];

    private final Rectangle asteroid;
    private double state;
    private double stateBang;

    private Ship ship;

    private boolean isCollapsed = false;


    public Asteroid() {
        for (int i = 0; i < asteroidImage.length; i++) {
            asteroidImage[i] = new TextureRegion(new Texture(Gdx.files.internal("asteroids/asteroid-" + i + ".png")));
        }
        for (int i = 0; i < bangImage.length; i++) {
            bangImage[i] = new TextureRegion(new Texture(Gdx.files.internal("bang/bang-" + i + ".png")));
        }
        asteroid = new Rectangle();
        asteroid.x = MathUtils.random(200, 3500);
        asteroid.y = 1000 + MathUtils.random(900, 3000);
        asteroid.width = 30;
        asteroid.height = 300;
        state = Math.abs(MathUtils.random(0, 13));
        stateBang = 0;
    }

    public void fly(GameMain game, int angle) {
        if (!isCollapsed) {
            game.batch.draw(asteroidImage[getState()], asteroid.x, asteroid.y, asteroid.width, asteroid.height,
                    asteroid.width, asteroid.height, 1, 1, -15);
            if (asteroid.x < -100 || asteroid.x > 2000) {
                asteroid.x = MathUtils.random(200, 3500);
                asteroid.y = -1000;
            }
            if (asteroid.y < -1000) asteroid.y = 2000;
            if (asteroid.y > 2000) asteroid.y = -1000;

            asteroid.x -= 1; //3

            if (angle >= 0 && angle < 270) {
                asteroid.y -= (270 - angle) * Gdx.graphics.getDeltaTime();
                asteroid.x += (angle) * Gdx.graphics.getDeltaTime();
            }
            if (angle >= 270 && angle < 540) {
                asteroid.x += (540 - angle) * Gdx.graphics.getDeltaTime();
                asteroid.y += (angle - 270) * Gdx.graphics.getDeltaTime();
            }
            if (angle >= 540 && angle < 810) {
                asteroid.y += (810 - angle) * Gdx.graphics.getDeltaTime();
                asteroid.x -= (angle - 540) * Gdx.graphics.getDeltaTime();
            }
            if (angle >= 810 && angle < 1080) {
                asteroid.x -= (1080 - angle) * Gdx.graphics.getDeltaTime();
                asteroid.y -= (angle - 810) * Gdx.graphics.getDeltaTime();
            }
        } else bang(game);
    }

    public Rectangle getAsteroid() {
        return asteroid;
    }

    public void collapse(Ship ship) {
        isCollapsed = true;
        this.ship = ship;

    }

    private int getState() {
        if (state >= 14) state = 0;
        state += .4;
        return (int) state;
    }

    private int getStateBang() {
        if (stateBang >= 21) {
            stateBang = 0;
            isCollapsed = false;
            asteroid.x = MathUtils.random(0, 1500 - 64);
            asteroid.y = 1200;
            asteroid.width = 30;
            asteroid.height = 300;
            ship.dropLive();
        }
        stateBang += .4;
        return (int) stateBang;
    }

    private void bang(GameMain game) {
        game.batch.draw(bangImage[getStateBang()], asteroid.x-200, asteroid.y, 300, 250);
    }
}

