package com.jeppe.game.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import playn.core.Image;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.log;

import javax.annotation.PostConstruct;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.Callback;

public class SpriteTest {

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
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Image getImage() {
				// TODO Auto-generated method stub
				return assets().getImage("peas/images/bg.png");
			}
			
			@Override
			float getHeight() {
				// TODO Auto-generated method stub
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
