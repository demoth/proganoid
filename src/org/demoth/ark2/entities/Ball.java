package org.demoth.ark2.entities;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/10/12
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Ball extends Entity {
    public float vx = -0.1f;
    public float vy = -0.1f;

    public Ball(float x, float y,Image image) {
        super(x, y,image);
        centered = true;
        this.setHitBox(-image.getWidth() / 2, -image.getHeight() / 2, image.getWidth(), image.getHeight());
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        if (collide("PADDLE", x, y) != null) {
            vy = - Math.abs(vy);
            ResourceManager.getSound("bounce").play();
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
