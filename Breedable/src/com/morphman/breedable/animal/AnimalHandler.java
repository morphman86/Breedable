package com.morphman.breedable.animal;

import com.badlogic.gdx.utils.Array;

public class AnimalHandler {
	static Animal animal;
	Array<Trait> traits;
	
	public static Animal addNewAnimal(Array<Trait> traits){
		animal = new Animal(0, null);
		animal.setTraits(traits);
		
		return animal;
	}
	
	public static Animal addAnimalWithParents(Array<Animal> parents){
		animal = new Animal(calcGeneration(parents), parents);
		
		return animal;
	}
	
	public static int calcGeneration(Array<Animal> parents){
		int generation = 0;
		if(parents.get(0).getGeneration() > parents.get(1).getGeneration()){ //Father oldest
			generation = parents.get(0).getGeneration()+1;
		}else if(parents.get(0).getGeneration() < parents.get(1).getGeneration()){ //Mother oldest
			generation = parents.get(1).getGeneration()+1;
		}else{	//Both same generation
			generation = parents.get(0).getGeneration()+1;
		}
		
		return generation;
	}
}
