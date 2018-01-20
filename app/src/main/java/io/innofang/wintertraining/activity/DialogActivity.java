package io.innofang.wintertraining.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.innofang.wintertraining.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_dialog_button:
                showDialog();
                break;
            case R.id.show_custom_dialog_button:
                showCustomDialog();
                break;
            case R.id.show_list_dialog_button:
                showListDialog();
                break;
            case R.id.show_single_choice_dialog_button:
                showSingleChoiceDialog();
                break;
            case R.id.show_multi_choice_dialog_button:
                showMultiChoiceDialog();
                break;
        }
    }

    private void showMultiChoiceDialog() {
        final String[] items = {"Basketball", "Swimming", "Soccer", "Climbing"};
        final boolean[] isChecked = {true, false, true, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Hobby")
                .setMultiChoiceItems(items, isChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String text = isChecked ? "You select " + items[which]
                                : "You cancel " + items[which];
                        Toast.makeText(DialogActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void showSingleChoiceDialog() {
        final String[] grade = {"Freshman", "Sophomore", "Junior", "Senior"};
        final String[] item = new String[1];
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Grade")
                .setSingleChoiceItems(grade, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        item[0] = grade[which];
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, item[0], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void showListDialog() {
        final String[] items = new String[]{"Basketball", "Swimming", "Soccer", "Climbing"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Hobby")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = items[which];
                        Toast.makeText(DialogActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void showCustomDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_custom_dialog, null, false);
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Custom Dialog")
                .setView(view)
                .show();

        final EditText input = view.findViewById(R.id.input_edit_text);
        view.findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = input.getText().toString();
                Toast.makeText(DialogActivity.this, text, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    private void showDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("This is title")
                .setMessage("This is message, a long message, a long long message")
                .setIcon(R.mipmap.ic_launcher_round)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
