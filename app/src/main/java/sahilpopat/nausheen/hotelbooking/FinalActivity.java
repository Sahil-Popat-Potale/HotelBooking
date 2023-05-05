package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    String checkIn, checkOut, number;
    String name, email, phone, people, address, roomType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView tv1=findViewById(R.id.Tv1);

        Intent i=getIntent();
        name=i.getStringExtra("name");
        email=i.getStringExtra("email");
        phone=i.getStringExtra("phone");
        people=i.getStringExtra("people");
        address=i.getStringExtra("address");
        checkIn=i.getStringExtra("checkIn");
        checkOut=i.getStringExtra("checkOut");
        roomType=i.getStringExtra("roomType");
        number=i.getStringExtra("number");

        tv1.setText("Name: "+name+"\nEmail: "+email+"\nPhone: "+phone+
                "\nAddress: "+address+"\nNumber of People: "+people+
                "\nRoom Type: "+roomType+"\nNumber of Rooms:"+number+
                "\nCheck In Date: "+checkIn+"\nCheck Out Date: "+checkOut);
    }
}