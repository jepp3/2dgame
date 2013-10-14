package com.jeppe.game.core;

import org.jbox2d.dynamics.Body;

public interface PhysicsEntity {

	  public Body getBody();

	  public interface HasContactListener {
		    public void contact(PhysicsEntity other);
		  }
	}