package org.demoth.ark2.entities;

import it.randomtower.engine.ME;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/10/12
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Ball extends Entity {
    public float vx = -0.3f;
    public float vy = -0.3f;
    public Ball(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        if (collide("PADDLE", x, y) != null) {
            vy = - Math.abs(vy);
        }
        if (x < 0 || x + width > container.getWidth()) {
            vx *= -1;
        }
        if (y + height > container.getHeight()) {
            ME.remove(this);

        }
        if (y < 0) {
            vy *= -1;
        }
        x += vx * delta;
        y += vy * delta;
    }
}
