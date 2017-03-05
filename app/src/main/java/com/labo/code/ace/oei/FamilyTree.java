package com.labo.code.ace.oei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Chui Eng on 23/1/2016.
 */
public class FamilyTree extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s1, s2, s3;
    String gender;
    String language;
    TextView myText, firstText, secondText;
    ImageView who;


    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_tree);

        Intent myIntent = getIntent(); // gets the previously created intent
        gender = myIntent.getStringExtra("gender");
        language = myIntent.getStringExtra("language");

        who = (ImageView) findViewById(R.id.who);

        init();
        initSpinner1(); //Set 1st dropdown
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3125707977593776/1775701449");
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void init() {
        if ("Chinese".equalsIgnoreCase(language)) {
            myText = (TextView) findViewById(R.id.myText);
            firstText = (TextView) findViewById(R.id.firstText);
            secondText = (TextView) findViewById(R.id.secondText);
            myText.setText("我的");
            firstText.setText("的");
            secondText.setText("的");
        } else {
            myText = (TextView) findViewById(R.id.myText);
            firstText = (TextView) findViewById(R.id.firstText);
            secondText = (TextView) findViewById(R.id.secondText);
            myText.setText("My");
            firstText.setText("'s");
            secondText.setText("'s");
        }
    }

    public void initSpinner1() {
        s1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();

        if ("Chinese".equalsIgnoreCase(language)) {
            list.add("选择一项");
            list.add("爸爸");
            list.add("妈妈");
            list.add("哥哥");
            list.add("姐姐");
            list.add("弟弟");
            list.add("妹妹");
            //spouse
            if ("Female".equalsIgnoreCase(gender)) {
                list.add("老公");
            } else {
                list.add("老婆");
            }
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spinner1) {
            generateSpinner2Chinese();
        } else if (spinner.getId() == R.id.spinner2) {
            generateSpinner3Chinese();
        }

    }

    public void generateSpinner2Chinese() {
        String sp1 = String.valueOf(s1.getSelectedItem());
        //Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();

        //reset spinner
        List<String> reset = new ArrayList<String>();
        reset.add("选择一项");

        ArrayAdapter<String> resetDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, reset);
        resetDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resetDataAdapter.notifyDataSetChanged();
        s2.setAdapter(resetDataAdapter);
        s3.setAdapter(resetDataAdapter);


        if (sp1.contentEquals("爸爸")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("爸爸");
            list.add("妈妈");
            list.add("哥哥");
            list.add("姐姐");
            list.add("弟弟");
            list.add("妹妹");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("妈妈")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("爸爸");
            list.add("妈妈");
            list.add("哥哥");
            list.add("姐姐");
            list.add("弟弟");
            list.add("妹妹");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);

        } else if (sp1.contentEquals("哥哥")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("老婆");
            list.add("儿子");
            list.add("女儿");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("妹妹")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("老公");
            list.add("儿子");
            list.add("女儿");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("姐姐")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("老公");
            list.add("儿子");
            list.add("女儿");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("弟弟")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("老婆");
            list.add("儿子");
            list.add("女儿");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("老公")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("爸爸");
            list.add("妈妈");
            list.add("哥哥");
            list.add("姐姐");
            list.add("弟弟");
            list.add("妹妹");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        } else if (sp1.contentEquals("老婆")) {
            List<String> list = new ArrayList<String>();
            list.add("选择一项");
            list.add("爸爸");
            list.add("妈妈");
            list.add("哥哥");
            list.add("姐姐");
            list.add("弟弟");
            list.add("妹妹");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
    }

    public void generateSpinner3Chinese() {
        String sp1 = String.valueOf(s1.getSelectedItem());
        //reset spinner 3
        List<String> reset = new ArrayList<String>();
        reset.add("选择一项");

        ArrayAdapter<String> resetDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, reset);
        resetDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resetDataAdapter.notifyDataSetChanged();
        s3.setAdapter(resetDataAdapter);

        String sp2 = String.valueOf(s2.getSelectedItem());
        // Toast.makeText(this, sp2, Toast.LENGTH_SHORT).show();
        if (sp2.contentEquals("爸爸")) {
            List<String> list = new ArrayList<String>();

            if (sp1.contentEquals("老婆") || sp1.contentEquals("老公")) {
                list.add("-");
            } else {
                list.add("选择一项");
                list.add("哥哥");
                list.add("姐姐");
                list.add("弟弟");
                list.add("妹妹");
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        } else if (sp2.contentEquals("妈妈")) {
            List<String> list = new ArrayList<String>();
            //list.add("选择一项");
            list.add("-");
            //list.add("哥哥");
            //list.add("姐姐");
            //list.add("弟弟");
            //list.add("妹妹");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);

        } else if (sp2.contentEquals("哥哥")) {

            List<String> list = new ArrayList<String>();

            if (sp1.contentEquals("老婆") || sp1.contentEquals("老公")) {
                list.add("-");
            } else {
                list.add("选择一项");
                list.add("老婆");
                list.add("儿子");
                list.add("女儿");
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        } else if (sp2.contentEquals("妹妹")) {
            List<String> list = new ArrayList<String>();
            if (sp1.contentEquals("老婆") || sp1.contentEquals("老公")) {
                list.add("-");
            } else {
                list.add("选择一项");
                list.add("老公");
                list.add("儿子");
                list.add("女儿");
            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        } else if (sp2.contentEquals("姐姐")) {
            List<String> list = new ArrayList<String>();
            if (sp1.contentEquals("老婆") || sp1.contentEquals("老公")) {
                list.add("-");
            } else {

                list.add("选择一项");
                list.add("老公");
                list.add("儿子");
                list.add("女儿");
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        } else if (sp2.contentEquals("弟弟")) {
            List<String> list = new ArrayList<String>();

            if (sp1.contentEquals("老婆") || sp1.contentEquals("老公")) {
                list.add("-");
            } else {

                list.add("选择一项");
                list.add("老婆");
                list.add("儿子");
                list.add("女儿");
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        } else if (sp2.contentEquals("老婆") || sp2.contentEquals("老公") || sp2.contentEquals("儿子") || sp2.contentEquals("女儿")) {
            List<String> list = new ArrayList<String>();
            list.add("-");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s3.setAdapter(dataAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void answer(View view) {
        TextView answer = (TextView) findViewById(R.id.ansTextView);
        String sp1 = String.valueOf(s1.getSelectedItem());
        String sp2 = String.valueOf(s2.getSelectedItem());
        String sp3 = String.valueOf(s3.getSelectedItem());

        //TODO get answer
        if ("Chinese".equalsIgnoreCase(language)) {
            if ("爸爸".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.man);
                answer.setText("爸爸");

                if ("爸爸".equalsIgnoreCase(sp2)) {
                    answer.setText("爷爷");
                    who.setBackgroundResource(R.drawable.old_man);

                    if ("哥哥".equalsIgnoreCase(sp3)) {
                        answer.setText("伯公");
                        who.setBackgroundResource(R.drawable.old_man2);
                    } else if ("姐姐".equalsIgnoreCase(sp3)) {
                        answer.setText("姑婆");
                        who.setBackgroundResource(R.drawable.old_lady);
                    } else if ("弟弟".equalsIgnoreCase(sp3)) {
                        answer.setText("叔公");
                        who.setBackgroundResource(R.drawable.man4);
                    } else if ("妹妹".equalsIgnoreCase(sp3)) {
                        answer.setText("姑婆");
                        who.setBackgroundResource(R.drawable.old_lady2);
                    }

                } else if ("妈妈".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_lady2);
                    answer.setText("奶奶");

                } else if ("哥哥".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man2);
                    answer.setText("伯伯");

                    if ("老婆".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman);
                        answer.setText("伯娘");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.male_kid);
                        answer.setText("堂哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.female_kid);
                        answer.setText("堂姐/妹");

                    }

                } else if ("姐姐".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman2);
                    answer.setText("姑妈");

                    if ("老公".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man3);
                        answer.setText("姑丈");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.male_kid2);
                        answer.setText("表哥/弟");

                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.female_kid2);
                        answer.setText("表姐/妹");
                    }

                } else if ("弟弟".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man);
                    answer.setText("叔叔");
                    if ("老婆".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman3);
                        answer.setText("婶婶");

                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.male_kid3);
                        answer.setText("堂哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman4);
                        answer.setText("堂姐/妹");
                    }

                } else if ("妹妹".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman);
                    answer.setText("姑姑");
                    if ("老公".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man3);
                        answer.setText("姑丈");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man);
                        answer.setText("表哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.female_kid3);
                        answer.setText("表姐/妹");
                    }

                }
               /*
                else if ("".equalsIgnoreCase(sp2)) {
                    answer.setText("");

                } else if ("".equalsIgnoreCase(sp2)) {
                    answer.setText("");

                } else if ("".equalsIgnoreCase(sp2)) {
                    answer.setText("");

                }
*/
            } else if ("妈妈".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.woman5);
                answer.setText("妈妈");

                if ("爸爸".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_man2);
                    answer.setText("外公");
                    if ("哥哥".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man4);
                        answer.setText("舅公");
                    } else if ("姐姐".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman2);
                        answer.setText("姨婆");
                    } else if ("弟弟".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man2);
                        answer.setText("舅公");
                    } else if ("妹妹".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman4);
                        answer.setText("姨婆");
                    }

                } else if ("妈妈".equalsIgnoreCase(sp2)) {
                    answer.setText("外婆");
                    who.setBackgroundResource(R.drawable.old_lady2);

                } else if ("哥哥".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man3);
                    answer.setText("舅舅");

                    if ("老婆".equalsIgnoreCase(sp3)) {
                        answer.setText("舅妈/舅母");
                        who.setBackgroundResource(R.drawable.woman);
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        answer.setText("表哥/弟");
                        who.setBackgroundResource(R.drawable.male_kid);
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman3);
                        answer.setText("表姐/妹");
                    }

                } else if ("姐姐".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman4);
                    answer.setText("阿姨");
                    if ("老公".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man2);
                        answer.setText("姨丈");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man3);
                        answer.setText("表哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.female_kid3);
                        answer.setText("表姐/妹");
                    }

                } else if ("弟弟".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man);
                    answer.setText("舅舅");

                    if ("老婆".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.woman2);
                        answer.setText("舅妈/舅母");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.male_kid);
                        answer.setText("表哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        answer.setText("表姐/妹");
                        who.setBackgroundResource(R.drawable.female_kid);
                    }

                } else if ("妹妹".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman5);
                    answer.setText("阿姨");
                    if ("老公".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.man3);
                        answer.setText("姨丈");
                    } else if ("儿子".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.male_kid2);
                        answer.setText("表哥/弟");
                    } else if ("女儿".equalsIgnoreCase(sp3)) {
                        who.setBackgroundResource(R.drawable.female_kid2);
                        answer.setText("表姐/妹");

                    }

                }

            } else if ("哥哥".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.man2);
                answer.setText("哥哥");

                if ("老婆".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman3);
                    answer.setText("嫂子");
                } else if ("儿子".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.male_kid3);
                    answer.setText("侄儿");
                } else if ("女儿".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.female_kid3);
                    answer.setText("侄女");
                }

            } else if ("姐姐".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.woman);
                answer.setText("姐姐");

                if ("老公".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man4);
                    answer.setText("姐夫");
                } else if ("儿子".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.male_kid);
                    answer.setText("外甥");
                } else if ("女儿".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.female_kid2);
                    answer.setText("外甥女");
                }
            } else if ("弟弟".equalsIgnoreCase(sp1)) {
                answer.setText("弟弟");
                who.setBackgroundResource(R.drawable.man3);
                if ("老婆".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman4);
                    answer.setText("弟妹");
                } else if ("儿子".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.male_kid3);
                    answer.setText("侄儿");
                } else if ("女儿".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.female_kid);
                    answer.setText("侄女");
                }
            } else if ("妹妹".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.woman3);
                answer.setText("妹妹");
                if ("老公".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man2);
                    answer.setText("妹夫");
                } else if ("儿子".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.male_kid2);
                    answer.setText("外甥");
                } else if ("女儿".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.female_kid3);
                    answer.setText("外甥女");
                }
            } else if ("老公".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.man);
                answer.setText("老公");
                if ("爸爸".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_man);
                    answer.setText("公公");
                } else if ("妈妈".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_lady2);
                    answer.setText("婆婆");
                } else if ("哥哥".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man4);
                    answer.setText("大伯");
                } else if ("姐姐".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman5);
                    answer.setText("大姑");
                } else if ("弟弟".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man3);
                    answer.setText("小叔");
                } else if ("妹妹".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman4);
                    answer.setText("小姑");
                }


            } else if ("老婆".equalsIgnoreCase(sp1)) {
                who.setBackgroundResource(R.drawable.woman2);
                answer.setText("老婆");
                if ("爸爸".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_man2);
                    answer.setText("岳父");
                } else if ("妈妈".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.old_lady);
                    answer.setText("岳母");
                } else if ("哥哥".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man2);
                    answer.setText("大舅");
                } else if ("姐姐".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman3);
                    answer.setText("大姨");
                } else if ("弟弟".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.man);
                    answer.setText("小舅");
                } else if ("妹妹".equalsIgnoreCase(sp2)) {
                    who.setBackgroundResource(R.drawable.woman4);
                    answer.setText("小姨");
                }

            }
        }


        //end chinese

        else {//english

        }

    }


}
