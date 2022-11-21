/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

/**
 * Used to handle simple collisions between two bounding-boxes.
 * TODO: Three-dimensional collisions.
 *
 * @author Tim
 * @since 21.11.2022 - Version 1.0
 */
@SuppressWarnings("unused")
public class CollisionHandler {
    /**
     * Use this method to detect collision between two bounding-boxes.
     *
     * @see <a href="https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection">Collision Detection Math</a>
     * @param boundingBox first BoundingBox
     * @param otherBoundingBox second BoundingBox
     * @return collision detected ? true : false
     */
    public boolean isColliding(BoundingBox2D boundingBox, BoundingBox2D otherBoundingBox) {
        if (!boundingBox.isCircle()) {
            return boundingBox.getXPos() < otherBoundingBox.getXPos() + otherBoundingBox.getWidth() &&
                    boundingBox.getXPos() + boundingBox.getWidth() > otherBoundingBox.getXPos() &&
                    boundingBox.getYPos() < otherBoundingBox.getYPos() + otherBoundingBox.getHeight() &&
                    boundingBox.getHeight() + boundingBox.getYPos() > otherBoundingBox.getYPos();
        }

        float deltaX = boundingBox.getXPos() - otherBoundingBox.getXPos();
        float deltaY = boundingBox.getYPos() - otherBoundingBox.getYPos();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distance < boundingBox.getDiameter() / 2 + otherBoundingBox.getDiameter() / 2;
    }
}
