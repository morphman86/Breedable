package com.morphman.breedable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class JigsawScreen implements Screen {

	private Breedable game;
	private Stage stage;
	private Skin skin;
	private BitmapFont invFont;
	private TextButton bQuit;
	private TextureAtlas atlas;
	private BitmapFont font;
	private SpriteBatch batch;

	public JigsawScreen(Breedable game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
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
		
		bQuit = new TextButton("Quit", style);
		bQuit.setWidth(200);
		bQuit.setHeight(50);
		bQuit.setPosition(Gdx.graphics.getWidth()/2-(bQuit.getWidth()/2)-205, (Gdx.graphics.getHeight()/2)-300);
		
		stage.addActor(bQuit);
		
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
		game.dispose();
		stage.dispose();
		skin.dispose();
		invFont.dispose();
		atlas.dispose();
		font.dispose();

	}

}
