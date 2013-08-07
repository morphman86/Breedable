package com.morphman.breedable.animal;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.morphman.breedable.Breedable;

public class Animal {
	private static final String LOG = Breedable.LOG + ".Animal";
	
	private int generation;
	private Array<Animal> parents;
	private Array<Trait> traits;
	
	public Animal(int generation, Array<Animal> parents) {
		super();
		this.generation = generation;
		if(parents != null){
			this.parents = parents;
			this.traits = TraitHandler.setTraits(this, this.parents);
		}else{
			this.traits = TraitHandler.setTraits(this, null);
		}
	}
	
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public Array<Animal> getParents() {
		return parents;
	}
	public void setParents(Array<Animal> parents) {
		this.parents = parents;
	}
	public Array<Trait> getTraits() {
		return traits;
	}
	public void setTraits(Array<Trait> traits) {
		this.traits = traits;
	}
	
	public TextureRegion getTraitTexture(int index){
		return traits.get(index).getTexture();
	}

}
