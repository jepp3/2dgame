/**
 * 
 */
package com.jeppe.game.core;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import playn.core.Image;

/**
 * @author jeppe
 *
 */
public class Block extends StaticEntity {

	public static String TYPE = "Block";

	private static Image image = loadImage("Block-Normal.png");
	
	public Block(BallWorld ballWorld, World world, float x, float y, float angle) {
		super(ballWorld, world, x, y, angle);
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.StaticEntity#initPhysicsBody(org.jbox2d.dynamics.World, float, float, float)
	 */
	@Override
	Body initPhysicsBody(World world, float x, float y, float angle) {
		//
		BodyDef 	bodyDef 		= new BodyDef();
		bodyDef.type				= BodyType.STATIC;
		bodyDef.position			= new Vec2(0,0);
		Body body 					= world.createBody(bodyDef);
		
		Vec2[] polygon 				= new Vec2[4];
	    polygon[0] 					= new Vec2(-getWidth()/2f, -getHeight()/2f + getTopOffset());
	    polygon[1] 					= new Vec2(getWidth()/2f, -getHeight()/2f + getTopOffset());
	    polygon[2] 					= new Vec2(getWidth()/2f, getHeight()/2f);
	    polygon[3] 					= new Vec2(-getWidth()/2f, getHeight()/2f);
		
	    PolygonShape polygonShape 	= new PolygonShape();
	    polygonShape.set(polygon, polygon.length);
		
	    FixtureDef 	fixtureDef 		= new FixtureDef();
	    fixtureDef.shape 			= polygonShape;
	    fixtureDef.friction 		= 0.1f;
	    fixtureDef.restitution 		= 0.8f;
	    body.createFixture(fixtureDef);
	    body.setTransform(new Vec2(x, y), angle);
		return body;
	}
	public float getTopOffset() {
		return 2.0f / 8f;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getImage()
	 */
	@Override
	public Image getImage() {
	    return image;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getWidth()
	 */
	@Override
	float getWidth() {
		// TODO Auto-generated method stub
		return 2.0f;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getHeight()
	 */
	@Override
	float getHeight() {
		// TODO Auto-generated method stub
		return 2.0f;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#initPreLoad(com.jeppe.game.core.BallWorld)
	 */
	@Override
	public void initPreLoad(BallWorld ballWorld) {
		// TODO Auto-generated method stub

	}

}
