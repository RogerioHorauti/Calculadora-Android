package ciclodevida.com.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private String numero1="";
    private String numero2="";
    private EditText num1;
    private EditText num2;
    private EditText oper;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.num1 = (EditText) findViewById(R.id.editTextNum1);
        this.num2 = (EditText) findViewById(R.id.editTextNum2);
        this.oper = (EditText) findViewById(R.id.editTextOper);
        this.b = (Button) findViewById(R.id.buttonCalcular);
        this.b.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        this.numero1 = this.num1.getText().toString();
        this.numero2 = this.num2.getText().toString();

        Intent it = new Intent(this, SaidaActivity.class);

        Bundle params= new Bundle();

        params.putString("mensagem", "Olá, segunda tela");
        params.putString("numero1", this.numero1);
        params.putString("numero2", this.numero2);
        params.putString("operador", this.oper.getText().toString());

        it.putExtras(params);

        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
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
    }

}
