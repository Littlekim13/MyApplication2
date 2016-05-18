package activity;

/**
 * Created by PIYAPHORN on 17/5/2559.
 */

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import java.net.MalformedURLException;
import java.util.List;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.piyaphorn.myapplication.R;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.authentication.MobileServiceAuthenticationProvider;
import com.microsoft.windowsazure.mobileservices.authentication.MobileServiceUser;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableQueryCallback;

public class LoginAvtivity extends Activity{

    Button button;
    private MobileServiceClient mClient;
    private MobileServiceTable<Login> cLogin;;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        button=(Button)findViewById(R.id.buttonSignup);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), signupActivity.class);
                startActivity(i);
            }
        });

        try {
            mClient = new MobileServiceClient(
                    "https://myapplication2.azurewebsites.net",
                    this
            );
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /*** Create getTable ***/
        cLogin = mClient.getTable(Login.class);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

        final AlertDialog.Builder adb = new AlertDialog.Builder(this);

        // btnLogin
        final Button btnLogin = (Button) findViewById(R.id.buttonSignin);

        // Perform action on click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mClient == null) {
                    AlertDialog ad = adb.create();
                    ad.setMessage("Cannot connect to Windows Azure Mobile Service!");
                    ad.show();
                } else {

                    cLogin.where().field("username").eq(txtUsername.getText().toString()).and()
                            .field("password").eq(txtPassword.getText().toString())
                            .execute(new TableQueryCallback<Login>() {
                                public void onCompleted(List<Login> result, int count, Exception exception,
                                                        ServiceFilterResponse response) {

                                    if (exception == null) {
                                        if (result.size() > 0) {

                                            String id = "0";
									/*String username = null;
									String password = null;
									String name = null;
									String tel = null;
									String email = null;*/

                                            Login item = result.get(0);
                                            id = item.getId();
									/*username = item.getUsername();
									password = item.getPassword();
									name = item.getName();
									tel = item.getTel();
									email = item.getEmail();*/


                                            Intent newActivity = new Intent(LoginAvtivity.this, MainActivity.class);
                                            newActivity.putExtra("cId", id);
                                            startActivity(newActivity);

                                        } else {
                                            AlertDialog ad = adb.create();
                                            ad.setMessage("Incorrect Username and Password!");
                                            ad.show();
                                        }
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
        /*final TextView lbText = (TextView) findViewById(R.id.textView2);
        if (mClient == null) {
            lbText.setText("Android Connect Failed");
        }
        else
        {
            lbText.setText("Android Connected to Mobile Servie");
        }*/
    }


}
