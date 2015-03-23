package com.mobile.cricpoker;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class Schedule extends ActionBarActivity {

    private TableLayout mTableLayout;
    private TableRow.LayoutParams mRowParams;

    private TableRow mTableHeader;
    private TableRow mMatchRow;

    private TextView mEmptyText;
    private TextView mHeaderText;
    private TextView mMatchNum;
    private TextView mMatch;
    private TextView mDateTime;
    private TextView mVenue;
    private TextView mResult;

    private final int leftMargin = 0;
    private final int topMargin = 0;
    private final int rightMargin = 0;
    private final int bottomMargin = 20;
    private final int numColumns = 5;

    TableLayout.LayoutParams tableParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tableParams = new TableLayout.LayoutParams
                (TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
        tableParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

        mRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        mRowParams.span = numColumns;

        createTableLayout();

        renderGroupStageMatches();

        setContentView(mTableLayout);
    }

    private void createTableLayout() {
        mTableLayout = new TableLayout(this);
        mTableLayout.setStretchAllColumns(true);
        mTableLayout.setShrinkAllColumns(true);
    }

    private void renderGroupStageMatches() {
        mHeaderText = new TextView(this);
        mHeaderText.setText("\nGroup Stages\n");
        mHeaderText.setGravity(Gravity.CENTER);
        mHeaderText.setTextColor(Color.WHITE);
        mHeaderText.setTypeface(Typeface.DEFAULT_BOLD);

        mTableHeader = new TableRow(this);
        mTableHeader.setBackgroundColor(Color.parseColor("#3333CC"));
        mTableHeader.addView(mHeaderText, mRowParams);
        mTableHeader.setGravity(Gravity.CENTER_HORIZONTAL);

        mTableLayout.addView(mTableHeader, tableParams);

        mMatchNum = new TextView(this);
        mMatchNum.setText("#");
        mMatchNum.setGravity(Gravity.LEFT);

        mMatch = new TextView(this);
        mMatch.setText("Team1\nv/s\nTeam2");
        mMatch.setGravity(Gravity.CENTER);

        mVenue = new TextView(this);
        mVenue.setText("Venue");
        mVenue.setGravity(Gravity.CENTER);

        mEmptyText = new TextView(this);

        mDateTime = new TextView(this);
        mDateTime.setText("1st April '15");
        mDateTime.setGravity(Gravity.RIGHT);

        mMatchRow = new TableRow(this);
        mMatchRow.addView(mMatchNum);
        mMatchRow.addView(mMatch);
        mMatchRow.addView(mVenue);
        mMatchRow.addView(mEmptyText);
        mMatchRow.addView(mDateTime);

        mTableLayout.addView(mMatchRow, tableParams);

        mMatchNum = new TextView(this);
        mMatchNum.setText("#");
        mMatchNum.setGravity(Gravity.LEFT);

        mMatch = new TextView(this);
        mMatch.setText("Team1\nv/s\nTeam2");
        mMatch.setGravity(Gravity.CENTER);

        mEmptyText = new TextView(this);

        mDateTime = new TextView(this);
        mDateTime.setText("2nd April '15");
        mDateTime.setGravity(Gravity.RIGHT);

        mVenue = new TextView(this);
        mVenue.setText("Venue");
        mVenue.setGravity(Gravity.CENTER);

        mMatchRow = new TableRow(this);
        mMatchRow.addView(mMatchNum);
        mMatchRow.addView(mMatch);
        mMatchRow.addView(mVenue);
        mMatchRow.addView(mEmptyText);
        mMatchRow.addView(mDateTime);

        mTableLayout.addView(mMatchRow, tableParams);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
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
