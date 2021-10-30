package com.example.taskreminder;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class EditActivity extends AppCompatActivity {

    DBHelper helper = new DBHelper(this);
    List<Alarm> arrayList;
    boolean edit_action = false;
    int selected_id =0;
    String action = "no";
    Intent i;
    RadioButton enabled_checkbox;
    RadioGroup radioGroup;
    EditText editText_Name;
    boolean isEnabled ;
    String name,selectedDay,selectedMonth;
    Calendar calendar;
    Button dateButton;
    Button timeButton;
    Button btn_done;
    TimePickerDialog timePicker;
    DatePickerDialog datePicker;
    int mYear, mMonth, mDay, mHour, mMinute,enable=1,action_alarm_id;
    int selectedDate,selectedHour,selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
        gettingValuesFromViews();

    }

    //used toast to display a message if nothing selected.
    // In this the date and time buttons are also created
    private void gettingValuesFromViews() {


        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // time picker dialog
                timePicker = new TimePickerDialog(EditActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int sHour, int sMinute) {
                            selectedHour = sHour;
                            selectedMinute = sMinute;

                            calendar.set(Calendar.MINUTE, selectedMinute);
                            calendar.set(Calendar.HOUR_OF_DAY, selectedHour);
                        Toast.makeText(EditActivity.this, sHour + ":" + sMinute,Toast.LENGTH_SHORT).show();
                    }
                },mHour,mMinute,false);
                timePicker.show();
            }
        });
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                datePicker = new DatePickerDialog(EditActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int monthOfYear
                                    , int dayOfMonth) {
                                String[] monthName = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
                                String[] daysName = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year,monthOfYear,dayOfMonth); //Important line
                                selectedDate = dayOfMonth;
                                selectedDay = daysName[calendar.get(Calendar.DAY_OF_WEEK) - 1];
                                selectedMonth = monthName[calendar.get(Calendar.MONTH)];
                                Log.d("Date",selectedDate+"");
                                //  Log.d("Month",(calendar.get(Calendar.MONTH) + 1)+""); // month in number

                                Log.d("Month",selectedMonth+""); // OK

                                Log.d("Current day = ",selectedDay+"");
                                Log.d("Year","-------------------------------------");



//                                Toast.makeText(EditActivity.this, dayOfMonth + "-"
//                                        + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();

                            }
                        },mYear,mMonth,mDay);// Current date we are setting to DatePicker
                datePicker.show();

            }
        });


        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText_Name.getText().toString();
                isEnabled = ((RadioButton) findViewById(R.id.Enable)).isChecked();

                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    Toast.makeText(EditActivity.this, "Title: "+name+"\nEnabled: "+isEnabled, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EditActivity.this, "Nothing selected from the radio group", Toast.LENGTH_SHORT).show();
                }
                if(isEnabled){
                    enable = 1;
                }
                else enable = 0;

                try {
                    scheduleAlarm(edit_action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void init() {

        final Calendar cldr = Calendar.getInstance();
        mHour = cldr.get(Calendar.HOUR_OF_DAY);
        mMinute = cldr.get(Calendar.MINUTE);

        selectedHour = mHour;
        selectedMinute = mMinute;

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        String[] monthName = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        String[] daysName = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

        selectedDate = mDay;
        selectedDay = daysName[c.get(Calendar.DAY_OF_WEEK) - 1];
        selectedMonth = monthName[c.get(Calendar.MONTH)];

        i = new Intent(getApplicationContext(),MainActivity.class);

        editText_Name = findViewById(R.id.ET1);
        enabled_checkbox = findViewById(R.id.Enable);
        btn_done = findViewById(R.id.done_btn);
        dateButton = findViewById(R.id.date_btn);
        timeButton = findViewById(R.id.time_btn);
        calendar = Calendar.getInstance();

        if(getIntent().getStringExtra("action")!=null){
            action = getIntent().getStringExtra("action");

            Log.d("alarm",action_alarm_id+" ");

            if(action.contains("edit")){
                edit_action = true;
                Log.d("action","edit");
                action_alarm_id = getIntent().getIntExtra("alarm_id",0);
                Log.d("action",action_alarm_id+" ");
                selected_id = action_alarm_id;
                arrayList = helper.getAlarmbyID(action_alarm_id);

                //Alarm alarm = new Alarm(alarm_id,title,enabled,hour,minute,date,month,day);
                editText_Name.setText(arrayList.get(0).getTitle());
                enabled_checkbox.setChecked(arrayList.get(0).isEnabled()==1);

                selectedDate = arrayList.get(0).getDate();
                selectedDay = arrayList.get(0).getDay();
                selectedMonth = arrayList.get(0).getMonth();

                selectedHour = arrayList.get(0).getHour();
                selectedMinute = arrayList.get(0).getMinute();


            }
        }
    }

    private void scheduleAlarm(boolean edit_action)  {
        int alarmId = new Random().nextInt(1000);
        Log.d("alarmId",selected_id+"");
        Alarm alarm = new Alarm(selected_id,alarmId,name,enable,selectedHour,selectedMinute,selectedDate,selectedMonth,selectedDay);
        Log.d("edit before schedule",edit_action+"");

        //alarm.schedule(getApplicationContext(),alarm,calendar,edit_action,false);

        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void onCancelClick(View view)
    {
        startActivity(i);
    }


}
