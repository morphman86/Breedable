package com.morphman.breedable.jigsaw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class JigsawHandler {
	static Texture image;
	static Array<TextureRegion> pieces;
	static float pieceHeight, pieceWidth;
	static Array<Sprite> sprites;
	
	public static void createPieces(Texture image){
		TextureRegion[] regions = new TextureRegion[25];
		pieceHeight = image.getHeight()/5;
		pieceWidth = image.getWidth()/5;
		
		for(int i=0; i<5 ; i++){
			regions[i] = new TextureRegion(image, 0, 0, pieceHeight, pieceWidth+pieceWidth*i);
		}
		for(int i=0; i<5 ; i++){
			regions[i] = new TextureRegion(image, 0, 0, pieceHeight*2, pieceWidth+pieceWidth*i);
		}
		for(int i=0; i<5 ; i++){
			regions[i] = new TextureRegion(image, 0, 0, pieceHeight*3, pieceWidth+pieceWidth*i);
		}
		for(int i=0; i<5 ; i++){
			regions[i] = new TextureRegion(image, 0, 0, pieceHeight*4, pieceWidth+pieceWidth*i);
		}
		for(int i=0; i<5 ; i++){
			regions[i] = new TextureRegion(image, 0, 0, pieceHeight*5, pieceWidth+pieceWidth*i);
		}
		
		for(TextureRegion region : regions){
			pieces.add(region);
		}
		
		sprites = new Array<Sprite>();
		sprites.addAll(pieces);
	}
	
	public static boolean comparePieceLocation(int currentPiece){
		if(sprites.get(currentPiece).getX() >= sprites.get(currentPiece-1).getX()+5 && 
				sprites.get(currentPiece).getX() <= sprites.get(currentPiece-1).getX()-5 &&
				sprites.get(currentPiece).getY() <= sprites.get(currentPiece-1).getY()-5 &&
				sprites.get(currentPiece).getY() <= sprites.get(currentPiece-1).getY()-5){
			return true;
		}else if(sprites.get(currentPiece).getX() >= sprites.get(currentPiece+1).getX()+5 && 
				sprites.get(currentPiece).getX() <= sprites.get(currentPiece+1).getX()-5 &&
				sprites.get(currentPiece).getY() <= sprites.get(currentPiece+1).getY()-5 &&
				sprites.get(currentPiece).getY() <= sprites.get(currentPiece+1).getY()-5){
			return true;
		}else{
			return false;
		}
	}
}
