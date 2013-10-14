package com.jeppe.game.core;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;



public abstract class DynamicPhysicsEntity extends Entity implements PhysicsEntity {
  // for calculating interpolation
  private float prevX, prevY, prevA;
  private Body body;

  public DynamicPhysicsEntity(BallWorld peaWorld, World world, float x, float y, float angle) {
    super(peaWorld, x, y, angle);
    body = initPhysicsBody(world, x, y, angle);
    setPos(x, y);
    setAngle(angle);
  }

  abstract Body initPhysicsBody(World world, float x, float y, float angle);

  @Override
  public void paint(float alpha) {
    // interpolate based on previous state
    float x = (body.getPosition().x * alpha) + (prevX * (1f - alpha));
    float y = (body.getPosition().y * alpha) + (prevY * (1f - alpha));
    float a = (body.getAngle() * alpha) + (prevA * (1f - alpha));
    layer.setTranslation(x, y);
    layer.setRotation(a);
  }

  @Override
  public void update(float delta) {
    // store state for interpolation in paint()
    prevX = body.getPosition().x;
    prevY = body.getPosition().y;
    prevA = body.getAngle();
  }

  @Override
  public void initPreLoad(final BallWorld ballWorld) {
    // attach our layer to the dynamic layer
	 	ballWorld.dynamicLayer.add(layer);
  }
  
  @Override
  public void initPostLoad(final BallWorld ballWorld) {
  
  }

  public void setLinearVelocity(float x, float y) {
    body.setLinearVelocity(new Vec2(x, y));
  }

  public void setAngularVelocity(float w) {
    body.setAngularVelocity(w);
  }

  @Override
  public void setPos(float x, float y) {
	  
	  System.out.println("set pos");
    super.setPos(x, y);
    getBody().setTransform(new Vec2(x, y), getBody().getAngle());
    prevX = x;
    prevY = y;
  }

  @Override
  public void setAngle(float a) {
    super.setAngle(a);
    getBody().setTransform(getBody().getPosition(), a);
    prevA = a;
  }

  @Override
  public Body getBody() {
    return body;
  }
}