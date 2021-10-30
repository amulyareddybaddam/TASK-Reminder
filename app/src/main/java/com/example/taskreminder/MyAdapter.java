package com.example.taskreminder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AlarmViewHolder> {

    DBHelper helper;
    String date = "";
    private Context mCtx;
    private List<Alarm> productList;


    public MyAdapter(Context mCtx, List<Alarm> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.helper = new DBHelper(mCtx);

    }

    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view =LayoutInflater.from(mCtx).inflate(R.layout.item_alarm, null);
        return new AlarmViewHolder(view);
    }



    @Override
    public void onBindViewHolder(AlarmViewHolder holder, final int position) {
        final Alarm product = productList.get(position); // getting single product item 1 by 1


        holder.tv_Title.setText(product.getTitle());
        if(product.getHour()>12){
            int hour = product.getHour() - 12;
            product.setHour(hour);
            date = product.getDay()+", "+product.getMonth()+" "+product.getDate()
                    +" , "+product.getHour()+":"+product.getMinute()+" PM";
        }
        else{
            date = product.getDay()+", "+product.getMonth()+" "+product.getDate()
                    +" , "+product.getHour()+":"+product.getMinute()+" AM";
        }
        holder.tv_date.setText(date+"");

        holder.imageView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = product.getId();
                Intent editIntent = new Intent(mCtx, EditActivity.class);
                editIntent.putExtra("action","edit");
                editIntent.putExtra("alarm_id",a);
                mCtx.startActivity(editIntent);
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               removeItem(position);
               int a = product.getAlarmId();
               helper.delete(a);
               Toast.makeText(mCtx, "Alarm DELETED with id "+a, Toast.LENGTH_SHORT).show();
           }
       });

        if(product.isEnabled()==1)holder.toggle_switch.setChecked(true);

      holder.toggle_switch.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              helper.toggle_enable(product.getAlarmId(),product.isEnabled());
          }
      });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class AlarmViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Title,tv_priority,tv_date;
        ImageView imageView,imageView_edit;
        Switch toggle_switch;

        public AlarmViewHolder(View itemView) {
            super(itemView);

            tv_Title = itemView.findViewById(R.id.item_alarm_title_TV);
            tv_date = itemView.findViewById(R.id.date_tv);
            imageView = itemView.findViewById(R.id.image_delete);
            imageView_edit = itemView.findViewById(R.id.image_edit);
            toggle_switch = itemView.findViewById(R.id.item_alarm_toggle);

        }
    }


    public void removeItem(int position){
        productList.remove(position);
        notifyDataSetChanged();

    }
    public void enable_disable(int position){

    }
}

