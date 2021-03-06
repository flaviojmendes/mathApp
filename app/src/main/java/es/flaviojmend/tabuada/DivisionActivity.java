package es.flaviojmend.tabuada;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import es.flaviojmend.tabuada.components.HandwrittenTextView;
import es.flaviojmend.tabuada.model.PontuationModel;

public class DivisionActivity extends AppCompatActivity implements View.OnClickListener{


    public static final int MAX_LIMIT = 10;
    public static final int SUM_MAX_LIMIT = MAX_LIMIT;
    public static final int MIN_LIMIT = 1;
    private int num1;
    private int num2;
    private int result;

    HandwrittenTextView num1Text;
    HandwrittenTextView num2Text;


    HandwrittenTextView rights;
    HandwrittenTextView wrongs;
    HandwrittenTextView pontuation;

    private RelativeLayout result1;
    private RelativeLayout result2;
    private RelativeLayout result3;
    private RelativeLayout result4;

    HandwrittenTextView result1Text;
    HandwrittenTextView result2Text;
    HandwrittenTextView result3Text;
    HandwrittenTextView result4Text;

    RelativeLayout resultPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        setSignalParams();
        this.num1Text = (HandwrittenTextView) findViewById(R.id.num1);
        this.num2Text = (HandwrittenTextView) findViewById(R.id.num2);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        this.rights = (HandwrittenTextView) findViewById(R.id.rights);
        this.wrongs = (HandwrittenTextView) findViewById(R.id.wrongs);
        this.pontuation = (HandwrittenTextView) findViewById(R.id.pontuation);

        rights.setText(preferences.getInt(PontuationModel.divisionsRight, 0)+"");
        wrongs.setText(preferences.getInt(PontuationModel.divisionsWrong, 0)+"");
        pontuation.setText((preferences.getInt(PontuationModel.divisionsRight, 0) - preferences.getInt(PontuationModel.divisionsWrong, 0))+"");


        num1 = ThreadLocalRandom.current().nextInt(MIN_LIMIT, MAX_LIMIT);
        num2 = ThreadLocalRandom.current().nextInt(MIN_LIMIT, MAX_LIMIT);
        result = num1 / num2;
        while(num1 % num2 != 0) {
            num1 = ThreadLocalRandom.current().nextInt(MIN_LIMIT, MAX_LIMIT);
            num2 = ThreadLocalRandom.current().nextInt(MIN_LIMIT, MAX_LIMIT);
            result = num1 / num2;
        }

        num1Text.setText(num1+"");
        num2Text.setText(num2+"");


        result1 = (RelativeLayout) findViewById(R.id.result1);
        result1.setOnClickListener(this);
        result2 = (RelativeLayout) findViewById(R.id.result2);
        result2.setOnClickListener(this);
        result3 = (RelativeLayout) findViewById(R.id.result3);
        result3.setOnClickListener(this);
        result4 = (RelativeLayout) findViewById(R.id.result4);
        result4.setOnClickListener(this);

        result1Text = (HandwrittenTextView) findViewById(R.id.result1Text);
        result2Text = (HandwrittenTextView) findViewById(R.id.result2Text);
        result3Text = (HandwrittenTextView) findViewById(R.id.result3Text);
        result4Text = (HandwrittenTextView) findViewById(R.id.result4Text);

        resultPopup = (RelativeLayout) findViewById(R.id.result_popup);
        resultPopup.setOnClickListener(this);

        populateResults();



    }

    private void setSignalParams() {
        ((HandwrittenTextView) findViewById(R.id.signal)).setText(getString(R.string.division_signal));
        ((HandwrittenTextView) findViewById(R.id.signal)).setTextColor(getColor(R.color.divisionMainColor));
    }

    private void populateResults() {
        ArrayList<HandwrittenTextView> resultsList = new ArrayList<>();
        resultsList.add(result1Text);
        resultsList.add(result2Text);
        resultsList.add(result3Text);
        resultsList.add(result4Text);
        boolean resultPut = false;
        for(HandwrittenTextView txt : resultsList) {
            if (!resultPut &&
                    (ThreadLocalRandom.current().nextBoolean() || resultsList.indexOf(txt) == resultsList.size()-1)) {
                txt.setText(result+"");
                resultPut = true;
            } else {
                txt.setText(ThreadLocalRandom.current().nextInt(MIN_LIMIT, SUM_MAX_LIMIT)+"");
            }
        }

    }

    @Override
    public void onClick(View view) {

        HandwrittenTextView txtResult = (HandwrittenTextView) findViewById(R.id.result_text);
        ImageView imgResult = (ImageView) findViewById(R.id.result_icon);



        switch (view.getId()) {

            case R.id.result1:
                evaluateResult((RelativeLayout) view, txtResult, imgResult);
                break;
            case R.id.result2:
                evaluateResult((RelativeLayout) view, txtResult, imgResult);
                break;
            case R.id.result3:
                evaluateResult((RelativeLayout) view, txtResult, imgResult);
                break;
            case R.id.result4:
                evaluateResult((RelativeLayout) view, txtResult, imgResult);
                break;
            case R.id.result_popup:
                Intent intentNext = new Intent(this, DivisionActivity.class);
                startActivity(intentNext);

                break;

        }
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    private void evaluateResult(RelativeLayout view, HandwrittenTextView txtResult, ImageView imgResult) {
        int value = Integer.parseInt(((HandwrittenTextView) view.getChildAt(0)).getText().toString());

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


        if(value == result) {
            txtResult.setText(getString(R.string.right));
            imgResult.setImageDrawable(getDrawable(R.drawable.ic_right));

            int divisionsRight = preferences.getInt(PontuationModel.divisionsRight, 0);
            divisionsRight += 1;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(PontuationModel.divisionsRight, divisionsRight);
            editor.apply();


        } else {
            txtResult.setText(getString(R.string.wrong));
            imgResult.setImageDrawable(getDrawable(R.drawable.ic_wrong));

            int divisionsWrong = preferences.getInt(PontuationModel.divisionsWrong, 0);
            divisionsWrong += 1;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(PontuationModel.divisionsWrong, divisionsWrong);
            editor.apply();
        }
        animate();
        new Timer().schedule(new TimerTask(){
            public void run() {
                DivisionActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Intent intentNext = new Intent(DivisionActivity.this, DivisionActivity.class);
                        startActivity(intentNext);
                    }
                });
            }
        }, 2000);


    }

    private void animate() {
        resultPopup.setVisibility(View.VISIBLE);
        // Prepare the View for the animation
        resultPopup.setVisibility(View.VISIBLE);
        resultPopup.setAlpha(0.0f);
        // Start the animation
        resultPopup.animate()
                .translationY(resultPopup.getHeight())
                .alpha(1.0f);
    }

}
