package com.example.a1039_jay.myapplication;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    private Button button; //抽一個
    private Button button2; //全部清除
    private Button button3; //加入
    private Button button4;//傳LINE
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private Map<String, String> psItemsMap = new HashMap<String, String>(); //全部項目
    private Map<String, String> playerMap = new HashMap<String, String>(); // 全部球員
    private int nextNumber = 1; //下一個要抽的人
    private int totalPlayCount = 0; //全部球員數
    private TextView textViewT; //全部統計
    private boolean notifyFlag;
    private int goodInt;
    private int badInt;
    private int notThingInt;
    private Button add1;
    private Button add2;
    private TextView score1;
    private int scoreInt1;
    private int scoreInt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        add1 = (Button) findViewById(R.id.add1);
        add2 = (Button) findViewById(R.id.add2);
        button3.setEnabled(true);
        button4 = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textViewT = (TextView) findViewById(R.id.textViewT);
        score1 = (TextView) findViewById(R.id.score1);

        Bundle bundle = this.getIntent().getExtras();
        String play1 = bundle.get("play1").toString();
        String play2 = bundle.get("play2").toString();
        String play3 = bundle.get("play3").toString();
        String play4 = bundle.get("play4").toString();
        String play5 = bundle.get("play5").toString();
        String play6 = bundle.get("play6").toString();
        String play7 = bundle.get("play7").toString();
        String play8 = bundle.get("play8").toString();
        String play9 = bundle.get("play9").toString();
        String play10 = bundle.get("play10").toString();
        notifyFlag = bundle.getBoolean("notifyFlag");

        int count = 0;
        if (!"none".equals(play1)) {
            playerMap.put("1", play1);
            textView1.setText(play1 + ":");
            totalPlayCount++;
        } else {
            textView1.setText("");
        }
        if (!"none".equals(play2)) {
            playerMap.put("2", play2);
            textView2.setText(play2 + ":");
            totalPlayCount++;
        } else {
            textView2.setText("");
        }
        if (!"none".equals(play3)) {
            playerMap.put("3", play3);
            textView3.setText(play3 + ":");
            totalPlayCount++;
        } else {
            textView3.setText("");
        }
        if (!"none".equals(play4)) {
            playerMap.put("4", play4);
            textView4.setText(play4 + ":");
            totalPlayCount++;
        } else {
            textView4.setText("");
        }
        if (!"none".equals(play5)) {
            playerMap.put("5", play5);
            textView5.setText(play5 + ":");
            totalPlayCount++;
        } else {
            textView5.setText("");
        }
        if (!"none".equals(play6)) {
            playerMap.put("6", play6);
            textView6.setText(play6 + ":");
            totalPlayCount++;
        } else {
            textView6.setText("");
        }
        if (!"none".equals(play7)) {
            playerMap.put("7", play7);
            textView7.setText(play7 + ":");
            totalPlayCount++;
        } else {
            textView7.setText("");
        }
        if (!"none".equals(play8)) {
            playerMap.put("8", play8);
            textView8.setText(play8 + ":");
            totalPlayCount++;
        } else {
            textView8.setText("");
        }
        if (!"none".equals(play9)) {
            playerMap.put("9", play9);
            textView9.setText(play9 + ":");
            totalPlayCount++;
        } else {
            textView9.setText("");
        }
        if (!"none".equals(play10)) {
            playerMap.put("10", play10);
            textView10.setText(play10 + ":");
            totalPlayCount++;
        } else {
            textView10.setText("");
        }

        if (playerMap.size() == 10) {
            button3.setEnabled(false);
        }

        // good
        psItemsMap.put("0", "G1:投手往後一步(正常步伐)");
        psItemsMap.put("2", "G2:擦棒被補不死");
        psItemsMap.put("4", "G3:投手原地先轉7圈, 立即投球");
        psItemsMap.put("6", "G4:選擇一個守備人員被石化, 不能移動, 但可以守備");
        psItemsMap.put("8", "G5:無法雙殺");
        psItemsMap.put("10", "G6:好球帶可轉45度");
        psItemsMap.put("12", "G7:打者0好2壞開始");
        psItemsMap.put("14", "G8:打到邊框不算好球");
        psItemsMap.put("16", "G9:壘球式投法");
        psItemsMap.put("18", "G10:得點圈有打跑者,隨時可選擇更換代打, 不影響棒次");
        psItemsMap.put("22", "G11:投手伏地挺身3下");
        psItemsMap.put("24", "G12:觸身球直接保送");
        psItemsMap.put("26", "G13:揮棒落空記1好1壞");
        psItemsMap.put("28", "G14:守備方只能用走的守備,用跑的接殺不算");
        psItemsMap.put("30", "G15:打者是陳金鋒,投手跪著投球");

        // bad
        psItemsMap.put("1", "B1:換成左打");
        psItemsMap.put("3", "B2:球棒拿反的打+單手擊球");
        psItemsMap.put("5", "B3:投手往前一步(正常步伐)");
        psItemsMap.put("7", "B4:打者原地轉7圈, 立即打擊");
        psItemsMap.put("9", "B5:整個球架+好球帶都是好球");
        psItemsMap.put("11", "B6:彈地球也算好球");
        psItemsMap.put("13", "B7:打者1好0壞開始");
        psItemsMap.put("15", "B8:分身投球(找一名隊友協助)");
        psItemsMap.put("17", "B9:朱鴻森式打擊");
        psItemsMap.put("19", "B10:打去出要跑壘, 守方要踩壘捉出局(會放一壘,只需跑一壘)");
        psItemsMap.put("23", "B11:打者伏地挺身3下");
        psItemsMap.put("25", "B12:揮棒落空記1好, 並減1壞, 如沒壞則不扣");
        psItemsMap.put("27", "B13:投手是神, 打者跪著打球");
        psItemsMap.put("29", "B14:守備方漏接一個彈跳內都算safe");
        psItemsMap.put("31", "B15:打者夾著著二顆球,球落地記1好");

        //normal
        psItemsMap.put("20", "N1:沒有任何事情發生");
        psItemsMap.put("21", "N1:沒有任何事情發生");
        psItemsMap.put("32", "N1:沒有任何事情發生");

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreInt1++;
                StringBuffer testS = new StringBuffer("本");
                testS.append(scoreInt1);
                testS.append(":敵");
                testS.append(scoreInt2);
                score1.setText(testS.toString());
            }
        });

        add1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                scoreInt1--;
                StringBuffer testS = new StringBuffer("本");
                testS.append(scoreInt1);
                testS.append(":敵");
                testS.append(scoreInt2);
                score1.setText(testS.toString());
                return true;
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreInt2++;
                StringBuffer testS = new StringBuffer("本");
                testS.append(scoreInt1);
                testS.append(":敵");
                testS.append(scoreInt2);
                score1.setText(testS.toString());
            }
        });

        add2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                scoreInt2--;
                StringBuffer testS = new StringBuffer("本");
                testS.append(scoreInt1);
                testS.append(":敵");
                testS.append(scoreInt2);
                score1.setText(testS.toString());
                return true;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("請按按鈕!");
                textViewT.setText("");
                score1.setText("本0:敵0");
                scoreInt1 = 0;
                scoreInt2 = 0;
                nextNumber = 1;
                goodInt = 0;
                badInt = 0;
                notThingInt = 0;
                if (playerMap.containsKey("1")) {
                    textView1.setText(playerMap.get("1") + ":");
                } else {
                    textView1.setText("");
                }
                if (playerMap.containsKey("2")) {
                    textView2.setText(playerMap.get("2") + ":");
                } else {
                    textView2.setText("");
                }
                if (playerMap.containsKey("3")) {
                    textView3.setText(playerMap.get("3") + ":");
                } else {
                    textView3.setText("");
                }
                if (playerMap.containsKey("4")) {
                    textView4.setText(playerMap.get("4") + ":");
                } else {
                    textView4.setText("");
                }
                if (playerMap.containsKey("5")) {
                    textView5.setText(playerMap.get("5") + ":");
                } else {
                    textView5.setText("");
                }
                if (playerMap.containsKey("6")) {
                    textView6.setText(playerMap.get("6") + ":");
                } else {
                    textView6.setText("");
                }
                if (playerMap.containsKey("7")) {
                    textView7.setText(playerMap.get("7") + ":");
                } else {
                    textView7.setText("");
                }
                if (playerMap.containsKey("8")) {
                    textView8.setText(playerMap.get("8") + ":");
                } else {
                    textView8.setText("");
                }
                if (playerMap.containsKey("9")) {
                    textView9.setText(playerMap.get("9") + ":");
                } else {
                    textView9.setText("");
                }
                if (playerMap.containsKey("10")) {
                    textView10.setText(playerMap.get("10") + ":");
                } else {
                    textView10.setText("");
                }
                textView1.setBackgroundColor(Color.WHITE);
                textView2.setBackgroundColor(Color.WHITE);
                textView3.setBackgroundColor(Color.WHITE);
                textView4.setBackgroundColor(Color.WHITE);
                textView5.setBackgroundColor(Color.WHITE);
                textView6.setBackgroundColor(Color.WHITE);
                textView7.setBackgroundColor(Color.WHITE);
                textView8.setBackgroundColor(Color.WHITE);
                textView9.setBackgroundColor(Color.WHITE);
                textView10.setBackgroundColor(Color.WHITE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLine();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Random r = new Random();
                                          int i = r.nextInt(psItemsMap.size());
                                          if (psItemsMap.containsKey(Integer.toString(i))) {
                                              String code = (psItemsMap.get(Integer.toString(i)).split(":"))[0];
                                              textView.setText(psItemsMap.get(Integer.toString(i)));

                                              if (nextNumber > totalPlayCount) {
                                                  nextNumber = 1;
                                              }

                                              notifyMessage(playerMap.get(String.valueOf(nextNumber)) + ":" + psItemsMap.get(Integer.toString(i)));

                                              if (code.matches("G.+")) {
                                                  showDialog("恭禧你", psItemsMap.get(Integer.toString(i)), playerMap.get(String.valueOf(nextNumber + 1 > totalPlayCount ? 1 : nextNumber + 1)));
                                              } else if (code.matches("B.+")) {
                                                  showDialog("很抱歉", psItemsMap.get(Integer.toString(i)), playerMap.get(String.valueOf(nextNumber + 1 > totalPlayCount ? 1 : nextNumber + 1)));
                                              } else {
                                                  showDialog("沒事的", psItemsMap.get(Integer.toString(i)), playerMap.get(String.valueOf(nextNumber + 1 > totalPlayCount ? 1 : nextNumber + 1)));
                                              }

                                              calInt(code);
                                              if (nextNumber == 1) {
                                                  textView1.setText(textView1.getText() + code + " ");
                                              }
                                              if (nextNumber == 2) {
                                                  textView2.setText(textView2.getText() + code + " ");
                                              }
                                              if (nextNumber == 3) {
                                                  textView3.setText(textView3.getText() + code + " ");
                                              }
                                              if (nextNumber == 4) {
                                                  textView4.setText(textView4.getText() + code + " ");
                                              }
                                              if (nextNumber == 5) {
                                                  textView5.setText(textView5.getText() + code + " ");
                                              }
                                              if (nextNumber == 6) {
                                                  textView6.setText(textView6.getText() + code + " ");
                                              }
                                              if (nextNumber == 7) {
                                                  textView7.setText(textView7.getText() + code + " ");
                                              }
                                              if (nextNumber == 8) {
                                                  textView8.setText(textView8.getText() + code + " ");
                                              }
                                              if (nextNumber == 9) {
                                                  textView9.setText(textView9.getText() + code + " ");
                                              }
                                              if (nextNumber == 10) {
                                                  textView10.setText(textView10.getText() + code + " ");
                                              }
                                              nextNumber++;

                                              textViewT.setText("");
                                              StringBuffer sb2 = new StringBuffer();
                                              sb2.append("好:");
                                              sb2.append(goodInt);
                                              sb2.append("  壞:");
                                              sb2.append(badInt);
                                              sb2.append("  沒事:");
                                              sb2.append(notThingInt);
                                              textViewT.setText(sb2.toString());
                                          }
                                      }
                                  }
        );
    }

    private void showLine() {
        if (checkLineInstalled()) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setClassName(PACKAGE_NAME, CLASS_NAME);
            intent.setType("text/plain");
            StringBuffer sb = new StringBuffer();
            sb.append("日期:\n");
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(Calendar.getInstance().getTime());
            sb.append(date1);
            sb.append("\n\n");
            sb.append("本隊成員:\n");
            for (Map.Entry<String, String> entryTemp : playerMap.entrySet()) {
                sb.append(entryTemp.getValue().toString());
                sb.append(" ");
            }
            sb.append("\n\n分數:\n");
            sb.append(score1.getText());
            sb.append("\n\n");

            String theBadName = "";
            int theBadCount = 0;
            if (!"".equals(textView1.getText())) {
                sb.append(textView1.getText());
                sb.append("\n");
                int badCount = calBadInt(textView1.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("1");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("1");
                }
            }
            if (!"".equals(textView2.getText())) {
                sb.append(textView2.getText());
                sb.append("\n");
                int badCount = calBadInt(textView2.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("2");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("2");
                }
            }
            if (!"".equals(textView3.getText())) {
                sb.append(textView3.getText());
                sb.append("\n");
                int badCount = calBadInt(textView3.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("3");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("3");
                }
            }
            if (!"".equals(textView4.getText())) {
                sb.append(textView4.getText());
                sb.append("\n");
                int badCount = calBadInt(textView4.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("4");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("4");
                }
            }
            if (!"".equals(textView5.getText())) {
                sb.append(textView5.getText());
                sb.append("\n");
                int badCount = calBadInt(textView5.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("5");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("5");
                }
            }
            if (!"".equals(textView6.getText())) {
                sb.append(textView6.getText());
                sb.append("\n");
                int badCount = calBadInt(textView6.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("6");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("6");
                }
            }
            if (!"".equals(textView7.getText())) {
                sb.append(textView7.getText());
                sb.append("\n");
                int badCount = calBadInt(textView7.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("7");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("7");
                }
            }
            if (!"".equals(textView8.getText())) {
                sb.append(textView8.getText());
                sb.append("\n");
                int badCount = calBadInt(textView8.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("8");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("8");
                }
            }
            if (!"".equals(textView9.getText())) {
                sb.append(textView9.getText());
                sb.append("\n");
                int badCount = calBadInt(textView9.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("9");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("9");
                }
            }
            if (!"".equals(textView10.getText())) {
                sb.append(textView10.getText());
                sb.append("\n");
                int badCount = calBadInt(textView10.getText().toString().split(":")[1]);
                if (badCount > theBadCount) {
                    theBadName = playerMap.get("10");
                    theBadCount = badCount;
                } else if (badCount == theBadCount) {
                    theBadName += playerMap.get("10");
                }
            }
            sb.append("\n\n\n本日最衰:");
            sb.append("\n*****************\n");
            sb.append(theBadName);
            sb.append("\n*****************");

            intent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            startActivity(intent);
        }
    }

    private void showDialog(String title, String message, String nextPlayer) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle(title);
        dialog.setMessage(message + "\n\n下一棒:" + nextPlayer);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    private void showAlert() {
        LinearLayout alertLayout = new LinearLayout(MainActivity.this);
        alertLayout.setOrientation(LinearLayout.HORIZONTAL);
        alertLayout.setPadding(100, 50, 100, 50);
        TextView textViewTemp = new TextView(MainActivity.this);
        textViewTemp.setText("球員名字");
        textViewTemp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final Spinner spinnerTemp = new Spinner(MainActivity.this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        spinnerTemp.setAdapter(adapter);
        alertLayout.addView(textViewTemp);
        alertLayout.addView(spinnerTemp);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("加入");
        dialog.setView(alertLayout);

        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectStr = spinnerTemp.getSelectedItem().toString();
                if (!"none".equals(selectStr)) {
                    totalPlayCount++;
                    playerMap.put(String.valueOf(totalPlayCount), selectStr);
                    if (totalPlayCount == 1) {
                        textView1.setText(selectStr + ":");
                    } else if (totalPlayCount == 2) {
                        textView2.setText(selectStr + ":");
                    } else if (totalPlayCount == 3) {
                        textView3.setText(selectStr + ":");
                    } else if (totalPlayCount == 4) {
                        textView4.setText(selectStr + ":");
                    } else if (totalPlayCount == 5) {
                        textView5.setText(selectStr + ":");
                    } else if (totalPlayCount == 6) {
                        textView6.setText(selectStr + ":");
                    } else if (totalPlayCount == 7) {
                        textView7.setText(selectStr + ":");
                    } else if (totalPlayCount == 8) {
                        textView8.setText(selectStr + ":");
                    } else if (totalPlayCount == 9) {
                        textView9.setText(selectStr + ":");
                    } else if (totalPlayCount == 10) {
                        textView10.setText(selectStr + ":");
                    }

                    if (playerMap.size() == 10) {
                        button3.setEnabled(false);
                    }
                }
            }
        });

        dialog.create().show();
    }

    private void notifyMessage(String message) {
        if (notifyFlag) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("HyWeb Wiffle")
                    .setContentText(message);
            Notification notification = builder.build();
            notificationManager.notify(0, notification);
        }
    }

    private boolean checkLineInstalled() {
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> m_appList = pm.getInstalledApplications(0);
        boolean lineInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if (ai.packageName.equals(PACKAGE_NAME)) {
                lineInstallFlag = true;
                break;
            }
        }
        return lineInstallFlag;
    }

    private void calInt(String code) {
        if (code.matches("G.+")) {
            goodInt++;
        } else if (code.matches("B.+")) {
            badInt++;
        } else {
            notThingInt++;
        }
    }

    private int calBadInt(String records) {
        return records.split("B").length;
    }
}
