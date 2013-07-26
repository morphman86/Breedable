package com.morphman.breedable.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.morphman.breedable.Breedable;

public class AnimalHandler{

	public static Trait tBody, tLArm, tRArm, tLLeg, tRLeg;
	public static Array<Trait> traits, tier1Body, tier1LArm, tier1RArm, tier1LLeg, tier1RLeg, tier2Body, tier2LArm, tier2RArm, tier2LLeg, tier2RLeg;
	public static Array<Animal> parents;
	public static Array<String> textureNames;
	public static TextureAtlas atlas;
	
	public static Array<Trait> setTraits(Animal animal, Array<Animal> parents) {
		
		traits = new Array<Trait>();
		
		if(parents != null){
			generateTraitsFromParents(parents);
		}else{
			tBody = tier1Body.random();
			
			tLArm = tier1LArm.random();
			
			tRArm = tier1RArm.random();
			
			tLLeg = tier1LLeg.random();
			
			tRLeg = tier1RLeg.random();
			
			traits.add(tBody);
			traits.add(tLArm);
			traits.add(tRArm);
			traits.add(tLLeg);
			traits.add(tRLeg);			
		}
		
		return traits;
	}

	public static void setupAtlas() {
		atlas = new TextureAtlas("data/textures.pack");
	}

