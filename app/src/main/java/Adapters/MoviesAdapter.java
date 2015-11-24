package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ijzepeda.topmovies.R;

/**
 * Created by ivan.zepeda on 23/11/2015.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    Context mContext;
    AdapterView.OnItemClickListener mItemClickListener;

    public MoviesAdapter(Context context){
        this.mContext=context;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie,parent,false);
        return new ViewHolder(view);
    }
/*This method will generate an image and get the average color from the palette, if color is not found
* will return a default value - black in this case*/
    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder holder, int position) {
//final MenuItem menuItem = new MenuItemData().placeList(mContext).get(position);
//        holder.movieTitle.setText("");
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //MAnage the row_movie views
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       public LinearLayout mainHolder;//for ripple effect
        public LinearLayout movieTitleHolder;
        public TextView movieTitle;
        public ImageView movieImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mainHolder=(LinearLayout)itemView.findViewById(R.id.mainHolder);
movieTitleHolder=(LinearLayout)itemView.findViewById(R.id.movieTitleHolderRipple);
            movieTitle = (TextView)itemView.findViewById(R.id.movieTitle);
            movieImage=(ImageView)itemView.findViewById(R.id.movieImage);
            mainHolder.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {


        }
    }
}


/*package adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import helpers.MenuItemData;
import models.MenuItem;

public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.ViewHolder> {

    Context mContext;
    //Because Recycler Doesnt include OnItemClickListener it needs to be done on the Adapter
    OnItemClickListener mItemClickListener;

    public TravelListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(softtek.demo.R.layout.row_places, parent, false);
        return new ViewHolder(view);
    }

    *This method will generate an image and get the average color from the pallete, if color is not found,
    * will return a default value - black in this case
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MenuItem menuItem = new MenuItemData().placeList(mContext).get(position);
//use integers?
//        if(menuItem.name.equals("Remote Data")){//change to a constant values for id on name, it will be also used on mainactivity
//           menuItem.name=mContext.getResources().getString(R.string.remote_data);
//            holder.placeName.setText(mContext.getResources().getString(R.string.remote_data));// menuItem.nameAqui cambiarle el nombre a un string o un constant basado en el menuItem
//        }else{
//        ;
//        }

        holder.placeName.setText(menuItem.name);

        Picasso.with(mContext).load(menuItem.getImageResourceId(mContext)).into(holder.placeImage);

        Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), menuItem.getImageResourceId(mContext));

        Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int mutedLight = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
                //muted get a matted color, more pastel like, vibrant get a semi pastel but the brighter color, darkvibrant get the brigthest but on the darkest tone, the result is not pastel.
                //  int mutedLight = palette.getDarkVibrantColor(mContext.getResources().getColor(android.R.color.black));
                holder.placeNameHolder.setBackgroundColor(mutedLight);
            }
        });


    }

    @Override
    public int getItemCount() {
        return new MenuItemData().placeList(mContext).size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(softtek.demo.R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(softtek.demo.R.id.placeName);
            placeNameHolder = (LinearLayout) itemView.findViewById(softtek.demo.R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(softtek.demo.R.id.placeImage);
            placeHolder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}*/