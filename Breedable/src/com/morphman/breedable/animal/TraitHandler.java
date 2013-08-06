package com.morphman.breedable.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.morphman.breedable.Breedable;

public class TraitHandler{

	public static Trait tHead, tHair, tEyes, tMouth, tNose;
	public static Array<Trait> traits, tier1Head, tier1Hair, tier1Eyes, tier1Mouth, tier1Nose;
	public static Array<Animal> parents;
	public static Array<String> textureNames;
	public static TextureAtlas atlas;
	
	public static Array<Trait> setTraits(Animal animal, Array<Animal> parents) {
		
		traits = new Array<Trait>();
		
		if(parents != null){
			generateTraitsFromParents(parents);
		}else{
			tHead = tier1Head.random();
			
			tHair = tier1Hair.random();
			
			tEyes = tier1Eyes.random();
			
			tMouth = tier1Mouth.random();
			
			tNose = tier1Nose.random();
			
			traits.add(tHead);
			traits.add(tHair);
			traits.add(tEyes);
			traits.add(tMouth);
			traits.add(tNose);			
		}
		
		return traits;
	}

	public static void setupAtlas() {
		atlas = new TextureAtlas("data/textures.pack");
	}

	public static Array<Sprite> setTextures(Animal animal, Array<Sprite> sprites){
		TextureRegion headTexture, eyesTexture, hairTexture, noseTexture, mouthTexture;
		Sprite headSprite, eyesSprite, hairSprite, noseSprite, mouthSprite;
		
		if(animal.getParents() != null){
			
			headTexture = animal.getParents().get(0).getTraitTexture(0);
			
			eyesTexture = animal.getParents().get(0).getTraitTexture(2);
			
			hairTexture = animal.getParents().get(0).getTraitTexture(1);
			
			noseTexture = animal.getParents().get(0).getTraitTexture(4);
			
			mouthTexture = animal.getParents().get(0).getTraitTexture(3);
			
			headSprite = new Sprite(headTexture);
			eyesSprite = new Sprite(eyesTexture);
			hairSprite = new Sprite(hairTexture);
			noseSprite = new Sprite(noseTexture);
			mouthSprite = new Sprite(mouthTexture);
			
			//Head
			headSprite.setOrigin(headSprite.getWidth()/2, headSprite.getHeight()/2);
			headSprite.setPosition((Gdx.graphics.getWidth()/4)+(headSprite.getWidth()), (Gdx.graphics.getHeight()/4)-50);
			headSprite.setScale(0.5f, 0.5f);
			
			//Eyes
			eyesSprite.setOrigin(eyesSprite.getWidth()/2, eyesSprite.getHeight()/2);
			eyesSprite.setPosition(headSprite.getX(), headSprite.getY());
			eyesSprite.setScale(0.5f, 0.5f);
			
			//Hair
			hairSprite.setOrigin(hairSprite.getWidth()/2, hairSprite.getHeight()/2);
			hairSprite.setPosition(headSprite.getX(), headSprite.getY());
			hairSprite.setScale(0.5f, 0.5f);
			
			//Nose
			noseSprite.setOrigin(noseSprite.getWidth()/2, noseSprite.getHeight()/2);
			noseSprite.setPosition(headSprite.getX(), headSprite.getY());
			noseSprite.setScale(0.5f, 0.5f);
			
			//Mouth
			mouthSprite.setOrigin(mouthSprite.getWidth()/2, mouthSprite.getHeight()/2);
			mouthSprite.setPosition(headSprite.getX(), headSprite.getY());
			mouthSprite.setScale(0.5f, 0.5f);
			
			
			sprites.add(hairSprite);
			sprites.add(headSprite);
			sprites.add(eyesSprite);
			sprites.add(mouthSprite);
			sprites.add(noseSprite);
			
			
			headTexture = animal.getParents().get(1).getTraitTexture(0);
			
			eyesTexture = animal.getParents().get(1).getTraitTexture(2);
			
			hairTexture = animal.getParents().get(1).getTraitTexture(1);
			
			noseTexture = animal.getParents().get(1).getTraitTexture(4);
			
			mouthTexture = animal.getParents().get(1).getTraitTexture(3);
			
			headSprite = new Sprite(headTexture);
			eyesSprite = new Sprite(eyesTexture);
			hairSprite = new Sprite(hairTexture);
			noseSprite = new Sprite(noseTexture);
			mouthSprite = new Sprite(mouthTexture);
			
			//Head
			headSprite.setOrigin(headSprite.getWidth()/2, headSprite.getHeight()/2);
			headSprite.setPosition((Gdx.graphics.getWidth()/3)-(headSprite.getWidth()), (Gdx.graphics.getHeight()/4)-50);
			headSprite.setScale(0.5f, 0.5f);
			
			//Eyes
			eyesSprite.setOrigin(eyesSprite.getWidth()/2, eyesSprite.getHeight()/2);
			eyesSprite.setPosition(headSprite.getX(), headSprite.getY());
			eyesSprite.setScale(0.5f, 0.5f);
			
			//Hair
			hairSprite.setOrigin(hairSprite.getWidth()/2, hairSprite.getHeight()/2);
			hairSprite.setPosition(headSprite.getX(), headSprite.getY());
			hairSprite.setScale(0.5f, 0.5f);
			
			//Nose
			noseSprite.setOrigin(noseSprite.getWidth()/2, noseSprite.getHeight()/2);
			noseSprite.setPosition(headSprite.getX(), headSprite.getY());
			noseSprite.setScale(0.5f, 0.5f);
			
			//Mouth
			mouthSprite.setOrigin(mouthSprite.getWidth()/2, mouthSprite.getHeight()/2);
			mouthSprite.setPosition(headSprite.getX(), headSprite.getY());
			mouthSprite.setScale(0.5f, 0.5f);
			
			
			sprites.add(hairSprite);
			sprites.add(headSprite);
			sprites.add(eyesSprite);
			sprites.add(mouthSprite);
			sprites.add(noseSprite);
		}
		
		headTexture = animal.getTraitTexture(0);
		
		eyesTexture = animal.getTraitTexture(2);
		
		hairTexture = animal.getTraitTexture(1);
		
		noseTexture = animal.getTraitTexture(4);
		
		mouthTexture = animal.getTraitTexture(3);
		
		headSprite = new Sprite(headTexture);
		eyesSprite = new Sprite(eyesTexture);
		hairSprite = new Sprite(hairTexture);
		noseSprite = new Sprite(noseTexture);
		mouthSprite = new Sprite(mouthTexture);
		
		//Head
		headSprite.setOrigin(headSprite.getWidth()/2, headSprite.getHeight()/2);
		headSprite.setPosition(Gdx.graphics.getWidth()/3.5f, Gdx.graphics.getHeight()/4);
		
		//Eyes
		eyesSprite.setOrigin(eyesSprite.getWidth()/2, eyesSprite.getHeight()/2);
		eyesSprite.setPosition(headSprite.getX(), headSprite.getY());

		//Hair
		hairSprite.setOrigin(hairSprite.getWidth()/2, hairSprite.getHeight()/2);
		hairSprite.setPosition(headSprite.getX(), headSprite.getY());
		
		//Nose
		noseSprite.setOrigin(noseSprite.getWidth()/2, noseSprite.getHeight()/2);
		noseSprite.setPosition(headSprite.getX(), headSprite.getY());

		//Mouth
		mouthSprite.setOrigin(mouthSprite.getWidth()/2, mouthSprite.getHeight()/2);
		mouthSprite.setPosition(headSprite.getX(), headSprite.getY());
		

		sprites.add(hairSprite);
		sprites.add(headSprite);
		sprites.add(eyesSprite);
		sprites.add(mouthSprite);
		sprites.add(noseSprite);
		
		
		
		
		return sprites;
	}
	
