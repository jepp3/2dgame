package com.jeppe.game.core;

import static org.junit.Assert.*;
import static playn.core.PlayN.assets;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import playn.core.GroupLayer;
import playn.core.Image;
import playn.java.JavaPlatform;


public class EntityTest {
	

	private static Entity entity;
	
	
	@BeforeClass
	public static void beforeClass()
	{
	//	initPlayN();
	}

	@Test
	public void testLoadOfImage() {
		
		//EntityTest.createInstance(new BallWorld(), 0, 0,0);
		//assertTrue(this.entity.getImage() != null);
	}

	private static void createInstance(final BallWorld ballWorld, float x, float y, float angle)
	{
		entity = new Entity(ballWorld,x,y,angle) {
			
			@Override
			public void initPreLoad(BallWorld ballWorld) {
			}
			
			@Override
			public void initPostLoad(BallWorld ballWorld) {
			}
			
			@Override
			float getWidth() {
				return 0;
			}
			
			@Override
			public Image getImage() {
				return assets().getImage("peas/images/pea.png");
			}
			
			@Override
			float getHeight() {
				return 0;
			}
		};
	}

}
