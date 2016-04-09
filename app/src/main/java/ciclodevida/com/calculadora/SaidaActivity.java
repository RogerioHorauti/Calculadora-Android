package ciclodevida.com.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SaidaActivity extends AppCompatActivity {

    private String msg="";
    private String num1="";
    private String num2="";
    private double total=0;
    private double n1=0;
    private double n2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saida);
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


        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if (params != null) {

                this.msg = params.getString("mensagem");
                this.num1 = params.getString("numero1");
                this.num2 = params.getString("numero2");

                this.n1 = Double.valueOf(params.getString("numero1")).doubleValue();
                this.n2 = Double.valueOf(params.getString("numero2")).doubleValue();


                Log.i("exemplo", "Mensagem: " + this.msg);
                Log.i("exemplo", "Número 1: " + this.n1);
                Log.i("exemplo", "Número 2: " + this.n2);

                if("+".equals(params.getString("operador"))){
                    this.total = this.n1 + this.n2;
                }else if("-".equals(params.getString("operador"))){
                    this.total = this.n1 - this.n2;
                }else if("*".equals(params.getString("operador"))){
                    this.total = this.n1 * this.n2;
                }else if("/".equals(params.getString("operador"))){
                    this.total = this.n1 / this.n2;
                }
            }

            //String.valueOf(total);
            //Double.toString(total);

            TextView mTextViewSaida1 = (TextView) findViewById(R.id.textViewSaida1);
            TextView mTextViewSaida2 = (TextView) findViewById(R.id.textViewSaida2);
            TextView mTextViewSaida3 = (TextView) findViewById(R.id.textViewSaida3);
            TextView mTextViewTotal = (TextView) findViewById(R.id.textViewTotal);

            mTextViewSaida1.setText(it.getStringExtra("numero1"));
            mTextViewSaida2.setText(it.getStringExtra("operador"));
            mTextViewSaida3.setText(it.getStringExtra("numero2"));
            mTextViewTotal.setText(Double.toString(this.total));

        }


    }

}
