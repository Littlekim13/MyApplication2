package activity;

/**
 * Created by PIYAPHORN on 17/5/2559.
 */
import java.net.MalformedURLException;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import android.app.Activity;
import android.widget.TextView;
import com.example.piyaphorn.myapplication.R;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.net.MalformedURLException;

public class signupActivity extends Activity{

    Button button;
    Button button1;
    private MobileServiceClient mClient;
    private MobileServiceTable<Login> cLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //onclick
        button=(Button)findViewById(R.id.buttonSignup);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), LoginAvtivity.class);
                startActivity(i);
            }
        });

        button1=(Button)findViewById(R.id.buttonCancel);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), LoginAvtivity.class);
                startActivity(i);
            }
        });

        /*** Create to Mobile Services ***/
        try {
            mClient = new MobileServiceClient(
                    "https://myapplication2.azurewebsites.net",
                    this);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /*** Create getTable ***/
        cLogin = mClient.getTable(Login.class);

        final EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        final EditText txtComfirm = (EditText)findViewById(R.id.txtConfirm);
        final EditText txtEmail = (EditText)findViewById(R.id.txtEmail);

        final AlertDialog.Builder adb = new AlertDialog.Builder(this);

        // btnSave
        final Button btnSave = (Button) findViewById(R.id.buttonSignup);
            // Perform action on click
            btnSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (mClient == null) {
                        AlertDialog ad = adb.create();
                        ad.setMessage("Cannot connect to Windows Azure Mobile Service!");
                        ad.show();
                    } else {
                        /*** Item for Insert ***/
                        Login item = new Login();
                        item.setUsername(txtUsername.getText().toString());
                        item.setPassword(txtPassword.getText().toString());
                        item.setEmail(txtEmail.getText().toString());

                        // Insert the new item
                        cLogin.insert(item, new TableOperationCallback<Login>() {

                            public void onCompleted(Login entity, Exception exception, ServiceFilterResponse response) {

                                if (exception == null) {
                                    AlertDialog ad = adb.create();
                                    ad.setMessage("Register Data Successfully.");
                                    ad.show();
                                } else {
                                    AlertDialog ad = adb.create();
                                    ad.setMessage("Error : " + exception.getCause().getMessage());
                                    ad.show();
                                }

                            }
                        });
                    }

                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
