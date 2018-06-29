package com.example.nobrokertask.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nobrokertask.MainActivity;
import com.example.nobrokertask.R;

import java.util.HashMap;
import java.util.Map;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener{


    LinearLayout linear2bhk,linear3bhk,linear4bhk,linearapartment,linearindependent,linearbuilder,linearfull,linearsemi,linearnone;
    TextView tv2bhk,tv3bhk,tv4bhk,tvapartment,tvindependent,tvbuilder,tvfull,tvsemi,tvnone;
    Button applyfilter;
    HashMap<String,String> bedroommap;
    HashMap<String,String> propertymap;
    HashMap<String,String> furnishedmap;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        linear2bhk=(LinearLayout)findViewById(R.id.linear_2bhk);
        linear3bhk=(LinearLayout)findViewById(R.id.linear_3bhk);
        linear4bhk=(LinearLayout)findViewById(R.id.linear_4bhk);
        linearapartment=(LinearLayout)findViewById(R.id.linear_apartment);
        linearindependent=(LinearLayout)findViewById(R.id.linear_independent);
        linearbuilder=(LinearLayout)findViewById(R.id.linear_builder);
        linearfull=(LinearLayout)findViewById(R.id.linear_full);
        linearsemi=(LinearLayout)findViewById(R.id.linear_semi);
        //linearnone=(LinearLayout)findViewById(R.id.linear_none);
        tv2bhk=(TextView) findViewById(R.id.textview_2bhk);
        tv3bhk=(TextView) findViewById(R.id.textview_3bhk);
        tv4bhk=(TextView) findViewById(R.id.textview_4bhk);
        tvapartment=(TextView) findViewById(R.id.textview_apartment);
        tvindependent=(TextView) findViewById(R.id.textview_independent);
        tvbuilder=(TextView) findViewById(R.id.textview_builder);
        tvfull=(TextView) findViewById(R.id.textview_full);
        tvsemi=(TextView) findViewById(R.id.textview_semi);
        //tvnone=(TextView) findViewById(R.id.textview_none);
        applyfilter=(Button)findViewById(R.id.apply_filters);


        linear2bhk.setOnClickListener(this);
        linear3bhk.setOnClickListener(this);
        linear4bhk.setOnClickListener(this);
        linearapartment.setOnClickListener(this);
        linearindependent.setOnClickListener(this);
        linearbuilder.setOnClickListener(this);
        linearfull.setOnClickListener(this);
        linearsemi.setOnClickListener(this);
        //linearnone.setOnClickListener(this);
        tv2bhk.setOnClickListener(this);
        tv3bhk.setOnClickListener(this);
        tv4bhk.setOnClickListener(this);
        tvapartment.setOnClickListener(this);
        tvindependent.setOnClickListener(this);
        tvbuilder.setOnClickListener(this);
        tvfull.setOnClickListener(this);
        tvsemi.setOnClickListener(this);
        //tvnone.setOnClickListener(this);
        applyfilter.setOnClickListener(this);

        bedroommap=new HashMap<>();
        propertymap=new HashMap<>();
        furnishedmap=new HashMap<>();
        intent=this.getIntent();
        if(intent.getStringExtra("bmap")!=null){
            ProcessIntentBedroom(intent.getStringExtra("bmap"));
        }
        if(intent.getStringExtra("pmap")!=null){
            ProcessIntentProperty(intent.getStringExtra("pmap"));
        }
        if(intent.getStringExtra("fmap")!=null){
            ProcessIntentFur(intent.getStringExtra("fmap"));
        }
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch(id){
            case R.id.linear_2bhk:
                FunLinear2BHK();
                break;
            case R.id.linear_3bhk:
                FunLinear3BHK();
                break;
            case R.id.linear_4bhk:
                FunLinear4BHK();
                break;
            case R.id.linear_apartment:
                FunLinearAP();
                break;
            case R.id.linear_independent:
                FunLinearIH();
                break;
            case R.id.linear_builder:
                FunLinearIF();
                break;
            case R.id.linear_full:
                FunLinearFull();
                break;
            case R.id.linear_semi:
                FunLinearSemi();
                break;
            case R.id.textview_2bhk:
                FunLinear2BHK();
                break;
            case R.id.textview_3bhk:
                FunLinear3BHK();
                break;
            case R.id.textview_4bhk:
                FunLinear4BHK();
                break;
            case R.id.textview_apartment:
                FunLinearAP();
                break;
            case R.id.textview_independent:
                FunLinearIH();
                break;
            case R.id.textview_builder:
                FunLinearIF();
                break;
            case R.id.textview_full:
                FunLinearFull();
                break;
            case R.id.textview_semi:
                FunLinearSemi();
                break;
            case R.id.apply_filters:
                ProcessApply();
                break;

        }
    }

    void ProcessIntentBedroom(String bmap){
        if(bmap.contains("BHK2")){
            FunLinear2BHK();
        }
        if(bmap.contains("BHK3")){
            FunLinear3BHK();
        }
        if(bmap.contains("BHK4")){
            FunLinear4BHK();
        }
    }
    void ProcessIntentProperty(String pmap){
        if(pmap.contains("AP")){
            FunLinearAP();
        }
        if(pmap.contains("IH")){
            FunLinearIH();
        }
        if(pmap.contains("IF")){
            FunLinearIF();
        }

    }
    void ProcessIntentFur(String fmap){
        if(fmap.contains("SEMI_FURNISHED")){
            FunLinearSemi();
        }
        if(fmap.contains("FULLY_FURNISHED")){
            FunLinearFull();
        }
    }





    private void FunLinear2BHK(){
        if(tv2bhk.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!bedroommap.containsKey(tv2bhk.getText().toString())){
                bedroommap.put(tv2bhk.getText().toString(),"BHK2");
            }
            linear2bhk.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tv2bhk.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(bedroommap.containsKey(tv2bhk.getText().toString())){
                bedroommap.remove(tv2bhk.getText().toString());
            }
            linear2bhk.setBackgroundColor(getResources().getColor(R.color.grey));
            tv2bhk.setTextColor(getResources().getColor(R.color.black));
        }

    }
    private void FunLinear3BHK(){
        if(tv3bhk.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!bedroommap.containsKey(tv3bhk.getText().toString())){
                bedroommap.put(tv3bhk.getText().toString(),"BHK3");
            }
            linear3bhk.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tv3bhk.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(bedroommap.containsKey(tv3bhk.getText().toString())){
                bedroommap.remove(tv3bhk.getText().toString());
            }
            linear3bhk.setBackgroundColor(getResources().getColor(R.color.grey));
            tv3bhk.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinear4BHK(){
        if(tv4bhk.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!bedroommap.containsKey(tv4bhk.getText().toString())){
                bedroommap.put(tv4bhk.getText().toString(),"BHK4");
            }
            linear4bhk.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tv4bhk.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(bedroommap.containsKey(tv4bhk.getText().toString())){
                bedroommap.remove(tv4bhk.getText().toString());
            }
            linear4bhk.setBackgroundColor(getResources().getColor(R.color.grey));
            tv4bhk.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinearAP(){
        if(tvapartment.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!propertymap.containsKey(tvapartment.getText().toString())){
                propertymap.put(tvapartment.getText().toString(),"AP");
            }
            linearapartment.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tvapartment.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(propertymap.containsKey(tvapartment.getText().toString())){
                propertymap.remove(tvapartment.getText().toString());
            }
            linearapartment.setBackgroundColor(getResources().getColor(R.color.grey));
            tvapartment.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinearIH(){
        if(tvindependent.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!propertymap.containsKey(tvindependent.getText().toString())){
                propertymap.put(tvindependent.getText().toString(),"IH");
            }
            linearindependent.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tvindependent.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(propertymap.containsKey(tvindependent.getText().toString())){
                propertymap.remove(tvindependent.getText().toString());
            }
            linearindependent.setBackgroundColor(getResources().getColor(R.color.grey));
            tvindependent.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinearIF(){
        if(tvbuilder.getCurrentTextColor()==getResources().getColor(R.color.black)){

            if(!propertymap.containsKey(tvbuilder.getText().toString())){
                propertymap.put(tvbuilder.getText().toString(),"IF");
            }
            linearbuilder.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tvbuilder.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(propertymap.containsKey(tvbuilder.getText().toString())){
                propertymap.remove(tvbuilder.getText().toString());
            }
            linearbuilder.setBackgroundColor(getResources().getColor(R.color.grey));
            tvbuilder.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinearFull(){
        if(tvfull.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!furnishedmap.containsKey(tvfull.getText().toString())){
                furnishedmap.put(tvfull.getText().toString(),"FULLY_FURNISHED");
            }
            linearfull.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tvfull.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(furnishedmap.containsKey(tvfull.getText().toString())){
                furnishedmap.remove(tvfull.getText().toString());
            }
            linearfull.setBackgroundColor(getResources().getColor(R.color.grey));
            tvfull.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void FunLinearSemi(){
        if(tvsemi.getCurrentTextColor()==getResources().getColor(R.color.black)){
            if(!furnishedmap.containsKey(tvsemi.getText().toString())){
                furnishedmap.put(tvsemi.getText().toString(),"SEMI_FURNISHED");
            }
            linearsemi.setBackgroundColor(getResources().getColor(R.color.button_green_selected));
            tvsemi.setTextColor(getResources().getColor(R.color.white));
        }
        else{
            if(furnishedmap.containsKey(tvsemi.getText().toString())){
                furnishedmap.remove(tvsemi.getText().toString());
            }
            linearsemi.setBackgroundColor(getResources().getColor(R.color.grey));
            tvsemi.setTextColor(getResources().getColor(R.color.black));
        }
    }
    void ProcessApply(){
        Intent intent=new Intent(this, MainActivity.class);
        StringBuilder sb=new StringBuilder();
        StringBuilder pbuilder=new StringBuilder();
        StringBuilder fbuilder=new StringBuilder();
        for(Map.Entry<String,String> bmap:bedroommap.entrySet()){
            sb.append(bmap.getValue());
            sb.append(",");
        }
        if(sb.length()!=0){
            int a=sb.lastIndexOf(",");
            sb=sb.replace(a,a+1,"");
        }
        for(Map.Entry<String,String> pmap:propertymap.entrySet()){
            pbuilder.append(pmap.getValue());
            pbuilder.append(",");
        }
        if(pbuilder.length()!=0){
            int a=pbuilder.lastIndexOf(",");
            pbuilder=pbuilder.replace(a,a+1,"");
        }
        for(Map.Entry<String,String> fmap:furnishedmap.entrySet()){
            fbuilder.append(fmap.getValue());
            fbuilder.append(",");
        }
        if(fbuilder.length()!=0){
            int a=fbuilder.lastIndexOf(",");
            fbuilder=fbuilder.replace(a,a+1,"");
        }
        intent.putExtra("type",String.valueOf(sb));
        intent.putExtra("buildingType",String.valueOf(pbuilder));
        intent.putExtra("furnishing",String.valueOf(fbuilder));
        startActivity(intent);
    }
}
