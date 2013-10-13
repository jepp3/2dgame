package com.jeppe.game.core;

import static playn.core.PlayN.*;
import playn.core.Game;
import playn.core.Graphics;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.util.Callback;

public class JeppeGame extends Game.Default {

	
	public static float physUnitPerScreenUnit = 1 / 26.666667f;

	private GroupLayer	worldLayer;
	private	BallWorld	world;
	private boolean 	worldLoaded = false;
	
	public JeppeGame() {
		super(33); // call update every 33ms (30 times per second)
 	}
	@Override
	public void init() {
	//create and add background image layer
		createBackgroundLayer();
		createWorldLayer();
		createWorld();
		
	}
	private void createBackgroundLayer()
	{
		Image bgImage = assets().getImage("images/bg.png");
		ImageLayer bgLayer = graphics().createImageLayer(bgImage);
		graphics().rootLayer().add(bgLayer);
	}
	
	private void createWorldLayer()
	{
		worldLayer = graphics().createGroupLayer();
		worldLayer.setScale(1f/physUnitPerScreenUnit);
		graphics().rootLayer().add(worldLayer);
	}
	
	private void createWorld()
	{
		// create callback class
		Callback<BallWorld> callback = new Callback<BallWorld>() {
			@Override
			public void onSuccess(BallWorld result) {
		          world = result; // how this scope is used scares me
		          worldLoaded = true;
			}

			@Override
			public void onFailure(Throwable cause) {
				 PlayN.log().error("Error loading pea world: " + cause.getMessage());
			}
		};
		
		
		BallLoader.createWorld(worldLayer,callback);
	}
	
	private void setPointerListner()
	{
		
	}
	@Override
	public void update(int delta) {
	}

	@Override
	public void paint(float alpha) {
	
		
	}
}
