package com.jeppe.game.core;

import static org.junit.Assert.*;
import static playn.core.PlayN.assets;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import playn.core.Image;


public class EntityTest {
	

	private Entity entity;
	
	
	@Before
	public  void before()
	{
		entity = new Entity(new BallWorld(),0,0,0) {

			@Override
			public void initPreLoad(BallWorld ballWorld) {
				
			}
			
			@Override
			public void initPostLoad(BallWorld ballWorld) {
				System.out.println("called init");
			}
			
			@Override
			float getWidth() {
				return 0;
			}
			
			@Override
			public Image getImage() {

				Image bgImage = assets().getImage("images/bg.png");
				
				
				return bgImage;
			}
			
			@Override
			float getHeight() {

				return 0;
			}
		};
		
		
		
		
	}
	
	@After
	public  void after()
	{
		
	}
	
	@Test
	public void test() {
	
	}


}
