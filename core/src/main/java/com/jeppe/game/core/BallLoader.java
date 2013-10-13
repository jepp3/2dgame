package com.jeppe.game.core;

import playn.core.AssetWatcher;
import playn.core.GroupLayer;
import playn.core.util.Callback;

public class BallLoader {
	public static void createWorld(final GroupLayer worldLayer,final Callback<BallWorld> callback) {
		
		final BallWorld ballworld = new BallWorld();
		
	}
	
	public static void loadWorld()
	{
		
		
		
		
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
