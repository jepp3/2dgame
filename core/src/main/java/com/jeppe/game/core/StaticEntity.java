package com.jeppe.game.core;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public abstract class StaticEntity extends Entity {

	private Body body;
	
	public StaticEntity(BallWorld ballWorld,World world,float x, float y, float angle)
	{
		super(ballWorld,x,y,angle);
		body = initPhysicsBody(world, x, y, angle);
	}
	
	abstract Body initPhysicsBody(World world, float x, float y, float angle);
	
	@Override
	public void initPostLoad(final BallWorld ballWorld) {
		ballWorld.staticLayerBack.add(layer);
	}
	
	public Body getBody() {
		return body;
	}
	
}
