package com.jeppe.game.core;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.log;

import javax.annotation.PostConstruct;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.Callback;
public abstract class Entity {

	final ImageLayer layer;
	float x, y, angle;
	
	
	public Entity(final BallWorld ballWorld, float x, float y, float angle)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
	    layer = graphics().createImageLayer(getImage());
	    
	    this.initPreLoad(ballWorld);
	    this.addCallback(ballWorld);
	}

	private void addCallback(final BallWorld ballWorld)
	{
	    getImage().addCallback(new Callback<Image>() {
	
				@Override
				public void onSuccess(Image image) {
					
					layer.setOrigin(image.width()/2f,image.width()/2f);
					layer.setScale(getWidth() / image.width(), getHeight() / image.height());
					layer.setTranslation(x, y);
			        layer.setRotation(angle);
			        initPostLoad(ballWorld);
				}
	
				@Override
				public void onFailure(Throwable err) {
			        log().error("Error loading image: " + err.getMessage());
				}
			});
	}
	public abstract Image getImage();

	abstract float getWidth();
	
	abstract float getHeight();
	
	public abstract void initPostLoad(final BallWorld ballWorld);
	
	public abstract void initPreLoad(final BallWorld ballWorld);
	
	
	public void setPos(float x, float y)
	{
		this.layer.setTranslation(x, y);
	}
	public void setAngle(float angle)
	{
		this.layer.setRotation(angle);
	}
	 protected static Image loadImage(String name) {
		 return assets().getImage("peas/images/" + name);
	 }

	
	public void paint(float alfa)
	{
		
	}
	
	public void update(float delta) {
	}
	
}
