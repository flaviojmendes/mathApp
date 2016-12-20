package es.flaviojmend.tabuada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View addView;
    private View subView;
    private View multView;
    private View divView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sumLayout).setOnClickListener(this);
        findViewById(R.id.subtractionLayout).setOnClickListener(this);
        findViewById(R.id.multiplyLayout).setOnClickListener(this);
        findViewById(R.id.divisionLayout).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sumLayout:
                Intent sumIntent = new Intent(this, SumActivity.class);
                startActivity(sumIntent);
                break;
            case R.id.subtractionLayout:
                Intent subtractionIntent = new Intent(this, SubtractionActivity.class);
                startActivity(subtractionIntent);
                break;
            case R.id.multiplyLayout:
                Intent multiplicationIntent = new Intent(this, MultiplicationActivity.class);
                startActivity(multiplicationIntent);
                break;
            case R.id.divisionLayout:
                Intent divisionIntent = new Intent(this, DivisionActivity.class);
                startActivity(divisionIntent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