	public static Array<Trait> generateTraitsFromParents(Array<Animal> parents){
	
		
		//Head
		double rand = Math.random()*100;
		if(rand<10){
			//random tier1 trait
			traits.add(tier1Head.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(0));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(0));
		}
		
		//Hair
		rand = Math.random()*100;
		if(rand<10){
			//random tier1 trait
			traits.add(tier1Hair.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(1));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(1));
		}
		
		//Eyes
		rand = Math.random()*100;
		if(rand<10){
			//random tier1 trait
			traits.add(tier1Eyes.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(2));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(2));
		}
		
		//Mouth
		rand = Math.random()*100;
		if(rand<10){
			//random tier1 trait
			traits.add(tier1Mouth.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(3));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(3));
		}
		
		//Nose
		rand = Math.random()*100;
		if(rand<10){
			//random tier1 trait
			traits.add(tier1Nose.random());
		}else if(rand<50){
			//Fathers trait
			traits.add(parents.get(0).getTraits().get(4));
		}else{
			//Mothers trait
			traits.add(parents.get(1).getTraits().get(4));
		}
		
		return traits;
	}
	
public static Array<Trait> generatePureTraits(int index){ //ToDo: Add index depending on what traits you want
		Array<Trait> pureTraits = new Array<Trait>();
		
		pureTraits.add(tier1Head.get(index));
		pureTraits.add(tier1Hair.get(index));
		pureTraits.add(tier1Eyes.get(index));
		pureTraits.add(tier1Mouth.get(index));
		pureTraits.add(tier1Nose.get(index));
		
		return pureTraits;
	}

	public static void populateTier1(){
		tier1Head = new Array<Trait>();
		tier1Hair = new Array<Trait>();
		tier1Eyes = new Array<Trait>();
		tier1Mouth = new Array<Trait>();
		tier1Nose = new Array<Trait>();
		
		
		
		int atlasSize = atlas.getRegions().size;
		Gdx.app.log(Breedable.LOG, "Initializing traits: " + atlasSize); //Log the init of textures and how many are loaded
		for(int i = 0; i<atlasSize; i++){
			String name = atlas.getRegions().get(i).name; 
			String traitName = name.substring(name.indexOf("-")+1);
			String prefix = "Tier1 ";
			String partName = "";
			if(name.contains("T1-")){
				if(name.contains("Head-")){
					partName = " Head";
					tHead = new Trait(prefix+traitName+partName, new TextureRegion(atlas.getRegions().get(i)), 0, 1);
					tier1Head.add(tHead);
				}else if(name.contains("Hair-")){
					partName = " Hair";
					tHair = new Trait(prefix+traitName+partName, new TextureRegion(atlas.getRegions().get(i)), 1, 1);
					tier1Hair.add(tHair);
				}else if(name.contains("Eyes-")){
					tEyes = new Trait(prefix+traitName+partName, new TextureRegion(atlas.getRegions().get(i)), 2, 1);
					tier1Eyes.add(tEyes);
				}else if(name.contains("Mouth-")){
					partName = " Mouth";
					tMouth = new Trait(prefix+traitName+partName, new TextureRegion(atlas.getRegions().get(i)), 3, 1);
					tier1Mouth.add(tMouth);
				}else if(name.contains("Nose-")){
					tNose = new Trait(prefix+traitName+partName, new TextureRegion(atlas.getRegions().get(i)), 4, 1);
					tier1Nose.add(tNose);
				}else{
					Gdx.app.log(Breedable.LOG, "Texture not loaded: " + name);
				}
			}
		}
	}
	
}
