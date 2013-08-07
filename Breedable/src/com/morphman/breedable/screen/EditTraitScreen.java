package com.morphman.breedable.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.morphman.breedable.Breedable;
import com.morphman.breedable.animal.Animal;
import com.morphman.breedable.animal.AnimalHandler;
import com.morphman.breedable.animal.Trait;
import com.morphman.breedable.animal.TraitHandler;

public class EditTraitScreen implements Screen {
	private static final String LOG = Breedable.LOG + ".EditTraitScreen";

	Array<Animal> animalHistory;
	Array<Animal> animalTemp;
	Animal animal;
	Array<Trait> traits;
	Array<Trait> newTraits;
	Array<Sprite> sprites;
	TextureAtlas atlas;
	Skin skin;
	BitmapFont font, invFont;
	SpriteBatch batch;
	Stage stage;
	TextButton bQuit, bSave;
	Breedable game;

	
	public EditTraitScreen(Breedable game, Array<Animal> animalHistory) {
		this.game = game;
		this.animalHistory = animalHistory;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		//Buttons
		batch.begin();
			stage.draw(); //The text button
		batch.end();
		
		//The characters/animals
		batch.begin();
			for(Sprite sprite : sprites){
				sprite.draw(batch);
			}	
		batch.end();
		
		//Texts
		batch.begin();
		
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		if(stage == null){
			stage = new Stage(width, height, true);
		}
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("buttonnormal");
		style.down = skin.getDrawable("buttonpressed");
		style.font = invFont;
		
		bSave = new TextButton("Save", style);
		bSave.setWidth(100);
		bSave.setHeight(50);
		bSave.setOrigin(bSave.getWidth()/2, bSave.getHeight()/2);
		bSave.setPosition(Gdx.graphics.getWidth()-bSave.getWidth(), Gdx.graphics.getHeight()-bSave.getHeight());
		
		bQuit = new TextButton("Quit", style);
		bQuit.setWidth(100);
		bQuit.setHeight(50);
		bQuit.setOrigin(bQuit.getWidth()/2, bQuit.getHeight()/2);
		bQuit.setPosition(Gdx.graphics.getWidth()-bQuit.getWidth(), Gdx.graphics.getHeight()-bQuit.getHeight()-bSave.getHeight());
		
		bSave.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	animalHistory.add(animal);
	        	game.setScreen(new GameScreen(game, animalHistory, false)); //Save and return to game
	        }
		});
		
		bQuit.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	Gdx.app.exit();
	        }
		});
		
		stage.addActor(bSave);
		stage.addActor(bQuit);
		
		addButtons(style);

	}
	
	/** Adds one button for each trait */
	private void addButtons(TextButtonStyle style) {
		newTraits = animal.getTraits();
		float posX = 10;
		float posY = 600;
		for(final Trait trait : traits){
			String category = "";
			if(trait.getType() == 0){
				category = "Head";
			}else if(trait.getType() == 1){
				category = "Hair";
			}else if(trait.getType() == 2){
				category = "Eyes";
			}else if(trait.getType() == 3){
				category = "Mouth";
			}else if(trait.getType() == 4){
				category = "Nose";
			}
			TextButton button = new TextButton(category + " " + trait.getName(), style);
			button.setWidth(button.getLabel().getWidth()+60);
			button.setHeight(25);
			button.setOrigin(button.getWidth()/2, button.getHeight()/2);
			button.setPosition(posX, posY);
			if(posY > 20){
				posY -= button.getHeight();
			}else{
				posY = 700;
				posX += button.getWidth();
			}
			
			button.addListener(new InputListener(){

				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	                return true;
		        }
				
		        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		        	animalTemp = animalHistory;
		        	for(Trait trait2 : newTraits){
		        		if(trait.getType() == trait2.getType()){
		        			newTraits.set(newTraits.indexOf(trait2, false), trait);
		        		}
		        	}
		        	animal = AnimalHandler.addNewAnimal(newTraits);
		        	animal.setGeneration(animalHistory.get(animalHistory.size-2).getGeneration()+1);
		        	animalTemp.removeIndex(animalTemp.size-1);
		        	animalTemp.add(animal);
		        	game.setScreen(new EditTraitScreen(game, animalTemp)); //Edit the traits
		        }
			});
			
			stage.addActor(button);
		}
		
	}

	/** Fetches the traits from previously discovered traits and adds to traits array */
	public void fetchTraits(){
		for(int i = 0; i<animalHistory.size; i++){
			for(Trait trait : animalHistory.get(i).getTraits()){
				Gdx.app.log(LOG, "Found trait: " + trait.getName());
				if(!traits.contains(trait, false)){
					traits.add(trait);
					Gdx.app.log(LOG, "Trait added");
				}
			}
		}
		Gdx.app.log(LOG, "Traits loaded: " + traits.size);
	}

	@Override
	public void show() {
		traits = new Array<Trait>();
		fetchTraits();
		sprites = new Array<Sprite>();
		
		animal = animalHistory.get(animalHistory.size-1);
		
		TraitHandler.setTextures(animal, sprites, false);
		
		
		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		font = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		invFont = new BitmapFont(Gdx.files.internal("data/blackfont.fnt"), false);
				
		batch = new SpriteBatch();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		atlas.dispose();
		skin.dispose();
		font.dispose();
		invFont.dispose();
		batch.dispose();
		stage.dispose();
		game.dispose();
	}

}
