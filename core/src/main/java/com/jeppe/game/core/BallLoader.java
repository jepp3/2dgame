package com.jeppe.game.core;

import playn.core.AssetWatcher;
import playn.core.GroupLayer;
import playn.core.Json;
import playn.core.PlayN;
import playn.core.util.Callback;

public class BallLoader {
	public static void createWorld(String level, final GroupLayer worldLayer,final Callback<BallWorld> callback) {
		
		final BallWorld ballworld = new BallWorld(worldLayer);
		loadWorld(level,worldLayer,ballworld,callback);
	}
	
	public static void loadWorld(String level, GroupLayer worldLayer, final BallWorld ballWorld, final Callback<BallWorld> callback)
	{
		PlayN.assets().getText(level, new Callback.Chain<String>(callback) {

			@Override
			public void onSuccess(String resource) {
		        // call a one time assertWatcher, that i defined here and thrown away later.
			     
		    	 AssetWatcher assetWatcher = BallLoader.createAssetWatcher(ballWorld, callback);
		    	 
		        // parse the level
		        Json.Object document = PlayN.json().parse(resource);

		        // previous Portal (used for linking portals)
		        

		        // parse the entities, adding each asset to the asset watcher
		        Json.Array jsonEntities = document.getArray("Entities");
		        for (int i = 0; i < jsonEntities.length(); i++) {
		          Json.Object jsonEntity = jsonEntities.getObject(i);
		          String type = jsonEntity.getString("type");
		          float x = jsonEntity.getNumber("x");
		          float y = jsonEntity.getNumber("y");
		          float a = jsonEntity.getNumber("a");

		          Entity entity = null;
		          if (Ball.TYPE.equalsIgnoreCase(type)) {
		            entity = new Ball(ballWorld, ballWorld.world, x, y, a);
		          }/* else if (Block.TYPE.equalsIgnoreCase(type)) {
		            entity = new Block(peaWorld, peaWorld.world, x, y, a);
		          } else if (BlockRightRamp.TYPE.equalsIgnoreCase(type)) {
		            entity = new BlockRightRamp(peaWorld, peaWorld.world, x, y, a);
		          } else if (BlockLeftRamp.TYPE.equalsIgnoreCase(type)) {
		            entity = new BlockLeftRamp(peaWorld, peaWorld.world, x, y, a);
		          } else if (BlockGel.TYPE.equalsIgnoreCase(type)) {
		            entity = new BlockGel(peaWorld, peaWorld.world, x, y, a);
		          } else if (BlockSpring.TYPE.equalsIgnoreCase(type)) {
		            entity = new BlockSpring(peaWorld, peaWorld.world, x, y, a);
		          } else if (Cloud1.TYPE.equalsIgnoreCase(type)) {
		            entity = new Cloud1(peaWorld);
		          } else if (Cloud3.TYPE.equalsIgnoreCase(type)) {
		            entity = new Cloud3(peaWorld);
		          } else if (FakeBlock.TYPE.equalsIgnoreCase(type)) {
		            entity = new FakeBlock(peaWorld, x, y, a);
		          } else if (Portal.TYPE.equalsIgnoreCase(type)) {
		            entity = new Portal(peaWorld, peaWorld.world, x, y, a);
		            if (lastPortal == null) {
		              lastPortal = (Portal) entity;
		            } else {
		              lastPortal.other = (Portal) entity;
		              ((Portal) entity).other = lastPortal;
		              lastPortal = null;
		            }
		          }
		          */

		          if (entity != null) {
		            assetWatcher.add(entity.getImage());
		            ballWorld.add(entity);
		          }
		        }

		        // start the watcher (it will call the callback when everything is
		        // loaded)
		        assetWatcher.start();
				
			}
		});
	}
	
	
	 private static AssetWatcher createAssetWatcher(final BallWorld peaWorld, final Callback<BallWorld> callback)
	  {
	  
		  return  new AssetWatcher(new AssetWatcher.Listener() {
		      @Override
		      public void done() {
		        callback.onSuccess(peaWorld);
		      }

		      @Override
		      public void error(Throwable e) {
		        callback.onFailure(e);
		      }
		    });

	  }
}
