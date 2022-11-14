package ru.set404.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import ru.set404.GameMain;

public class Planet {
    private final TextureRegion planetImage;
    private final Rectangle planet;
    private static int type = 0;
    private final int planetType;

    public Planet() {
        if (type < 2) type++;
        else type = 0;
        planetType = type;
        planetImage = new TextureRegion(new Texture(Gdx.files.internal("planet" + type + ".png")));
        planet = new Rectangle();
        if (type == 0) {
            planet.x = 0;
            planet.width = 500;
            planet.height = 500;
        } else {
            planet.x = 200 * MathUtils.random(1, 5) + 500;
            planet.width = 200;
            planet.height = 200;
        }
        planet.y = 200 * type * MathUtils.random(1, 5) + 500;

    }

    public void fly(GameMain game, int angle) {
        game.batch.draw(planetImage, planet.x, planet.y, planet.width, planet.height);

        if (planet.y < -1000 || planet.y > 2000) planet.y = 200 * MathUtils.random(1, 5) + 1000;
        if (planet.x < -500 || planet.x > 2500) planet.x = 200 * MathUtils.random(1, 5) + 500;


        if (angle >= 0 && angle < 270) {
            planet.y -= Math.abs((270 - angle) / 3) * Gdx.graphics.getDeltaTime();
            if (planetType == 0) {
                if (planet.x <= 0 && planet.x > -300) {
                    planet.x += Math.abs(angle / 3) * Gdx.graphics.getDeltaTime();
                }
            } else planet.x += Math.abs(angle / 3) * Gdx.graphics.getDeltaTime();

        }
        if (angle >= 270 && angle < 540) {
            planet.y += Math.abs((angle - 270) / 3) * Gdx.graphics.getDeltaTime();
            if (planetType == 0) {
                if (planet.x <= 0 && planet.x > -300) {
                    planet.x += Math.abs((540 - angle) / 3) * Gdx.graphics.getDeltaTime();
                }
            } else planet.x += Math.abs((540 - angle) / 3) * Gdx.graphics.getDeltaTime();
        }
        if (angle >= 540 && angle < 810) {

            planet.y += Math.abs((angle - 810) / 3) * Gdx.graphics.getDeltaTime();
            if (planetType == 0) {
                if (planet.x <= 0 && planet.x > -300) {
                    planet.x -= Math.abs((angle - 540) / 3) * Gdx.graphics.getDeltaTime();
                }
            } else planet.x -= Math.abs((angle - 540) / 3) * Gdx.graphics.getDeltaTime();
        }
        if (angle >= 810 && angle < 1080) {
            planet.y -= Math.abs((angle - 810) / 3) * Gdx.graphics.getDeltaTime();

            if (planetType == 0) {
                if (planet.x <= 0 && planet.x > -300) {
                    planet.x -= Math.abs((1080 - angle) / 3) * Gdx.graphics.getDeltaTime();
                }
            } else planet.x -= Math.abs((1080 - angle) / 3) * Gdx.graphics.getDeltaTime();
        }
    }

}

