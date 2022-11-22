/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

import me.tim.util.Vec3f;

/**
 * Used to handle simple collisions between two bounding-boxes.
 *
 * @author Tim
 * @since 21.11.2022 - Version 1.0
 */
@SuppressWarnings("unused")
public class CollisionHandler {
    /**
     * Use this method to detect collision between two, two-dimensional bounding-boxes.
     *
     * @see <a href="https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection">Collision Detection Math</a>
     * @param box2D first BoundingBox
     * @param otherBox2D second BoundingBox
     * @return if there is a collision -> true  else -> false
     */
    public boolean isColliding(BoundingBox2D box2D, BoundingBox2D otherBox2D) {
        if (!box2D.isCircle()) {
            return box2D.getXPos() < otherBox2D.getXPos() + otherBox2D.getWidth() &&
                    box2D.getXPos() + box2D.getWidth() > otherBox2D.getXPos() &&
                    box2D.getYPos() < otherBox2D.getYPos() + otherBox2D.getHeight() &&
                    box2D.getHeight() + box2D.getYPos() > otherBox2D.getYPos();
        }

        float deltaX = box2D.getXPos() - otherBox2D.getXPos();
        float deltaY = box2D.getYPos() - otherBox2D.getYPos();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distance < box2D.getRadius() + otherBox2D.getRadius();
    }

    /**
     * Use this method to detect collision between two three-dimensional bounding-boxes.
     *
     * @see <a href="https://developer.mozilla.org/en-US/docs/Games/Techniques/3D_collision_detection">Collision Detection Math</a>
     * @param box3D first BoundingBox
     * @param otherBox3D secondBoundingBox
     * @return if there is a collision -> true  else -> false
     */
    public boolean isColliding(BoundingBox3D box3D, BoundingBox3D otherBox3D) {
        if (!box3D.isSphere()) {
            return box3D.getMinX() <= otherBox3D.getMaxX() &&
                    box3D.getMaxX() >= otherBox3D.getMinX() &&
                    box3D.getMinY() <= otherBox3D.getMaxY() &&
                    box3D.getMaxY() >= otherBox3D.getMinY() &&
                    box3D.getMinZ() <= otherBox3D.getMaxZ() &&
                    box3D.getMaxZ() >= otherBox3D.getMinZ();
        }

        Vec3f bbCenter = box3D.getCenter();
        Vec3f otherBBCenter = otherBox3D.getCenter();
        double distance = Math.sqrt(
                (bbCenter.getX() - otherBBCenter.getX()) * (bbCenter.getX() - otherBBCenter.getX()) +
                        (bbCenter.getY() - otherBBCenter.getY()) * (bbCenter.getY() - otherBBCenter.getY()) +
                        (bbCenter.getZ() - otherBBCenter.getZ()) * (bbCenter.getZ() - otherBBCenter.getZ())
        );
        return distance < (box3D.getRadius() + otherBox3D.getRadius());
    }
}
