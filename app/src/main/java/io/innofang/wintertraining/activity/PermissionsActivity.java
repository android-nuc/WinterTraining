package io.innofang.wintertraining.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import io.innofang.wintertraining.R;
import io.innofang.wintertraining.utils.RequestPermissions;

public class PermissionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

    }

    public void onClick(View view) {

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
//        } else {
//            Toast.makeText(this, "Camera Permission is Granted", Toast.LENGTH_SHORT).show();
//        }

        /*List<String> permissions = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.RECORD_AUDIO);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.CAMERA);
        }



        if (!permissions.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissions.toArray(new String[permissions.size()]),
                    1);
        } else {
            Toast.makeText(this, "All Permission is Granted", Toast.LENGTH_SHORT).show();
        }*/

        RequestPermissions.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA},
                new RequestPermissions.OnRequestPermissionsListener() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(PermissionsActivity.this, "All permissions is granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {
                        for (String s : deniedPermission) {
                            Toast.makeText(PermissionsActivity.this, s + " is denied", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Camera Permission is Granted", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Camera Permission is Denied", Toast.LENGTH_SHORT).show();
//            }
//        }

      /*  if (requestCode == 1) {
            if (grantResults.length > 0) {
                List<String> deniedPermissions = new ArrayList<>();
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permissions[i]);
                    }
                }
                if (deniedPermissions.isEmpty()) {
                    Toast.makeText(this, "All permissions is granted", Toast.LENGTH_SHORT).show();
                } else {
                    for (String deniedPermission : deniedPermissions) {
                        Toast.makeText(this, deniedPermission + " is denied", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }*/

        RequestPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
