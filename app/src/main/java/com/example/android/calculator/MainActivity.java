package com.example.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.operand_1)
    EditText operand1;
    @BindView(R.id.operand_2)
    EditText operand2;
    @BindView(R.id.display)
    TextView display;
    @BindView(R.id.button_plus)
    Button plus;
    @BindView(R.id.button_minus)
    Button minus;
    @BindView(R.id.button_ori)
    Button ori;
    @BindView(R.id.button_divide)
    Button divide;
    @BindView(R.id.button_max)
    Button max;
    @BindView(R.id.button2_min)
    Button min;
    @BindView(R.id.button_abs)
    Button abs;
    @BindView(R.id.button_sqrt)
    Button sqrt;
    @BindView(R.id.button_signum)
    Button signum;
    @BindView(R.id.button_pow)
    Button pow;
    @BindView(R.id.button_hypot)
    Button hypot;
    @BindView(R.id.button_log)
    Button log;
    @BindView(R.id.button)
    Button zecBin;
    @BindView(R.id.button2)
    Button binZec;
    @BindView(R.id.button3)
    Button hexaZec;
    @BindView(R.id.button4)
    Button zecHexa;


    int op1;
    int op2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void getValuesOperands() {
        if (!operand1.getText().toString().isEmpty() && !operand2.getText().toString().isEmpty()) {
            op1 = (int) Double.parseDouble(operand1.getText().toString());
            op2 = (int) Double.parseDouble(operand2.getText().toString());
        }

    }

    public void buttonColor(Button b) {
        ArrayList<Button> allButtons = new ArrayList<Button>();
        allButtons.add(plus);
        allButtons.add(minus);
        allButtons.add(ori);
        allButtons.add(divide);

        allButtons.add(max);
        allButtons.add(min);
        allButtons.add(abs);
        allButtons.add(sqrt);

        allButtons.add(signum);
        allButtons.add(pow);
        allButtons.add(hypot);
        allButtons.add(log);

        allButtons.add(zecBin);
        allButtons.add(binZec);
        allButtons.add(hexaZec);
        allButtons.add(zecHexa);
        if (b.isPressed()) {
            b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            allButtons.remove(b);
        }
        for (Button a : allButtons) {
            a.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }


    @OnClick(R.id.button_plus)
    public void plus(View view) {
        buttonColor(plus);
        getValuesOperands();
        display.setText(" Rezultatul adunarii: " + (op1 + op2));
    }

    @OnClick(R.id.button_minus)
    public void minus(View view) {
        buttonColor(minus);
        getValuesOperands();
        display.setText(" Rezultatul scaderii: " + (op1 - op2));
    }

    @OnClick(R.id.button_ori)
    public void ori(View view) {
        buttonColor(ori);
        getValuesOperands();
        display.setText(" Rezultatul inmultirii: " + (op1 * op2));
    }

    @OnClick(R.id.button_divide)
    public void divide(View view) {
        buttonColor(divide);
        getValuesOperands();
        display.setText(" Rezultatul impartirii: " + (op1 / op2));
    }

    //
    @OnClick(R.id.button_max)
    public void max(View view) {
        buttonColor(max);
        getValuesOperands();
        display.setText(" Maximul: " + Math.max(op1, op2));
    }

    @OnClick(R.id.button2_min)
    public void min(View view) {
        buttonColor(min);
        getValuesOperands();
        display.setText(" Minimul: " + Math.min(op1, op2));
    }

    @OnClick(R.id.button_abs)
    public void abs(View view) {
        buttonColor(abs);
        getValuesOperands();
        display.setText(" Returns the absolute value of a double value: " + Math.abs(op1));
    }

    @OnClick(R.id.button_sqrt)
    public void sqrt(View view) {
        buttonColor(sqrt);
        getValuesOperands();
        display.setText(" Returns the correctly rounded positive square root of a double value: " + Math.sqrt(op1));

    }

    //
    @OnClick(R.id.button_signum)
    public void signum(View view) {
        buttonColor(signum);
        getValuesOperands();
        display.setText(" Returneaza 1 dc operandul este mai > decat 1, sau 0 dc e zero sau -1: " + Math.signum(op1));
    }


    @OnClick(R.id.button_pow)
    public void pow(View view) {
        buttonColor(pow);
        getValuesOperands();
        display.setText("Returns the value of the first argument raised to the power of the second argument: " + Math.pow(op1, op2));
    }

    @OnClick(R.id.button_hypot)
    public void hypot(View view) {
        buttonColor(hypot);
        getValuesOperands();
        display.setText("Returns sqrt(x2 +y2) without intermediate overflow or underflow: " + Math.hypot(op1, op2));
    }

    //
    @OnClick(R.id.button_log)
    public void log(View view) {
        buttonColor(log);
        getValuesOperands();
        display.setText("Returns the natural logarithm : " + Math.log(op1));
    }

    @OnClick(R.id.button)
    public void zecimalToBinary(View view) {
        buttonColor(zecBin);
        getValuesOperands();
        display.setText(Integer.toString((int) op1,2)+"");
    }

    @OnClick(R.id.button2)
    public void bin(View view) {
        buttonColor(binZec);
        getValuesOperands();
        String s=Integer.parseInt(String.valueOf(op1))+"";
        try{
        display.setText(Integer.parseInt(operand1.getText().toString(), 2)+" ");}catch (NumberFormatException e){
            display.setText("Numarul nu poate fi convertit");
        }
    }

    @OnClick(R.id.button3)
    public void hexa(View view) {
        buttonColor(hexaZec);
        getValuesOperands();
        try {
            display.setText(Integer.parseInt(String.valueOf(op1), 16) + "");
        }catch (NumberFormatException e){
            display.setText("Numarul nu poate fi convertit");
        }
    }

    @OnClick(R.id.button4)
    public void zech(View view) {
        buttonColor(zecHexa);
        getValuesOperands();
        String str = Integer.toHexString(op1);
        display.setText(str);
    }

}