	public static Array<Sprite> setTextures(Animal animal, Array<Sprite> sprites){
		TextureRegion bodyTexture, rArmTexture, lArmTexture, rLegTexture, lLegTexture;
		Sprite bodySprite, rArmSprite, lArmSprite, rLegSprite, lLegSprite;
		
		if(animal.getParents() != null){
			bodyTexture = animal.getParents().get(0).getTraitTexture(0);
			
			
			rArmTexture = animal.getParents().get(0).getTraitTexture(2);
			
			lArmTexture = animal.getParents().get(0).getTraitTexture(1);
			
			rLegTexture = animal.getParents().get(0).getTraitTexture(4);
			
			lLegTexture = animal.getParents().get(0).getTraitTexture(3);
			
			bodySprite = new Sprite(bodyTexture);
			bodySprite.setOrigin(bodySprite.getWidth()/2, bodySprite.getHeight()/2);
			bodySprite.setPosition((Gdx.graphics.getWidth()/3)+(bodySprite.getWidth()+50), (Gdx.graphics.getHeight()/4)-50);
			bodySprite.setScale(0.5f, 0.5f);
			
			rArmSprite = new Sprite(rArmTexture);
			rArmSprite.setOrigin(rArmSprite.getWidth()/2, rArmSprite.getHeight()/2);
			rArmSprite.setPosition(bodySprite.getX()+rArmSprite.getWidth()-210, bodySprite.getY()+(rArmSprite.getHeight()/4)-45);
			rArmSprite.setScale(0.5f, 0.5f);
			
			lArmSprite = new Sprite(lArmTexture);
			lArmSprite.setOrigin(lArmSprite.getWidth()/2, lArmSprite.getHeight()/2);
			lArmSprite.setPosition(bodySprite.getX()-lArmSprite.getWidth()+210, bodySprite.getY()+(lArmSprite.getHeight()/4)-45);
			lArmSprite.setRotation(180);
			lArmSprite.setScale(0.5f, 0.5f);
			
			rLegSprite = new Sprite(rLegTexture);
			rLegSprite.setOrigin(rLegSprite.getWidth()/2, rLegSprite.getHeight()/2);
			rLegSprite.setPosition(bodySprite.getX()+(rLegSprite.getWidth()/4)-40, bodySprite.getY()-(rLegSprite.getHeight()/4));
			rLegSprite.setScale(0.5f, 0.5f);
			
			lLegSprite = new Sprite(lLegTexture);
			lLegSprite.setOrigin(lLegSprite.getWidth()/2, lLegSprite.getHeight()/2);
			lLegSprite.setPosition(bodySprite.getX()-(lLegSprite.getWidth()/4)+40, bodySprite.getY()-(lLegSprite.getHeight()/4));
			lLegSprite.setScale(0.5f, 0.5f);
			
			sprites.add(lArmSprite);
			sprites.add(rArmSprite);
			sprites.add(lLegSprite);
			sprites.add(rLegSprite);
			sprites.add(bodySprite);
			
			
			bodyTexture = animal.getParents().get(1).getTraitTexture(0);
			
			
			rArmTexture = animal.getParents().get(1).getTraitTexture(2);
			
			lArmTexture = animal.getParents().get(1).getTraitTexture(1);
			
			rLegTexture = animal.getParents().get(1).getTraitTexture(4);
			
			lLegTexture = animal.getParents().get(1).getTraitTexture(3);
			
			bodySprite = new Sprite(bodyTexture);
			bodySprite.setOrigin(bodySprite.getWidth()/2, bodySprite.getHeight()/2);
			bodySprite.setPosition((Gdx.graphics.getWidth()/3)-(bodySprite.getWidth()+50), (Gdx.graphics.getHeight()/4)-50);
			bodySprite.setScale(0.5f, 0.5f);
			
			rArmSprite = new Sprite(rArmTexture);
			rArmSprite.setOrigin(rArmSprite.getWidth()/2, rArmSprite.getHeight()/2);
			rArmSprite.setPosition(bodySprite.getX()+rArmSprite.getWidth()-210, bodySprite.getY()+(rArmSprite.getHeight()/4)-45);
			rArmSprite.setScale(0.5f, 0.5f);
			
			lArmSprite = new Sprite(lArmTexture);
			lArmSprite.setOrigin(lArmSprite.getWidth()/2, lArmSprite.getHeight()/2);
			lArmSprite.setPosition(bodySprite.getX()-lArmSprite.getWidth()+210, bodySprite.getY()+(lArmSprite.getHeight()/4)-45);
			lArmSprite.setRotation(180);
			lArmSprite.setScale(0.5f, 0.5f);
			
			rLegSprite = new Sprite(rLegTexture);
			rLegSprite.setOrigin(rLegSprite.getWidth()/2, rLegSprite.getHeight()/2);
			rLegSprite.setPosition(bodySprite.getX()+(rLegSprite.getWidth()/4)-40, bodySprite.getY()-(rLegSprite.getHeight()/4));
			rLegSprite.setScale(0.5f, 0.5f);
			
			lLegSprite = new Sprite(lLegTexture);
			lLegSprite.setOrigin(lLegSprite.getWidth()/2, lLegSprite.getHeight()/2);
			lLegSprite.setPosition(bodySprite.getX()-(lLegSprite.getWidth()/4)+40, bodySprite.getY()-(lLegSprite.getHeight()/4));
			lLegSprite.setScale(0.5f, 0.5f);
			
			
			sprites.add(lArmSprite);
			sprites.add(rArmSprite);
			sprites.add(lLegSprite);
			sprites.add(rLegSprite);
			sprites.add(bodySprite);
		}
		
		bodyTexture = animal.getTraitTexture(0);
		
		
		rArmTexture = animal.getTraitTexture(2);
		
		lArmTexture = animal.getTraitTexture(1);
		
		rLegTexture = animal.getTraitTexture(4);
		
		lLegTexture = animal.getTraitTexture(3);
		
		bodySprite = new Sprite(bodyTexture);
		bodySprite.setOrigin(bodySprite.getWidth()/2, bodySprite.getHeight()/2);
		bodySprite.setPosition(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3);
		
		rArmSprite = new Sprite(rArmTexture);
		rArmSprite.setOrigin(rArmSprite.getWidth()/2, rArmSprite.getHeight()/2);
		rArmSprite.setPosition(bodySprite.getX()+rArmSprite.getWidth()-100, bodySprite.getY()+(rArmSprite.getHeight()/4)-10);

		lArmSprite = new Sprite(lArmTexture);
		lArmSprite.setOrigin(lArmSprite.getWidth()/2, lArmSprite.getHeight()/2);
		lArmSprite.setPosition(bodySprite.getX()-lArmSprite.getWidth()+100, bodySprite.getY()+(lArmSprite.getHeight()/4)-10);
		lArmSprite.setRotation(180);
		
		rLegSprite = new Sprite(rLegTexture);
		rLegSprite.setOrigin(rLegSprite.getWidth()/2, rLegSprite.getHeight()/2);
		rLegSprite.setPosition(bodySprite.getX()+(rLegSprite.getWidth()/4), bodySprite.getY()-(rLegSprite.getHeight()/2)+15);

		lLegSprite = new Sprite(lLegTexture);
		lLegSprite.setOrigin(lLegSprite.getWidth()/2, lLegSprite.getHeight()/2);
		lLegSprite.setPosition(bodySprite.getX()-(lLegSprite.getWidth()/4), bodySprite.getY()-(lLegSprite.getHeight()/2)+15);
		
		sprites.add(lArmSprite);
		sprites.add(rArmSprite);
		sprites.add(lLegSprite);
		sprites.add(rLegSprite);
		sprites.add(bodySprite);
		
		
		
		return sprites;
	}
	
