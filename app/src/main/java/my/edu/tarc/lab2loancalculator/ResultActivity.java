package my.edu.tarc.lab2loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView mptext;
    TextView lptext;
    TextView irtext;
    TextView dptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        dptext = (TextView)findViewById(R.id.dptext);
        lptext = (TextView)findViewById(R.id.lptext);
        irtext = (TextView)findViewById(R.id.irtext);
        mptext = (TextView)findViewById(R.id.mptext);

        Intent intent = getIntent();
        double monthly_payment = getIntent().getDoubleExtra("MONTHLYPAYMENT", 0);
        int loan_period = getIntent().getIntExtra("LOANPERIOD", 0);
        double interest_rate = getIntent().getDoubleExtra("INTERESTRATE", 0);
        double down_payment = getIntent().getDoubleExtra("DOWNPAYMENT", 0);

        dptext.setText(String.format("%s : %.2f", getResources().getString(R.string.downpayment), down_payment));
        lptext.setText(String.format("%s : %d", getResources().getString(R.string.loanperiod), loan_period));
        irtext.setText(String.format("%s : %.2f", getResources().getString(R.string.interestrate),interest_rate));
        mptext.setText(String.format("%s : %.2f",getResources().getString(R.string.monthlypayment), monthly_payment));
    }
}
