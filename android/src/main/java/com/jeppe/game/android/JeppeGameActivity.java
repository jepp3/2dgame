package com.jeppe.game.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.jeppe.game.core.JeppeGame;

public class JeppeGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new JeppeGame());
  }
}
