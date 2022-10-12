package com.example.makemoremeat.controllers

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.makemoremeat.R
import com.example.makemoremeat.activities.GameActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ControllerFooter(context: GameActivity, viewHeader: View) {

    private var bottomSheetBehavior: BottomSheetBehavior<View>
    private var buttonOpenSheet: ImageButton
    private var buttonSheetButcher: Button
    private var view: View

    init {

        buttonOpenSheet = viewHeader.findViewById(R.id.imageButtonOpenSheet)
        view = viewHeader.findViewById(R.id.bottomSheet)
        bottomSheetBehavior = BottomSheetBehavior.from(view)
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
