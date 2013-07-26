package com.morphman.breedable.client;

import com.morphman.breedable.Breedable;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(900, 500);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new Breedable();
	}
}