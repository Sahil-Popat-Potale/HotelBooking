package sahilpopat.nausheen.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btn;
    String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Line no.16 is suppose to get the string from Main activity java but not working
        Intent i=getIntent();
        info=i.getStringExtra("info");
        TextView txv=findViewById(R.id.textView);
        txv.setText("Room Type: "+info);
        btn.findViewById(R.id.submit);
        btn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, HomeActivity.class)));
    }
}