package com.vris.vpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.sql.PreparedStatement

class CekilisAcKapat : AppCompatActivity() {
    private var connectSql = ConnectSql()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cekilis_ac_kapat)
        val freekapat:Button=findViewById(R.id.button44)
        val freeaç:Button=findViewById(R.id.button45)
        val oxkKapat:Button=findViewById(R.id.button46)
        val okxaç:Button=findViewById(R.id.button47)
        val bitpandakapat:Button=findViewById(R.id.button48)
        val bitpandaAç:Button=findViewById(R.id.button49)
        val Freechk:CheckBox=findViewById(R.id.checkBox6)
        val Okxchk:CheckBox=findViewById(R.id.checkBox7)
        val Bitchk:CheckBox=findViewById(R.id.checkBox8)
        val SonucFreecash:Button=findViewById(R.id.button50)
        val SonucOKX:Button=findViewById(R.id.button51)
        val SonucBitpanda:Button=findViewById(R.id.button52)
        val freekazanan:TextView=findViewById(R.id.textView52)
        val okxkazanan:TextView=findViewById(R.id.textView53)
        val bitkazanan:TextView=findViewById(R.id.textView54)
        val Katılanlar:Button=findViewById(R.id.button53)
        val freekatılım:TextView=findViewById(R.id.textView56)
        val okxkatılım:TextView=findViewById(R.id.textView58)
        val bitkatılım:TextView=findViewById(R.id.textView60)

        freekapat.setOnClickListener {
            if (Freechk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftFreacash set kontrol=0 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Kapandı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        freeaç.setOnClickListener {
            if (Freechk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftFreacash set kontrol=1 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Açıldı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        bitpandakapat.setOnClickListener {
            if (Bitchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftBitpanda set kontrol=0 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Kapandı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        bitpandaAç.setOnClickListener {
            if (Bitchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftBitpanda set kontrol=1 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Açıldı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        oxkKapat.setOnClickListener {
            if (Okxchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftOKX set kontrol=0 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Kapandı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        okxaç.setOnClickListener {
            if (Okxchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update giftOKX set kontrol=1 where uid=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Açıldı.",Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }







Katılanlar.setOnClickListener {
    val idchk: PreparedStatement = connectSql.dbConn()
        ?.prepareStatement("select COUNT(*) from GiftOKX ")!!

    val rs = idchk.executeQuery()
    while (rs.next())
    {
okxkatılım.setText(rs.getInt(1).toString())
        break

    }

    val idchk1: PreparedStatement = connectSql.dbConn()
        ?.prepareStatement("select COUNT(*) from GiftFreacash ")!!

    val rs1 = idchk1.executeQuery()
    while (rs1.next())
    {
        freekatılım.setText(rs1.getInt(1).toString())
        break

    }
    val idchk2: PreparedStatement = connectSql.dbConn()
        ?.prepareStatement("select COUNT(*) from GiftBitpanda ")!!

    val rs2 = idchk2.executeQuery()
    while (rs2.next())
    {
        bitkatılım.setText(rs2.getInt(1).toString())
        break

    }
}

        SonucBitpanda.setOnClickListener {
            if (Bitchk.isChecked==true) {
                val idchk2: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("SELECT TOP 1 uid FROM GiftBitpanda where uid!=0 ORDER BY NEWID() ")!!

                val rs2 = idchk2.executeQuery()
                while (rs2.next()) {
                    bitkazanan.setText(rs2.getInt(1).toString())
                    break

                }
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        SonucFreecash.setOnClickListener {
            if (Freechk.isChecked==true) {
                val idchk2: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("SELECT TOP 1 uid FROM GiftFreacash where uid!=0 ORDER BY NEWID() ")!!

                val rs2 = idchk2.executeQuery()
                while (rs2.next()) {
                    freekazanan.setText(rs2.getInt(1).toString())
                    break

                }
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        SonucOKX.setOnClickListener {
            if (Okxchk.isChecked==true) {
                val idchk2: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("SELECT TOP 1 uid FROM GiftOkx where uid!=0 ORDER BY NEWID() ")!!

                val rs2 = idchk2.executeQuery()
                while (rs2.next()) {
                    okxkazanan.setText(rs2.getInt(1).toString())
                    break

                }
            }
            else
            {Toast.makeText(this,"onaylamalısın.",Toast.LENGTH_SHORT).show()}
        }
        //SELECT TOP 1 uid FROM giftbitexen where uid!=0 ORDER BY NEWID()
      /*  val freacashchkekle: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("update freacash set bekleme=0,durum=1 where uid="+.text+"")!!

        freacashchkekle.executeUpdate()*/

        val yonetim: ImageView =findViewById(R.id.sifirlaImage)
        yonetim.setOnClickListener {
            val intent = Intent(this, TablolariSifirla::class.java)
            startActivity(intent)
            finish()
        }
        val sil: ImageView =findViewById(R.id.gelirgiderImage)
        sil.setOnClickListener {
            val intent = Intent(this, GelirGiderAyar::class.java)
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
}