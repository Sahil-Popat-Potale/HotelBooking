package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonnelInfoActivity extends AppCompatActivity {
    EditText name, email, phone, people, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_info);
        Button save = findViewById(R.id.Submit);
        name=findViewById(R.id.Name);
        email=findViewById(R.id.Email);
        phone=findViewById(R.id.Phone);
        people=findViewById(R.id.People);
        address=findViewById(R.id.Address);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PersonnelInfoActivity.this, RoomInfoActivity.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("phone",phone.getText().toString());
                i.putExtra("people",people.getText().toString());
                i.putExtra("address",address.getText().toString());
                startActivity(i);
            }
        });
    }
}