package com.jeppe.game.core;

import static playn.core.PlayN.*;
import playn.core.Game;
import playn.core.Graphics;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.util.Callback;

public class JeppeGame extends Game.Default {

	
	public static float physUnitPerScreenUnit = 1 / 26.666667f;

	private GroupLayer	worldLayer;
	private	BallWorld	world;
	private boolean 	worldLoaded = false;
	Image bgImage = null;
	ImageLayer bgLayer = null;
	private final String level = "peas/levels/level1.json";
	
	public JeppeGame() {
		super(33); // call update every 33ms (30 times per second)
 	}
	@Override
	public void init() {
	//create and add background image layer
		createBackgroundLayer();
		createWorldLayer();
		createWorld();
	    setPointerListner();		
	}
	private void createBackgroundLayer()
	{
		bgImage = assets().getImage("bg.png");
		bgLayer = graphics().createImageLayer(bgImage);
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
				 PlayN.log().error("Error loading ball world: " + cause.getMessage());
			}
		};
		
		
		BallLoader.createWorld(level,worldLayer,callback);
	}
	
	private void setPointerListner()
	{
		pointer().setListener(new Pointer.Adapter() {
		      @Override
		      public void onPointerStart(Pointer.Event event) {
		        if (worldLoaded) {
		          Ball pea = new Ball(world, world.world, physUnitPerScreenUnit * event.x(),
		                            physUnitPerScreenUnit * event.y(), 0);
		          world.add(pea);
		        }
		      }
		    });
	}
	  public void shutdown() {
	    bgLayer.destroy();
	    bgLayer = null;
	    worldLayer.destroy();
	    worldLayer = null;
	    world = null;
	    worldLoaded = false;
	  }

	  @Override
	  public void paint(float alpha) {
	    if (worldLoaded) {
	      world.paint(alpha);
	    }
	  }

	  @Override
	  public void update(int delta) {
	    if (worldLoaded) {
	      world.update(delta);
	    }
	  }
}
