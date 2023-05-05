package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbook=findViewById(R.id.button);
        btnbook.setOnClickListener(v -> {
            Intent i= new Intent(MainActivity.this, PersonnelInfoActivity.class);
            startActivity(i);
            i.putExtra("info", "Single Bed Rooms");
        });
    }
}