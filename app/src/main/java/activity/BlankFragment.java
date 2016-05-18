package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.piyaphorn.myapplication.R;

public class BlankFragment extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blank);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String[] str = { "สมองอักเสบ", "เนื้องอกในสมอง", "ปวดศรีษะจากความเครียด"};

        ListView listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, str));
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        Intent newActivity = new Intent(getApplication(), Blank01Fragment.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext()
                                , Blank02Fragment.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext()
                                , Blank03Fragment.class);
                        startActivity(intent);
                        break;
                    /*case 3:
                        intent = new Intent(getApplicationContext()
                                , DFragment.class);
                        startActivity(intent);
                        break;*/
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}