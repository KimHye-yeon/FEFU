package com.example.toearthtous

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.toearthtous.navigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_login.progress_bar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bottom Navigation View
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.selectedItemId = R.id.action_home

        // 앨범 접근 권한 요청
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)

        registerPushToken()

    }
    fun setToolbarDefault() {
        toolbar_title_image.visibility=View.VISIBLE
        toolbar_btn_back.visibility=View.GONE
        toolbar_username.visibility=View.GONE
    }

    fun registerPushToken(){
        var pushToken = FirebaseInstanceId.getInstance().token
        var uid =FirebaseAuth.getInstance().currentUser?.uid
        var map = mutableMapOf<String,Any>()
        map["pushtoken"] = pushToken!!
        FirebaseFirestore.getInstance().collection("pushtokens").document(uid!!).set(map)
    }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
        setToolbarDefault()
        when (item.itemId){
            R.id.action_home -> {
                val detailViewFragment = DetailViewFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content,detailViewFragment)
                    .commit()
                return true
            }
            R.id.action_search -> {
                val gridFragment =GridFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content,gridFragment)
                    .commit()
                return true
            }
            R.id.action_add_photo->{
                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                {
                    startActivity(Intent(this,AddPhotoActivity::class.java))
                }else{
                    Toast.makeText(this,"스토리지 읽기 권한이 없습니다.",Toast.LENGTH_LONG).show()
                }
                return true
            }
            R.id.action_favorite_alarm -> {
                val alarmFragement = AlarmFragement()
                supportFragmentManager
                    .beginTransaction()

                    .replace(R.id.main_content , alarmFragement)

                    .commit()
                return true
            }
            R.id.action_account -> {
                val userFragment = UserFragment()
                val uid = FirebaseAuth.getInstance().currentUser!!.uid
                val bundle = Bundle()
                bundle.putString("destinationUid", uid)
                userFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content, userFragment)
                    .commit()
                return true
            }
        }
        return false

        }
    val PICK_PROFILE_FROM_ALBUM = 10
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // 앨범에서 Profile Image 사진 선택시 호출 되는 부분분
        if (requestCode == PICK_PROFILE_FROM_ALBUM && resultCode == Activity.RESULT_OK) {

            var imageUri = data?.data


            val uid = FirebaseAuth.getInstance().currentUser!!.uid //파일 업로드
            //사진을 업로드 하는 부분  userProfileImages 폴더에 uid에 파일을 업로드함
            FirebaseStorage
                .getInstance()
                .reference
                .child("userProfileImages")
                .child(uid)
                .putFile(imageUri!!)
                .addOnCompleteListener { task ->
                    val url = task.result?.downloadUrl.toString()
                    val map = HashMap<String, Any>()
                    map["image"] = url
                    FirebaseFirestore.getInstance().collection("profileImages").document(uid).set(map)
                }
        }

    }
    }



