package com.example.makemoremeat.controllers

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.makemoremeat.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.button.MaterialButton

class ControllerFooter(context: Activity, viewHeader: View) {



    init {
        lateinit var bottomSheetBehavior:BottomSheetBehavior<View>
        lateinit var btnOpen: ImageButton

        lateinit var view:View


            btnOpen=viewHeader.findViewById(R.id.btn_open_sheet)
            view=viewHeader.findViewById(R.id.bottomsheet)
            bottomSheetBehavior=BottomSheetBehavior.from(view)
            btnOpen.setOnClickListener {
                if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED ) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    bottomSheetBehavior.state=BottomSheetBehavior.STATE_COLLAPSED
                }
            }

    }
}
