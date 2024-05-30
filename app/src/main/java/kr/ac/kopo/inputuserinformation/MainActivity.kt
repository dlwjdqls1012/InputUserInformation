package kr.ac.kopo.inputuserinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var textName : EditText
    lateinit var textEmail : EditText
    lateinit var btnDlg : Button
    lateinit var dlgEditName : EditText
    lateinit var dlgEditEmail : EditText
    lateinit var textToast : TextView
    lateinit var dlgView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        textName = findViewById(R.id.textName)
        textEmail = findViewById(R.id.textEmail)
        btnDlg = findViewById(R.id.btnDlg)

        btnDlg.setOnClickListener {
            dlgView = View.inflate(this@MainActivity, R.layout.dialog, null)
            var dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("사용자 정보 입력")
            dlgEditName = dlgView.findViewById(R.id.editName)
            dlgEditEmail = dlgView.findViewById(R.id.editEmail)
            dlgEditName.text = textName.text
            dlgEditEmail.text = textEmail.text
            dialog.setView(dlgView)
            dialog.setPositiveButton("확인"){dialogL, which ->
                textName.text = dlgEditName.text
                textEmail.text = dlgEditEmail.text
            }
            dialog.setNegativeButton("취소"){dialog, which ->
                toastView = View.inflate(this@MainActivity, R.layout.toast, null)
                var toast = Toast(this@MainActivity)
                toast.view = toastView
                toast.duration = Toast.LENGTH_LONG
                toast.show()
            }
            dialog.show()
        }
    }
}