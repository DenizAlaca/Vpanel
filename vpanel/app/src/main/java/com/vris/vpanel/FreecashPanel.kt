package com.vris.vpanel

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.sql.PreparedStatement


class FreecashPanel : AppCompatActivity() {
    private var connectSql = ConnectSql()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freecash_panel)


val textid:EditText=findViewById(R.id.editTextTextPersonName13)

        val getbuton:Button=findViewById(R.id.button40)
       val dogrula:Button=findViewById(R.id.button41)
val spinner:Spinner=findViewById(R.id.spinner)
        val spinner2:Spinner=findViewById(R.id.spinner2)
        val red:CheckBox=findViewById(R.id.checkBox16)

        val resimkapat:ImageView=findViewById(R.id.imageView12)
        resimkapat.setOnClickListener {
            resimkapat.visibility= View.INVISIBLE
        }

       val idchk: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=1 and bekleme=0")!!
        val arrayList: ArrayList<String> = ArrayList()


        val rs = idchk.executeQuery()
        while (rs.next())
        {

            arrayList.add(rs.getInt(1).toString()+"-"+rs.getString(2).toString())

           //=
                //rs.getInt(1).toString()

        }
       val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
       spinner.adapter = arrayAdapter

        val idchk2: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=0 and bekleme=1")!!
        val arrayList2: ArrayList<String> = ArrayList()


        val rs2 = idchk2.executeQuery()
        while (rs2.next())
        {

            arrayList2.add(rs2.getInt(1).toString()+"-"+rs2.getString(2).toString())

            //=
            //rs.getInt(1).toString()

        }
        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList2)
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = arrayAdapter2
        getbuton.setOnClickListener {
            resimkapat.visibility= View.VISIBLE
            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Veriler alınıyor..")
            progressDialog.setCancelable(false)
            progressDialog.show()

            val imageName=textid.text
            val storageReference=FirebaseStorage.getInstance().reference.child("freecashimage/$imageName.jpg")
            val localfile= File.createTempFile("tempImage","jpg")
            storageReference.getFile(localfile).addOnSuccessListener {
             if (progressDialog.isShowing)
                 progressDialog.dismiss()

                val bitmap=BitmapFactory.decodeFile(localfile.absolutePath)
val imageView12:ImageView=findViewById(R.id.imageView12)
                imageView12.setImageBitmap(bitmap)
            }.addOnFailureListener{
                if (progressDialog.isShowing)
                    progressDialog.dismiss()
Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
            }
        }


        dogrula.setOnClickListener {

            if (red.isChecked==false)
            { val freacashchkekle: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("update freacash set bekleme=0,durum=1 where uid="+textid.text+"")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Hesap doğrulandı",Toast.LENGTH_SHORT).show()

                spinner.adapter=null
                spinner2.adapter=null

                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=1 and bekleme=0")!!
                val arrayList: ArrayList<String> = ArrayList()


                val rs = idchk.executeQuery()
                while (rs.next())
                {

                    arrayList.add(rs.getInt(1).toString()+"-"+rs.getString(2).toString())

                    //=
                    //rs.getInt(1).toString()

                }
                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = arrayAdapter

                val idchk2: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=0 and bekleme=1")!!
                val arrayList2: ArrayList<String> = ArrayList()


                val rs2 = idchk2.executeQuery()
                while (rs2.next())
                {

                    arrayList2.add(rs2.getInt(1).toString()+"-"+rs2.getString(2).toString())

                    //=
                    //rs.getInt(1).toString()

                }
                val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList2)
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = arrayAdapter2
            }
            else
            {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update freacash set bekleme=0,durum=0,red=1 where uid="+textid.text+"")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Hesap doğrulandı",Toast.LENGTH_SHORT).show()

                spinner.adapter=null
                spinner2.adapter=null

                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=1 and bekleme=0")!!
                val arrayList: ArrayList<String> = ArrayList()


                val rs = idchk.executeQuery()
                while (rs.next())
                {

                    arrayList.add(rs.getInt(1).toString()+"-"+rs.getString(2).toString())

                    //=
                    //rs.getInt(1).toString()

                }
                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = arrayAdapter

                val idchk2: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("select uid,basvuru_tarihi from freacash where durum=0 and bekleme=1")!!
                val arrayList2: ArrayList<String> = ArrayList()


                val rs2 = idchk2.executeQuery()
                while (rs2.next())
                {

                    arrayList2.add(rs2.getInt(1).toString()+"-"+rs2.getString(2).toString())

                    //=
                    //rs.getInt(1).toString()

                }
                val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList2)
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = arrayAdapter2
            }




        }
        val yonetim: ImageView =findViewById(R.id.ackapatImage)
        yonetim.setOnClickListener {
            val intent = Intent(this, CekilisAcKapat::class.java)
            startActivity(intent)
            finish()
        }
        val sil: ImageView =findViewById(R.id.gelirgiderImage)
        sil.setOnClickListener {
            val intent = Intent(this, GelirGiderAyar::class.java)
            startActivity(intent)
            finish()
        }
        val geligider: ImageView =findViewById(R.id.updateImage)
        geligider.setOnClickListener {
            val intent = Intent(this, UpdateVersion::class.java)
            startActivity(intent)
            finish()
        }

        val versionup: ImageView =findViewById(R.id.sifirlaImage)
        versionup.setOnClickListener {

            val intent = Intent(this, TablolariSifirla::class.java)
            startActivity(intent)
            finish()
        }




    }
}