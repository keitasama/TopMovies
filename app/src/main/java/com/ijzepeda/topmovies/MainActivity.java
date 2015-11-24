package com.ijzepeda.topmovies;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import Adapters.MoviesAdapter;

public class MainActivity extends AppCompatActivity {
public RecyclerView mRecyclerView;
    public StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    public MoviesAdapter mmMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello Project from gitHub, and api root", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



       // mRecyclerView

//        api.themoviedb.org/3/movie/popular?api_key=



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



/*
*
* package softtek.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.Locale;

import adapters.TravelListAdapter;


public class MainActivity extends Activity {
private Toolbar toolbar;
  private Menu menu;
  private boolean isListView;
  private RecyclerView mRecyclerView;
  private StaggeredGridLayoutManager mStaggeredLayoutManager;
  private TravelListAdapter mAdapter;
  private boolean restart=false;

  int mLastLanguage;
  SharedPreferences sharedpreferences;
  public static final String MyPREFERENCES = "MyPrefs" ;

  //private int orientation= Activity.getResources().getConfiguration().orientation;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

    if(getResources().getConfiguration().locale.getLanguage() != sharedpreferences.getString("userLang","")) {
      setLanguage(this, sharedpreferences.getString("userLang", ""));
    }
    setContentView(softtek.demo.R.layout.activity_main);

    isListView = true;

    mRecyclerView=(RecyclerView) findViewById(softtek.demo.R.id.list);
    mStaggeredLayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);//in spancount. 1 is to use it as a list and not as a grid
    mRecyclerView.setLayoutManager(mStaggeredLayoutManager);//or use a fullspan-true, to get a layer with different size objects

    mAdapter= new TravelListAdapter(this);
    mRecyclerView.setAdapter(mAdapter);

    TravelListAdapter.OnItemClickListener onItemClickListener =new TravelListAdapter.OnItemClickListener(){

      @Override
      public void onItemClick(View view, int position) {
        //Toast.makeText(MainActivity.this,"Clicked"+position,Toast.LENGTH_SHORT).show();
      ///  Intent intent = new Intent(MainActivity.this, DetailActivity.class);
      ///  intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);//ESTE CAMBIARLO, o GENERAR UN SWITCH
       // startActivity(intent);

        ImageView placeImage = (ImageView) view.findViewById(softtek.demo.R.id.placeImage);
        LinearLayout placeNameHolder = (LinearLayout) view.findViewById(softtek.demo.R.id.placeNameHolder);

        View navigationBar=findViewById(android.R.id.navigationBarBackground);
        View statusBar= findViewById(android.R.id.statusBarBackground);

        Pair<View,String> imagePair=Pair.create((View) placeImage, "tImage");
        Pair<View,String> holderPair= Pair.create((View) placeNameHolder, "tNameHolder");

        Pair<View,String> navPair = Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);
        Pair<View,String> statusPair = Pair.create(statusBar,Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
        Pair<View,String> toolbarPair=Pair.create((View)toolbar,"tActionBar");


//create animation from A to B
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imagePair, holderPair, navPair, statusPair, toolbarPair);
Intent intent;
       // Toast.makeText(MainActivity.this, "Option: "+position, Toast.LENGTH_SHORT).show();
switch(position) {

  case 0:

     intent = new Intent(MainActivity.this, GeolocationActivity.class);
    intent.putExtra(GeolocationActivity.EXTRA_PARAM_ID, position);//ESTE CAMBIARLO, o GENERAR UN SWITCH

    break;
  case 1:

    intent = new Intent(MainActivity.this, SocialActivity.class);
    intent.putExtra(SocialActivity.EXTRA_PARAM_ID, position);

    break;
  case 3:

    intent = new Intent(MainActivity.this, RemoteDataActivity.class);
    intent.putExtra(RemoteDataActivity.EXTRA_PARAM_ID, position);

    break;
  case 4:

    intent = new Intent(MainActivity.this, LocalDataActivityCollapsing.class);
    intent.putExtra(LocalDataActivityCollapsing.EXTRA_PARAM_ID, position);

    break;
  case 6:

//    intent = new Intent(MainActivity.this, AllGeofencesActivity.class);
    intent = new Intent(MainActivity.this, GeofencesV2Activity.class);//GeofencingActivityCollapsing.class);
   // intent.putExtra(GeofencesV2Activity.EXTRA_PARAM_ID, position);
   //startActivity(MainActivity.this,intent);
   // ActivityCompat.startActivity();
    break;
  case 7:

    intent = new Intent(MainActivity.this, TestCollapsingActivity.class);
    intent.putExtra(TestCollapsingActivity.EXTRA_PARAM_ID, position);
    //startActivity(MainActivity.this,intent);
    // ActivityCompat.startActivity();
    break;
  case 8:

    intent = new Intent(MainActivity.this, DetailActivityCollapsing.class);
    intent.putExtra(DetailActivityCollapsing.EXTRA_PARAM_ID, position);
    //startActivity(MainActivity.this,intent);
    // ActivityCompat.startActivity();
    break;
  default:
     intent = new Intent(MainActivity.this, DetailActivity.class);
    intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);//ESTE CAMBIARLO, o GENERAR UN SWITCH

}


        //ActivityCompat.startActivity();
       ////
         ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());




      }

    };

    mAdapter.setOnItemClickListener(onItemClickListener);

    toolbar = (Toolbar) findViewById(softtek.demo.R.id.toolbar);
    setUpActionBar();

    boolean tabletSize = getResources().getBoolean(softtek.demo.R.bool.isTablet);
    if (tabletSize) {
      //Toast.makeText(MainActivity.this,"isTablet",Toast.LENGTH_SHORT).show();
      if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
        mStaggeredLayoutManager.setSpanCount((1));
        isListView = false;
      } else {
       // Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        mStaggeredLayoutManager.setSpanCount((2));
        isListView = true;
      }
    }
  }

  private void setUpActionBar() {
if (toolbar!=null){
  setActionBar(toolbar);
  getActionBar().setDisplayHomeAsUpEnabled(false);
  getActionBar().setDisplayShowTitleEnabled(true);
  getActionBar().setElevation(7);
}
  }



  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(softtek.demo.R.menu.menu_main, menu);
    this.menu = menu;


     //Opcion que hace un spinner,
   * final Spinner s = (Spinner) menu.findItem(R.id.language_spinner).getActionView(); // find the spinner
    SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this.getActionBar()
            .getThemedContext(), R.array.languages_array, android.R.layout.simple_spinner_dropdown_item); //  create the adapter from a StringArray
    s.setAdapter(mSpinnerAdapter); // set the adapter
    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"clickero:"+s.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });




return true;
        }


@Override
public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Limit to tablet only
        boolean tabletSize = getResources().getBoolean(softtek.demo.R.bool.isTablet);
        if (tabletSize) {
        MenuItem item = menu.findItem(softtek.demo.R.id.action_toggle);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        mStaggeredLayoutManager.setSpanCount((2));
        item.setIcon(softtek.demo.R.drawable.ic_action_grid);
        item.setTitle("Show as grid");
        isListView = true;
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
        mStaggeredLayoutManager.setSpanCount((1));
        item.setIcon(softtek.demo.R.drawable.ic_action_list);
        item.setTitle("Show as list");
        isListView = false;
        }
        }

        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == softtek.demo.R.id.action_toggle) {
        toggle();// this will be setted only on orientation change
        return true;
        }
        else{
        setLanguage(this, item.toString());
        // restartActivity();not here
        }
        return super.onOptionsItemSelected(item);
        }


public  void setLanguage(Context context, String languageToLoad) {
        if(languageToLoad.equals(getResources().getString(R.string.english)) || languageToLoad.equals("en")){ //usar un comparativo al string de idioma ingles
        languageToLoad="en";
        restart=true;
        }else if(languageToLoad.equals(getResources().getString(R.string.spanish))|| languageToLoad.equals("es")){
        languageToLoad="es";
        restart=true;
        }else{ //is for any other click, so
        restart=false;
        //languageToLoad="en";
        }

//    Toast.makeText(MainActivity.this, "language to load:" + languageToLoad, Toast.LENGTH_SHORT).show();
        if(restart) {
        restart=false;
        Locale locale = new Locale(languageToLoad); // e.g "sv"
        Locale systemLocale = Locale.getDefault();// Locale.getInstance().getCurrentLocale(context);
        if (systemLocale != null && systemLocale.equals(locale)) { //If there is no change
        return;
        }

        //Set the current language to the assigned , and save it to preferences
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        Editor editor = sharedpreferences.edit();
        editor.putString("userLang", languageToLoad);
        //editor.putInt("userLanPos", spinner.getSelectedItemPosition());
        editor.commit();
        restartActivity();//not here because this functions is used at the beginning of the activity

//  restartActivity();
        } //end if restart



        }

private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        }
private void toggle() {
        MenuItem item = menu.findItem(softtek.demo.R.id.action_toggle);
        if (isListView) {
        mStaggeredLayoutManager.setSpanCount((1));
        item.setIcon(softtek.demo.R.drawable.ic_action_list);
        item.setTitle("Show as list");
        isListView = false;
        } else {
        mStaggeredLayoutManager.setSpanCount((2));
        item.setIcon(softtek.demo.R.drawable.ic_action_grid);
        item.setTitle("Show as grid");
        isListView = true;
        }
        }
        }

        *
* */