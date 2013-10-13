package com.jeppe.game.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;

import playn.core.GroupLayer;
import static playn.core.PlayN.graphics;


public class BallWorld implements ContactListener {

	 public GroupLayer dynamicLayer;
	 public GroupLayer staticLayerBack;
	 public GroupLayer staticLayerFront;
	 
	 private static int width = 24;
	 private static int height = 18;
	 
	 protected World world;
	 
	 private List<Entity> entities = new ArrayList<Entity>();
	 	 
	 private HashMap<Body, PhysicsEntity> bodyEntityLUT = new HashMap<Body, PhysicsEntity>();
	 
	 private Stack<Contact> contacts = new Stack<Contact>();
 
	 public BallWorld(GroupLayer scaledLayer)
	 {
		 
		 // create the layers that we will be using
		 staticLayerBack = graphics().createGroupLayer();
		 dynamicLayer = graphics().createGroupLayer();
		 staticLayerFront = graphics().createGroupLayer();
		 
		 // add the layer to a scaled layer. this will make it posible to scale the application
		 scaledLayer.add(staticLayerBack);
		 scaledLayer.add(dynamicLayer);
		 scaledLayer.add(staticLayerFront);
		 
		 
		 
		 // create the physics world
		 Vec2 gravity 	= new Vec2(0.0f, 0.f);
		 world 			= new World(gravity);
		 world.setWarmStarting(true);
		 world.setAutoClearForces(true);
		 world.setContactListener(this);
		 
		  
		 Body ground 	= world.createBody(new BodyDef());
		 Body wallLeft 	= world.createBody(new BodyDef());
		 Body wallRight = world.createBody(new BodyDef());
		 
		 EdgeShape groundShape = new EdgeShape();
		 EdgeShape wallLeftShape  = new  EdgeShape();
		 EdgeShape wallRightShape = new EdgeShape();
		 
		 // create ground
		 groundShape.set(new Vec2(0,this.height), new Vec2(this.width,this.height));
		 ground.createFixture(groundShape,0f);
		 
		// create left wall
		 
		 wallLeftShape.set(new Vec2(0, 0), new Vec2(0, height));
		 wallLeft.createFixture(wallLeftShape, 0.0f);

		 // create right wall
		
		 wallRightShape.set(new Vec2(width, 0), new Vec2(width, height));
		 wallRight.createFixture(wallRightShape, 0.0f);
	 }

	  public void update(float delta) {
		  for(Entity entity:this.entities)
		  {
			  entity.update(delta);
		  }
		//the step delta is fixed so box2d isn't affected by framerate
		world.step(0.033f, 10, 10);
		processContacts();
	  }
  
	  private void processContacts() {
		  while (contacts.isEmpty() == false) 
		  {
			  Contact contact = contacts.pop();

		        // handle collision
			  PhysicsEntity entityA = bodyEntityLUT.get(contact.m_fixtureA.m_body);
			  PhysicsEntity entityB = bodyEntityLUT.get(contact.m_fixtureB.m_body);

			  if (entityA != null && entityB != null)
			  {
				  if (entityA instanceof PhysicsEntity.HasContactListener)
				  {
					  ((PhysicsEntity.HasContactListener) entityA).contact(entityB);
		          }
		          if (entityB instanceof PhysicsEntity.HasContactListener)
		          {
		        	  ((PhysicsEntity.HasContactListener) entityB).contact(entityA);
		          }
		      }
		  }
	  }

	  public void paint(float delta) {
		  for (Entity e : entities) {
		      e.paint(delta);
		    }
	  }
	  public void add(Entity entity)
	  {
		    entities.add(entity);
		    if (entity instanceof PhysicsEntity) {
		      PhysicsEntity physicsEntity = (PhysicsEntity) entity;
		      bodyEntityLUT.put(physicsEntity.getBody(), physicsEntity);
		    }
	  }

	  @Override
	  public void beginContact(Contact contact) {
		  contacts.add(contact);
	  }

	  @Override
	  public void endContact(Contact contact) {

	  }
	  @Override
	  public void preSolve(Contact contact, Manifold oldManifold) {
		  // TODO Auto-generated method stub
	  }

	  @Override
	  public void postSolve(Contact contact, ContactImpulse impulse) {
		  // TODO Auto-generated method stub
	  }
	 
	 
	 
}
