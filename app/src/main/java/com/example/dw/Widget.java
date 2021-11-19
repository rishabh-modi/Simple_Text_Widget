package com.example.dw;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class Widget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = "Text1";
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        int minWidth =  newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int minHeight =  newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
        int maxWidth =  newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH);
        int maxHeight =  newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT);

        Toast.makeText(context.getApplicationContext(), "minW = "+minWidth + "minH = " + minHeight + "maxW = " + maxWidth + "maxW = " + maxHeight, Toast.LENGTH_LONG ).show();

        if(minHeight > 200)
        {
            Toast.makeText(context.getApplicationContext() , "making text visible 1" , Toast.LENGTH_LONG).show();
            views.setViewVisibility(R.id.appwidget_text, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text2, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text3, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text4, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text5, View.VISIBLE);
        }
        else if(minHeight > 100  && minHeight < 200)
        {
            Toast.makeText(context.getApplicationContext() , "making text visible 2" , Toast.LENGTH_LONG).show();
            views.setViewVisibility(R.id.appwidget_text, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text2, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text3, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text4, View.GONE);
            views.setViewVisibility(R.id.appwidget_text5, View.GONE);
        }else if(minHeight > 10  && minHeight < 100)
        {
            Toast.makeText(context.getApplicationContext() , "making text visible 3" , Toast.LENGTH_LONG).show();
            views.setViewVisibility(R.id.appwidget_text, View.VISIBLE);
            views.setViewVisibility(R.id.appwidget_text2, View.GONE);
            views.setViewVisibility(R.id.appwidget_text3, View.GONE);
            views.setViewVisibility(R.id.appwidget_text4, View.GONE);
            views.setViewVisibility(R.id.appwidget_text5, View.GONE);
        }

        else {


        }

        appWidgetManager.updateAppWidget(appWidgetId, views);


    }
}