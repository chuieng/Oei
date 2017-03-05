package com.labo.code.ace.oei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private RadioGroup radioLanguageGroup;
    private RadioButton radioLanguageButton;
    private Button btnDisplay;

//    private ImageView malePic, femalePic;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

        malePic = (ImageView) findViewById(R.id.malePic);
        femalePic = (ImageView) findViewById(R.id.femalePic);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels/2;
        int width = displaymetrics.widthPixels/2;
        malePic.setMinimumWidth(width);
        femalePic.setMinimumWidth(width);
  */
    }

    /*
        public void clickedContinue(View view) {
            radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
            radioLanguageGroup = (RadioGroup) findViewById(R.id.radioLanguage);
            // get selected radio button from radioGroup
            int selectedId = radioSexGroup.getCheckedRadioButtonId();
            int selectedId2 = radioLanguageGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioSexButton = (RadioButton) findViewById(selectedId);
            radioLanguageButton = (RadioButton) findViewById(selectedId2);

            Intent i = new Intent(this, FamilyTree.class);
            i.putExtra("gender", radioSexButton.getText().toString());
            i.putExtra("language", radioLanguageButton.getText().toString());
            startActivity(i);
        }

    */
    public void maleSelected (View view){
        Intent i = new Intent(this, FamilyTree.class);
        i.putExtra("gender", "Male");
        i.putExtra("language", "Chinese");
        startActivity(i);
    }

    public void femaleSelected(View view){
        Intent i = new Intent(this, FamilyTree.class);
        i.putExtra("gender", "Female");
        i.putExtra("language", "Chinese");
        startActivity(i);

    }

}
