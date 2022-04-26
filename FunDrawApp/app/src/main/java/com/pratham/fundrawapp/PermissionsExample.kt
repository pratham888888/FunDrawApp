package com.pratham.fundrawapp

import android.Manifest.permission.CAMERA
import android.Manifest.permission_group.CAMERA
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permissions_example.*
import java.util.jar.Manifest

class PermissionsExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions_example)
        btnCameraPermission.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"you already have permission",Toast.LENGTH_LONG).show()
            }
            else{
                  ActivityCompat.requestPermissions(this,
                          arrayOf(android.Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"permission granted for camera",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Oops!permission for camera denied.You can also allow it from " +
                        "settings",Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object{
        private const val CAMERA_PERMISSION_CODE=1
        private const val FINE_LOCATION_PERMISSION_CODE=2
    }
}