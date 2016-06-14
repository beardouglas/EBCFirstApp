package samples.fabric.io.ebcfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {

    String TAG = "MainActivity";
    TextView welcomeText;
    Button clickMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("users").child("001").setValue("Bear");

        welcomeText = (TextView) findViewById(R.id.welcomeText);

        welcomeText.append(" Bear");

        EBCApplication app = (EBCApplication) getApplication();
        int currentVal= app.currentVal;

        clickMeButton = (Button) findViewById(R.id.clickMeButton);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ClickedActivity.class);
                startActivityForResult(i, RESULT_OK);
            }
        });

        Log.d(TAG, "onCreate called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    public void onActivityResult(int requestCode, int ResultCode, Intent data) {
        String message = data.getStringExtra("Success level");
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

}
