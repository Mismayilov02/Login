package com.example.pin_codeforthepractice

import android.annotation.SuppressLint
import android.content.Context

import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_splash_screen.view.*


class SplashScreen : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_splash_screen, container, false)
       sharedPreferences = this.context!!.getSharedPreferences("password", Context.MODE_PRIVATE)
       editor  =  sharedPreferences.edit()
        /*  val handler = Handler()*/
      /*  val runnable= Runnable {
            @Override
            fun run(){
                if(sharedPreferenceManager!!.getBoolean("create_pasword",false) == true){
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_logInPassword)
                }
                else{
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_createPassword)
                }
            }
        }
        handler.postDelayed(runnable,3000)
*/

        val countDownTimer  = object : CountDownTimer(3000,1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                if (sharedPreferences.getBoolean("create_pasword",false)) {
                    findNavController(view).navigate(R.id.navhost_splash_tocreate)
                } else {
                    findNavController(view).navigate(R.id.navhost_splash_tocreate)
                }
            }

        }.start()
        return view
    }


}