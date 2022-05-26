package sg.edu.rp.c346.id21037552.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Event handling step 1
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String bankClicked = "";
    String url = "";
    String phoneNo = "";
    boolean favDbs = false, favOcbc = false, favUob = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Event handling Step 2
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        //Trigger menu
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            bankClicked = "DBS";
        } else if (v == tvOCBC) {
            bankClicked = "OCBC";
        } else if (v == tvUOB) {
            bankClicked = "UOB";
        } else {
            bankClicked = "";
        }
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView tvSelected = null;
        if (bankClicked.equalsIgnoreCase("DBS")) {
            url = "https://www.dbs.com.sg";
            phoneNo = "18001111111";
            tvSelected = tvDBS;
        } else if (bankClicked.equalsIgnoreCase("OCBC")) {
            url = "https://www.ocbc.com";
            phoneNo = "18003633333";
            tvSelected = tvOCBC;
        } else if (bankClicked.equalsIgnoreCase("UOB")) {
            url = "https://www.uob.com.sg";
            phoneNo = "18002222121";
            tvSelected = tvUOB;
        } else {
            url = "";
            phoneNo = "";
        }

        if (item.getItemId() == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } else if (item.getItemId() == 1) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNo));
            startActivity(intent);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (item.getItemId() == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //options menu = upper right
    //context menu = long click then floating menu comes up
}