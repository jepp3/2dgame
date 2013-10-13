package com.jeppe.game.core;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class BallTest extends AbstractPlayNTester{

	@Test
	public void test_that_ball_is_circle() {
		
		Ball ball = new Ball(new BallWorld(),new World(new Vec2(0, 1)), 0f, 0f, 1f);
		
		assertEquals(ShapeType.CIRCLE,ball.getBody().getFixtureList().m_shape.m_type);
	}
	

	@BeforeClass
	public static void beforeClass()
	{
		initPlayN();
	}

}
