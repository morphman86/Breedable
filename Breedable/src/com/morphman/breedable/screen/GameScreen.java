package com.morphman.breedable.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.morphman.breedable.animal.TraitHandler;

public class GameScreen implements Screen {
	private static final String LOG = Breedable.LOG + ".GameScreen";
	
	Animal animal;
	Array<Animal> animalHistory;
	TextureRegion bodyTexture, rArmTexture, rLegTexture, lArmTexture, lLegTexture;
	Sprite bodySprite, rArmSprite, rLegSprite, lArmSprite, lLegSprite;
	Array<Sprite> sprites;
	SpriteBatch batch;
	Breedable game;
	BitmapFont font, invFont;
	TextButton bReroll, bQuit, bNew, bEdit;
	TextureAtlas atlas;
	Stage stage;
	Skin skin;
	
	static Array<Animal> parents;
	
	public GameScreen(Breedable game){
		this.game = game;
		parents = new Array<Animal>();
		animalHistory = new Array<Animal>();
	}
	
	public GameScreen(Breedable game, Array<Animal> animalList, Boolean randomTraits){
		this.game = game;
		this.animalHistory = animalList;
		parents.clear();
		parents.add(animalList.get(animalList.size-2));
		parents.add(animalList.get(animalList.size-1));
		if(!randomTraits){
			this.animal = animalList.get(animalList.size-1);
		}
	}
	
	public void parentsTemp(){  //TODO Remove, only used for testing
		if(parents.size == 0){
			Animal a1 = new Animal(0, null);
			a1.setTraits(TraitHandler.generatePureTraits(0));
			Animal a2 = new Animal(0, null);
			a2.setTraits(TraitHandler.generatePureTraits(2));
			parents.add(a1); //Mother
			animalHistory.add(a1);
			parents.add(a2); //Father
			animalHistory.add(a2);
		}
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
			font.draw(batch, "Father", 110, 200);
			font.draw(batch, "Mother", 1030, 200);
			font.draw(batch, "Child", Gdx.graphics.getWidth()/2, 150);
			//Draw name of body parts on child
			font.draw(batch, animal.getTraits().get(0).getName(), 10, 700); //Head
			font.draw(batch, "Generation: " + animal.getGeneration(), 600, 700); //generation
			font.draw(batch, animal.getTraits().get(1).getName(), 10, 650); //Hair
			font.draw(batch, animal.getTraits().get(2).getName(), 600, 650); //Eyes
			font.draw(batch, animal.getTraits().get(3).getName(), 10, 600);  //Mouth
			font.draw(batch, animal.getTraits().get(4).getName(), 600, 600); //Nose
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
		
		bEdit = new TextButton("Edit Parents", style);
		bEdit.setWidth(216);
		bEdit.setHeight(50);
		bEdit.setOrigin(bEdit.getWidth()/2, bEdit.getHeight()/2);
		bEdit.setPosition(415, 22);
		
		bReroll = new TextButton("New draw", style);
		bReroll.setWidth(150);
		bReroll.setHeight(50);
		bReroll.setOrigin(bReroll.getWidth()/2, bReroll.getHeight()/2);
		bReroll.setPosition(448, 72);
		
		bNew = new TextButton("New game", style);
		bNew.setWidth(150);
		bNew.setHeight(50);
		bNew.setOrigin(bNew.getWidth()/2, bNew.getHeight()/2);
		bNew.setPosition(Gdx.graphics.getWidth()-bNew.getWidth(), Gdx.graphics.getHeight()-bNew.getHeight());
		
		bQuit = new TextButton("Quit", style);
		bQuit.setWidth(100);
		bQuit.setHeight(50);
		bQuit.setOrigin(bQuit.getWidth()/2, bQuit.getHeight()/2);
		bQuit.setPosition(Gdx.graphics.getWidth()-bQuit.getWidth(), Gdx.graphics.getHeight()-bQuit.getHeight()-bNew.getHeight());
				
		stage.addActor(bEdit);
		stage.addActor(bReroll);
		stage.addActor(bNew);
		stage.addActor(bQuit);
		
		bEdit.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	animalHistory.add(animal);
	        	game.setScreen(new EditTraitScreen(game, animalHistory)); //Edit the traits
	        }
		});
		
		bReroll.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	animalHistory.add(animal);
	        	game.setScreen(new GameScreen(game, animalHistory, true)); //New roll, child becomes father
	        }
		});
		
		bNew.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	game.setScreen(new GameScreen(game)); //New game
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
	}

	@Override
	public void show() {
		
		parentsTemp();
		
		sprites = new Array<Sprite>();
		animal = AnimalHandler.addAnimalWithParents(parents);
		
		TraitHandler.setTextures(animal, sprites, true);
		
		
		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		font = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		invFont = new BitmapFont(Gdx.files.internal("data/blackfont.fnt"), false);
				
		batch = new SpriteBatch();
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		font.dispose();
		invFont.dispose();
		stage.dispose();
		game.dispose();
	}

}
