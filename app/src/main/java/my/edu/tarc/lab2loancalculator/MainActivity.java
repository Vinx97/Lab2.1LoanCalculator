package my.edu.tarc.lab2loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText carprice;
    private EditText downpayment;
    private EditText loanperiod;
    private EditText interestrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carprice = (EditText)findViewById(R.id.cptext);
        downpayment = (EditText)findViewById((R.id.dptext));
        loanperiod = (EditText)findViewById(R.id.lptext);
        interestrate = (EditText)findViewById(R.id.irtext);
    }

    public void calculate(View v){
        Intent intent = new Intent(this, ResultActivity.class);

        double cp = Double.parseDouble(carprice.getText().toString());
        int lp = Integer.parseInt(loanperiod.getText().toString());
        double dp = Double.parseDouble(downpayment.getText().toString());
        double ir = Double.parseDouble(interestrate.getText().toString());

        double carloan = cp - dp;
        double interest = carloan*ir*lp;
        double monthlyrepayment = (carloan + interest)/lp/12;

        intent.putExtra("DOWNPAYMENT", dp);
        intent.putExtra("LOANPERIOD", lp);
        intent.putExtra("INTERESTRATE", ir);
        intent.putExtra("MONTHLYPAYMENT", monthlyrepayment);
        startActivity(intent);
    }
}
