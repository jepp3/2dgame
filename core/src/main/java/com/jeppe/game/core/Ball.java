package com.jeppe.game.core;



import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import playn.core.Image;

public class Ball extends DynamicPhysicsEntity {
  public static String TYPE = "Pea";

  public Ball(BallWorld peaWorld, World world, float x, float y, float angle) {
    super(peaWorld, world, x, y, angle);
  }

  @Override
  Body initPhysicsBody(World world, float x, float y, float angle) {
    FixtureDef fixtureDef = new FixtureDef();
    BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyType.DYNAMIC;
    bodyDef.position = new Vec2(0, 0);
    Body body = world.createBody(bodyDef);

    CircleShape circleShape = new CircleShape();
    circleShape.m_radius = getRadius();
    fixtureDef.shape = circleShape;
    fixtureDef.density = 0.4f;
    fixtureDef.friction = 0.1f;
    fixtureDef.restitution = 0.35f;
    circleShape.m_p.set(0, 0);
    body.createFixture(fixtureDef);
    body.setLinearDamping(0.2f);
    body.setTransform(new Vec2(x, y), angle);
    return body;
  }

  @Override
  float getWidth() {
    return 2 * getRadius();
  }

  @Override
  float getHeight() {
    return 2 * getRadius();
  }

  float getRadius() {
    //return 1.50f;
    return 0.5f;
  }

  @Override
  public Image getImage() {
    return image;
  }

  private static Image image = loadImage("ball.png");
}
