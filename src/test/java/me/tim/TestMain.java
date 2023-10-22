/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

import javax.swing.*;
import java.awt.*;

/**
 * Example class for a possible usage of the CollisionLib.
 *
 * @author Tim
 * @since 21.11.2022 - Version 0.0.1
 */
public class TestMain {
    //Simple JFrame
    private static final JFrame frame = new JFrame("Collision-Test");
    //Initialize the CollisionHandler
    private static final CollisionHandler collisionHandler = new CollisionHandler();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        Entity entity = new Entity(100, 100, 100, 100);
        Entity entity1 = new Entity(100, 150, 100, 100);
        frame.add(entity);
        frame.add(entity1);
        entity.setVisible(true);
        entity1.setVisible(true);
        frame.setVisible(true);

        System.out.println(collisionHandler.isColliding(entity.getBoundingBox2D(), entity1.getBoundingBox2D()));
    }

    /**
     * Class that's being used to render a rectangle on the frame.
     *
     * @author Tim
     * @since 21.11.2022 - Version 1.0
     */
    private static class Entity extends JLabel {
        /**
         * @see BoundingBox2D
         */
        private final BoundingBox2D boundingBox2D;

        public Entity(float x, float y, float width, float height) {
            this.boundingBox2D = new BoundingBox2D(x, y, width, height);
        }

        /**
         * Overridden JLabel Method.
         * Gets called if the Label is getting drawn.
         *
         * @see JLabel
         * @param g the <code>Graphics</code> object to protect
         */
        @Override
        protected void paintComponent(Graphics g) {
            //Draw a rectangle at the BoundingBox position
            g.drawRect((int) this.boundingBox2D.getXPos(), (int) this.boundingBox2D.getYPos(), (int) this.boundingBox2D.getWidth(), (int) this.boundingBox2D.getHeight());
        }

        public BoundingBox2D getBoundingBox2D() {
            return boundingBox2D;
        }
    }
}
