package ru.set404.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import ru.set404.GameMain;

public class Star {

    private int x;
    private int y;
    private final int speed;

    public Star() {
        this.x = MathUtils.random(-1, 1500);
        this.y = MathUtils.random(0, 900);
        this.speed = MathUtils.random(1, 5);
    }

    public void fly(GameMain game, int angle) {
        game.font.draw(game.batch, ".", x, y);

        if (x < 0) x = 1500;
        if (x > 1500) x = 0;
        if (y < 0) y = 900;
        if (y > 900) y = 0;

        if (angle >= 0 && angle < 270) {
            y -= (270 - angle) * speed * Gdx.graphics.getDeltaTime();
            x += (angle) * speed * Gdx.graphics.getDeltaTime();
        }

        if (angle >= 270 && angle < 540) {
            x += (540 - angle) * (speed) * Gdx.graphics.getDeltaTime();
            y += (angle - 270) * speed * Gdx.graphics.getDeltaTime();
        }

        if (angle >= 540 && angle < 810) {
            y += (810 - angle) * (speed) * Gdx.graphics.getDeltaTime();
            x -= (angle - 540) * speed * Gdx.graphics.getDeltaTime();
        }

        if (angle >= 810 && angle < 1080) {
            x -= (1080 - angle) * (speed) * Gdx.graphics.getDeltaTime();
            y -= (angle - 810) * speed * Gdx.graphics.getDeltaTime();
        }
    }
}