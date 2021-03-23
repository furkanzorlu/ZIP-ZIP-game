package com.furkan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;



import javax.management.StringValueExp;
import javax.sound.sampled.AudioInputStream;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture hero;
	Texture canavar;
	Texture canavar1;
	Texture canavar2;
	Texture mermi;
	Texture coin;
	Texture coin1;
	Texture c;
	int mermihakkı=1000;//6 sn basılı tutma hakkı

	float hx,hy,hw,hh,canavarx,canavary,atesx,atesy;
	float gravity=0.1f;
	float v=0.0f;
	int state=0;
	int canavarsayısı=3;

	int mermisayısı=3;
	int coinsayısı=1;
	float coinlerx[]=new float[coinsayısı];
	float canavarlarx[]=new float[canavarsayısı];
	float mermilerx[]=new float[mermisayısı];

	float d;
	float coinlery[][]=new float[1][coinsayısı];
	float canavarlary[][]=new float[3][canavarsayısı];
	Circle cmermi;
	Circle chero;
	Circle ccoin1[]=new Circle[coinsayısı];
	Circle ccoin[]=new Circle[coinsayısı];
	Circle ccana[]=new Circle[canavarsayısı];
	Circle ccana1[]=new Circle[canavarsayısı];
	Circle ccana2[]=new Circle[canavarsayısı];
	ShapeRenderer sr;
	double puan;
	boolean flag=true;
	boolean flag1=true;
	BitmapFont font2;
	BitmapFont font;
	Sound sound;
	Sound sound1;
	Sound sound2;
	BitmapFont font1;
	BitmapFont font3;
	Sound sound3;
	//private ArrayList<Ates> atesler=new ArrayList<Ates>();







	@Override
	public void create () {

		batch = new SpriteBatch();

		img = new Texture("Full-background.png");
		hero=new Texture("JK_P_Gun__Run_000.png");
		canavar=new Texture("1.png");
		canavar1=new Texture("gif-preview.gif");
		canavar2=new Texture("q.gif");
		mermi=new Texture("spr_shield.png");
		coin=new Texture("Coin.png");
		coin1=new Texture("Coin.png");
		c=new Texture("Bullet.png");
		hx=Gdx.graphics.getWidth()/8;
		hy=Gdx.graphics.getHeight()/10;
		hw=Gdx.graphics.getWidth()/8;
		hh=Gdx.graphics.getHeight()/8;

		canavarx=200;
		canavary=0;
		ccoin=new Circle[coinsayısı];
		ccoin1=new Circle[coinsayısı];
		chero =new Circle();
		cmermi=new Circle();
		ccana=new Circle[canavarsayısı];
		ccana1=new Circle[canavarsayısı];
		ccana2=new Circle[canavarsayısı];
		sr=new ShapeRenderer();
		font=new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(2);

		font1=new BitmapFont();
		font1.setColor(Color.BLACK);
		font1.getData().setScale(2);
		font2=new BitmapFont();
		font2.setColor(Color.BLACK);
		font3=new BitmapFont();
		font3.setColor(Color.BLACK);
		font3.getData().setScale(2);

		sound=Gdx.audio.newSound(Gdx.files.internal("lose.ogg"));
		sound1=Gdx.audio.newSound(Gdx.files.internal("12.wav"));

		sound3=Gdx.audio.newSound(Gdx.files.internal("qw.mp3"));
		atesx=hy+100;
		atesy=hx-25;




		d=Gdx.graphics.getWidth()/2;
		for (int y=0;y<coinsayısı;y++){
			coinlerx[y]=450;
			//coinlerx[y]=Gdx.graphics.getWidth()+y*d;
			Random r4=new Random();

			coinlery[0][y] = r4.nextFloat() * Gdx.graphics.getHeight()-hh ;

			ccoin[y]=new Circle();

		}
		for (int i=0;i<canavarsayısı;i++){
			canavarlarx[i]=Gdx.graphics.getWidth()+i*d;
			Random r1=new Random();
			Random r2=new Random();
			Random r3=new Random();
			canavarlary[0][i]=r1.nextFloat()*Gdx.graphics.getHeight()-hh;
			canavarlary[1][i]=r2.nextFloat()*Gdx.graphics.getHeight()-hh;
			canavarlary[2][i]=r3.nextFloat()*Gdx.graphics.getHeight()-hh;
			ccana[i]=new Circle();
			ccana1[i]=new Circle();
			ccana2[i]=new Circle();
		}


	}


	@Override
	public void render () {

		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//batch.draw(mermi, atesx, atesy, hw / 5, hh / 5);
		/*if (state == 1) {
			if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				batch.draw(mermi, hx+100, hy, hw / 5, hh / 5);



			}
		}
		/*for (Ates ates:atesler){
			//batch.draw(mermi,30,30);
			batch.draw(mermi,30,30,hw/5,hh/5);
		}*/




		/*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			atesler.add(new Ates(120,120));
			batch.draw(mermi,atesx,atesy,hw/5,hh/5);





		}*/
		/*for (Ates ates :atesler){
			ates.setX(ates.getX()-1);

		}*/


		batch.draw(hero, hx, hy, hw, hh);
		batch.draw(c,100,200,200,200);
		if (state == 1) {
			flag1 = true;


			if (Gdx.input.justTouched()) {

				v = -5;


			}

			for (int i=0;i<coinsayısı;i++){
				if (coinlerx[i]<hx-300){
					coinlerx[i]=450;
					//coinlerx[i]+=coinsayısı *d;
					Random r4=new Random();

					coinlery[0][i] = r4.nextFloat() * Gdx.graphics.getHeight() - hh;

				}

				coinlerx[i]-=4;
				batch.draw(coin, coinlerx[i], coinlery[0][i], hw, hh);



			}
			for (int i = 0; i < canavarsayısı; i++) {
				if (canavarlarx[i] < hx - 300) {
					canavarlarx[i] += canavarsayısı * d;
					Random r1 = new Random();
					Random r2 = new Random();
					Random r3 = new Random();
					canavarlary[0][i] = r1.nextFloat() * Gdx.graphics.getHeight() - hh;
					canavarlary[1][i] = r2.nextFloat() * Gdx.graphics.getHeight() - hh;
					canavarlary[2][i] = r3.nextFloat() * Gdx.graphics.getHeight() - hh;
				}
				if (hx > canavarlarx[i] && flag) {
					puan += 00.1;

					flag = false;
				}
				if (canavarlarx[i] < hw + 120) {
					flag = true;
				}


				canavarlarx[i] -= 4;
				batch.draw(canavar1, canavarlarx[i] + 100, canavarlary[0][i], hw, hh);
				batch.draw(canavar, canavarlarx[i] + 200, canavarlary[1][i], hw, hh);
				batch.draw(canavar2, canavarlarx[i], canavarlary[2][i], hw, hh);
			}
			if (hy < 0) {

				state = 2;
				hy = Gdx.graphics.getWidth() / 3;
				v = 0;


			}
			else  {
				v = v + gravity;
				hy = hy - v;

			}
			if(hy>Gdx.graphics.getHeight()-hh+40){
				//v = v + gravity;
				hy=hy+v;




			}


			if (Gdx.input.justTouched()) {
				sound1.play();
			}

		}
		else if (state == 2) {
			font1.draw(batch, "Oyun bitti! Tekrar  Denemek  için Dokun!", 0, Gdx.graphics.getHeight() / 2);
			if (flag1) {
				sound.play();
				flag1 = false;

			}


			puan = 0;
			v = 0;
			mermihakkı=1000;


			if (Gdx.input.justTouched()) {
				state = 1;
				for (int i = 0; i < canavarsayısı; i++) {
					canavarlarx[i] = Gdx.graphics.getWidth() + i * d;
					Random r1 = new Random();
					Random r2 = new Random();
					Random r3 = new Random();
					canavarlary[0][i] = r1.nextFloat() * Gdx.graphics.getHeight()-hh;
					canavarlary[1][i] = r2.nextFloat() * Gdx.graphics.getHeight()-hh;
					canavarlary[2][i] = r3.nextFloat() * Gdx.graphics.getHeight()-hh;
					ccana[i] = new Circle();
					ccana1[i] = new Circle();
					ccana2[i] = new Circle();
					for (int y=0;y<coinsayısı;y++){

						coinlerx[y] = Gdx.graphics.getWidth() + y * d;
						Random r4=new Random();

						coinlery[0][y] = r4.nextFloat() * Gdx.graphics.getHeight() - hh;

						ccoin[y]=new Circle();

					}

				}
			}

		} else if (state == 0) {
			flag1 = true;
			font1.draw(batch, "Baslamak  için Dokun!\nKalkan kullanmak için space tusuna basılı tut", 00, Gdx.graphics.getHeight() / 2);


			puan = 0;
			v = 0;
			if (Gdx.input.justTouched()) {
				state = 1;
			}

		}
		font2.draw(batch,String.valueOf("Koruma Kalkanı Süresi:"+mermihakkı/166+"SN"),34,Gdx.graphics.getHeight()-hh+50);
		font.draw(batch, String.valueOf("Score:" + (int) puan), 480, Gdx.graphics.getHeight());


		cmermi.set(hx + hw / 2, hy + hh / 2,hw / 2);
		chero.set(hx + hw / 2, hy + hh / 2, hw / 3);
		//sr.begin(ShapeRenderer.ShapeType.Filled);
		//sr.setColor(Color.BLUE);
		//sr.circle(hx+hw/2,hy+hh/2,hw/2);
		/*for (int i =0; i<coinsayısı;i++){
			ccoin[i].set(coinlerx[i] + 135, coinlery[0][i] + hh / 2, hw / 2);
			 if (Intersector.overlaps(chero,ccoin[i])){
				state =2;

			}
		}*/
		for (int i = 0; i < coinsayısı; i++){
			ccoin[i].set(coinlerx[i],coinlery[0][i]+hh/2,hw/2);

			if (state == 1 ) {
				if (Intersector.overlaps(chero,ccoin[i])){


					mermihakkı +=12;
					font3.draw(batch, "1 snlik kalkan kazanıldı!", 200, Gdx.graphics.getHeight() / 2);
					sound3.play();


				}

			}
		}
		for (int i = 0; i < canavarsayısı; i++) {

			//sr.circle(canavarlarx[i]+135,canavarlary[0][i]+hh/2,hw/2);
			//sr.circle(canavarlarx[i]+235,canavarlary[1][i]+hh/2,hw/2);
			//sr.circle(canavarlarx[i]+35,canavarlary[2][i]+hh/2,hw/2);
			ccana[i].set(canavarlarx[i] + 135, canavarlary[0][i] + hh / 2, hw / 2);
			ccana1[i].set(canavarlarx[i] + 235, canavarlary[1][i] + hh / 2, hw / 2);
			ccana2[i].set(canavarlarx[i] + 35, canavarlary[2][i] + hh / 2, hw / 2);


			if (state == 1 ) {





				if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
					if (mermihakkı>0){
						mermihakkı--;
						System.out.println(mermihakkı);
						batch.draw(mermi, hx-20, hy, hw+20 , hh+20 );

						if (Intersector.overlaps(cmermi,ccana[i]) || Intersector.overlaps(cmermi, ccana1[i]) || Intersector.overlaps(cmermi, ccana2[i])){
							state=1;
						}

					}}


				else if (Intersector.overlaps(chero, ccana[i]) || Intersector.overlaps(chero, ccana1[i]) || Intersector.overlaps(chero, ccana2[i])) {
					state = 2;




				}

			}


		}


		batch.end();
		//sr.end();


	}



	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}


}
