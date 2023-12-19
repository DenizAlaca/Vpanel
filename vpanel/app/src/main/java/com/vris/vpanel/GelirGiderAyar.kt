package com.vris.vpanel

import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.storage.FirebaseStorage
import java.sql.PreparedStatement

class GelirGiderAyar : AppCompatActivity() {
    lateinit var imageUri: Uri
    private var connectSql = ConnectSql()
    lateinit var userlogin: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gelir_gider_ayar)

        val güncelle=findViewById<Button>(R.id.button60)
        val güncellegider=findViewById<Button>(R.id.button62)
        val frechk:CheckBox=findViewById(R.id.checkBox11)
        val bitchk:CheckBox=findViewById(R.id.checkBox12)
        val okchk:CheckBox=findViewById(R.id.checkBox13)
        val fregelir:EditText=findViewById(R.id.editTextTextPersonName15)
        val bitgelir:EditText=findViewById(R.id.editTextTextPersonName16)
        val okxgelir:EditText=findViewById(R.id.editTextTextPersonName17)
val detay:EditText=findViewById(R.id.editTextTextPersonName21)

        val resimsec: Button = findViewById(R.id.button64)
        resimsec.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 100)
        }
        val yükle: Button = findViewById(R.id.button58)
        val frechk1: CheckBox = findViewById(R.id.checkBox17)
        val okx: CheckBox = findViewById(R.id.checkBox18)
        yükle.setOnClickListener {
            if (frechk1.isChecked == true && okx.isChecked == false) {
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("uploading file..")
                progressDialog.setCancelable(false)
                progressDialog.show()
                val filename = "teklif1"
                val storageReference =
                    FirebaseStorage.getInstance().getReference("skins/$filename.png")


                storageReference.putFile(imageUri).addOnSuccessListener {
                    val img:ImageView=findViewById(R.id.imageView17)
                    img.setImageURI(null)

                    Toast.makeText(this, "Yüklendi", Toast.LENGTH_SHORT).show()
                    val freacashchkekle: PreparedStatement = connectSql.dbConn()
                        ?.prepareStatement("update Skins set skinDetay='" + detay.text.toString() + "' where teklif='Freecash'")!!

                    freacashchkekle.executeUpdate()
                    if (progressDialog.isShowing) progressDialog.dismiss()
                }.addOnFailureListener {
                    if (progressDialog.isShowing) progressDialog.dismiss()
                    Toast.makeText(this, "Hata oluştu", Toast.LENGTH_SHORT).show()
                }
            }else
                if (frechk1.isChecked == false && okx.isChecked == true) {
                    val progressDialog = ProgressDialog(this)
                    progressDialog.setMessage("uploading file..")
                    progressDialog.setCancelable(false)
                    progressDialog.show()
                    val filename = "teklif2"
                    val storageReference =
                        FirebaseStorage.getInstance().getReference("skins/$filename.png")


                    storageReference.putFile(imageUri).addOnSuccessListener {
                        val img:ImageView=findViewById(R.id.imageView17)
                        img.setImageURI(null)

                        Toast.makeText(this, "Yüklendi", Toast.LENGTH_SHORT).show()
                        val freacashchkekle: PreparedStatement = connectSql.dbConn()
                            ?.prepareStatement("update Skins set skinDetay='" + detay.text.toString() + "' where teklif='Okx'")!!

                        freacashchkekle.executeUpdate()

                        if (progressDialog.isShowing) progressDialog.dismiss()
                    }.addOnFailureListener {
                        if (progressDialog.isShowing) progressDialog.dismiss()
                        Toast.makeText(this, "Hata oluştu", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        güncelle.setOnClickListener {

            if (frechk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gelir='" + fregelir.text.toString() + "' where teklif_adı='Freecash'")!!

                freacashchkekle.executeUpdate()
            }
            if (bitchk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gelir='" + bitgelir.text.toString() + "' where teklif_adı='Bitpanda'")!!

                freacashchkekle.executeUpdate()
            }
            if (okchk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gelir='" + okxgelir.text.toString() + "' where teklif_adı='Okx'")!!

                freacashchkekle.executeUpdate()
            }
        }
        güncellegider.setOnClickListener {
            if (frechk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gider='" + fregelir.text.toString() + "' where teklif_adı='Freecash'")!!

                freacashchkekle.executeUpdate()
            }
            if (bitchk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gider='" + bitgelir.text.toString() + "' where teklif_adı='Bitpanda'")!!

                freacashchkekle.executeUpdate()
            }
            if (okchk.isChecked==true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update GelirGider set gider='" + okxgelir.text.toString() + "' where teklif_adı='Okx'")!!

                freacashchkekle.executeUpdate()
            }
        }

        val okxonay:Button=findViewById(R.id.button43)
        okxonay.setOnClickListener {
            val freacashchkekle: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("update okx set bekleme=0,durum=1")!!

            freacashchkekle.executeUpdate()
        }


        val yonetim: ImageView =findViewById(R.id.ackapatImage)
        yonetim.setOnClickListener {
            val intent = Intent(this, CekilisAcKapat::class.java)
            startActivity(intent)
            finish()
        }
        val sil: ImageView =findViewById(R.id.sifirlaImage)
        sil.setOnClickListener {
            val intent = Intent(this, TablolariSifirla::class.java)
            startActivity(intent)
            finish()
        }
        val geligider: ImageView =findViewById(R.id.freecashImage)
        geligider.setOnClickListener {
            val intent = Intent(this, FreecashPanel::class.java)
            startActivity(intent)
            finish()
        }

        val versionup: ImageView =findViewById(R.id.updateImage)
        versionup.setOnClickListener {

            val intent = Intent(this, UpdateVersion::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100&&resultCode== RESULT_OK)
        {
            val img:ImageView=findViewById(R.id.imageView17)
            imageUri=data?.data!!
            img.setImageURI(imageUri)
        }
    }
}