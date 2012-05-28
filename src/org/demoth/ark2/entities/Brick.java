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
 * Time: 1:01 AM
 */
public class Brick extends Entity {
    public Brick(float x, float y, Image image) {
        super(x, y, image);
        centered = true;
        setHitBox(-image.getWidth()/2, -image.getHeight()/2, image.getWidth(), image.getHeight());
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        if (collide("BALL", x, y) != null) {
            ME.remove(this);
            ResourceManager.getSound("brick").play();

            if (Math.random() > 0.75f) {
            /*if (true) {*/
                ScoreBonus bonus = new ScoreBonus(x,y, ResourceManager.getImage("bonus"));
                ME.world.add(bonus);
            }
        }

    }
}
