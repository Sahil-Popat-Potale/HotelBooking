package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoomInfoActivity extends AppCompatActivity {
    Calendar myCalendar;
    EditText checkIn, checkOut;
    String name, email, phone, people, address;
    Spinner spinner;
    Button preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        Intent i=getIntent();
        name=i.getStringExtra("name");
        email=i.getStringExtra("email");
        phone=i.getStringExtra("phone");
        people=i.getStringExtra("people");
        address=i.getStringExtra("address");

        myCalendar = Calendar.getInstance();
        checkIn=findViewById(R.id.CheckIn);
        checkOut=findViewById(R.id.CheckOut);
        spinner=findViewById(R.id.spinnerType);
        preview=findViewById(R.id.Preview);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLable();
            }
        };
        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RoomInfoActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLable(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.US);

        checkIn.setText(sdf.format(myCalendar.getTime()));
    }
}