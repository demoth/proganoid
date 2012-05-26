package org.demoth.ark2.entities;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/10/12
 * Time: 1:01 AM
 */
public class Brick extends Entity {
    public Brick(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        if (collide("BALL", x, y) != null) {
            ME.remove(this);

            /*if (Math.random() > 0.5f) {*/
            if (true) {
                ScoreBonus bonus = new ScoreBonus(x,y, ResourceManager.getImage("bonus"));
                ME.world.add(bonus);
            }
        }

    }
}
