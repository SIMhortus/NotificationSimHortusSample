package com.example.notificationsimhortussample;

import java.util.Date;

public class NotificationAttributes {
   public String  date, action_description;
   public int notificationType;

   public NotificationAttributes(){}

    public NotificationAttributes( String action_description, String date, int notificationType) {
        this.date = date;
        this.action_description = action_description;
        this.notificationType = notificationType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAction_description(String action_description) {
        this.action_description = action_description;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public String getDate() {
        return date;
    }

    public String getAction_description() {
        return action_description;
    }

    public int getNotificationType() {
        return notificationType;
    }
}
