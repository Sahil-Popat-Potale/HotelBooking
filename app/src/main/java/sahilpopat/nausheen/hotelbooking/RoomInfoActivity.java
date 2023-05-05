package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoomInfoActivity extends AppCompatActivity {
    Calendar myCalendar;
    EditText checkIn, checkOut, number;
    String name, email, phone, people, address, roomType;
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
        number=findViewById(R.id.Number);
        spinner=findViewById(R.id.spinnerType);
        preview=findViewById(R.id.Preview);

        preview.setOnClickListener(v -> {
            Intent i1 =new Intent(RoomInfoActivity.this, FinalActivity.class);
            i1.putExtra("name",name);
            i1.putExtra("email",email);
            i1.putExtra("phone",phone);
            i1.putExtra("people",people);
            i1.putExtra("address",address);
            i1.putExtra("roomType",roomType);
            i1.putExtra("checkIn",checkIn.getText().toString());
            i1.putExtra("checkOut",checkOut.getText().toString());
            i1.putExtra("number",number.getText().toString());
            startActivity(i1);
        });

        DatePickerDialog.OnDateSetListener date1 = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLable();
        };
        checkIn.setOnClickListener(v -> new DatePickerDialog(RoomInfoActivity.this, date1, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        DatePickerDialog.OnDateSetListener date2 = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLable1();
        };
        checkOut.setOnClickListener(v -> new DatePickerDialog(RoomInfoActivity.this, date2, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());
    }
    private void updateLable(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.US);
        checkIn.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLable1(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.US);
        checkOut.setText(sdf.format(myCalendar.getTime()));
    }
}