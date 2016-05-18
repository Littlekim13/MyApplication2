package activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.piyaphorn.myapplication.R;

public class EmailFragment extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_email);

        final EditText tEmailTo = (EditText) findViewById(R.id.txtEmailTo);
        final EditText tSubject = (EditText) findViewById(R.id.txtSubject);
        final EditText tMessage = (EditText) findViewById(R.id.txtMessage);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_SEND);
                newActivity.putExtra(Intent.EXTRA_EMAIL, new String[]{ tEmailTo.getText().toString() });
                newActivity.putExtra(Intent.EXTRA_SUBJECT, tSubject.getText().toString());
                newActivity.putExtra(Intent.EXTRA_TEXT, tMessage.getText().toString());
                newActivity.setType("plain/text");
                startActivity(Intent.createChooser(newActivity, "Email Sending Option :"));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}