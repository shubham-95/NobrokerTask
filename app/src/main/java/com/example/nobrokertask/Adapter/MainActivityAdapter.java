package com.example.nobrokertask.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.R;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MAViewHolder>{


    private Context context;
    private List<Datum> datumList;
    private Reached reached;
    private int total_count;

    public MainActivityAdapter(Context context, List<Datum> datumList,Reached reached,int total_count) {
        this.context = context;
        this.datumList = datumList;
        this.reached=reached;
        this.total_count=total_count;
    }

    @Override
    public MAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_page_layout,parent,false);
        return new MAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MAViewHolder holder, int position) {
        holder.BindPosition();
    }

    @Override
    public int getItemCount() {
        if(datumList.size()!=0 && datumList.get(datumList.size()-1).getTitle().equals("LE")){
            return datumList.size()-1;
        }
        else{
            return datumList.size();
        }
    }

    class MAViewHolder extends RecyclerView.ViewHolder{
        TextView title,secondaytitle,price,furnish,bathrooms,area;
        ImageView flatimage;
        ProgressBar progressBar;
        MAViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title_listpage);
            secondaytitle=(TextView)itemView.findViewById(R.id.description_listpage);
            price=(TextView)itemView.findViewById(R.id.price_listpage);
            furnish=(TextView)itemView.findViewById(R.id.furnishing_listpage);
            area=(TextView)itemView.findViewById(R.id.area_listpage);
            flatimage=(ImageView)itemView.findViewById(R.id.flatimage_listpage);
            bathrooms=(TextView)itemView.findViewById(R.id.bathrooms_listpage);
            progressBar=(ProgressBar)itemView.findViewById(R.id.loader_indicator);
        }
        private void BindPosition(){
            progressBar.setVisibility(View.GONE);
            int position=getAdapterPosition();
            title.setText(datumList.get(position).getTitle());
            String st="at "+datumList.get(position).getSecondaryTitle();
            secondaytitle.setText(st);
            price.setText(String.valueOf(datumList.get(position).getRent()));
            furnish.setText(ProcessFurnsh(datumList.get(position).getFurnishing()));
            bathrooms.setText(ProcessBathrooms(datumList.get(position).getBathroom()));
            String ps=String.valueOf(datumList.get(position).getPropertySize())+" Sq. ft";
            area.setText(ps);
            try{
                if(datumList.get(position).getPhotos()!=null)
                {
                    ProcessImage(datumList.get(position).getPhotos().get(0).getImagesMap().getOriginal());
                }
                else{
                    flatimage.setImageResource(R.drawable.defaultimage);
                }
            }
            catch(Exception e){
                flatimage.setImageResource(R.drawable.defaultimage);
            }
            if(position==datumList.size()-1){
                reached.GetPosition(position);
                if(datumList.size()!=total_count)
                    progressBar.setVisibility(View.VISIBLE);
            }
        }
        private String ProcessFurnsh(String s){
            if(s.equals("FULLY_FURNISHED")){
                return "Fully Furnished";
            }
            else{
                return "Semi Furnished";
            }
        }
        private String ProcessBathrooms(int a){
            if(a==1){
                return String.valueOf(a)+" Bathroom";
            }
            else{
                return String.valueOf(a)+" Bathrooms";
            }
        }
        private void ProcessImage(String key){
            String url="http://d3snwcirvb4r88.cloudfront.net/images/"+key.split("_")[0]+"/"+key;
            Glide.with(context).load(url).asBitmap().format(DecodeFormat.PREFER_ARGB_8888).dontTransform().into(flatimage);
        }
    }
    public interface Reached{
        void GetPosition(int a);
    }
}
