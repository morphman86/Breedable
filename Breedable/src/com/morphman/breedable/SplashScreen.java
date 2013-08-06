package com.morphman.breedable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
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
import com.morphman.breedable.animal.TraitHandler;
import com.morphman.breedable.screen.GameScreen;

public class SplashScreen implements Screen {
	
	Array<Sprite> sprites;
	SpriteBatch batch;
	BitmapFont font, invFont;
	TextButton bNew, bQuit, bJigz;
	TextureAtlas atlas;
	Stage stage;
	Skin skin;
	Breedable game;
	Texture splash;
	Sprite splashSprite;

	public SplashScreen(Breedable game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);		
		
		batch.begin();
			batch.draw(splashSprite, delta, delta);
		batch.end();
		
		batch.begin();
			stage.draw(); //The text button
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
		
		bNew = new TextButton("Start game", style);
		bNew.setWidth(200);
		bNew.setHeight(50);
		bNew.setPosition(Gdx.graphics.getWidth()/2-(bNew.getWidth()/2)-205, (Gdx.graphics.getHeight()/2)-300);
		
		bJigz = new TextButton("Jigsaw", style);
		bJigz.setWidth(200);
		bJigz.setHeight(50);
		bJigz.setPosition(Gdx.graphics.getWidth()/2-(bJigz.getWidth()/2), (Gdx.graphics.getHeight()/2));
		
		bQuit = new TextButton("Quit", style);
		bQuit.setWidth(100);
		bQuit.setHeight(50);
		bQuit.setPosition(Gdx.graphics.getWidth()/2-(bNew.getWidth()/2)+100, (Gdx.graphics.getHeight()/2)-300);
		
		stage.addActor(bNew);
		stage.addActor(bQuit);
		stage.addActor(bJigz);
		
		bJigz.addListener(new InputListener(){
			
			

			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	game.setScreen(new JigsawScreen(game)); 
	        }
		});
		
		bNew.addListener(new InputListener(){
			
			

			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
	        }
			
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	game.setScreen(new GameScreen(game)); 
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
		TraitHandler.setupAtlas();
		TraitHandler.populateTier1();
		
		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		font = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		invFont = new BitmapFont(Gdx.files.internal("data/blackfont.fnt"), false);
				
		batch = new SpriteBatch();
		
		splash = new Texture("data/splash.png");
		splashSprite = new Sprite(splash);

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
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		font.dispose();
		invFont.dispose();
		stage.dispose();
		splash.dispose();

	}

}
