package hbacak07.example.com.costumactionbarexample;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MenuItem menuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        //actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.yenile:
                menuItem=item;
                menuItem.setActionView(R.layout.progressbar);
                menuItem.expandActionView();
                TestTask task=new TestTask();
                task.execute("test");
                Toast.makeText(this, "Yenile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yeni:
                Toast.makeText(this, "Yeni", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bilgi:
                Toast.makeText(this, "Bilgi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ayarlar:
                Toast.makeText(this, "Ayarlar", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
    private class TestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // Simulate something long running
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
