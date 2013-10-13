package com.jeppe.game.core;

import playn.core.GroupLayer;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import playn.core.Image;
public class Ball extends com.jeppe.game.core.DynamicPhysicsEntity
{
	 
	private static Image image = loadImage("pea.png");
	 
	public Ball(BallWorld ballWorld, World world, float x, float y, float angle) 
	{
	    super(ballWorld, world, x, y, angle);
	}

	@Override
	Body initPhysicsBody(World world, float x, float y, float angle)
	{
		/*
		 * FLOW
		 * 
		 * create a new bodyDefinition
		 * create the body out of the definition
		 * 
		 * create a shape 
		 * 
		 * create a fixtureDef 
		 * add shapte to fixtureDef
		 * 
		 * create fixture from def
		 *  
		 * add fixture to body
		 */
		
		
	    BodyDef bodyDef 		= new BodyDef();
	    bodyDef.type 			= BodyType.DYNAMIC;
	    bodyDef.position		= new Vec2(0,0);
	    Body body 				= new Body(bodyDef, world);
	    
	    CircleShape circleShape = new CircleShape();
	    circleShape.m_radius = getRadius();
	    circleShape.m_p.set(0,0);
	    
	    
	    FixtureDef fixtureDef 	= new FixtureDef();
	    fixtureDef.shape = circleShape;
	    fixtureDef.density = 0.4f;
	    fixtureDef.friction = 0.1f;
	    fixtureDef.restitution = 0.35f;
	    
	    
	    body.createFixture(fixtureDef);
	    body.setLinearDamping(0.2f);
	    body.setTransform(new Vec2(x,y),angle);
	    
	    
		return body;
	}


	  float getWidth() {
	    return 2 * getRadius();
	  }


	  float getHeight() {
	    return 2 * getRadius();
	  }

	  float getRadius() {
	    return 0.5f;
	  }


	  public Image getImage() {
	    return image;
	  }

	@Override
	public void initPostLoad(BallWorld ballWorld) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initPreLoad(BallWorld ballWorld) {
		// TODO Auto-generated method stub
		
	}

	 
	
	
}
