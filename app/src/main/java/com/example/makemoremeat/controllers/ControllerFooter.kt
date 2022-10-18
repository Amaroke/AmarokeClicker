package com.example.makemoremeat.controllers

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.makemoremeat.R
import com.example.makemoremeat.activities.GameActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ControllerFooter(context: GameActivity, viewHeader: View) {

    private var viewFooter: View
    private var bottomSheetBehavior: BottomSheetBehavior<View>
    private var buttonOpenSheet: ImageButton
    private var buttonSheetButcher: Button

    init {

        viewFooter = viewHeader.findViewById(R.id.bottomSheet)
        buttonOpenSheet = viewHeader.findViewById(R.id.imageButtonOpenSheet)
        bottomSheetBehavior = BottomSheetBehavior.from(viewFooter)

        buttonOpenSheet.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        buttonSheetButcher = viewHeader.findViewById(R.id.buttonSheetButcher)
        buttonSheetButcher.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            context.showDialogButchers()
        }

    }
}
