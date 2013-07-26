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

public class GameScreen implements Screen {
	
	Animal animal;
	TextureRegion bodyTexture, rArmTexture, rLegTexture, lArmTexture, lLegTexture;
	Sprite bodySprite, rArmSprite, rLegSprite, lArmSprite, lLegSprite;
	Array<Sprite> sprites;
	SpriteBatch batch;
	Breedable game;
	BitmapFont font, invFont;
	TextButton bNew, bQuit;
	TextureAtlas atlas;
	Stage stage;
	Skin skin;
	
	static Array<Animal> parents; //TODO Remove, debug tool
	
	public GameScreen(Breedable game){
		this.game = game;
		parents = new Array<Animal>();
	}
	
	public GameScreen(Breedable game, Animal mother, Animal child){
		this.game = game;
		parents.clear();
		parents.add(mother);
		parents.add(child);
	}
	
	public static void parentsTemp(){  //TODO Remove, only used for testing
		if(parents.size == 0){
			Animal a1 = new Animal(1, null);
			Animal a2 = new Animal(1, null);
			parents.add(a1);
			parents.add(a2);
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		batch.begin();
			stage.draw(); //The text button
		batch.end();
		
		batch.begin();
			font.draw(batch, "Father", (Gdx.graphics.getWidth()/2)-505, (Gdx.graphics.getHeight()/2)-250);
			font.draw(batch, "Mother", (Gdx.graphics.getWidth()/2)+250, (Gdx.graphics.getHeight()/2)-250);
		batch.end();
		
		batch.begin();
			for(Sprite sprite : sprites){
				sprite.draw(batch);
			}	
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
		
		bNew = new TextButton("New draw", style);
		bNew.setWidth(300);
		bNew.setHeight(50);
		bNew.setPosition(Gdx.graphics.getWidth()/2-(bNew.getWidth()/2)-205, (Gdx.graphics.getHeight()/2)-300);
		
		bQuit = new TextButton("Quit", style);
		bQuit.setWidth(300);
		bQuit.setHeight(50);
		bQuit.setPosition(Gdx.graphics.getWidth()/2-(bNew.getWidth()/2)+100, (Gdx.graphics.getHeight()/2)-300);
		
		stage.addActor(bNew);
		stage.addActor(bQuit);
		
		bNew.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	game.setScreen(new GameScreen(game, parents.get(1), animal)); //New roll, child becomes father
	        }
		});
		bQuit.addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	System.exit(0);
	        }
		});
	}

	@Override
	public void show() {
		AnimalHandler.setupAtlas();
		AnimalHandler.populateTier1();
		
		parentsTemp();
		
		sprites = new Array<Sprite>();
		animal = new Animal(2, parents);
		
		AnimalHandler.setTextures(animal, sprites);
		
		
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
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		font.dispose();
		invFont.dispose();
		stage.dispose();
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
