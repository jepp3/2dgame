/**
 * 
 */
package com.jeppe.game.core;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import playn.core.Image;

/**
 * @author jeppe
 *
 */
public class Block extends StaticEntity {

	public Block(BallWorld ballWorld, World world, float x, float y, float angle) {
		super(ballWorld, world, x, y, angle);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.StaticEntity#initPhysicsBody(org.jbox2d.dynamics.World, float, float, float)
	 */
	@Override
	Body initPhysicsBody(World world, float x, float y, float angle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getImage()
	 */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getWidth()
	 */
	@Override
	float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#getHeight()
	 */
	@Override
	float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.jeppe.game.core.Entity#initPreLoad(com.jeppe.game.core.BallWorld)
	 */
	@Override
	public void initPreLoad(BallWorld ballWorld) {
		// TODO Auto-generated method stub

	}

}
