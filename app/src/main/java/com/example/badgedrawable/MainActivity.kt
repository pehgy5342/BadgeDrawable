package com.example.badgedrawable

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val btn_clear = findViewById<Button>(R.id.btn_clearNumber)

        //標點
        val badge = tabLayout.getTabAt(0)?.orCreateBadge
        badge?.isVisible = true
        badge?.backgroundColor = getColor(R.color.red)

        //數字
        val badge1 = tabLayout.getTabAt(1)?.orCreateBadge
        badge1?.isVisible = true
        //文字顏色
        badge1?.badgeTextColor = Color.WHITE
        //設定顯示位置(右下)
        badge1?.badgeGravity = BadgeDrawable.BOTTOM_END
        badge1?.number = 10

        val badge2 = tabLayout.getTabAt(2)?.orCreateBadge
        badge2?.isVisible = true
        //限制幾位數(3=兩位數)
        badge2?.maxCharacterCount = 3
        badge2?.number = 100

        btn_clear.setOnClickListener {
            //清除數字，但還是會出現紅點所以必須設為隱藏
            badge2?.clearNumber()
            badge2?.isVisible = false
        }
    }

}


