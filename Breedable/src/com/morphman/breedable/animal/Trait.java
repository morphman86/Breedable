package com.morphman.breedable.animal;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Trait {
	
	private String name;
	private TextureRegion texture;
	private int type; //Type of body part, 0 = body, 1=L Arm, 2=R Arm, 3=L Leg, 4=R Leg
	private int tier;
	
	public Trait(String name, TextureRegion texture,int type, int tier) {
		super();
		this.name = name;
		this.texture = texture;
		this.type = type;
		this.tier = tier;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TextureRegion getTexture() {
		return texture;
	}
	public void setTexture(TextureRegion texture) {
		this.texture = texture;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	
}
