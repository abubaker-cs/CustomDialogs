package com.customdialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.dialog_custom.*

class MainActivity : AppCompatActivity() {

    /**
     * This method is autocreated by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)

        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)

        /*This is implemented by android studio it self when we select the Basic Activity while creating the project.*/
        setSupportActionBar(toolbar)

        /**
         * Here we have handled onclick of ImageButton. And we have used SnackBar to notify.
         */
        image_button.setOnClickListener { view ->
            Snackbar.make(view, "You have clicked image button.", Snackbar.LENGTH_LONG).show()
        }

        /**
         * Here we have handled onClick of Alert Dialog Button.
         */
        btn_alert_dialog.setOnClickListener { view ->

            //Launch Alert Dialog
            alertDialogFunction()
        }

        /**
         * Here we have handled onClick of Custom Dialog Button.
         */
        btn_custom_dialog.setOnClickListener { view ->

            //Launch Custom Dialog
            customDialogFunction()
        }

        /**
         * Here we have handled onClick of Custom Progress Dialog Button.
         */
        btn_custom_progress_dialog.setOnClickListener { view ->

            //Launch Custom Progress Dialog
            customProgressDialogFunction()
        }
    }

    /**
     * TEMPLATE: Default
     * Method is used to show the Alert Dialog.
     */
    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)

        // TITLE - set title for alert dialog
        builder.setTitle("Alert")

        // MESSAGE - set message for alert dialog
        builder.setMessage("This is Alert Dialog. Which is used to show alerts in our app.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        // YES (BUTTON) - performing positive action
        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        // CANCEL (BUTTON) - performing cancel action
        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(
                    applicationContext,
                    "clicked cancel\n operation cancel",
                    Toast.LENGTH_LONG
            ).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        // NO (BUTTON) - performing negative action
        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        // PREPARE - Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()

        // CONFIGURE - Set other dialog properties
        alertDialog.setCancelable(false) // Will not allow user to cancel after clicking on remaining screen area.

        // INITIALIZE
        alertDialog.show()  // show the dialog to UI
    }


    /**
     * TEMPLATE - Custom
     * Method is used to show the Custom Dialog.
     */
    private fun customDialogFunction() {

        // Assign Context
        val customDialog = Dialog(this)

        /**
         *  Set the screen content from a layout resource.
         *  The resource will be inflated, adding all top-level views to the screen.
         */
        customDialog.setContentView(R.layout.dialog_custom)

        // Button: Submit
        customDialog.tv_submit.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss() // Dialog will be dismissed
        })

        // Button: Cancel
        customDialog.tv_cancel.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })

        //Start the dialog and display it on screen.
        customDialog.show()
    }

    /**
     * TEMPLATE - Custom Progress Dialog
     * Method is used to show the Custom Progress Dialog.
     */
    private fun customProgressDialogFunction() {

        //
        val customProgressDialog = Dialog(this)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)

        //Start the dialog and display it on screen.
        customProgressDialog.show()
    }
}
