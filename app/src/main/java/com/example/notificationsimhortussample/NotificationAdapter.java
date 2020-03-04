package com.example.notificationsimhortussample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.myNotif>{
    Context context;
    ArrayList<NotificationAttributes> notificationAttributes;

    public NotificationAdapter(Context c, ArrayList<NotificationAttributes> notif){
        context = c;
        notificationAttributes = notif;
    }

    @NonNull
    @Override
    public myNotif onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myNotif(LayoutInflater.from(context).inflate(R.layout.listview_notif, parent, false ));
    }

    @Override
    public void onBindViewHolder(@NonNull myNotif holder, int position) {
        holder.desc.setText(notificationAttributes.get(position).getAction_description());

        String date = notificationAttributes.get(position).getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aa");

        SimpleDateFormat format2 = new SimpleDateFormat("MMM dd, yyyy HH:mm aa");

        String dateTime;
        try {
            Date date1 = format.parse(date);

            dateTime = format2.format(date1);
            holder.date.setText(dateTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (notificationAttributes.get(position).getNotificationType() == 1) {
            holder.notifImage.setImageResource(R.drawable.ic_women);
        }

        if (notificationAttributes.get(position).getNotificationType() == 2) {
            holder.notifImage.setImageResource(R.drawable.ic_sprout);
        }

        if (notificationAttributes.get(position).getNotificationType() == 3) {
            holder.notifImage.setImageResource(R.drawable.ic_info);
        }

        if (notificationAttributes.get(position).getNotificationType() == 4) {
            holder.notifImage.setImageResource(R.drawable.ic_error);
        }

        if (notificationAttributes.get(position).getNotificationType() == 5) {
            holder.notifImage.setImageResource(R.drawable.ic_tree);
        }


    }

    @Override
    public int getItemCount() {
        return notificationAttributes.size();
    }

    class myNotif extends RecyclerView.ViewHolder
    {
        TextView desc, date;
        ImageView notifImage;

        public myNotif(View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.displayDesc);
            date = itemView.findViewById(R.id.displayDate);
            notifImage = itemView.findViewById(R.id.notifImage);

        }
    }

}
