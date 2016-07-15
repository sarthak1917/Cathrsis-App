package com.example.sarthak.cathapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText txtEmail,txtEventKey;
    String emailKey,eventkey;
    AlertDialog.Builder builder,fbBuilder,keyBuilder,optionBuilder;
    AlertDialog dialog,resposneDialog,fbButtonDialog,keyDialog,optionDialog;
    LoginButton loginButton;
    CallbackManager callbackManager;

    private void initViews(){
        txtEmail=new EditText(this);
        txtEmail.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

        txtEventKey=new EditText(this);
        txtEventKey.setInputType(InputType.TYPE_CLASS_TEXT);

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Register");
        builder.setMessage("Enter Email:");
        builder.setView(txtEmail);



        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                emailKey = txtEmail.getText().toString().trim();
                checkEmail();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                txtEmail.setText("");
            }
        });

        dialog=builder.create();

        AlertDialog.Builder buildDialog = new AlertDialog.Builder(MainActivity.this);
        buildDialog.setMessage("Incorrect Email....");
        buildDialog.setTitle("Response");
        buildDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resposneDialog.dismiss();
            }
        });

        resposneDialog = buildDialog.create();
    }

    void fbDialogBuilder(){
        fbBuilder=new AlertDialog.Builder(this);
        fbBuilder.setTitle("Login");
        loginButton=new LoginButton(this);
        fbBuilder.setView(loginButton);
        fbButtonDialog=fbBuilder.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                keyDialog.show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    void keyDialogBuilder(){
        keyBuilder=new AlertDialog.Builder(this);
        keyBuilder.setTitle("enter key");
        keyBuilder.setView(txtEventKey);
        keyBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eventkey = txtEventKey.getText().toString().trim();
                checkEventkey();
            }
        });
        keyBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                keyDialog.dismiss();
            }
        });
        keyDialog=keyBuilder.create();
    }

    void checkEventkey(){
        if(eventkey.equals("b")){
            optionDialog.show();
        }else{
            txtEventKey.setText("");
            resposneDialog.show();
        }
    }

    void optionDialogBuilder(){
        optionBuilder=new AlertDialog.Builder(this);
        optionBuilder.setItems(new String[]{"Event Page", "Registration List", "Results"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if(which==0){
                   Intent i=new Intent(MainActivity.this,ResultActivity.class);
                   i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                   i.putExtra("check",1);
                   startActivity(i);
               }else if(which==1){
                   Intent i=new Intent(MainActivity.this,ResultActivity.class);
                   i.putExtra("url","https://docs.google.com/spreadsheets/d/1cZfVt571aqtw4ptWnF69v5bGTJn-A2UI5XIVAmGy4G8/edit?usp=sharing");
                   i.putExtra("check",1);
                   startActivity(i);
               }else if(which==2){
                   Intent i=new Intent(MainActivity.this,ResultActivity.class);
                   i.putExtra("url","https://docs.google.com/spreadsheets/d/19YP21cyzGrvf_IRMdW6VRufiZlBCPKs4bdmopP1S_Ns/edit?usp=sharing");
                   i.putExtra("check",1);
                   startActivity(i);
               }
            }
        });

        optionDialog=optionBuilder.create();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        callbackManager=CallbackManager.Factory.create();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMain);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("url", "https://www.google.co.in/maps/place/Ambedkar+Institute+of+Advanced+Communication+Technologies+and+Research/@28.6543891,77.2649951,17z/data=!3m1!4b1!4m2!3m1!1s0x390cfc944ec6b523:0xd8bf72d453dbf662");
                i.putExtra("check", 1);
                startActivity(i);
            }
        });

        initViews();
        fbDialogBuilder();
        keyDialogBuilder();
        optionDialogBuilder();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cath16) {
            Intent i=new Intent(MainActivity.this,ResultActivity.class);
            i.putExtra("url","http://catharsis16.in/");
            i.putExtra("check",2);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.resultId) {
            Intent i=new Intent(this,ResultListActivity.class);
            startActivity(i);
        } else if (id == R.id.patId) {

        } else if (id == R.id.eventId) {
            Intent i=new Intent(MainActivity.this,EventList.class);
            startActivity(i);

        } else if (id == R.id.headId) {
            fbButtonDialog.show();

        } else if (id == R.id.detId) {

            dialog.show();

        } else if (id == R.id.nav_slideshow) {
            Intent i=new Intent(MainActivity.this,ResultActivity.class);
            i.putExtra("url","http://catharsis16.github.io/#gallery");
            i.putExtra("check",2);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void checkEmail(){
        if(emailKey.equals("a")){
            Intent i=new Intent(this,ResultActivity.class);
            i.putExtra("url","https://docs.google.com/forms/d/1HAb4p7RStqETj8B40kXxDYTfXBPk1R61yPeuDnD63LE/viewform?usp=send_form");
            i.putExtra("check",1);
            startActivity(i);
        }else{
            txtEmail.setText("");
            resposneDialog.show();
        }

    }

}