	public static Array<Trait> generateTraitsFromParents(Array<Animal> parents){
	
		
		//Body
		double rand = Math.random()*100;
		if(rand<2){
			//Tier2 traits
			traits.add(tier2Body.random());
		}else if(rand<10){
			//random tier1 trait
			traits.add(tier1Body.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(0));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(0));
		}
		
		//LArm
		rand = Math.random()*100;
		if(rand<2){
			//Tier2 traits
			traits.add(tier2LArm.random());
		}else if(rand<10){
			//random tier1 trait
			traits.add(tier1LArm.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(1));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(1));
		}
		
		//RArm
		rand = Math.random()*100;
		if(rand<2){
			//Tier2 traits
			traits.add(tier2RArm.random());
		}else if(rand<10){
			//random tier1 trait
			traits.add(tier1RArm.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(2));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(2));
		}
		
		//LLeg
		rand = Math.random()*100;
		if(rand<2){
			//Tier2 traits
			traits.add(tier2LLeg.random());
		}else if(rand<10){
			//random tier1 trait
			traits.add(tier1LLeg.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(3));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(3));
		}
		
		//RLeg
		rand = Math.random()*100;
		if(rand<2){
			//Tier2 traits
			traits.add(tier2RLeg.random());
		}else if(rand<10){
			//random tier1 trait
			traits.add(tier1RLeg.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(4));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(4));
		}
		
		return traits;
	}

	public static void populateTier1(){
		tier1Body = new Array<Trait>();
		tier1LArm = new Array<Trait>();
		tier1RArm = new Array<Trait>();
		tier1LLeg = new Array<Trait>();
		tier1RLeg = new Array<Trait>();
		tier2Body = new Array<Trait>();
		tier2LArm = new Array<Trait>();
		tier2RArm = new Array<Trait>();
		tier2LLeg = new Array<Trait>();
		tier2RLeg = new Array<Trait>();
		
		
		int atlasSize = atlas.getRegions().size; 
		for(int i = 0; i<atlasSize; i++){
			String name = atlas.getRegions().get(i).name; 
			String traitName = name.substring(name.indexOf("-")+1);
			String prefix = "Tier1 ";
			if(name.contains("b-")){
				tBody = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 0, 1);
				tier1Body.add(tBody);
			}else if(name.contains("a-")){
				tLArm = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 1, 1);
				tier1LArm.add(tLArm);
				tRArm = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 2, 1);
				tier1RArm.add(tRArm);
			}else if(name.contains("l-")){
				tLLeg = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 3, 1);
				tier1LLeg.add(tLLeg);
				tRLeg = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 4, 1);
				tier1RLeg.add(tRLeg);
			}else if(name.contains("bs-")){
				prefix = "Tier2 ";
				tBody = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 0, 2);
				tier2Body.add(tBody);
			}else if(name.contains("as-")){
				prefix = "Tier2 ";
				tLArm = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 1, 2);
				tier2LArm.add(tLArm);
				tRArm = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 2, 2);
				tier2RArm.add(tRArm);
			}else if(name.contains("ls-")){
				prefix = "Tier2 ";
				tLLeg = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 3, 2);
				tier2LLeg.add(tLLeg);
				tRLeg = new Trait(prefix+traitName, new TextureRegion(atlas.getRegions().get(i)), 4, 2);
				tier2RLeg.add(tRLeg);
			}else{
				Gdx.app.log(Breedable.LOG, "Texture not loaded: " + name);
			}
		}
	}
	
}
