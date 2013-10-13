package com.jeppe.game.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.jeppe.game.core.JeppeGame;

public class JeppeGameJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new JeppeGame());
  }
}
