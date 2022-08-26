package com.example.pin_codeforthepractice

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pin_codeforthepractice.databinding.FragmentCreatePasswordBinding
import com.example.pin_codeforthepractice.databinding.FragmentLogInPasswordBinding
import kotlinx.android.synthetic.main.fragment_create_password.*
import kotlinx.android.synthetic.main.fragment_create_password.view.*


class LogInPassword : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var password1 = ""
    var binding: FragmentLogInPasswordBinding? = null
    //var radio1true:CreatePassword?=null
    var radioList1: ArrayList<RadioButton> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_log_in_password, container, false)
        val view=binding!!.root
        sharedPreferences = this.requireContext().getSharedPreferences("password", Context.MODE_PRIVATE)
        editor  =  sharedPreferences.edit()
        radioList1.add(binding!!.radio1);
        radioList1.add(binding!!.radio2);
        radioList1.add(binding!!.lradio3);
        radioList1.add(binding!!.radio4);

        binding!!.lbtnx.setOnClickListener { view ->
            if (password1.length > 0) {
                password1 = password1.substring(0, password1.length - 1)
               radio1true(password1.length)
                println(password1)
            }
        }
        binding!!.lbtn0.setOnClickListener { view -> passwordCheck("0") }
        binding!!.lbtn1.setOnClickListener { view -> passwordCheck("1") }
        binding!!.lbtn2.setOnClickListener { view -> passwordCheck("2") }
        binding!!.lbtn3.setOnClickListener { view -> passwordCheck("3") }
        binding!!.lbtn4.setOnClickListener { view -> passwordCheck("4") }
        binding!!.lbtn5.setOnClickListener { view -> passwordCheck("5") }
        binding!!.lbtn6.setOnClickListener { view -> passwordCheck("6") }
        binding!!.lbtn7.setOnClickListener { view -> passwordCheck("7") }
        binding!!.lbtn8.setOnClickListener { view -> passwordCheck("8") }
        binding!!.lbtn9.setOnClickListener { view -> passwordCheck("9") }

        return view
    }

    private fun radio1true(length: Int) {
        for(i in 0..3 ){
            if (i < length) {
                radioList1[i].isChecked = true
            } else {
                radioList1[i].isChecked = false
            }
        }
    }
    private fun passwordCheck(s: String) {
        if(password1!!.length<4){
            password1+=s
            radio1true(password1.length)
        }

        checkpaswordequal()
    }

    private fun checkpaswordequal() {
        if (password1!!.length==4 ){
            if(password1.equals(sharedPreferences.getString("password","862186214632"))){
                textView.setVisibility(View.VISIBLE)
                Toast.makeText(getActivity() , "succes login" ,Toast.LENGTH_SHORT).show()
                /*val intent = Intent(this@Create_Password, ProfileActivity::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                finish()*/
            }
            else{
                password1=""
               radio1true(password1.length)
            }
        }
    }


}