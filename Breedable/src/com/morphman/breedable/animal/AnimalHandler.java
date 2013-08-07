package com.morphman.breedable.animal;

import com.badlogic.gdx.utils.Array;
import com.morphman.breedable.Breedable;

public class AnimalHandler {
	private static final String LOG = Breedable.LOG + ".AnimalHandler";
	
	static Animal animal;
	Array<Trait> traits;
	
	/** Adds new animal with specific traits
	 * @param traits Array of the traits you wish to add, must have one for each body part */
	public static Animal addNewAnimal(Array<Trait> traits){
		animal = new Animal(0, null);
		animal.setTraits(traits);
		
		return animal;
	}
	
	/** Adds a new animal and calculates its generation number */
	public static Animal addAnimalWithParents(Array<Animal> parents){
		animal = new Animal(calcGeneration(parents), parents);
		
		return animal;
	}
	
	/** Generates a new generation number based on the highest previous generation
	 * @param parents Parents of current animal */
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
