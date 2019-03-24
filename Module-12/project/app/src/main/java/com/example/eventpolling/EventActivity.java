package com.example.eventpolling;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class EventActivity extends AppCompatActivity {
    private Button button;
    public CheckBox pubg;
    public CheckBox fifa;
    public CheckBox mini;
    public CheckBox csgo;
    public CheckBox rolls;
    public CheckBox deserts;
    public CheckBox burger;
    public CheckBox pizza;
    public CheckBox dance;
    public CheckBox song;
    public CheckBox comedy;
    public CheckBox dj;
    Count obj = new Count();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        pubg = (CheckBox) findViewById(R.id.checkBox1);
        fifa = (CheckBox) findViewById(R.id.checkBox2);
        mini = (CheckBox) findViewById(R.id.checkBox3);
        csgo = (CheckBox) findViewById(R.id.checkBox4);
        rolls = (CheckBox) findViewById(R.id.checkBox21);
        deserts = (CheckBox) findViewById(R.id.checkBox22);
        burger = (CheckBox) findViewById(R.id.checkBox23);
        pizza = (CheckBox) findViewById(R.id.checkBox24);
        dance = (CheckBox) findViewById(R.id.checkBox31);
        song = (CheckBox) findViewById(R.id.checkBox32);
        comedy = (CheckBox) findViewById(R.id.checkBox33);
        dj = (CheckBox) findViewById(R.id.checkBox34);
        button = (Button) findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count();
            }
        }) ;
    }
    public void selectGames(View v) {

        switch (v.getId()) {
            case R.id.checkBox1:
                if (pubg.isChecked()) {
                    fifa.setEnabled(false);
                    mini.setEnabled(false);
                    csgo.setEnabled(false);
//                    i = obj.getPubgcount() + 1;
                    obj.setPubgcount(1);
                } else {
                    mini.setEnabled(true);
                    fifa.setEnabled(true);
                    csgo.setEnabled(true);
                }
                break;

            case R.id.checkBox2:
                if (fifa.isChecked()) {
                    pubg.setEnabled(false);
                    mini.setEnabled(false);
                    csgo.setEnabled(false);
//                    j = obj.getFifacount() + 1;
                    obj.setFifacount(1);
                } else {
                    pubg.setEnabled(true);
                    mini.setEnabled(true);
                    csgo.setEnabled(true);
                }
                break;

            case R.id.checkBox3:
                if (mini.isChecked()) {
                    fifa.setEnabled(false);
                    pubg.setEnabled(false);
                    csgo.setEnabled(false);
//                    final int k = obj.getMinicount() + 1;
                    obj.setMinicount(1);
                } else {
                    pubg.setEnabled(true);
                    fifa.setEnabled(true);
                    csgo.setEnabled(true);
                }
                break;

            case R.id.checkBox4:
                if (csgo.isChecked()) {
                    fifa.setEnabled(false);
                    pubg.setEnabled(false);
                    mini.setEnabled(false);
//                    final int l = obj.getCsgocount()+ 1;
                    obj.setCsgocount(1);
                } else {
                    pubg.setEnabled(true);
                    fifa.setEnabled(true);
                    mini.setEnabled(true);
                }
                break;
            case R.id.checkBox21:
                if (rolls.isChecked()) {
                    deserts.setEnabled(false);
                    burger.setEnabled(false);
                    pizza.setEnabled(false);
//                    final int m = obj. + 1;
                    obj.setRollscount(1);
                } else {
                    deserts.setEnabled(true);
                    burger.setEnabled(true);
                    pizza.setEnabled(true);
                }
                break;

            case R.id.checkBox22:
                if (deserts.isChecked()) {
                    rolls.setEnabled(false);
                    burger.setEnabled(false);
                    pizza.setEnabled(false);
                    obj.setDesertscount(1);
                } else {
                    rolls.setEnabled(true);
                    burger.setEnabled(true);
                    pizza.setEnabled(true);
                }
                break;

            case R.id.checkBox23:
                if (burger.isChecked()) {
                    deserts.setEnabled(false);
                    rolls.setEnabled(false);
                    pizza.setEnabled(false);
                    obj.setBurgercount(1);
                } else {
                    deserts.setEnabled(true);
                    rolls.setEnabled(true);
                    pizza.setEnabled(true);
                }
                break;

            case R.id.checkBox24:
                if (pizza.isChecked()) {
                    deserts.setEnabled(false);
                    burger.setEnabled(false);
                    rolls.setEnabled(false);
                    obj.setPizzacount(1);
                } else {
                    deserts.setEnabled(true);
                    burger.setEnabled(true);
                    rolls.setEnabled(true);
                }
                break;
            case R.id.checkBox31:
                if (dance.isChecked()) {
                    song.setEnabled(false);
                    comedy.setEnabled(false);
                    dj.setEnabled(false);
                    obj.setDancecount(1);
                } else {
                    song.setEnabled(true);
                    comedy.setEnabled(true);
                    dj.setEnabled(true);
                }
                break;

            case R.id.checkBox32:
                if (song.isChecked()) {
                    dance.setEnabled(false);
                    comedy.setEnabled(false);
                    dj.setEnabled(false);
                    obj.setSongcount(1);
                } else {
                    dance.setEnabled(true);
                    comedy.setEnabled(true);
                    dj.setEnabled(true);
                }
                break;

            case R.id.checkBox33:
                if (comedy.isChecked()) {
                    song.setEnabled(false);
                    dance.setEnabled(false);
                    dj.setEnabled(false);
                    obj.setComedycount(1);
                } else {
                    song.setEnabled(true);
                    dance.setEnabled(true);
                    dj.setEnabled(true);
                }
                break;

            case R.id.checkBox34:
                if (dj.isChecked()) {
                    song.setEnabled(false);
                    comedy.setEnabled(false);
                    dance.setEnabled(false);
                    obj.setDjcount(1);
                } else {
                    song.setEnabled(true);
                    comedy.setEnabled(true);
                    dance.setEnabled(true);
                }
                break;
        }

    }

    public void submitButton(View v) {

    }


    private void count() {

        System.out.println(obj.getBurgercount()+"  "+obj.getComedycount()+"  "+obj.getBurgercount() + "maddy");

        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                HashMap<String, Object> countlist = new HashMap<>();
                countlist.put("pubgcount", obj.getPubgcount() +"");
                countlist.put("fifacount", obj.getFifacount()+"");
                countlist.put("minicount", obj.getMinicount()+"");
                countlist.put("csgocount", obj.getCsgocount()+"");
                countlist.put("rollscount", obj.getRollscount()+"");
                countlist.put("desertscount", obj.getDesertscount()+"");
                countlist.put("burgercount", obj.getBurgercount()+"");
                countlist.put("pizzacount", obj.getPizzacount()+"");
                countlist.put("dancecount", obj.getDancecount()+"");
                countlist.put("songcount", obj.getSongcount()+"");
                countlist.put("comedycount", obj.getComedycount()+"");
                countlist.put("djcount", obj.getDjcount()+"");

//                if(pubg.isChecked()) {
//                    countlist.put("pubgcount", obj.getPubgcount() +"");
//                }
//                if (fifa.isChecked()) {
//                    countlist.put("fifacount", obj.getFifacount()+"");
//                }
//                if (mini.isChecked()) {
//                    countlist.put("minicount", obj.getMinicount()+"");
//                }
//                if (csgo.isChecked()) {
//                    countlist.put("csgocount", obj.getCsgocount()+"");
//                }
//                if (rolls.isChecked()) {
//                    countlist.put("rollscount", obj.getRollscount()+"");
//                }
//                if (deserts.isChecked()) {
//                    countlist.put("desertscount", obj.getDesertscount()+"");
//                }
//                if (burger.isChecked()) {
//                    countlist.put("burgercount", obj.getBurgercount()+"");
//                }
//                if (pizza.isChecked()) {
//                    countlist.put("pizzacount", obj.getPizzacount()+"");
//                }
//                if (dance.isChecked()) {
//                    countlist.put("dancecount", obj.getDancecount()+"");
//                }
//                if(song.isChecked()) {
//                    countlist.put("songcount", obj.getSongcount()+"");
//                }
//                if (comedy.isChecked()) {
//                    countlist.put("comedycount", obj.getComedycount()+"");
//                }
//                if (dj.isChecked()){
//                    countlist.put("djcount", obj.getDjcount()+"");
//                }

                //getting old values
                rootref.child("Count").child("pubgcount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setPubgcount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });

                rootref.child("Count").child("rollscount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println(" roll temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setRollscount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });

                rootref.child("Count").child("fifacount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setFifacount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("minicount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setMinicount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("csgocount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setCsgocount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("desertscount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setDesertscount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("burgercount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setBurgercount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("pizzacount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setPizzacount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("dancecount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setDancecount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("songcount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setSongcount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("comedycount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setComedycount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                rootref.child("Count").child("djcount").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                        System.out.println("temp is "+temp);
                        int t = Integer.parseInt(temp);

                        obj.setDjcount(t);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });



                button.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        openActivity();
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void openActivity() {
        final DatabaseReference rootref1;
        rootref1 = FirebaseDatabase.getInstance().getReference();
        System.out.println("value is "+obj.getPubgcount());
        rootref1.child("Count").setValue(obj);

        Intent intent = new Intent(this, StatusActivity.class);
        intent.putExtra("pubgcount","PUBG COUNT ------ " + "  "+obj.getPubgcount()+"");
        intent.putExtra("fifacount","FIFA COUNT------" + "  "+obj.getFifacount()+"");
        intent.putExtra("minicount","MINI MILITIA COUNT----" + "  "+ obj.getMinicount()+"");
        intent.putExtra("csgocount","CSGO COUNT------" + "  "+ obj.getCsgocount()+"");
        intent.putExtra("rollscount","ROLLS COUNT-----" + "  "+ obj.getRollscount()+"");
        intent.putExtra("desertscount","DESERTS COUNT------" + "  "+ obj.getDesertscount()+"");
        intent.putExtra("burgercount","BURGER COUNT-------" + "  "+ obj.getBurgercount()+"");
        intent.putExtra("pizzacount","PIZZA COUNT--------" + "  "+ obj.getPizzacount()+"");
        intent.putExtra("dancecount","DANCE COUNT--------" + "  "+ obj.getDancecount()+"");
        intent.putExtra("songcount","SONG COUNT -------" + "  "+obj.getSongcount()+"");
        intent.putExtra("comedycount","COMEDY COUNT ------ " + "  "+obj.getComedycount()+"");
        intent.putExtra("djcount","DJ COUNT --------" + "  "+obj.getDjcount()+"");
//        intent.putExtra("pubgcount", obj.getPubgcount());
        startActivity(intent);
    }
}
