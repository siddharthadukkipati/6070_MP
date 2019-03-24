package com.example.eventpolling;

import android.widget.Toast;

public class Count {
    private int pubgcount = 0;
    private int fifacount = 0;
    private int minicount = 0;
    private int csgocount = 0;
    private int rollscount = 0;
    private int desertscount = 0;
    private int burgercount = 0;
    private int pizzacount = 0;
    private int dancecount = 0;
    private int songcount = 0;
    private int comedycount = 0;
    private int djcount = 0;

    public Count() {
//        Toast.makeText(Count.this,getPubgcount()+" "+getBurgercount()+" "+getComedycount(),Toast.LENGTH_SHORT).show();
    }

    public Count(int pubgcount, int fifacount, int minicount, int csgocount, int rollscount, int desertscount, int burgercount, int pizzacount, int dancecount, int songcount, int comedycount, int djcount) {

        this.pubgcount = pubgcount;
        this.fifacount = fifacount;
        this.minicount = minicount;
        this.csgocount = csgocount;
        this.rollscount = rollscount;
        this.desertscount = desertscount;
        this.burgercount = burgercount;
        this.pizzacount = pizzacount;
        this.dancecount = dancecount;
        this.songcount = songcount;
        this.comedycount = comedycount;
        this.djcount = djcount;
    }

    public int getPubgcount() {
        return this.pubgcount;
    }

    public void setPubgcount(int t) {

        this.pubgcount += t;
    }

    public int getFifacount() {
        return this.fifacount;
    }

    public void setFifacount(int t) {
        this.fifacount += t;
    }

    public int getMinicount() {
        return this.minicount;
    }

    public void setMinicount(int t) {
        this.minicount += t;
    }

    public int getCsgocount() {
        return this.csgocount;
    }

    public void setCsgocount(int t) {
        this.csgocount += t;
    }

    public int getRollscount() {
        return this.rollscount;
    }

    public void setRollscount(int t) {
        this.rollscount += t;
    }

    public int getDesertscount() {
        return desertscount;
    }

    public void setDesertscount(int t) {
        this.desertscount += t;
    }

    public int getBurgercount() {
        return this.burgercount;
    }

    public void setBurgercount(int t) {
        this.burgercount += t;
    }

    public int getPizzacount() {
        return this.pizzacount;
    }

    public void setPizzacount(int t) {
        this.pizzacount += t;
    }

    public int getDancecount() {
        return this.dancecount;
    }

    public void setDancecount(int t) {
        this.dancecount += t;
    }

    public int getSongcount() {
        return this.songcount;
    }

    public void setSongcount(int t) {
        this.songcount += t;
    }

    public int getComedycount() {
        return this.comedycount;
    }

    public void setComedycount(int t) {
        this.comedycount += t;
    }

    public int getDjcount() {
        return this.djcount;
    }

    public void setDjcount(int t) {
        this.djcount += t;
    }
}